package examples_lr8;

import lr8.DataDemoConfig;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.nio.file.Files;

public class Example7 {

    public static void run() throws Exception {
        var excelFile = DataDemoConfig.resolve("example7", "products.xlsx");
        Files.createDirectories(excelFile.getParent());

        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream output = new FileOutputStream(excelFile.toFile())) {

            XSSFSheet sheet = workbook.createSheet("Товары");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Название");
            header.createCell(1).setCellValue("Характеристики");
            header.createCell(2).setCellValue("Стоимость");

            Row bookRow = sheet.createRow(1);
            bookRow.createCell(0).setCellValue("Книга по Java");
            bookRow.createCell(1).setCellValue("Учебник, 500 стр.");
            bookRow.createCell(2).setCellValue(1200);

            Row computerRow = sheet.createRow(2);
            computerRow.createCell(0).setCellValue("Компьютер");
            computerRow.createCell(1).setCellValue("16 ГБ RAM, SSD 512 ГБ");
            computerRow.createCell(2).setCellValue(65000);

            workbook.write(output);
        }

        System.out.println("Excel-файл успешно создан: " + excelFile);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Пример 1.5.2. Создание Excel-файла");
        run();
    }
}
