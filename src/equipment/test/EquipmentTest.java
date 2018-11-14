package equipment.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import equipment.EquipDao;

class EquipmentTest {

	@Test
	void testGetAssignNum() {
		EquipDao equipment = new EquipDao();
		assertEquals("lms", equipment.getAssignNum("1").getUsername());
	}

}
