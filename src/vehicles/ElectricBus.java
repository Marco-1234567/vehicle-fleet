package vehicles;

public class ElectricBus extends Bus implements ElectricVehice, Maintainable {

    private int voltage;

    private ElectricBus(Builder builder){
        super(builder);
        this.voltage = builder.voltage;
    }

    @Override
    public String toString() {
        return "Electrical Bus{" +
                "seats='" + super.getSeats() +
                "voltage= " + voltage + '}';
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
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

        private int voltage;
        
        public Builder voltage(int voltage){
            this.voltage = voltage;
            return this;
        }
        
        @Override
        public ElectricBus build(){
            return new ElectricBus(this);
        }
    }
}
