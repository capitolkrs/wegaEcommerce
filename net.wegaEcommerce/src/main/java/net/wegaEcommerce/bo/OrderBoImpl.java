package net.wegaEcommerce.bo;

import java.sql.SQLException;

import net.wegaEcommerce.dao.OrderDao;
import net.wegaEcommerce.dto.Order;

public class OrderBoImpl implements OrderBo {

	OrderDao orderDao;
	
	public boolean placeOrder(Order order) throws BOException {
		
			try {
				int orderResult = orderDao.createOrder(order);
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
			Order order = orderDao.readOrder(id);
			order.setStatus("cancelled");
			int result = orderDao.updateOrder(order);
			
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
			int result=orderDao.deleteOrder(id);
			if(result==0){
				return false;
			}
			
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

}
