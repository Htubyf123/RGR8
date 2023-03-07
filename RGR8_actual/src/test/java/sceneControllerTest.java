import static org.junit.Assert.*;

import org.junit.Test;

import rgr8.SceneController;

public class sceneControllerTest {

	@Test
	public void testObjectNotNull() {
		SceneController sc = new SceneController();
		assertNotNull(sc);
	}

}
