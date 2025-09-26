package baseclasses;

public abstract class Vehicle {

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

    public abstract void move();

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

    public Vehicle(){}

    public static class Builder{

        private int velocity;
        private int weight;
        private String fuel;
        private double milage;
        private double milageSinceLastService;
        private  String name;

        public Builder velocity( int velocity){
            this.velocity = velocity;
            return this;
        }

        public Builder weight( int weight){
            this.weight = weight;
            return this;
        }

        public Builder fuel( String fuel){
            this.fuel = fuel;
            return this;
        }

        public Builder milage( double milage){
            this.milage = milage;
            return this;
        }

        public Builder milageSinceLastService( double milageSinceLastService){
            this.milageSinceLastService = milageSinceLastService;
            return this;
        }

        public Builder name( String name){
            this.name = name;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}
