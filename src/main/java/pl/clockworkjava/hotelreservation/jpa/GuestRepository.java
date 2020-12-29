package pl.clockworkjava.hotelreservation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GuestRepository {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    public void createNewGuest(String name, int age) {

        System.out.println(" ------------ CREATE ------------ ");

        Guest newOne = new Guest(name, age);
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        System.out.println(" ------ Persisting in new transaction ------ ");

        em.persist(newOne);

        System.out.println(" New Guest ID " + newOne.getId());
        System.out.println(" ------ Closing transaction ------ ");

        transaction.commit();
    }

    public Guest findById(long i) {
        System.out.println(" ------ FIND BY ID ------");
        em.clear();
        return em.find(Guest.class, 1);
    }
}
