package pl.clockworkjava.hotelreservation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GuestRepository {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    public void createNewGuest(String name, int age) {

        Guest newOne = new Guest(name, age);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(newOne);

        transaction.commit();
    }

    public Guest findById(long i) {
        return em.find(Guest.class, i);
    }

    public void updateAge(Guest guest, int newAge) {
        EntityTransaction transaction = em.getTransaction();
        System.out.println(" -------- UPDATE --------");
        transaction.begin();
        guest.setAge(newAge);
        transaction.commit();
    }
}
