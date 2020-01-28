package _8powerMock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import _8powerMock.dto.User;
import _8powerMock.util.IDGenerator;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IDGenerator.class)
public class UserDAOTest {

	@Test
	public void createShouldReturnAUserId() {
		UserDAO dao = new UserDAO();

		PowerMockito.mockStatic(IDGenerator.class);
		PowerMockito.when(IDGenerator.generateID()).thenReturn(1);

		int result = dao.create(new User());
		Assertions.assertEquals(1, result);
		PowerMockito.verifyStatic(IDGenerator.class);
		// PowerMockito.verifyStatic();
	}

}
