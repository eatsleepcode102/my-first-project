package dp.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Item> items;

	public ShoppingCart() {
		this.items=new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void removeItem(Item item) {
		this.items.remove(item);
	}
	
	public int caculateTotal() {
		return this.items.stream().map(e-> e.getPrice()).reduce(0, Integer::sum);
	}
	
	public void pay(PaymentStrategy paymentMethod) {
		int amount=caculateTotal();
		paymentMethod.pay(amount);
	}
}
