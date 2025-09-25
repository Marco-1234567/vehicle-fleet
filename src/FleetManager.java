import vehicles.Bus;

public class FleetManager {

    public void run(){
        Bus bus = new Bus(100,2000, "Diesel",50);
        bus.move();
        bus.performService();
        System.out.println("Seats: " + bus.getSeats());
    }
}
