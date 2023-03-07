import static org.junit.Assert.*;

import org.junit.Test;

import rgr8.variables;

public class variablesTest {

	@Test
	public void testSetGet() {
		variables v = new variables();
		int x = 1000;
		int y = 2000;
		v.setCountOptions1(x);
		v.setCountOptions2(y);
		assertEquals(x, v.getCountOptions1());
		assertEquals(y, v.getCountOptions2());
	}

}
