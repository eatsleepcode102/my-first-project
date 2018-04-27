package aggregate_function_in_select;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import entities.AggregatedTestEntity;
import entities.TestEntity;

@Named
@SessionScoped
public class TestService implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Resource
    private UserTransaction userTransaction;

    public void saveEntities() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

    	userTransaction.begin();
        TestEntity testEntity1 = new TestEntity();
        testEntity1.setValue("ab");
        TestEntity testEntity2 = new TestEntity();
        testEntity2.setValue("dn");

        entityManager.persist(testEntity1);
        entityManager.persist(testEntity2);
        userTransaction.commit();
    }

    public List<AggregatedTestEntity> getAggregation() throws NotSupportedException, SystemException {
        return entityManager.createQuery("SELECT new entities.AggregatedTestEntity(_testEntity.value) FROM TestEntity _testEntity",AggregatedTestEntity.class).getResultList();
    }
}