package baseclasses;

public abstract class Vehicle {

    private int velocity;

    private int weight;

    private String fuel;

    public abstract void move(Vehicle vehicle);

    public Vehicle(int velocity, int weight, String fuel) {
        this.velocity = velocity;
        this.weight = weight;
        this.fuel = fuel;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getWeight() {
        return weight;
    }

    public String getFuel() {
        return fuel;
    }
}
