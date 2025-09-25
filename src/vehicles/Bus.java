package vehicles;

import baseclasses.Vehicle;

public class Bus extends Vehicle implements Maintainable {
    private int seats;


    public Bus(int velocity, int weight, String fuel, int seats) {
        super(velocity, weight, fuel);
        this.seats = seats;
    }



    @Override
    public void move() {
        System.out.println("Bus drives at " + getVelocity() + " km/h with " + seats + " seats.");
    }
    @Override
public void performService() {
        System.out.println("Bus serviced");
    }
    public int getSeats() {
        return seats;
    }
}
