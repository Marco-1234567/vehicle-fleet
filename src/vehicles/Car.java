package vehicles;
import baseclasses.Vehicle;

public class Car extends Vehicle implements Maintainable {
    private String brand;
    private String model;

    public  Car (int velocity, int weight, String fuel, String brand, String model, String name, double milageSinceLastService){
        super( velocity, weight, fuel, name, milageSinceLastService);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void move() {
        System.out.println("Car is moving.");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public void performService() {

        if (getMilageSinceLastService() > 1500){
            System.out.println("Car needs service.");
        } else {
            System.out.println("Car doesn't need service.");
        }

    }
}
