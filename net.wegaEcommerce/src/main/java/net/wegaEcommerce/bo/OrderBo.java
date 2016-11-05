package net.wegaEcommerce.bo;

import net.wegaEcommerce.dto.Order;

public interface OrderBo {
	
	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;
}
