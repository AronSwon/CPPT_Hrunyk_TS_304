package Lab2Hrunyk304;

import java.io.FileWriter;
import java.io.IOException;


public class Logger {
    private FileWriter fileWriter;


    public Logger(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, true);
    }


    public void log(String message) throws IOException {
        if (fileWriter != null) {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        }
    }


    public void close() {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Виникла помилка при закриванні файла: " + e.getMessage());
            }
        }
    }
}

