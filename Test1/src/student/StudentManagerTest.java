package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {

	StudentManager studentManager;
	
	@BeforeEach
	void setUp() throws Exception {
		studentManager = new StudentManager();
	}

	@Test
	void testAddStudent() {
		studentManager.addStudent("Kimyeho");
		assertTrue(studentManager.hasStudent("Kimyeho"));
	}

	@Test
	void testRemoveStudent() {
		studentManager.addStudent("Kimyeho");
		studentManager.removeStudent("Kimyeho");
		assertFalse(studentManager.hasStudent("Kimyeho"));
	}

	@Test
	void testDurability() {
		studentManager.addStudent("Kimyeho");
		assertThrows(IllegalArgumentException.class,()->{
			studentManager.addStudent("Kimyeho");
		});
	}
	
	@Test
	void testUnexist() {
		assertThrows(IllegalArgumentException.class,()->{
			studentManager.removeStudent("Kimyeho");
		});
	}

}
