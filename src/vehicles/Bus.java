package vehicles;

import baseclasses.Vehicle;

public class Bus extends Vehicle {

    @Override
    public void move(Vehicle vehicle) {

    }

    public Bus(int velocity, int weight, String fuel){
        super(velocity, weight, fuel);
    }

    }
}
