package sk.marekpecho.orders_service_v2.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sk.marekpecho.orders_service_v2.model.Order;

public class OrderDaoImpl implements OrderDao {

	EntityManagerFactory entityManagerFactory;

	public OrderDaoImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("default");
	}

	@Override
	public Order save(Order order) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			entityManager.persist(order);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			try {
				entityManager.getTransaction().rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			entityManager.close();
		}

		return order;
	}

	@Override
	public List<Order> findAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Order> list = null;

		try {
			entityManager.getTransaction().begin();

			list = entityManager.createQuery("from Order", Order.class).getResultList();

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			try {
				entityManager.getTransaction().rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			entityManager.close();
		}
		return list;

	}

	@Override
	public void delete(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			entityManager.createQuery("delete from Order where id = :id").setParameter("id", id).executeUpdate();

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			try {
				entityManager.getTransaction().rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Order update(Order order) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			entityManager.merge(order);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			try {
				entityManager.getTransaction().rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			entityManager.close();
		}

		return order;
	}

}
