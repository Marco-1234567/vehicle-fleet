import vehicles.Bus;
import vehicles.Truck;

public class FleetManager {

    public void run(){
        Bus bus = new Bus(100,2000, "Diesel",50);
        bus.move();
        bus.performService();
        System.out.println("Seats: " + bus.getSeats());

        Truck truck1 = new Truck(100, 5000, "Diesel", 20000, 0);
        truck1.setCurrentLoad(3000);
        truck1.move();
        truck1.setMilageSinceLastService(1245);
        truck1.performService();

        Truck truck2 = new Truck(100, 5000, "Diesel", 20000, 0);
        truck2.setCurrentLoad(3000);
        truck2.move();
        truck2.setMilageSinceLastService(145);
        truck2.performService();
    }
}
