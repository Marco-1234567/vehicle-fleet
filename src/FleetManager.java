import baseclasses.Vehicle;
import vehicles.*;

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
                new Bus.Builder<>().seats(55).velocity(100).weight(2000).fuel("Diesel").milage(1500).milageSinceLastService(1700).name("bus  1").build(),
                new Truck.Builder().velocity(80).weight(5000).fuel("Diesel").milage(1500).milageSinceLastService(1245).name("truck  1").loadCapacity(100).currentLoad(20).build(),
                new Truck.Builder().velocity(80).weight(5000).fuel("Diesel").milage(1500).milageSinceLastService(1245).name("truck  2").loadCapacity(5000).currentLoad(3000).build(),
                new Car.Builder().velocity(80).weight(5000).fuel("Diesel").milage(1500).milageSinceLastService(1245).name("car  1").brand("Fiat").model("x25").build(),
                new ElectricBus.Builder().velocity(20).name("El-bus").seats(22).build()
                ));

        //alla fordon kör 50 i for-loopen
        double tripleKm = 50;
        System.out.println("\n=========Service check=========\n");
        for ( Vehicle v : vehicleList){
            v.move(tripleKm);

            if (v instanceof Maintainable m){ //en enskild check på maintainiable
                double since = v.getMilageSinceLastService();
                if(m.isServiceDue(since)){
                    System.out.println("⚠️  " + v.getName() + ": SERVICE DUE (" + since + " km). Performing now...");
                    m.performService();
                } else if (m.isServiceSoon(since)) {
                    System.out.println("ℹ️  " + v.getName() + ": Service soon (" + since + " km). Interval=" + m.getServiceIntervalKm());
                }
            }

        }
        System.out.println("\n=========Vehicle details=========\n");
        for ( Vehicle v : vehicleList){
            if (v instanceof ElectricBus eb) {
                
                eb.chargeBattery();
            } else if ( v instanceof Bus b){
                
                System.out.println("Number of seats: " + b.getSeats());

            } else if ( v instanceof Truck t){
                
                System.out.println("Current load is: " + t.getCurrentLoad());

            } else if ( v instanceof Car c){
                
                System.out.printf("The brand is %s, model %s%n", c.getBrand(), c.getModel());

            } else {
                System.out.println("Error. Not an option.");
            }
        }
    }
}
