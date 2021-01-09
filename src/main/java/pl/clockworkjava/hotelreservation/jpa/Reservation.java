package pl.clockworkjava.hotelreservation.jpa;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Guest guest;

    public Reservation(Guest guest) {
        this.guest = guest;
    }
}
