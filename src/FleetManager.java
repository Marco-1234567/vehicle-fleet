import baseclasses.Vehicle;
import baseclasses.VehicleFactory;
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
                VehicleFactory.createVehicle("car", "car 1"),
                VehicleFactory.createVehicle("bus", "bus 1"),
                VehicleFactory.createVehicle("truck", "truck 1")
//                new Bus.Builder().velocity(100).weight(2000).fuel("Diesel").milage(1500).milageSinceLastService(1700).name("bus  1").seats(54).build(),
//                new Truck.Builder().velocity(80).weight(5000).fuel("Diesel").milage(1500).milageSinceLastService(1245).name("truck  1").loadCapacity(100).currentLoad(20).build(),
//                new Truck.Builder().velocity(80).weight(5000).fuel("Diesel").milage(1500).milageSinceLastService(1245).name("truck  2").loadCapacity(5000).currentLoad(3000).build(),
//                new Car.Builder().velocity(80).weight(5000).fuel("Diesel").milage(1500).milageSinceLastService(1245).name("car  1").brand("Fiat").model("x25").build()
                ));

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
