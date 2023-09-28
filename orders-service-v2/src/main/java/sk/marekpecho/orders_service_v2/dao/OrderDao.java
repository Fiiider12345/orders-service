package sk.marekpecho.orders_service_v2.dao;

import java.util.List;

import sk.marekpecho.orders_service_v2.model.Order;

public interface OrderDao {
	Order save(Order order);

	List<Order> findAll();

	void delete(Long id);

	Order update(Order order);
}
