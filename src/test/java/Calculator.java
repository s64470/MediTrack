/**
 * Einfache Rechner-Klasse mit Additionsfunktion.
 */
public class Calculator {

    /**
     * Addiert zwei ganze Zahlen.
     *
     * @param a erster Summand
     * @param b zweiter Summand
     * @return die Summe von a und b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Einstiegspunkt für manuelles Testen.
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        System.out.print("2 + 3 = " + result);
    }
}