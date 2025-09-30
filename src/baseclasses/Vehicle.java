package baseclasses;

import Exceptions.NegativeSpeedException;
import Exceptions.SpeedLimitExceededException;

public class Vehicle {

    private int velocity;
    private int weight;
    private String fuel;
    private double milage;
    private double milageSinceLastService;
    private  String name;

    private Vehicle(int velocity, int weight, String fuel, String name, double milageSinceLastService) {
        this.velocity = velocity;
        this.weight = weight;
        this.fuel = fuel;
        this.milage = 0;
        this.name = name;
        this.milageSinceLastService = milageSinceLastService;
    }

    public void move(){
        move(10);
        System.out.println("Vehicle is moving...");
    }
    public void move(double km) {
        if (km <= 0) {
            System.out.println(getName()  + " did not move.");
            return;
        }
        this.milage += km;
        this.milageSinceLastService += km;
        System.out.printf("%s moved %.1f km. Total mileage=%.1f, Since service=%.1f%n", getName(),km, getMilage(), getMilageSinceLastService());
    }

    public String getName() {
        return name;
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

    public void setVelocity(int velocity) throws NegativeSpeedException, SpeedLimitExceededException {

        if (velocity < 0) {
            throw new NegativeSpeedException("Your speed is negative.");
        } else if (velocity > 300) {
            throw new SpeedLimitExceededException("Your speed is to high.");
        } else {
            this.velocity = velocity;
            System.out.printf("Velocity is now %d km/h.%n", this.velocity);
        }
    }

    protected Vehicle(Builder builder){
        this.velocity = builder.velocity;
        this.weight = builder.weight;
        this.fuel = builder.fuel;
        this.milage = builder.milage;
        this.milageSinceLastService = builder.milageSinceLastService;
        this.name = builder.name;
    }

    private  Vehicle(){}

    public static class Builder<T extends Builder<T>>{ //Lade till defaultvärden som skrivs över när vi lägger till i listan

        private int velocity = 50;
        private int weight = 1000;
        private String fuel = "Unknown fuel";
        private double milage = 0.0;
        private double milageSinceLastService = 0.0;
        private  String name= "Unnamed";

        public T velocity( int velocity){
            this.velocity = velocity;
            return (T) this;
        }

        public T weight( int weight){
            this.weight = weight;
            return (T)this;
        }

        public T fuel( String fuel){
            this.fuel = fuel;
            return (T)this;
        }

        public T milage( double milage){
            this.milage = milage;
            return (T)this;
        }

        public T milageSinceLastService( double milageSinceLastService){
            this.milageSinceLastService = milageSinceLastService;
            return (T)this;
        }

        public T name( String name){
            this.name = name;
            return (T)this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }


    }
}
