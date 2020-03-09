package com.vanessapr.practica03.springmvc.views;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vanessapr.practica03.springmvc.beans.Client;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PdfView extends AbstractPdfView {
    public static final String[] HEADERS = {
            "Name",
            "LastName",
            "Email",
            "Number Phone"
    };

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Client> clientList = (List<Client>) model.get("clients");

        PdfPTable table = new PdfPTable(4);
        Arrays.stream(HEADERS)
                .forEach(title -> {
                    PdfPCell header = new PdfPCell();
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(title));
                    table.addCell(header);
                });

        clientList.stream().forEach(client -> {
            table.addCell(client.getName());
            table.addCell(client.getLastName());
            table.addCell(client.getEmail());
            table.addCell(client.getNumberPhone());
        });

        document.add(table);
        document.close();
    }
}
