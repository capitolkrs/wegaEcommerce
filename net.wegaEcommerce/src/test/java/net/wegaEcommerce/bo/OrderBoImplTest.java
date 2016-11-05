package net.wegaEcommerce.bo;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.wegaEcommerce.dao.OrderDao;
import net.wegaEcommerce.dto.Order;

public class OrderBoImplTest {

	@Mock
	OrderDao orderDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void placeOrder_should_creat_AnOrder() throws SQLException {

		OrderBoImpl orderImpl = new OrderBoImpl();
		orderImpl.setOrderDao(orderDao);
		Order order = new Order();
		when(orderDao.createOrder(order)).thenReturn(new Integer(1));

	}

}
