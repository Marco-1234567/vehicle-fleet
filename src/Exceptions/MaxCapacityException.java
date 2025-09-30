package Exceptions;

public class MaxCapacityException extends Exception {
    public MaxCapacityException(int load, int capacity) {

        super(load + " is too large. Capacity is " + capacity + " kg.");
    }
}
