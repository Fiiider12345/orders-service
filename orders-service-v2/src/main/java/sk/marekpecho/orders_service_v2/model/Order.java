package sk.marekpecho.orders_service_v2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import sk.marekpecho.orders_service_v2.converters.CoffeeConverter;
import sk.marekpecho.orders_service_v2.converters.MilkConverter;
import sk.marekpecho.orders_service_v2.converters.SizeConverter;
import sk.marekpecho.orders_service_v2.converters.StateConverter;
import sk.marekpecho.orders_service_v2.converters.TakeawayConverter;
import sk.marekpecho.orders_service_v2.enums.Coffee;
import sk.marekpecho.orders_service_v2.enums.Milk;
import sk.marekpecho.orders_service_v2.enums.Size;
import sk.marekpecho.orders_service_v2.enums.State;
import sk.marekpecho.orders_service_v2.enums.Takeaway;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "COFFEE")
	@Convert(converter = CoffeeConverter.class)
	private Coffee coffee;

	@Column(name = "SIZE")
	@Convert(converter = SizeConverter.class)
	private Size size;

	@Column(name = "MILK")
	@Convert(converter = MilkConverter.class)
	private Milk milk;

	@Column(name = "TAKEAWAY")
	@Convert(converter = TakeawayConverter.class)
	private Takeaway takeaway;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "STATE")
	@Convert(converter = StateConverter.class)
	private State state;

	public Order() {

	}

	public Order(Coffee coffee, Size size, Milk milk, Takeaway takeaway) {
		super();
		this.coffee = coffee;
		this.size = size;
		this.milk = milk;
		this.takeaway = takeaway;
		this.price = coffee.getPrice() + size.getPrice() + milk.getPrice();
		this.state = State.WAITING;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Milk getMilk() {
		return milk;
	}

	public void setMilk(Milk milk) {
		this.milk = milk;
	}

	public Takeaway getTakeaway() {
		return takeaway;
	}

	public void setTakeaway(Takeaway takeaway) {
		this.takeaway = takeaway;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", coffee=" + coffee + ", size=" + size + ", milk=" + milk + ", takeaway=" + takeaway
				+ ", price=" + price + ", state=" + state + "]";
	}

}
