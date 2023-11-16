public class InternalCombustionEngineVehicle extends Vehicle {

    private double kilometersPerLiter;
    private double maxLitersInTank;
    private double currentLitersInTank;

    public InternalCombustionEngineVehicle(String make, String model, String color,
                                           double kilometersPerLiter, double maxLitersInTank) {
        super(make, model, color);
        this.kilometersPerLiter = kilometersPerLiter;
        this.maxLitersInTank = maxLitersInTank;
        currentLitersInTank = 0;
    }

    public double getKilometersPerLiter() {
        return kilometersPerLiter;
    }

    public double getMaxLitersInTank() {
        return maxLitersInTank;
    }

    public double getCurrentLitersInTank() {
        return currentLitersInTank;
    }

    public void addGas(double litersOfGasToAdd){
        if ( litersOfGasToAdd > 0) {
            currentLitersInTank += litersOfGasToAdd;
        }
        if ( currentLitersInTank > maxLitersInTank ){
            currentLitersInTank = maxLitersInTank;
        }
    }

    @Override
    public boolean drive(double kilometersToDrive){
        double litersOfGasRequired = kilometersToDrive / kilometersPerLiter;

        if ( litersOfGasRequired > currentLitersInTank){
            return false;
        }

        currentLitersInTank -= litersOfGasRequired;
        super.drive(kilometersToDrive); // makes the odometer value increase
        return true;
    }
}
