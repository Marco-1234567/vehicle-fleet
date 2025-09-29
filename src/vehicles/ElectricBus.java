package vehicles;

public class ElectricBus extends Bus implements ElectricVehice, Maintainable {

    private ElectricBus(Builder builder){
        super(builder);
    }

    @Override
    public void chargeBattery() {
        System.out.println("Battery is charging.");
    }

    @Override
    public void performService() {
        System.out.println("El-bus serviced");
    }

    public static class Builder extends Bus.Builder<ElectricBus.Builder>{

        @Override
        public Bus build(){
            return new ElectricBus(this);
        }
    }
}
