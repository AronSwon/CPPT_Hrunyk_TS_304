package Lab1Hrunyk304;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Lab1Hrunyk304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввід розміру матриці
        System.out.println("Введіть розмір матриці: ");
        int row = sc.nextInt();

        // Ввід символа заповнювача
        System.out.println("Введіть символ заповнювач: ");
        String symbol = sc.next();

        // Перевірка на валідність символа заповнювача
        if (symbol.length() != 1) {
            System.out.println("Введіть коректний символ заповнювач");
            return;
        }

        String[][] arr = createLengthOfEachSubArr(row);
        String fileName = "Lab1.txt";

        // Запуск бізнес логіки для генерації зубчастого масиву (виводу в консоль і запису в файл)
        try {
            printMatrix(arr, symbol, row, fileName);
        } catch (IOException e) {
            // Обробка помилки під час запису в файл
            throw new RuntimeException("Сталася помилка під час запису в файл: " + e.getMessage());
        }
    }


    public static void printMatrix(String[][] arr, String symbol, int row, String file) throws IOException {
        System.out.println("Результат матриці: ");

        try (FileWriter writer = new FileWriter(file)) {
            // Логіка для формування зубачастого масиву за варіантом
            for (int i = 0; i < row; i++) {
                int indexJ = 0;

                for (int j = 0; j < row; j++) {
                    if (j <= row - i - 1) {
                        arr[i][indexJ] = symbol;

                        // Вивід в консоль і запис в файл
                        writer.write(arr[i][indexJ] + " ");
                        System.out.print(arr[i][indexJ] + " ");

                        indexJ++;
                    } else {
                        writer.write("  ");
                        System.out.print("  ");
                    }
                }
                System.out.println();
                writer.write("\n");
            }

            writer.flush();
        }
    }


    public static String[][] createLengthOfEachSubArr (int row){
        String[][] arr = new String[row][];

        for (int i = 0; i < row; i++) {
            int length = 0;

            for (int j = 0; j < row; j++) {
                if (j <= row - i - 1) {
                    length++;
                }
            }

            arr[i] = new String[length];
        }

        return arr;
    }
}