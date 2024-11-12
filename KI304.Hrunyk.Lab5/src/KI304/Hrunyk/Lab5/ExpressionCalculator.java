package KI304.Hrunyk.Lab5;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас для обчислення виразу y = tg(x)/(3x), запису та читання результатів у текстовому і двійковому форматах.
 */
public class ExpressionCalculator {

    /**
     * Обчислює вираз y = tg(x)/(3x).
     *
     * @param x значення кута в радіанах
     * @return результат обчислення виразу
     * @throws ArithmeticException якщо x дорівнює 0 (викликає ділення на нуль)
     */
    public double calculateExpression(double x) throws ArithmeticException {
        if (x == 0) {
            throw new ArithmeticException("x дорівнює 0, ділення на нуль.");
        }

        double tg = Math.tan(x);
        return tg / (3 * x);
    }

    /**
     * Перетворює результат обчислення у двійковий формат (масив байтів).
     *
     * @param result результат для перетворення
     * @return масив байтів, що представляє результат
     * @throws IOException якщо виникає помилка під час перетворення
     */
    public byte[] resultToBinaryFormat(double result) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeDouble(result);
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * Перетворює масив байтів у результат обчислення.
     *
     * @param binaryData масив байтів для перетворення
     * @return результат у вигляді числа
     * @throws IOException якщо виникає помилка під час перетворення
     */
    public double binaryFormatToResult(byte[] binaryData) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(binaryData);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        double result = dataInputStream.readDouble();
        dataInputStream.close();
        return result;
    }

    /**
     * Метод main для тестування програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введіть значення x в радіанах:");
            double x = scanner.nextDouble();

            // Обчислення виразу
            double result = calculator.calculateExpression(x);
            System.out.println("Результат: " + result);

            // Перетворення результату в двійковий формат (масив байтів)
            byte[] binaryData = calculator.resultToBinaryFormat(result);
            System.out.println("Результат у двійковому форматі: " + java.util.Arrays.toString(binaryData));

            // Перетворення назад із двійкового формату
            double resultFromBinary = calculator.binaryFormatToResult(binaryData);
            System.out.println("Результат після перетворення з двійкового формату: " + resultFromBinary);

        } catch (InputMismatchException e) {
            System.out.println("Помилка: введено некоректне значення. Будь ласка, введіть число.");
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка при роботі з даними: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
