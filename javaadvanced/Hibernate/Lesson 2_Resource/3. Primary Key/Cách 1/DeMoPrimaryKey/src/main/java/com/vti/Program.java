package com.vti;

import com.vti.entity.Order;
import com.vti.repository.OrderRepository;

public class Program {
	public static void main(String[] args) {
		OrderRepository repository = new OrderRepository();

		System.out.println("\n\n***********CREATE ORDER***********");

		Order.OrderPK pk = new Order.OrderPK();
		pk.setOrderId((short) 2);
		pk.setProductId((short) 4);

		Order order = new Order();
		order.setId(pk);
		order.setTitle("Order 4");

		repository.createOrder(order);

	}
}




