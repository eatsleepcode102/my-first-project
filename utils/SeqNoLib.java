/*--------------------------------------------------------------------------*
 | Modification Logs:
 | DATE        		AUTHOR		DESCRIPTION
 | ------------------------------------------------
 | May-09-2011	LocHD      	First creation
 *--------------------------------------------------------------------------*/

package synergix.taskhub5.util.lib;

import javax.persistence.EntityManager;

import synergix.taskhub5.annotation.TablePkSeq;
import synergix.taskhub5.persistence.EmLocator;
import synergix.taskhub5.persistence.TypedQueryWrapper;
import synergix.taskhub5.persistence.domain.AbstractEntity;
import synergix.taskhub5.util.Assert;

/**
 * Utility to get max(Seq_no) from detail tables which seq_no as a part of table key.
 * 
 * @author lochd
 * 
 */
public class SeqNoLib {

	public static final String MAX_SEQ_NO_SQL_PATTERN = "SELECT MAX(e.%s) FROM %s e WHERE (1=1)";
	public static final String DYNAMIC_AND_PATTERN = " AND e.%s = ?%s";
	public static final int SEQ_STEP = 1;

	public static <E extends AbstractEntity> int nextSeqNo(Class<E> clazz, Object... keyValues) {
		if (clazz.getName().startsWith("synergix.taskhub5.persistence.domain.ctrl")) {
			final EntityManager emCtrl = EmLocator.getCtrlEntityManager();
			return nextSeqNo(emCtrl, clazz, keyValues);
		}
		else {
			final EntityManager emMain = EmLocator.getMainEntityManager();
			return nextSeqNo(emMain, clazz, keyValues);
		}

	}

	public static <E extends AbstractEntity> int nextSeqNo(EntityManager em, Class<E> clazz, Object... keyValues) {
		TablePkSeq pkSeq = clazz.getAnnotation(TablePkSeq.class);
		Assert.notNull(pkSeq, "Class " + clazz.getName() + " must be annotated by @" + TablePkSeq.class.getSimpleName());

		String cmd = String.format(MAX_SEQ_NO_SQL_PATTERN, pkSeq.seqNoField(), clazz.getSimpleName());

		String[] otherKeyFields = pkSeq.otherKeyFields();
		for (int i = 1; i <= otherKeyFields.length; i++) {
			cmd += String.format(DYNAMIC_AND_PATTERN, otherKeyFields[i - 1], i);
		}

		TypedQueryWrapper<Number> query = (TypedQueryWrapper<Number>) em.createQuery(cmd, Number.class);
		for (int i = 1; i <= otherKeyFields.length; i++) {
			query.setParameter(i, keyValues[i - 1]);
		}

		// The result can be Double or Integer.
		Number curSeq = query.getSingleResult();
		return curSeq.intValue() + SEQ_STEP;
	}
}
