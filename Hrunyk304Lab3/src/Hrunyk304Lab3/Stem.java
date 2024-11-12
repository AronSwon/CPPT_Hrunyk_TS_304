package Hrunyk304Lab3;

/**
 * Клас, що представляє стебло рослини.
 */
public class Stem {
    private double length;

    /**
     * Конструктор, що ініціалізує стебло з заданою довжиною.
     *
     * @param length Довжина стебла в сантиметрах.
     */
    public Stem(double length) {
        this.length = length;
    }

    /**
     * Отримати довжину стебла.
     *
     * @return Довжина стебла в сантиметрах.
     */
    public double getLength() {
        return length;
    }

    /**
     * Встановити нову довжину стебла.
     *
     * @param length Нова довжина стебла в сантиметрах.
     */
    public void setLength(double length) {
        this.length = length;
    }
}

