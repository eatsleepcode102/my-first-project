package synergix.th6.business.action.jaxrs;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.omnifaces.filter.HttpFilter;

import synergix.th6.framework.faces.cdi.AutomaticConversationPropagationFilter.FilteredRequest;
import synergix.th6.framework.logging.SynLogger;
import synergix.th6.framework.logging.SynLoggerProducer;
import synergix.th6.framework.persistence.transaction.SynTransaction;

@ApplicationScoped
@WebFilter
public class TransactionServletFilter extends HttpFilter implements Serializable {
	private static final SynLogger log = SynLoggerProducer.getLogger();

	@Override
	public void doFilter(final HttpServletRequest request, final HttpServletResponse response, final HttpSession session, final FilterChain chain) throws ServletException, IOException {
		try {
			if (SynTransaction.isNoTransaction()) {
				TransactionServletFilter.log.debug("Beginning transaction by Servlet Filter");
				SynTransaction.begin();
			}

			try {
				chain.doFilter(new FilteredRequest(request), response);
			}

			catch (IOException | ServletException e) {
				if (SynTransaction.isActiveOrMarkedRollback()) {
					SynTransaction.rollback();
				}

				throw e;
			}

			if (SynTransaction.isActive()) {
				SynTransaction.commit();
			}

			else if (SynTransaction.isMarkedRollback()) {
				SynTransaction.rollback();
			}

			else if (SynTransaction.isRolledBackOrCommitted()) {
				TransactionServletFilter.log.warn("Transaction has already been rolled back or committed elsewhere. Need to do cleanup now...");
				SynTransaction.cleanup();
			}

			else {
				TransactionServletFilter.log.warn("Unexpected Transaction status at end of request: " + SynTransaction.getStatusString());
			}
		}

		catch (final SystemException | NotSupportedException | RollbackException | HeuristicMixedException | HeuristicRollbackException e1) {
			throw new RuntimeException(e1);
		}
	}
}
