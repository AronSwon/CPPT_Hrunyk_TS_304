package Hrunyk304Lab3;

/**
 * Клас, що представляє листя рослини.
 */
public class Leaf {
    private int count;

    /**
     * Конструктор, що ініціалізує кількість листя.
     *
     * @param count Кількість листя.
     */
    public Leaf(int count) {
        this.count = count;
    }

    /**
     * Отримати кількість листя.
     *
     * @return Кількість листя.
     */
    public int getCount() {
        return count;
    }

    /**
     * Встановити нову кількість листя.
     *
     * @param count Нова кількість листя.
     */
    public void setCount(int count) {
        this.count = count;
    }
}
