package org.example;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        DataFormatter dataFormatter=new DataFormatter();
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Andrei.Marincas\\IdeaProjects\\untitled1\\src\\main\\java\\org\\example\\Example.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount - 1][colCount - 1];
        for (int i = 0; i < rowCount - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell=row.getCell(j);

                data[i][j]=dataFormatter.formatCellValue(cell);
            }
        }

    }
}