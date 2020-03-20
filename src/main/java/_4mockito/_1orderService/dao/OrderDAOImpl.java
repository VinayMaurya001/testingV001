package _4mockito._1orderService.dao;

import java.sql.SQLException;

import _4mockito._1orderService.dto.Order;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int create(Order order) throws SQLException {
		//db connection
		return 0;
	}

	@Override
	public Order read(int id) throws SQLException {
		return null;
	}

	@Override
	public int update(Order order) throws SQLException {
		return 0;
	}

	@Override
	public int delete(int id) throws SQLException {
		return 0;

	}

}
