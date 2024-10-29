package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("Should display 0 when calculator is first used")
    void testInitialScreenValue() {
        Calculator calc = new Calculator();    //neues Objekt

        String expected = "0";    //Bildschirm zeigt 0 an
        String actual = calc.readScreen(); //ruft den aktuellen Bildschirminhalt des Rechner ab

        assertEquals(expected, actual); //Vergleicht erwarteten Wert mit tatsächlichem Wert
    }

    @Test
    @DisplayName("should reset all values on double press of clear key") //Test drückt Clear Taste zweimal um alles zurückzusetzen - wird rot weil alles zurücksetzt
    void testClearKeyDoublePress() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5); // Drückt die Zifferntaste "5", sodass der Bildschirm jetzt "5" anzeigt
        calc.pressClearKey(); // Erstes Drücken der Clear-Taste, Bildschirm sollte auf "0" zurückgesetzt sein
        assertEquals("0", calc.readScreen()); // Prüft, ob der Bildschirm auf "0" zurückgesetzt wurde

        calc.pressClearKey(); // Zweites Drücken der Clear-Taste, sollte jetzt alles zurücksetzen
        assertEquals("0", calc.readScreen()); // Erwartung: Bildschirm zeigt "0" an, da alles zurückgesetzt sein sollte
    }

    @Test
    @DisplayName("should display error when inverting zero") //testet ob Error angezeigt wird wenn durch 0 geteilt wird
    void testDivisionByZeroWithInverse() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0); // Drückt die Zifferntaste "0"
        calc.pressUnaryOperationKey("1/x"); // Versucht, 1 durch den Bildschirmwert "0" zu teilen (1/0)

        String expected = "Error"; // Erwartetes Ergebnis: Der Bildschirm zeigt "Error" an
        String actual = calc.readScreen(); // Ruft den aktuellen Bildschirminhalt ab

        assertEquals(expected, actual); // Vergleicht den erwarteten Wert "Error" mit dem tatsächlichen Wert
    }

}

