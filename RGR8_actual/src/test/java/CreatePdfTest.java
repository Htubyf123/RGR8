import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import rgr8.CreatePdf;

public class CreatePdfTest {

	@Test
	public void testCreatePdf() {
		CreatePdf.create(3, 2, 1, "����", "���", "���", "������");
		File file = new File("d:\\��������� �������.pdf");
		assertNotNull(file);
	}

}
