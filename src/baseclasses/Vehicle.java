package baseclasses;

public abstract class Vehicle {

    private int velocity;
    private int weight;
    private String fuel;
    private double milage;

    private double milageSinceLastService;

    public abstract void move();

    public Vehicle(int velocity, int weight, String fuel) {
        this.velocity = velocity;
        this.weight = weight;
        this.fuel = fuel;
        this.milage = 0;
    }

    public double getMilageSinceLastService() {
        return milageSinceLastService;
    }

    public void setMilageSinceLastService(double milageSinceLastService) {
        this.milageSinceLastService = milageSinceLastService;
    }

    public double getMilage() {
        return milage;
    }

    public void setMilage(double milage) {
        this.milage = milage;
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
