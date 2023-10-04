import static org.junit.jupiter.api.Assertions.*;

class ChairTest {

    @org.junit.jupiter.api.Test
    void testConstructorAndGets() {
        // AAA convention

        // Arrange - setup the variables we need to test
        String expectedColor = "black";
        boolean expectedHasArms = true;
        int expectedCurrentHeightInCentimeters = 30;
        int expectedMinimumHeightInCentimeters = 20;
        int expectedMaximumHeightInCentimeters = 40;

        // Act - call the code we are testing & get the values
        Chair chair = new Chair(expectedColor, expectedHasArms,
                expectedCurrentHeightInCentimeters,
                expectedMinimumHeightInCentimeters,
                expectedMaximumHeightInCentimeters);
        String actualColor = chair.getColor();
        boolean actualHasArms = chair.hasArms();
        int actualCurrentHeightInCentimeters = chair.getHeightInCentimeters();
        int actualMinimumHeightInCentimeters = chair.getMinimumHeightInCentimeters();
        int actualMaximumHeightInCentimeters = chair.getMaximumHeightInCentimeters();

        // Assert - did we get what we expected
        assertEquals(expectedColor, actualColor);
        assertEquals(expectedHasArms, actualHasArms);
        assertEquals(expectedCurrentHeightInCentimeters, actualCurrentHeightInCentimeters);
        assertEquals(expectedMinimumHeightInCentimeters, actualMinimumHeightInCentimeters);
        assertEquals(expectedMaximumHeightInCentimeters, actualMaximumHeightInCentimeters);

    }
    @org.junit.jupiter.api.Test
    void setHasArms() {
        // Arrange
        Chair chair = new Chair("", false, 0, 0, 0);

        // Act
        chair.setHasArms(true);
        boolean actualChairHasArms = chair.hasArms();

        // Assert
        assertTrue(actualChairHasArms);
    }

    @org.junit.jupiter.api.Test
    void adjustChairHeight() {
        // Arrange
        int expectedChairHeight = 30;
        Chair chair = new Chair("", false, 25, 20, 40);

        // Act
        chair.adjustChairHeight(5);
        int actualHeightInCentimeters = chair.getHeightInCentimeters();

        // Assert
        assertEquals(expectedChairHeight, actualHeightInCentimeters);

    }

    @org.junit.jupiter.api.Test
    void adjustChairHeightOverMax() {
        // Arrange
        int expectedChairHeight = 40;
        Chair chair = new Chair("", false, 25, 20, 40);

        // Act
        chair.adjustChairHeight(100);
        int actualHeightInCentimeters = chair.getHeightInCentimeters();

        // Assert
        assertEquals(expectedChairHeight, actualHeightInCentimeters);

    }

    @org.junit.jupiter.api.Test
    void adjustChairHeightUnderMin() {
        // Arrange
        int expectedChairHeight = 20;
        Chair chair = new Chair("", false, 25, 20, 40);

        // Act
        chair.adjustChairHeight(-100);
        int actualHeightInCentimeters = chair.getHeightInCentimeters();

        // Assert
        assertEquals(expectedChairHeight, actualHeightInCentimeters);

    }
}