package vehicles;
public class Car extends Vehicle {
    String type;
    public  Car (int speed, int weight, String fuelType, String type){
//        super(speed, weight, fuel);
        this.type=type;
    }

    @Override
    public void move() {

    }
}
