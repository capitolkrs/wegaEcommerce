package net.wegaEcommerce.bo;

import java.sql.SQLException;

import net.wegaEcommerce.dao.OrderDao;
import net.wegaEcommerce.dto.Order;

public class OrderBoImpl implements OrderBo {

	private OrderDao orderDao;
	
	public boolean placeOrder(Order order) throws BOException {
		
			try {
				int orderResult = getOrderDao().createOrder(order);
				if(orderResult==0){
					return false;
				}
			} catch (SQLException e) {
				throw new BOException(e);
			}
		
		
		
		return true;
	}

	public boolean cancelOrder(int id) throws BOException {
		
		try {
			Order order = getOrderDao().readOrder(id);
			order.setStatus("cancelled");
			int result = getOrderDao().updateOrder(order);
			
			if(result==0){
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public boolean deleteOrder(int id) throws BOException {
		
		try {
			int result=getOrderDao().deleteOrder(id);
			if(result==0){
				return false;
			}
			
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
