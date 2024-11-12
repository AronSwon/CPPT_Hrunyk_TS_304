package Lab2Hrunyk304;

import java.io.IOException;
import java.util.Random;


public class Plant {
    private Root root;
    private Stem steam;
    private Leaf leaves;
    private Logger logger;
    private String name;
    private int age;
    private double height;
    private boolean isBlooming;
    private int fruitCount;


    public Plant(String name, int age, double height) throws IOException {
        this.name = name;
        this.age = age;
        this.height = height;
        this.root = new Root(0);
        this.steam = new Stem(0);
        this.leaves = new Leaf(0);
        this.isBlooming = false;
        this.fruitCount = 0;

        this.logger = new Logger("plant_log.txt");

        logger.log(String.format("Рослина %s створена.", this.toString()));
    }


    public Plant(Root root, Stem steam, Leaf leaves, String name, int age, double height, boolean isBlooming, int fruitCount) throws IOException {
        this.root = root;
        this.steam = steam;
        this.leaves = leaves;
        this.name = name;
        this.age = age;
        this.height = height;
        this.isBlooming = isBlooming;
        this.fruitCount = fruitCount;

        this.logger = new Logger("plant_log.txt");

        logger.log(String.format("Рослина %s створена.", this.toString()));
    }



    public void grow(double amount) throws IOException {
        height += amount;

        logger.log("Рослина виросла на " + amount + " см. Нова висота: " + height + " см");
        System.out.println("Рослина виросла на " + amount + " см. Нова висота: " + height + " см");
    }


    public void prune(double amount) throws IOException {
        if (amount < height) {
            height -= amount;

            logger.log("Рослину обрізано на " + amount + " см. Нова висота: " + height + " см");
            System.out.println("Рослину обрізано на " + amount + " см. Нова висота: " + height + " см");
        } else {
            logger.log("Помилка: неможливо обрізати більше, ніж висота рослини");
            System.out.println("Помилка: неможливо обрізати більше, ніж висота рослини");
        }
    }


    public void rename(String newName) throws IOException {
        logger.log("Назву рослини змінено з '" + name + "' на '" + newName + "'");
        System.out.println("Назву рослини змінено з '" + name + "' на '" + newName + "'");

        this.name = newName;
    }


    public boolean needsWatering() throws IOException {
        boolean needsWatering = Math.random() < 0.5;

        logger.log(String.format("Рослині потрібно полити: %s", needsWatering));
        System.out.println(String.format("Рослині потрібно полити: %s", needsWatering));
        return needsWatering;
    }


    public boolean bloom() throws IOException {
        Random random = new Random();

        if (age >= 5 && !isBlooming && random.nextDouble() < 0.7) {
            isBlooming = true;

            logger.log("Рослина зацвіла!");
            System.out.println("Рослина зацвіла!");
            return true;
        }
        logger.log("Рослина не зацвіла цього разу.");
        System.out.println("Рослина не зацвіла цього разу.");
        return false;
    }


    public int produceFruits() throws IOException {
        Random random = new Random();

        if (isBlooming) {
            int newFruits = random.nextInt(5) + 1;
            fruitCount += newFruits;
            isBlooming = false;

            logger.log("Рослина утворила " + newFruits + " нових плодів. Загальна кількість плодів: " + fruitCount);
            System.out.println("Рослина утворила " + newFruits + " нових плодів. Загальна кількість плодів: " + fruitCount);
            return newFruits;
        }
        logger.log("Рослина не може утворити плоди, бо не цвіте.");
        System.out.println("Рослина не може утворити плоди, бо не цвіте.");
        return 0;
    }


    public boolean interactWithInsects() throws IOException {
        Random random = new Random();

        if (random.nextDouble() < 0.5) {
            logger.log("Корисні комахи запилюють рослину.");
            System.out.println("Корисні комахи запилюють рослину.");
            if (random.nextDouble() < 0.3) {
                bloom();
            }
            return true;
        } else {
            height *= 0.95;
            logger.log("Шкідливі комахи пошкодили рослину. Нова висота: " + height + " см");
            System.out.println("Шкідливі комахи пошкодили рослину. Нова висота: " + height + " см");
            return false;
        }
    }


    public boolean competeWithOtherPlant(double competitorHeight) throws IOException {
        if (height > competitorHeight) {
            grow(1.0);
            logger.log("Рослина перемогла в конкуренції та виросла ще трохи. Нова висота: " + height + " см");
            System.out.println("Рослина перемогла в конкуренції та виросла ще трохи. Нова висота: " + height + " см");
            return true;
        } else {
            height *= 0.98;
            logger.log("Рослина програла в конкуренції та трохи зменшилась. Нова висота: " + height + " см");
            System.out.println("Рослина програла в конкуренції та трохи зменшилась. Нова висота: " + height + " см");
            return false;
        }
    }


    public String determineMaturity() throws IOException {
        String maturityStatus;
        if (age < 5) {
            maturityStatus = "молода";
        } else if (age < 10) {
            maturityStatus = "зріла";
        } else {
            maturityStatus = "стара";
        }
        String message = "Стадія зрілості рослини " + name + ": " + maturityStatus;
        logger.log(message);
        System.out.println(message);
        return message;
    }


    public String assessProductivity() throws IOException {
        String productivityStatus;
        if (fruitCount > 10) {
            productivityStatus = "висока";
        } else if (fruitCount > 5) {
            productivityStatus = "середня";
        } else {
            productivityStatus = "низька";
        }
        String message = "Продуктивність рослини " + name + ": " + productivityStatus + " (кількість плодів: " + fruitCount + ")";
        logger.log(message);
        System.out.println(message);
        return message;
    }


    public void closeLogger() throws IOException {
        logger.close();
    }
}
