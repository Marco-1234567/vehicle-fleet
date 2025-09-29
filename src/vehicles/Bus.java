package vehicles;

import baseclasses.Vehicle;

public class Bus extends Vehicle implements Maintainable {

    private final int seats;

    protected Bus(Builder builder) {
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

    public static class Builder<T extends Vehicle.Builder<T>> extends Vehicle.Builder<T>{

        private int seats;

        public T seats(int seats){
            this.seats = seats;
            return (T)this;
        }

        @Override
        public Vehicle build() {
            return new Bus(this);
        }
    }
}
