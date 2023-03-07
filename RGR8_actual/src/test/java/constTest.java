import static org.junit.Assert.*;

import org.junit.Test;

import rgr8.variables;

public class constTest {

	@Test
	public void testSetGet() {
		variables v = new variables();
		int a = 500;
		v.setPod(a);
		assertEquals(a, v.getPod());
	}

}
