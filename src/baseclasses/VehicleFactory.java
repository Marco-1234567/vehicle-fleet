package baseclasses;

import vehicles.Bus;
import vehicles.Car;
import vehicles.Truck;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String name){
        return  switch (type.toLowerCase()){
            case "car" -> new Car.Builder().name(name).velocity(120).weight(1000).fuel("Gasoline").milageSinceLastService(0).brand("Toyota").model("xs32").build();
            case "bus" -> new Bus.Builder().name(name).velocity(80).weight(5000).fuel("Diesel").milageSinceLastService(0).seats(40).build();
            case "truck" -> new Truck.Builder().name(name).velocity(70).weight(8000).fuel("Diesel").milageSinceLastService(0).loadCapacity(10000).currentLoad(0).build();
            default -> throw new IllegalStateException("Unexpected value: " + type.toLowerCase());
        };
    }
}
