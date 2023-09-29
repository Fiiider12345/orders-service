package sk.marekpecho.orders_service_v2.service;

import java.util.List;

import sk.marekpecho.orders_service_v2.dao.OrderDaoImpl;
import sk.marekpecho.orders_service_v2.enums.Coffee;
import sk.marekpecho.orders_service_v2.enums.Milk;
import sk.marekpecho.orders_service_v2.enums.Size;
import sk.marekpecho.orders_service_v2.enums.State;
import sk.marekpecho.orders_service_v2.enums.Takeaway;
import sk.marekpecho.orders_service_v2.model.Order;

public class OrderService {

	private static OrderService orderService = null;
	private OrderDaoImpl orderDaoImpl;

	private OrderService() {
		this.orderDaoImpl = new OrderDaoImpl();
		createDummyData();
	}

	private void createDummyData() {
		orderDaoImpl.save(new Order(Coffee.CAPPUCCINO, Size.SMALL, Milk.ALMOND, Takeaway.ON_SITE));
		orderDaoImpl.save(new Order(Coffee.ESPRESSO, Size.LARGE, Milk.NONE, Takeaway.TAKEAWAY));
		orderDaoImpl.save(new Order(Coffee.LATTE, Size.MEDIUM, Milk.COW, Takeaway.ON_SITE));
	}

	public static OrderService getOrderService() {
		if (orderService == null) {
			return orderService = new OrderService();
		}

		return orderService;
	}

	public Order addNewOrder(Order order) {
		order.setPrice(order.getCoffee().getPrice() + order.getMilk().getPrice() + order.getSize().getPrice());
		order.setState(State.WAITING);
		return orderDaoImpl.save(order);
	}

	public List<Order> getAllOrders() {
		return orderDaoImpl.findAll();
	}

	public void deleteOrderById(Long id) {
		List<Order> list = orderDaoImpl.findAll();

		for (Order order : list) {
			if (order.getId() == id) {
				if (order.getState() == State.WAITING || order.getState() == State.PICKED_UP) {
					orderDaoImpl.delete(id);
				} else {
					System.out.println("Can not delete order in preparation!");
				}
			}
		}

	}

	public Order updateOrder(Order order) {
		return orderDaoImpl.update(order);
	}

	public Order getFirstOrder() {
		List<Order> orders = orderDaoImpl.findAll();
		if (orders.size() == 0) {
			return null;
		} else {
			return orders.get(0);
		}
	}
}
