package Hrunyk304Lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас-контейнер для зберігання та опрацювання об'єктів типу T, що реалізують інтерфейс Comparable.
 *
 * @param <T> тип елементів, що зберігаються в контейнері
 */
public class StructureContainer<T extends Comparable<T>> {

    private List<T> elements;

    /**
     * Конструктор для ініціалізації порожнього контейнера.
     */
    public StructureContainer() {
        elements = new ArrayList<>();
    }

    /**
     * Додає елемент до контейнера.
     *
     * @param element елемент для додавання
     */
    public void addElement(T element) {
        elements.add(element);
    }

    /**
     * Видаляє елемент з контейнера.
     *
     * @param element елемент для видалення
     */
    public void removeElement(T element) {
        elements.remove(element);
    }

    /**
     * Повертає максимальний елемент у контейнері.
     *
     * @return максимальний елемент або null, якщо контейнер порожній
     */
    public T findMaxElement() {
        if (elements.isEmpty()) {
            return null;
        }
        T maxElement = elements.get(0);
        for (T element : elements) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    /**
     * Повертає список всіх елементів у контейнері.
     *
     * @return список елементів
     */
    public List<T> getAllElements() {
        return new ArrayList<>(elements);
    }
}
