import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalCombustionEngineVehicleTest {

    @Test
    void InternalCombustionEngineVehicleConstructor() {
        // Arrange
         double expectedKilometersPerLiter = 10;
         double expectedMaxLitersInTank = 5;
         double expectedCurrentLitersInTank = 0;

        // Act
        InternalCombustionEngineVehicle vehicle =
                new InternalCombustionEngineVehicle("", "", "",
                        expectedKilometersPerLiter, expectedMaxLitersInTank);
        double actualKilometersPerLiter = vehicle.getKilometersPerLiter();
        double actualMaxLitersInTank = vehicle.getMaxLitersInTank();
        double actualCurrentLitersInTank = vehicle.getCurrentLitersInTank();

        // Assert
        assertEquals(expectedKilometersPerLiter, actualKilometersPerLiter);
        assertEquals(expectedMaxLitersInTank, actualMaxLitersInTank);
        assertEquals(expectedCurrentLitersInTank, actualCurrentLitersInTank);

    }


    @Test
    void addGas() {
        double expectedCurrentLitersInTank = 10;
        InternalCombustionEngineVehicle vehicle = new InternalCombustionEngineVehicle(
                "", "", "" , 0, expectedCurrentLitersInTank);

        vehicle.addGas(expectedCurrentLitersInTank*2);
        double actualCurrentLitersInTank = vehicle.getCurrentLitersInTank();

        assertEquals(expectedCurrentLitersInTank, actualCurrentLitersInTank);
    }

    @Test
    void driveReturnsTrue() {
        double expectedCurrentLitersInTank = 9;
        double kilometersPerLiter = 10;
        double maxLitersInTank = 10;
        double expectedOdometer = 10;
        InternalCombustionEngineVehicle vehicle = new InternalCombustionEngineVehicle(
                "", "", "" , kilometersPerLiter, maxLitersInTank);
        vehicle.addGas(maxLitersInTank);

        boolean result = vehicle.drive(expectedOdometer);
        double actualCurrentLitersInTank = vehicle.getCurrentLitersInTank();
        double actualOdometer = vehicle.getOdometer();

        assertTrue(result);
        assertEquals(expectedOdometer, actualOdometer);
        assertEquals(expectedCurrentLitersInTank, actualCurrentLitersInTank);

    }

    @Test
    void driveReturnsFalse() {
        double expectedCurrentLitersInTank = 10;
        double kilometersPerLiter = 10;
        double maxLitersInTank = 10;
        double expectedOdometer = 0;
        InternalCombustionEngineVehicle vehicle = new InternalCombustionEngineVehicle(
                "", "", "" , kilometersPerLiter, maxLitersInTank);
        vehicle.addGas(maxLitersInTank);

        boolean result = vehicle.drive(1000000);
        double actualCurrentLitersInTank = vehicle.getCurrentLitersInTank();
        double actualOdometer = vehicle.getOdometer();

        assertFalse(result);
        assertEquals(expectedOdometer, actualOdometer);
        assertEquals(expectedCurrentLitersInTank, actualCurrentLitersInTank);
    }
}