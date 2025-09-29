package vehicles;
import baseclasses.Vehicle;

public class Truck extends Vehicle implements Maintainable{

    private final int loadCapacity;
    private int currentLoad;

    public Truck(Truck.Builder builder) {
        super(builder);
        this.loadCapacity = builder.loadCapacity;
        this.currentLoad = builder.currentLoad;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }
    public void setCurrentLoad(int currentLoad){
        if(currentLoad <= loadCapacity){
            this.currentLoad = currentLoad;
            System.out.println("Truck loaded with" + currentLoad + "Kg");
        }
        else{
            System.out.println("Load exceeds capacity!");
        }
    }

    @Override
    public void move() {
        if(this.currentLoad > 0){
            System.out.println("Truck is moving slow as it is loaded");
        }
        else {
            System.out.println("truck is empty and moving fast");
        }
    }

    @Override
    public void performService() {
        if (getMilageSinceLastService() > 1000){
            System.out.println("Truck needs service.");
        } else {
            System.out.println("Truck doesn't need service.");
        }

    }

    public  static class Builder extends Vehicle.Builder<Builder>{
        private int loadCapacity;
        private int currentLoad;

        public Builder loadCapacity(int loadCapacity){
            this.loadCapacity = loadCapacity;
            return this;

        }

        public Builder currentLoad(int currentLoad){
            this.currentLoad = currentLoad;
            return this;
        }

        @Override
        public Vehicle build() {
            return new Truck(this);
        }
    }
}
