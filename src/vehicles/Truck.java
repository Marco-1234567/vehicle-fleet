package vehicles;
import baseclasses.Vehicle;

public class Truck extends Vehicle{

    private int loadCapacity;
    private int currentLoad;

    public Truck(int velocity, int weight, String fuel, int loadCapacity, int currentLoad){
        super(velocity, weight, fuel);
        this.loadCapacity = loadCapacity;
        this.currentLoad = currentLoad;
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
}
