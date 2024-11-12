package Hrunyk304Lab3;

import java.io.IOException;
import java.util.Random;

/**
 * Клас, що представляє рослину з коренем, стеблом і листям, а також методи для
 * симуляції росту, цвітіння, плодоношення та взаємодії з навколишнім середовищем.
 */
public abstract class Plant {
    protected Root root;
    protected Stem steam;
    protected Leaf leaves;
    protected Logger logger;
    protected String name;
    protected int age;
    protected double height;
    protected boolean isBlooming;
    protected int fruitCount;

    /**
     * Конструктор, що ініціалізує рослину з заданими параметрами.
     *
     * @param name   Назва рослини.
     * @param age    Вік рослини в роках.
     * @param height Висота рослини в сантиметрах.
     * @throws IOException якщо виникає помилка під час створення логера.
     */
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

    /**
     * Конструктор, що дозволяє створити рослину з усіма параметрами.
     *
     * @param root        Корінь рослини.
     * @param steam       Стебло рослини.
     * @param leaves      Листя рослини.
     * @param name        Назва рослини.
     * @param age         Вік рослини в роках.
     * @param height      Висота рослини в сантиметрах.
     * @param isBlooming  Чи цвіте рослина.
     * @param fruitCount  Кількість плодів на рослині.
     * @throws IOException якщо виникає помилка під час створення логера.
     */
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

    /**
     * Абстрактний метод для специфічної поведінки рослини.
     */
    public abstract void specificBehavior() throws IOException;

    /**
     * Метод для росту рослини.
     *
     * @param amount Кількість сантиметрів для росту
     */
    public void grow(double amount) throws IOException {
        height += amount;

        logger.log("Рослина виросла на " + amount + " см. Нова висота: " + height + " см");
        System.out.println("Рослина виросла на " + amount + " см. Нова висота: " + height + " см");
    }

    /**
     * Метод для обрізки рослини.
     *
     * @param amount Кількість сантиметрів для обрізки
     */
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

    /**
     * Метод для зміни назви рослини.
     *
     * @param newName Нова назва рослини
     */
    public void rename(String newName) throws IOException {
        logger.log("Назву рослини змінено з '" + name + "' на '" + newName + "'");
        System.out.println("Назву рослини змінено з '" + name + "' на '" + newName + "'");

        this.name = newName;
    }

    /**
     * Метод для перевірки, чи потрібно поливати рослину.
     *
     * @return true, якщо рослину потрібно полити, інакше false
     */
    public boolean needsWatering() throws IOException {
        boolean needsWatering = Math.random() < 0.5;

        logger.log(String.format("Рослині потрібно полити: %s", needsWatering));
        System.out.println(String.format("Рослині потрібно полити: %s", needsWatering));
        return needsWatering;
    }

    /**
     * Метод для симуляції цвітіння рослини.
     * @return true, якщо рослина зацвіла, false - якщо ні
     */
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

    /**
     * Метод для утворення плодів на рослині.
     * @return кількість утворених плодів
     */
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

    /**
     * Метод для симуляції взаємодії рослини з комахами.
     * @return true, якщо взаємодія була позитивною, false - якщо негативною
     */
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

    /**
     * Метод для симуляції конкуренції з іншими рослинами.
     * @param competitorHeight висота рослини-конкурента
     * @return true, якщо наша рослина перемогла у конкуренції, false - якщо програла
     */
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

    /**
     * Метод для визначення зрілості рослини.
     * @return рядок, що описує стадію зрілості рослини
     */
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

    /**
     * Метод для оцінки продуктивності рослини.
     * @return рядок, що описує продуктивність рослини
     */
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

    /**
     * Метод для закриття логера.
     *
     * @throws IOException якщо виникає помилка під час закриття логера.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}
