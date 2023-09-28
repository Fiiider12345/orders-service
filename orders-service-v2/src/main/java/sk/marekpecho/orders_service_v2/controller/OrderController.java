package sk.marekpecho.orders_service_v2.controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sk.marekpecho.orders_service_v2.model.Order;
import sk.marekpecho.orders_service_v2.service.OrderService;

@Path("/orders")
public class OrderController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrders() {
		return OrderService.getOrderService().getAllOrders();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Order addOrder(Order order) {
		return OrderService.getOrderService().addNewOrder(order);
	}

	@DELETE
	@Path("{id}")
	public void cancelOrder(@PathParam("id") Long id) {
		OrderService.getOrderService().deleteOrderById(id);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Order updateOrder(Order order) {
		return OrderService.getOrderService().updateOrder(order);
	}

	@GET
	@Path("/firstOrder")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getFirstOrder() {
		return OrderService.getOrderService().getFirstOrder();
	}
}
