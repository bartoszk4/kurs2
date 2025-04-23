package Utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    public static List<String> readDataFromFile(String pathname, boolean skipFirstLine) {
        try (
                Scanner scanner = new Scanner(new File(pathname), "cp1250");
        ) {
            List<String> list = new ArrayList<>();
            if (skipFirstLine) {
                scanner.nextLine();
            }
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Błąd odczytu pliku: " + pathname);
        }
    }

    public static void printDataFromFile(String pathname) {
        for (String singleLineOfData : readDataFromFile(pathname, false)) {
            System.out.println(singleLineOfData);
        }
    }

    public static void createFile(String pathname) {
        try {
            File myObj = new File(pathname);
            if (myObj.createNewFile()) {
                System.out.println("Utworzono plik: " + myObj.getName());
            } else {
                System.out.println("Plik już istnieje!");
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas tworzenia pliku");
            e.getMessage();
        }
    }

    public static void writeDataToFile(String pathname, String data) {
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(pathname, true),
                        Charset.forName("windows-1250")))) {
            writer.write(data + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
