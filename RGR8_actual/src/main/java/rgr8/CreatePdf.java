package rgr8;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class CreatePdf {

    public static final Font FONT = FontFactory.getFont("/Fonts/times.ttf","CP1251",true);//шрифт

    public static void create(int type1, int quantity1, int options1, String typePrice, String quantityPrice, String optionsPrice, String itogPrice) {//статический метод
        String[] tableHeads = {"Тип окна","Стеклопакет","Опции","Итоговая стоимость"};//шапка пдф документа
        Document doc = new Document();//иницализируем документ
        String type = "Не выбрано";
        String quantity = "Не выбрано";
        String options = "Не выбрано";

        try {
        	switch (type1) {
        	case 0: 
        		type = "Одностворчатое";
        		break;
        	case 1:
        		type = "Двухстворчатое";
        		break;
        	case 2:
        		type = "Трёхстворчатое";
        		break;
        	}
        	switch (quantity1) {
        	case 0: 
        		quantity = "Однокамерный";
        		break;
        	case 1:
        		quantity = "Двухкамерный";
        		break; 
        	}
        	switch (options1) {
        	case 0: 
        		options = "Без опций";
        		break;
        	case 1:
        		options = "Подоконник";
        		break;
        	case 2:
        		options = "Отлив";
        		break;
        	case 3:
        		options = "Подоконник+отлив";
        		break;
        	}
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("d:\\Результат расчета.pdf"));
            doc.open();

            Paragraph firstLine = new Paragraph("ОТЧЕТ О РАБОТЕ ПРОГРАММЫ: \n\n", FONT);
            firstLine.setAlignment(Element.ALIGN_CENTER);
            doc.add(firstLine);
            
            PdfPTable table = new PdfPTable(4);

            for (String tableHead : tableHeads) {
                table.addCell(new Phrase(tableHead,FONT));
            }

                table.addCell(new Phrase(type, FONT));
                table.addCell(new Phrase(quantity, FONT));
                table.addCell(new Phrase(options, FONT));
                table.addCell(new Phrase(itogPrice, FONT));

            doc.add(table);

            String allPrice = "Стоимость окна: " + typePrice + "\n" + "Стоимость доп. стеклопакета: " +  quantityPrice + "\n" + "Стоимость опций: " + optionsPrice;
            
            Paragraph footer = new Paragraph(allPrice, FONT);
            doc.add(footer);

            doc.close();
            writer.close();

        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}