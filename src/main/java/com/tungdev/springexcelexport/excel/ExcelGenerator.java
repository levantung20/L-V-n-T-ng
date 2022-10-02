package com.tungdev.springexcelexport.excel;

import com.tungdev.springexcelexport.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {

    private List<Student> studentList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List<Student> studentList) {
        this.studentList = studentList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeader() {
        sheet = workbook.createSheet("Student");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        style.setFont(font);
        createCell(row, 0, "id", style);
        createCell(row, 1, "code", style);
        createCell(row, 2, "names", style);
        createCell(row, 3, "email", style);
        createCell(row, 4, "age", style);
        createCell(row, 5, "address", style);
    }

    private void createCell(Row row, int columCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columCount);
        Cell cell = row.createCell(columCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }

    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Student record : studentList) {
            Row row = sheet.createRow(rowCount);
            int columCount = 0;
            createCell(row, columCount++, record.getId(), style);
            createCell(row, columCount++, record.getCode(), style);
            createCell(row, columCount++, record.getNames(), style);
            createCell(row, columCount++, record.getEmail(), style);
            createCell(row, columCount++, record.getAges(), style);
            createCell(row, columCount++, record.getAddress(), style);
        }
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
