package StudentManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {

	StudentManager manager;
	
	@BeforeEach
	void setUp() {
		manager = new StudentManager();
	}

	@Test
    void testAddStudent() {
        manager.addStudent("홍길동");
        assertTrue(manager.hasStudent("홍길동"));
    }

	@Test
	void testRemoveStudent() {
		manager.addStudent("홍길동");
		manager.removeStudent("홍길동");
		assertFalse(manager.hasStudent("홍길동"));
	}
	
	@Test
	void testDurability() {
		manager.addStudent("홍길동");
		assertThrows(IllegalArgumentException.class,()->{
			manager.addStudent("홍길동");
		});
	}
	
	@Test
	void testUnexist() {
		assertThrows(IllegalArgumentException.class,()->{
			manager.removeStudent("홍길동");
		});
	}
}
