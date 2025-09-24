public abstract class Vehicle {

    private int speed;

    private int weight;

    private String fuel;

    public abstract void move();

    public Vehicle(int speed, int weight, String fuel) {
        this.speed = speed;
        this.weight = weight;
        this.fuel = fuel;
    }
}
