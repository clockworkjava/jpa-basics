package pl.clockworkjava.hotelreservation.jpa;

public class App {

    public static void main(String[] args) {
        GuestRepository repo = new GuestRepository();
        repo.createNewGuest("Paweł", 34);
        Guest guest = repo.findById(1);
        repo.updateAge(guest, 35);
        repo.delete(guest);
    }
}
