package Hrunyk304Lab3;

/**
 * Клас, що представляє корінь рослини.
 */
public class Root {
    private double length;

    /**
     * Конструктор, що ініціалізує корінь з заданою довжиною.
     *
     * @param length Довжина кореня в сантиметрах.
     */
    public Root(double length) {
        this.length = length;
    }

    /**
     * Отримати довжину кореня.
     *
     * @return Довжина кореня в сантиметрах.
     */
    public double getLength() {
        return length;
    }

    /**
     * Встановити нову довжину кореня.
     *
     * @param length Нова довжина кореня в сантиметрах.
     */
    public void setLength(double length) {
        this.length = length;
    }
}

