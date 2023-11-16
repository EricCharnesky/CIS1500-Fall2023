import java.beans.VetoableChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @org.junit.jupiter.api.Test
    void vehicleConstructor() {
        // Arrange
        String expectedMake = "Make";
        String expectedModel = "Model";
        String expectedColor = "color";
        double expectedOdometer = 0;

        // Act
        Vehicle vehicle = new Vehicle(expectedMake, expectedModel, expectedColor);
        String actualMake = vehicle.getMake();
        String actualModel = vehicle.getModel();
        String actualColor = vehicle.getColor();
        double actualOdometer = vehicle.getOdometer();

        // Assert
        assertEquals(expectedMake, actualMake);
        assertEquals(expectedModel, actualModel);
        assertEquals(expectedColor, actualColor);
        assertEquals(expectedOdometer, actualOdometer);
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        String expectedColor = "color";
        Vehicle vehicle = new Vehicle("", "", "");

        vehicle.setColor(expectedColor);
        String actualColor = vehicle.getColor();

        assertEquals(expectedColor, actualColor);
    }

    @org.junit.jupiter.api.Test
    void drive() {
        double expectedOdometer = 42;
        Vehicle vehicle = new Vehicle("", "", "");

        boolean result = vehicle.drive(expectedOdometer);
        double actualOdometer = vehicle.getOdometer();

        assertTrue(result);
        assertEquals(expectedOdometer, actualOdometer);
    }
}