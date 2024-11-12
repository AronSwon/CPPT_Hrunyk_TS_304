package Hrunyk304Lab6;

/**
 * Клас, що представляє будівлю (споруду).
 */
public class Building implements Comparable<Building> {

    private String name;
    private double height;
    private static int count = 0; // Змінна для підрахунку кількості будівель

    /**
     * Конструктор класу Building.
     *
     * @param name назва будівлі
     * @param height висота будівлі
     */
    public Building(String name, double height) {
        this.name = name;
        this.height = height;
        count++; // Збільшуємо кількість при створенні нової будівлі
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public int compareTo(Building other) {
        return Double.compare(this.height, other.height);
    }

    @Override
    public String toString() {
        return "Building - " + name + " (height=" + height + ")";
    }
}
