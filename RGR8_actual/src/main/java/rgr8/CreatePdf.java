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

    public static final Font FONT = FontFactory.getFont("/Fonts/times.ttf","CP1251",true);//�����

    public static void create(int type1, int quantity1, int options1, String typePrice, String quantityPrice, String optionsPrice, String itogPrice) {//����������� �����
        String[] tableHeads = {"��� ����","�����������","�����","�������� ���������"};//����� ��� ���������
        Document doc = new Document();//������������� ��������
        String type = "�� �������";
        String quantity = "�� �������";
        String options = "�� �������";

        try {
        	switch (type1) {
        	case 0: 
        		type = "��������������";
        		break;
        	case 1:
        		type = "��������������";
        		break;
        	case 2:
        		type = "�������������";
        		break;
        	}
        	switch (quantity1) {
        	case 0: 
        		quantity = "������������";
        		break;
        	case 1:
        		quantity = "������������";
        		break; 
        	}
        	switch (options1) {
        	case 0: 
        		options = "��� �����";
        		break;
        	case 1:
        		options = "����������";
        		break;
        	case 2:
        		options = "�����";
        		break;
        	case 3:
        		options = "����������+�����";
        		break;
        	}
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("d:\\��������� �������.pdf"));
            doc.open();

            Paragraph firstLine = new Paragraph("����� � ������ ���������: \n\n", FONT);
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

            String allPrice = "��������� ����: " + typePrice + "\n" + "��������� ���. ������������: " +  quantityPrice + "\n" + "��������� �����: " + optionsPrice;
            
            Paragraph footer = new Paragraph(allPrice, FONT);
            doc.add(footer);

            doc.close();
            writer.close();

        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}