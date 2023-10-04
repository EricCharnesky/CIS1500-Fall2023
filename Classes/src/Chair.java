public class Chair {
    // list of attributes
    private String color;
    private boolean hasArms;
    private int heightInCentimeters;
    private int minimumHeightInCentimeters;
    private int maximumHeightInCentimeters;

    // constructor method - has no return type
    // constructors job is to construct the object - give values to the attributes
    // no argument constructor - default constructor
//    public Chair() {
//        color = "";
//        hasArms = false;
//        heightInCentimeters = 0;
//        minimumHeightInCentimeters = 0;
//        maximumHeightInCentimeters = 0;
//    }

    public Chair(String color, boolean hasArms, int heightInCentimeters,
                 int minimumHeightInCentimeters, int maximumHeightInCentimeters) {
        this.color = color;
        this.hasArms = hasArms;
        this.heightInCentimeters = heightInCentimeters;
        this.minimumHeightInCentimeters = minimumHeightInCentimeters;
        this.maximumHeightInCentimeters = maximumHeightInCentimeters;
        validateChairHeight();
    }

    public int getMinimumHeightInCentimeters() {
        return minimumHeightInCentimeters;
    }

    // don't want access for someone to change this
//    public void setMinimumHeightInCentimeters(int minimumHeightInCentimeters) {
//        this.minimumHeightInCentimeters = minimumHeightInCentimeters;
//    }

    public int getMaximumHeightInCentimeters() {
        return maximumHeightInCentimeters;
    }

// don't want this to be changeable
//    public void setMaximumHeightInCentimeters(int maximumHeightInCentimeters) {
//        this.maximumHeightInCentimeters = maximumHeightInCentimeters;
//    }

    public String getColor() {
        return color;
    }

    public boolean hasArms() {
        return hasArms;
    }

    public void setHasArms(boolean hasArms) {
        this.hasArms = hasArms;
    }

    public int getHeightInCentimeters() {
        return heightInCentimeters;
    }

    public void adjustChairHeight(int centimetersToAdjust) {
        heightInCentimeters += centimetersToAdjust;
        validateChairHeight();
    }

    // private - means you can't use it OUTSIDE of the class
    private void validateChairHeight(){
        if (heightInCentimeters > maximumHeightInCentimeters) {
            heightInCentimeters = maximumHeightInCentimeters;
        } else if (heightInCentimeters < minimumHeightInCentimeters) {
            heightInCentimeters = minimumHeightInCentimeters;
        }
    }
}
