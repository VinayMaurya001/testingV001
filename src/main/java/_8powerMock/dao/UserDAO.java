package _8powerMock.dao;

import _8powerMock.dto.User;
import _8powerMock.util.IDGenerator;

public class UserDAO {

	public int create(User user) {
		int id = IDGenerator.generateID();
		// Save the user object to the db
		return id;
	}

}
