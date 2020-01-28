package _4mockito._1orderService.bo;

import _4mockito._1orderService.bo.exception.BOException;
import _4mockito._1orderService.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;

}
