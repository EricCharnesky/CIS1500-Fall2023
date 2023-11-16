public class Vehicle {
    private String make;
    private String model;
    private String color;
    private double odometer;


    public Vehicle(String make, String model, String color) {
        this.make = make;
        this.model = model;
        this.color = color;
        odometer = 0;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean drive(double kilometersToDrive) {
        if (kilometersToDrive > 0) {
            odometer += kilometersToDrive;
        }
        return true;
    }
}
