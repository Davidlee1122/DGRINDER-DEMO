package StudentManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {

	StudentManager manager;
	
	@BeforeEach
	void setUp() throws Exception {
		manager = new StudentManager();
	}

	@Test
	void testAddStudent() {
		manager.addStudent("Kimyeho");
		assertTrue(manager.hasStudent("Kimyeho"));
	}

	@Test
	void testRemoveStudent() {
		manager.addStudent("Kimyeho");
		manager.removeStudent("Kimyeho");
		assertFalse(manager.hasStudent("Kimyeho"));
	}

	@Test
	void testHasDuplicateStudent() {
		manager.addStudent("Kimyeho");
		assertThrows(IllegalArgumentException.class,()->{
			manager.addStudent("Kimyeho");
		});
	}
	
	@Test
	void testHasNotSudent() {
		assertThrows(IllegalArgumentException.class,()->{
			manager.removeStudent("Kimyeho");
		});
	}

}
