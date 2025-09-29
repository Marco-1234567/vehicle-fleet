package vehicles;

import baseclasses.Vehicle;

public class Bus extends Vehicle implements Maintainable {

    private final int seats;

    //  int velocity, int weight, String fuel, int seats, String name, double milageSinceLastService
    private Bus(Builder builder) {
        super(builder);
        this.seats = builder.seats;
    }


    public int getSeats() {
        return seats;
    }

    @Override
    public void move() {
        System.out.println("Bus drives at " + getVelocity() + " km/h with " + seats + " seats.");
    }

    @Override
    public void performService() {
        System.out.println("Bus serviced");
    }

    public static class Builder extends Vehicle.Builder<Builder>{
        private int seats;

        public Builder seats(int seats){
            this.seats = seats;
            return this;

        }

        @Override
        public Vehicle build() {
            return new Bus(this);
        }
    }
}
