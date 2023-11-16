import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricVehicleTest {

    @Test
    void electricVehicleConstructor(){
        double expectedCurrentKilowattHoursInBattery = 0;
        double kilometersPerKilowattHour = 5;
        double maxKilowattHoursInBattery = 10;

        ElectricVehicle vehicle = new ElectricVehicle(
                "", "", "" , kilometersPerKilowattHour, maxKilowattHoursInBattery);
        double actualCurrentKilowattHoursInBattery = vehicle.getCurrentKilowattsHourInBattery();
        double actualKilometersPerKilowattHour = vehicle.getKilometersPerKilowattHour();
        double actualMaxKilowattHoursInBattery = vehicle.getMaxKilowattsHoursInBattery();

        assertEquals(expectedCurrentKilowattHoursInBattery, actualCurrentKilowattHoursInBattery);
        assertEquals(kilometersPerKilowattHour, actualKilometersPerKilowattHour);
        assertEquals(maxKilowattHoursInBattery, actualMaxKilowattHoursInBattery);
    }

    @Test
    void charge() {
        double expectedCurrentKilowattHoursInBattery = 10;
        ElectricVehicle vehicle = new ElectricVehicle(
                "", "", "" , 0, expectedCurrentKilowattHoursInBattery);

        vehicle.charge(expectedCurrentKilowattHoursInBattery*2);
        double actualCurrentKilowattHoursInBattery = vehicle.getCurrentKilowattsHourInBattery();

        assertEquals(expectedCurrentKilowattHoursInBattery, actualCurrentKilowattHoursInBattery);
    }

    @Test
    void driveReturnsTrue() {
        double expectedCurrentKilowattHoursInBattery = 9;
        double kilometersPerKilowattHour = 10;
        double maxKilowattHoursInBattery = 10;
        double expectedOdometer = 10;
        ElectricVehicle vehicle = new ElectricVehicle(
                "", "", "" , kilometersPerKilowattHour, maxKilowattHoursInBattery);
        vehicle.charge(maxKilowattHoursInBattery);

        boolean result = vehicle.drive(expectedOdometer);
        double actualCurrentKilowattHoursInBattery = vehicle.getCurrentKilowattsHourInBattery();
        double actualOdometer = vehicle.getOdometer();

        assertTrue(result);
        assertEquals(expectedOdometer, actualOdometer);
        assertEquals(expectedCurrentKilowattHoursInBattery, actualCurrentKilowattHoursInBattery);

    }

    @Test
    void driveReturnsFalse() {
        double expectedCurrentKilowattHoursInBattery = 10;
        double kilometersPerKilowattHour = 10;
        double maxKilowattHoursInBattery = 10;
        double expectedOdometer = 0;
        ElectricVehicle vehicle = new ElectricVehicle(
                "", "", "" , kilometersPerKilowattHour, maxKilowattHoursInBattery);
        vehicle.charge(maxKilowattHoursInBattery);

        boolean result = vehicle.drive(100000000);
        double actualCurrentKilowattHoursInBattery = vehicle.getCurrentKilowattsHourInBattery();
        double actualOdometer = vehicle.getOdometer();

        assertFalse(result);
        assertEquals(expectedOdometer, actualOdometer);
        assertEquals(expectedCurrentKilowattHoursInBattery, actualCurrentKilowattHoursInBattery);

    }
}