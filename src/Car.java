public class Car extends Vehicle {
    String type;
    public  Car (int velocity, int weight, String fuel, String type){
//        super(velocity, weight, fuel);
        this.type=type;
    }

    @Override
    public void move() {

    }
}
