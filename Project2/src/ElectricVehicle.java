public class ElectricVehicle extends Vehicle {

    private double kilometersPerKilowattHour;
    private double maxKilowattsHoursInBattery;
    private double currentKilowattsHourInBattery;

    public ElectricVehicle(String make, String model, String color,
                                           double kilometersPerKilowattHour, double maxKilowattsHoursInBattery) {
        super(make, model, color);
        this.kilometersPerKilowattHour = kilometersPerKilowattHour;
        this.maxKilowattsHoursInBattery = maxKilowattsHoursInBattery;
        currentKilowattsHourInBattery = 0;
    }

    public double getKilometersPerKilowattHour() {
        return kilometersPerKilowattHour;
    }

    public double getMaxKilowattsHoursInBattery() {
        return maxKilowattsHoursInBattery;
    }

    public double getCurrentKilowattsHourInBattery() {
        return currentKilowattsHourInBattery;
    }

    public void charge(double kilowattHoursToCharge){
        if ( kilowattHoursToCharge > 0) {
            currentKilowattsHourInBattery += kilowattHoursToCharge;
        }
        if ( currentKilowattsHourInBattery > maxKilowattsHoursInBattery ){
            currentKilowattsHourInBattery = maxKilowattsHoursInBattery;
        }
    }

    @Override
    public boolean drive(double kilometersToDrive){
        double kilowattHoursRequired = kilometersToDrive / kilometersPerKilowattHour;

        if ( kilowattHoursRequired > currentKilowattsHourInBattery){
            return false;
        }

        currentKilowattsHourInBattery -= kilowattHoursRequired;
        super.drive(kilometersToDrive); // makes the odometer value increase
        return true;
    }
}
