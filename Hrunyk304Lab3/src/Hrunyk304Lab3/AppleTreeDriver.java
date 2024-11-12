package Hrunyk304Lab3;

import java.io.IOException;

/**
 * Клас для запуску і тестування роботи з рослиною.
 */
public class AppleTreeDriver {
    /**
     * Основний метод для запуску програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            AppleTree appleTree = new AppleTree("Червона яблуня", 5, 3);

            appleTree.grow(0.5);
            appleTree.prune(0.2);
            appleTree.rename("Велика червона яблуня");
            appleTree.needsWatering();
            appleTree.bloom();
            appleTree.produceFruits();
            appleTree.interactWithInsects();
            appleTree.competeWithOtherPlant(2.5);
            appleTree.determineMaturity();
            appleTree.assessProductivity();
            appleTree.specificBehavior();
            int harvestedApples = appleTree.harvestFruits();
            System.out.println("Зібрано яблук: " + harvestedApples);

            appleTree.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
