package net.wegaEcommerce.dao;

import java.sql.SQLException;

import net.wegaEcommerce.dto.Order;

public interface OrderDao {

	int createOrder(Order order) throws SQLException;

	Order readOrder(int id) throws SQLException;

	int updateOrder(Order order) throws SQLException;
	int deleteOrder(int id) throws SQLException;


}
