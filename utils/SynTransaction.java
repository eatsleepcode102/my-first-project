package synergix.th6.framework.persistence.transaction;

import javax.enterprise.inject.Vetoed;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import synergix.th6.framework.logging.SynLogger;
import synergix.th6.framework.logging.SynLoggerProducer;
import synergix.th6.framework.persistence.SynEntityManager;
import synergix.th6.framework.persistence.SynEntityManagerFactory;
import synergix.th6.framework.util.cdi.CDIUtils;
import synergix.th6.framework.util.cdi.Instances;



/**
 * Static methods for controlling transaction via TransactionManager
 *
 * @author Hugh Nguyen
 */
@Vetoed
public abstract class SynTransaction {
	private static final SynLogger log = SynLoggerProducer.getLogger();

	private static final String[] JNDI_LOCATIONS = { "java:jboss/TransactionManager", "java:/TransactionManager", "java:appserver/TransactionManager", "java:comp/TransactionManager", };
	private static transient javax.transaction.TransactionManager transactionManager;
	private static volatile String foundJndiLocation;

	// We use TransactionManager's methods to control the transaction
	// The transaction object itself, transactionManager.getTransaction() would return null when there's no active transaction
	public static TransactionManager getTransactionManager() {
		if (SynTransaction.transactionManager == null) {
			if (SynTransaction.foundJndiLocation != null) {
				try {
					SynTransaction.transactionManager = (TransactionManager) new InitialContext().lookup(SynTransaction.foundJndiLocation);
					return SynTransaction.transactionManager;
				}
				catch (final NamingException e) {
					SynTransaction.log.trace(() -> "Could not find transaction manager under" + SynTransaction.foundJndiLocation);
				}
			}


			for (final String location : SynTransaction.JNDI_LOCATIONS) {
				try {
					SynTransaction.transactionManager = (TransactionManager) new InitialContext().lookup(location);
					SynTransaction.foundJndiLocation = location;
					return SynTransaction.transactionManager;
				}
				catch (final NamingException e) {
					SynTransaction.log.trace(() -> "Could not find transaction manager under" + location);
				}
			}


			throw new RuntimeException("Could not find TransactionManager in JNDI");
		}

		return SynTransaction.transactionManager;
	}



	// transaction control methods
	public static void begin() throws NotSupportedException, SystemException {
		SynTransaction.getTransactionManager().begin();

		// whenever a transaction begin(), the active EntityManagers that want
		// to participate in the global UserTransaction must call joinTransaction()

		// if conversation scope is active, enlist all SynEntityManager in the conversation
		if (CDIUtils.isConversationContextActive()) {
			for (final SynEntityManager em : Instances.get(ConversationScopedEntityManagerRegistry.class).getSynEntityManagers()) {
				SynTransaction.log.debug("Enlisting SynEntityManager " + em + " to global JTA UserTransaction as it begins.");
				em.joinTransaction();
			}
		}

		// if conversation scope is NOT active, then entity manager must be created after the transaction start,
		// and then join the transaction. This is done by SynEntityManagerFactory

		SynTransaction.log.debug("JTA transaction begun");
	}


	public static void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {
		SynTransaction.getTransactionManager().commit();
		SynTransaction.log.debug("JTA transaction committed");

	}

	public static void rollback() throws IllegalStateException, SecurityException, SystemException {
		SynTransaction.getTransactionManager().rollback();
		SynTransaction.log.debug("JTA transaction rolled back");
	}


	public static void cleanup() throws SystemException {
		if (SynTransaction.isRolledBackOrCommitted()) {
			SynTransaction.log.warn("Transaction status is " + SynTransaction.getStatusString() + ". Cleaning up by disassociating it from the current thread.");
			SynTransaction.getTransactionManager().suspend();

			for (final SynEntityManager em : SynEntityManagerFactory.getCurrentSynEntityManagers()) {
				// Hibernate leaves some dirty status that need to be cleared
				try {
					em.isOpen();
				}
				catch (final Throwable e) {
					SynTransaction.log.warn(e.getMessage());
				}
			}

			// TODO: must find way to warn user of transaction timeout/rolledback from a different thread
		}
	}


	// status query methods
	public static boolean isActive() throws SystemException {
		return SynTransaction.getStatus() == Status.STATUS_ACTIVE;
	}

	public static boolean isActiveOrMarkedRollback() throws SystemException {
		final int status = SynTransaction.getStatus();
		return status == Status.STATUS_ACTIVE || status == Status.STATUS_MARKED_ROLLBACK;
	}

	public static boolean isRolledBackOrMarkedRollback() throws SystemException {
		final int status = SynTransaction.getStatus();
		return status == Status.STATUS_ROLLEDBACK || status == Status.STATUS_MARKED_ROLLBACK;
	}

	public static boolean isMarkedRollback() throws SystemException {
		return SynTransaction.getStatus() == Status.STATUS_MARKED_ROLLBACK;
	}

	public static boolean isNoTransaction() throws SystemException {
		return SynTransaction.getStatus() == Status.STATUS_NO_TRANSACTION;
	}

	public static boolean isRolledBack() throws SystemException {
		return SynTransaction.getStatus() == Status.STATUS_ROLLEDBACK;
	}

	public static boolean isCommitted() throws SystemException {
		return SynTransaction.getStatus() == Status.STATUS_COMMITTED;
	}

	public static boolean isRolledBackOrCommitted() throws SystemException {
		final int status = SynTransaction.getStatus();
		return status == Status.STATUS_ROLLEDBACK || status == Status.STATUS_COMMITTED;
	}

	public static int getStatus() throws SystemException {
		return SynTransaction.getTransactionManager().getStatus();
	}

	public static String getStatusString() {
		try {
			return SynTransaction.convertTransactionStatusCodeToFriendlyString(SynTransaction.getTransactionManager().getStatus());
		}
		catch (final Throwable e) {
			return "Encountered Exception in getting transaction status " + e.getMessage();
		}
	}

	// helper
	private static String convertTransactionStatusCodeToFriendlyString(final int status) {
		switch (status) {
		case Status.STATUS_ACTIVE:
			return "Active";
		case Status.STATUS_MARKED_ROLLBACK:
			return "Marked Rollback";
		case Status.STATUS_PREPARED:
			return "Prepared";
		case Status.STATUS_PREPARING:
			return "Preparing";
		case Status.STATUS_COMMITTED:
			return "Committed";
		case Status.STATUS_COMMITTING:
			return "Committing";
		case Status.STATUS_ROLLING_BACK:
			return "Rolling Back";
		case Status.STATUS_ROLLEDBACK:
			return "Rolledback";
		case Status.STATUS_NO_TRANSACTION:
			return "No Transaction";
		default:
			return "Unknown";
		}
	}
}
