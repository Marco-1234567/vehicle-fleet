package vehicles;
import baseclasses.Vehicle;

public class Car extends Vehicle {
    private String brand;
    private String model;

    public  Car (int velocity, int weight, String fuel, String brand, String model){
        super( velocity, weight, fuel);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void move() {
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
