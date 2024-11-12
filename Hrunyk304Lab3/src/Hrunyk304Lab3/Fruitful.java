package Hrunyk304Lab3;

import java.io.IOException;

/**
 * Інтерфейс для рослин, які можуть давати фрукти.
 */
interface Fruitful {
    /**
     * Метод для збору фруктів.
     * @return кількість зібраних фруктів
     */
    int harvestFruits() throws IOException;
}
