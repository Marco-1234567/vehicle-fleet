package vehicles;
public class Truck extends Vehicle{
    public Truck(int velocity, int weight, String fuel){
        super(velocity, weight, fuel);


    }
    public void move(Truck truck) {
        if(this.loadCapacity > 0){
            System.out.println("Truck is moving slow with a heavy load");
        }
        else {
            System.out.println("truck is empty and moving fast");
        }

    }
}
