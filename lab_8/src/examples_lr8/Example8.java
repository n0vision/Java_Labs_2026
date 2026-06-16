package examples_lr8;

import lr8.DataDemoConfig;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class Example8 {

    public static void run() throws Exception {
        var excelFile = DataDemoConfig.resolve("example7", "products.xlsx").toFile();
        if (!excelFile.exists()) {
            Example7.run();
        }

        try (FileInputStream input = new FileInputStream(excelFile);
             XSSFWorkbook workbook = new XSSFWorkbook(input)) {

            Sheet sheet = workbook.getSheet("Товары");
            if (sheet == null) {
                System.out.println("Лист \"Товары\" не найден.");
                return;
            }

            System.out.println("Содержимое листа \"Товары\":");
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
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Пример 1.5.3. Чтение Excel-файла");
        run();
    }
}
