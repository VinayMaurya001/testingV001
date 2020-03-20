package _4mockito._1orderService.bo;


import java.sql.SQLException;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import _4mockito._1orderService.bo.OrderBOImpl;
import _4mockito._1orderService.bo.exception.BOException;
import _4mockito._1orderService.dao.OrderDAOImpl;
import _4mockito._1orderService.dto.Order;
@RunWith(JUnitPlatform.class)
public class OrderBOImplTest {

	private static final int ORDER_ID = 123;

	@Mock
	OrderDAOImpl dao;

	@InjectMocks
	private OrderBOImpl bo;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

		
		//When @InjectMocks not used
		//bo = new OrderBOImpl();
		//bo.setDao(dao);
	}

	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		
		//When @Mock not used
		//OrderDAOImpl dao=Mockito.mock(OrderDAOImpl.class);
		//bo.setDao(dao);
		
		Mockito.when(dao.create(order)).thenReturn(new Integer(1));
		// Mockito.when(dao.create(Matchers.any(Order.class))).thenReturn(new
		// Integer(1));
		boolean result = bo.placeOrder(order);
		Assertions.assertTrue(result);

		Mockito.verify(dao).create(order);//By default, it will verify that create(order) will be called once.
		//Mockito.verify(dao,Mockito.times(2)).create(order);//RTE,ToLittleInvocations error
		// Mockito.verify(dao, Mockito.atLeast(1)).create(order);

	}

	@Test
	public void placeOrder_Should_not_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		Mockito.when(dao.create(order)).thenReturn(new Integer(0));
		boolean result = bo.placeOrder(order);

		Assertions.assertFalse(result);
		
		Mockito.verify(dao).create(order);

	}

	@Test
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		Mockito.when(dao.create(Matchers.any(Order.class))).thenThrow(SQLException.class);
		Order order = new Order();
		Assertions.assertThrows(BOException.class,()->{
			boolean result =bo.placeOrder(order);
		});
	}

	@Test
	public void cancelOrder_Should_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order();
		Mockito.when(dao.read(Matchers.anyInt())).thenReturn(order);
		Mockito.when(dao.update(order)).thenReturn(1);

		boolean result = bo.cancelOrder(123);
		Assertions.assertTrue(result);
		
		Mockito.verify(dao).read(Matchers.anyInt());
		Mockito.verify(dao).update(order);
	}

	@Test
	public void cancelOrder_Should_NOT_Cancel_The_Order() throws SQLException, BOException {
		Order order = new Order();
		Mockito.when(dao.read(ORDER_ID)).thenReturn(order);
		Mockito.when(dao.update(order)).thenReturn(0);

		boolean result = bo.cancelOrder(123);
		Assertions.assertFalse(result);

		Mockito.verify(dao).read(ORDER_ID);
		Mockito.verify(dao).update(order);
	}

	@Test
	public void cancelOrder_ShouldThrowABOExceptionOnRead() throws SQLException, BOException {
		Mockito.when(dao.read(Matchers.anyInt())).thenThrow(SQLException.class);
		
		Assertions.assertThrows(BOException.class,()->{
			bo.cancelOrder(ORDER_ID);
		});

	}

	@Test
	public void cancelOrder_Should_Throw_A_BOExceptionOnUpdate() throws SQLException, BOException {
		Order order = new Order();
		Mockito.when(dao.read(ORDER_ID)).thenReturn(order);
		Mockito.when(dao.update(order)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class,()->{
			bo.cancelOrder(ORDER_ID);
		});

	}

	@Test
	public void deleteOrder_Deletes_The_Order() throws SQLException, BOException {
		Mockito.when(dao.delete(ORDER_ID)).thenReturn(1);
		boolean result = bo.deleteOrder(ORDER_ID);
		Assertions.assertTrue(result);
		Mockito.verify(dao).delete(ORDER_ID);
	}

}
