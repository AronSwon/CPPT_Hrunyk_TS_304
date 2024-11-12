package Hrunyk304Lab6;

/**
 * Клас, що представляє міст.
 */
public class Bridge implements Comparable<Bridge> {

    private String name;
    private double length;
    private int kil;
    private static int count = 0; // Змінна для підрахунку кількості мостів

    /**
     * Конструктор класу Bridge.
     *
     * @param name назва мосту
     * @param length довжина мосту
     * @param kil кількість об'єктів
     */
    public Bridge(String name, double length, int kil) {
        this.name = name;
        this.length = length;
        this.kil = kil;
        count++; // Збільшуємо кількість при створенні нового мосту
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public int compareTo(Bridge other) {
        return Double.compare(this.length, other.length);
    }

    @Override
    public String toString() {
        return "Bridge - " + name + " (length= " + length + ")";
    }
}
