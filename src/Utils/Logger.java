package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import Constants.Constants;

public class Logger {
    public static void writeFile(String log) {
        try {
            String directory = "";
            char[] dirCharArr = Constants.DIRECTORY.toCharArray();
            for (char letter:dirCharArr)
                directory += letter=='/'?"\\":letter;
            directory += "\\src\\Log\\latest.txt";
            Path file = Paths.get(directory);

            try {
                Files.write(file, Arrays.asList(log), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (Exception e) {
                System.out.println("[ERROR] Could not write to log file: " + e.getStackTrace());
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Log file not found error: " + e.getMessage());
        }
    }

    public static void write(Exception exception) {
        String directory = "";
        char[] dirCharArr = Constants.DIRECTORY.toCharArray();
        for (char letter:dirCharArr)
            directory += letter=='/'?"\\":letter;
        directory += "\\src\\Log\\latest.txt";
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(directory, true));
            exception.printStackTrace(writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("[ERROR] Log file not found error: " + exception.getMessage());
        }
    }

    public static void write(String log) {
        write(log, true);
    }

    public static void write(String log, String error) {
        write(log, true);
        write(error, true);
    }

    public static void write(String log, Exception exception) {
        write(log, true);
        write(exception, true);
    }

    public static void write(String log, String error, Exception exception) {
        write(log, true);
        write(error, true);
        write(exception, true);
    }

    public static void write(String log, boolean printToConsol) {
        writeFile(log);
        if (printToConsol) System.out.println(log);
    }

    public static void write(Exception exception, boolean printToConsol) {
        write(exception);
        exception.printStackTrace();
    }

    public static void write(String log, String error, boolean printToConsol) {
        write(log, printToConsol);
        write(error, printToConsol);
    }

    public static void write(String log, Exception exception, boolean printToConsol) {
        write(log, printToConsol);
        write(exception, printToConsol);
    }

    public static void write(String log, String error, Exception exception, boolean printToConsol) {
        write(log, printToConsol);
        write(error, printToConsol);
        write(exception, printToConsol);
    }

    public static void clearLatestLog() {
        Logger.writeFile("[Init] Creating new log file");
        String directory = "";
        char[] dirCharArr = Constants.DIRECTORY.toCharArray();
        for (char letter:dirCharArr)
            directory += letter=='/'?"\\":letter;
        directory += "\\src\\Log\\latest.txt";
        File logFile = new File(directory);
        if (!logFile.exists()) { logFile.mkdirs(); }
        Path file = Paths.get(directory);
        try {
            Files.write(file, Arrays.asList());
        } catch (Exception e) {
            System.out.println("[ERROR] Could not clear log file: " + e.getStackTrace());
        }
    }
}
