import baseclasses.Vehicle;
import vehicles.Bus;
import vehicles.Car;
import vehicles.Maintainable;
import vehicles.Truck;

import java.util.ArrayList;
import java.util.List;

public class FleetManager {

    private static FleetManager instance;

    private FleetManager(){}

    public static FleetManager getInstance(){
        if(instance == null){
            instance = new FleetManager();
        }
        return instance;
    }

    public void run(){

        List<Vehicle> vehicleList = new ArrayList<>( List.of(
                new Bus(100,2000, "Diesel",50, "bus 1", 1500),
                new Truck(100, 5000, "Diesel", 20000, 0, "truck 1", 1245),
                new Truck(100, 5000, "Diesel", 20000, 0, "truck 2", 145),
                new Car(250, 1200, "Petrol", "Fiat", "x23", "Car 1", 2000)));

        for ( Vehicle v : vehicleList){
            v.move();
/*
            if (v instanceof Maintainable m){
                System.out.println("it works! " + v.getName());
                m.performService();
            }
*/
            if ( v instanceof Bus b){
                b.performService();
                System.out.println("Number of seats: " + b.getSeats());

            } else if ( v instanceof Truck t){
                t.performService();
                System.out.println("Current load is: " + t.getCurrentLoad());

            } else if ( v instanceof Car c){
                c.performService();
                System.out.printf("The brand is %s, model %s%n", c.getBrand(), c.getModel());
            }
        }
    }
}
