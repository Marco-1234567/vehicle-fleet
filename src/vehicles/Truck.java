package vehicles;
import Exceptions.MaxCapacityException;
import Exceptions.NegativeLoadException;
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
    public void setCurrentLoad(int currentLoad) throws NegativeLoadException, MaxCapacityException {
        if(currentLoad < 0){
            throw new NegativeLoadException(currentLoad);
        }
        if(currentLoad > loadCapacity){
            throw new MaxCapacityException(currentLoad, loadCapacity);
        }
        this.currentLoad = currentLoad;
        System.out.println("Truck loaded with" + currentLoad + "Kg");
    }

    @Override
    public void move() {
        super.move(10);

    }
    public void move(double km){
        super.move(km);
        if (this.currentLoad > 0){
            System.out.println("Truck is moving slow as it is loaded");
        } else {
            System.out.println("Truck is empty and moving fast");
        }
    }


    @Override
    public double getServiceIntervalKm() {
        return 1500;
    }

    @Override
    public void performService() {

            setMilageSinceLastService(0); //återställer service-mätare
        System.out.println(getName() + ": Truck serviced.");



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
