package Hrunyk304Lab3;

import java.io.IOException;
import java.util.Random;

public class AppleTree extends Plant implements Fruitful{
    private int appleCount;

    /**
     * Конструктор, що ініціалізує яблуню.
     *
     * @param name   Назва яблуні.
     * @param age    Вік яблуні в роках.
     * @param height Висота яблуні в сантиметрах.
     * @throws IOException якщо виникає помилка під час створення логера.
     */
    public AppleTree(String name, int age, double height) throws IOException {
        super(name, age, height);
        this.appleCount = 0;
    }

    @Override
    public int harvestFruits() throws IOException {
        int harvestedApples = this.appleCount;
        logger.log("Зібрано " + harvestedApples + " яблук.");
        System.out.println("Зібрано " + harvestedApples + " яблук.");
        this.appleCount = 0;
        return harvestedApples;
    }

    @Override
    public void specificBehavior() throws IOException {
        logger.log("Яблуня скидає листя восени.");
        System.out.println("Яблуня скидає листя восени.");
    }

    @Override
    public int produceFruits() throws IOException {
        if (isBlooming) {
            Random random = new Random();
            int newApples = random.nextInt(10) + 1;
            this.appleCount += newApples;
            isBlooming = false;

            logger.log("Яблуня утворила " + newApples + " нових яблук. Загальна кількість яблук: " + this.appleCount);
            System.out.println("Яблуня утворила " + newApples + " нових яблук. Загальна кількість яблук: " + this.appleCount);
            return newApples;
        }
        logger.log("Яблуня не може утворити яблука, бо не цвіте.");
        System.out.println("Яблуня не може утворити яблука, бо не цвіте.");
        return 0;
    }
}
