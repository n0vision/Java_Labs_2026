package lr8.task5;

import lr8.DataDemoConfig;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task5 {

    public static void readExcelWithHandling(File excelFile) {
        if (!excelFile.exists()) {
            System.out.println("Ошибка: файл не найден: " + excelFile.getAbsolutePath());
            System.out.println("Рекомендация: сначала создайте файл с помощью Example7.");
            return;
        }

        if (!excelFile.getName().toLowerCase().endsWith(".xlsx")) {
            System.out.println("Ошибка: ожидается файл формата .xlsx");
            return;
        }

        try (FileInputStream input = new FileInputStream(excelFile);
             XSSFWorkbook workbook = new XSSFWorkbook(input)) {

            Sheet sheet = workbook.getSheet("Товары");
            if (sheet == null) {
                System.out.println("Ошибка: лист \"Товары\" отсутствует в файле.");
                System.out.println("Доступные листы:");
                for (int index = 0; index < workbook.getNumberOfSheets(); index++) {
                    System.out.println("  - " + workbook.getSheetName(index));
                }
                return;
            }

            System.out.println("Чтение листа \"Товары\" из файла: " + excelFile.getName());
            for (Row row : sheet) {
                StringBuilder line = new StringBuilder();
                for (Cell cell : row) {
                    if (line.length() > 0) {
                        line.append(" | ");
                    }
                    line.append(cell.toString());
                }
                System.out.println(line);
            }
        } catch (IOException error) {
            System.out.println("Ошибка чтения Excel-файла: " + error.getMessage());
            System.out.println("Рекомендация: убедитесь, что файл не повреждён и не открыт в другой программе.");
        }
    }

    public static void run() throws Exception {
        File validFile = DataDemoConfig.resolve("example7", "products.xlsx").toFile();
        if (!validFile.exists()) {
            examples_lr8.Example7.run();
        }

        System.out.println("--- Чтение корректного файла ---");
        readExcelWithHandling(validFile);

        File missingFile = DataDemoConfig.resolve("task5", "missing.xlsx").toFile();
        System.out.println();
        System.out.println("--- Обработка отсутствующего файла ---");
        readExcelWithHandling(missingFile);

        File wrongFormat = DataDemoConfig.resolve("task5", "wrong-format.txt").toFile();
        wrongFormat.getParentFile().mkdirs();
        if (!wrongFormat.exists()) {
            java.nio.file.Files.writeString(wrongFormat.toPath(), "not excel");
        }

        System.out.println();
        System.out.println("--- Обработка файла неверного формата ---");
        readExcelWithHandling(wrongFormat);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Задание 5. Улучшение обработки ошибок при работе с Excel");
        run();
    }
}
