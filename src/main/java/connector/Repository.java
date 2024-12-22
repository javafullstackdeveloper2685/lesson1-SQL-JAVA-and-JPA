package connector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

public class Repository {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public Repository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sergei");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void saveBicycle(UUID id, String size, String userName){
       Bicycle bicycle = new Bicycle(id, size, userName);

       entityManager.getTransaction().begin();
       entityManager.persist(bicycle);
       entityManager.getTransaction().commit();
    }

    public void close() {
        if (entityManager != null) entityManager.close();
        if (entityManagerFactory != null) entityManagerFactory.close();
    }
}
