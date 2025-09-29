package baseclasses;

import vehicles.Bus;
import vehicles.Car;
import vehicles.Truck;

public class VehicleFactory {

    public static Car createCar(String name, int velocity, int weight, String fuel, double milageSinceLastService, String brand, String model) {
        return (Car) new Car.Builder()
                .name(name)
                .velocity(velocity)
                .weight(weight)
                .fuel(fuel)
                .milageSinceLastService(milageSinceLastService)
                .brand(brand)
                .model(model)
                .build();
    }


    public static Bus createBus(String name, int velocity, int weight, String fuel, double milageSinceLastService, int seats) {
        return (Bus) new Bus.Builder()
                .name(name)
                .velocity(velocity)
                .weight(weight)
                .fuel(fuel)
                .milageSinceLastService(milageSinceLastService)
                .seats(seats)
                .build();
    }

    public static Truck createTruck(String name, int velocity, int weight, String fuel, double milageSinceLastService, int loadCapacity, int currentLoad) {
        return (Truck) new Truck.Builder()
                .name(name)
                .velocity(velocity)
                .weight(weight)
                .fuel(fuel)
                .milageSinceLastService(milageSinceLastService)
                .loadCapacity(loadCapacity)
                .currentLoad(currentLoad)
                .build();
    }


}
