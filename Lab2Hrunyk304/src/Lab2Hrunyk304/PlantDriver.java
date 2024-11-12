package Lab2Hrunyk304;

import java.io.IOException;


public class PlantDriver {

    public static void main(String[] args) {
        try {
            Plant plant = new Plant("Яблуня", 10, 2);

            plant.grow(0.2);
            plant.prune(0.1);
            plant.rename("Яблуня-Нова");
            plant.needsWatering();
            plant.bloom();
            plant.produceFruits();
            plant.interactWithInsects();
            plant.competeWithOtherPlant(4);
            plant.determineMaturity();
            plant.assessProductivity();

            plant.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
