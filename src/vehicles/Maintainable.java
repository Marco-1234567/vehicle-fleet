package vehicles;

public interface Maintainable {

    double getServiceIntervalKm();


    void performService();

    default boolean isServiceDue(double milageSinceLastService) {
        return milageSinceLastService >= getServiceIntervalKm();
    }

    default boolean isServiceSoon(double milageSinceLastService) {
        return !isServiceDue(milageSinceLastService) && milageSinceLastService >= getServiceIntervalKm();
    }


}
