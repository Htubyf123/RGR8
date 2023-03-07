import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import rgr8.CreatePdf;

public class CreatePdfTest {

	@Test
	public void testCreatePdf() {
		CreatePdf.create(3, 2, 1, "один", "два", "три", "четыре");
		File file = new File("d:\\Результат расчета.pdf");
		assertNotNull(file);
	}

}
