package vehicles;
import baseclasses.Vehicle;

public class Car extends Vehicle implements Maintainable {
    private String brand;
    private String model;

    public  Car (Car.Builder builder) {
        super(builder);
        this.brand = builder.brand;
        this.model = builder.model;
    }

    @Override
    public void move() {
        super.move(10);
        System.out.println("Car is moving.");
    }
    @Override
    public double getServiceIntervalKm() {
        return 1500;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    @Override
    public void performService() {
        setMilageSinceLastService(0); //återställer service-mätare
        System.out.println(getName() + ": Car serviced");
    }

    public static class Builder extends Vehicle.Builder<Builder>{

        private String brand;
        private String model;

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder model(String model){
            this.model = model;
            return this;
        }

        @Override
        public Vehicle build() {
            return new Car(this);
        }
    }
}
