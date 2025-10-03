package vehicles;

public interface Maintainable {

    double getServiceIntervalKm();


    void performService();

    default boolean isServiceDue(double milageSinceLastService) {
        return milageSinceLastService >= getServiceIntervalKm();
    }

    default boolean isServiceSoon(double since) {
        return !isServiceDue(since) && since >= 0.9 * getServiceIntervalKm();
    }


}
