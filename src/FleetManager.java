import Exceptions.FuelException;
import Exceptions.NegativeSpeedException;
import Exceptions.SpeedLimitExceededException;
import baseclasses.Vehicle;
import baseclasses.VehicleFactory;
import genericutils.Filter;
import vehicles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
                VehicleFactory.createCar("Car 1", 100, 1500, "Bensin", 1430, "Toyota", "SX32"),
                VehicleFactory.createCar("Car 2", 200, 1500, "Bensin", 1700, "Toyota", "SX32"),
                VehicleFactory.createCar("Car 3", 300, 1500, "Bensin", 1700, "Toyota", "SX32"),
                VehicleFactory.createBus("Bus 1", 80, 5000, "Diesel", 1200, 54),
                VehicleFactory.createTruck("Truck 1", 70, 8000, "Diesel", 1600, 5000, 3000),
                VehicleFactory.createElectricBus("ElectricBus 1", 80, 5000, "Diesel", 1700, 43, 1000)
                ));

        Filter<Vehicle> filtered = new Filter<>(vehicleList);
        //filtered.filterList(  v -> v.getVelocity() > 20 ).foreach( v -> System.out.println(v));
        //filtered.filterList(  v -> v.getVelocity() > 20 ).foreach( System.out::println );

        filtered.filterList(  v -> v.getVelocity() > 20 ).foreach(new Consumer<Vehicle>() {
            @Override
            public void accept(Vehicle vehicle) {
                System.out.println( vehicle);
            }
        }
    );

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

            try{
                v.validateFuel(v.getFuel());
            } catch (FuelException e) {
                System.out.printf(" *** Fuel Validation = Vehicle %s: %s\n", v.getName(), e.getMessage());
            }

            if (v instanceof ElectricBus eb) {

                eb.chargeBattery();
            } else if ( v instanceof Bus b){

                System.out.println("Number of seats: " + b.getSeats());

            } else if ( v instanceof Truck t){

                System.out.println("Current load is: " + t.getCurrentLoad());
                trySetLoad(t,-1);
                trySetLoad(t,t.getLoadCapacity()+ 1);


            } else if ( v instanceof Car c){

                System.out.printf("The brand is %s, model %s%n", c.getBrand(), c.getModel());

                try {
                    c.setVelocity(15);
                } catch (NegativeSpeedException e) {
                    System.out.println( "Catching negative speed: -> " + e.getMessage());
                } catch (SpeedLimitExceededException e) {
                    System.out.println( "Catching Speed exceeded : -> " + e.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println( "In finally");
                }

            } else {
                System.out.println("Error. Not an option.");
            }
        }


    }
    private static void trySetLoad(Truck t, int load) {
        try {
            t.setCurrentLoad(load);
            System.out.println("Put the load to " + load + " kg");
        } catch (Exceptions.NegativeLoadException | Exceptions.MaxCapacityException e) {
            System.out.println("Error (" + t.getName() + "): " + e.getMessage());
        }
    }
}
