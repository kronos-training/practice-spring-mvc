package com.vanessapr.practica03.springmvc.views;


import com.vanessapr.practica03.springmvc.beans.Client;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


public class ExcelView extends AbstractXlsView {
    public static final String[] HEADERS = {
            "Name",
            "LastName",
            "Email",
            "Number Phone"
    };

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Client> clientList = (List<Client>) model.get("clients");

        // helper
        CreationHelper creationHelper = workbook.getCreationHelper();
        // create Sheet
        Sheet sheet = workbook.createSheet("DATA");
        // create rows for header
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);
        // create cells
        for (int i = 0; i < HEADERS.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(HEADERS[i]);
            cell.setCellStyle(headerCellStyle);
        }

        for (int i = 0; i < clientList.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(clientList.get(i).getName());
            row.createCell(1).setCellValue(clientList.get(i).getLastName());
            row.createCell(2).setCellValue(clientList.get(i).getEmail());
            row.createCell(3).setCellValue(clientList.get(i).getNumberPhone());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < HEADERS.length; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setHeader( "Content-Disposition", "attachment;filename=" + "clients.xls" );
        workbook.close();
    }
}
