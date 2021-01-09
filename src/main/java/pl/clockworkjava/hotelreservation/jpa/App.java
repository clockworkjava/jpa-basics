package pl.clockworkjava.hotelreservation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager();

    public static void main(String[] args) {
        GuestRepository guestRepository = new GuestRepository(em);
        ReservationRepository reservationRepository = new ReservationRepository(em);
        guestRepository.createNewGuest("Paweł", 34);
        Guest guest = guestRepository.findById(1l);
        reservationRepository.createReservation(guest);
    }
}
