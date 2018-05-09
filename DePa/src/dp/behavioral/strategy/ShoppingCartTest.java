package dp.behavioral.strategy;

public class ShoppingCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingCart cart=new ShoppingCart();
		Item item1=new Item("1234",10);
		Item item2=new Item("5678",40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
		cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));
		cart.pay(new CreditCardStrategy("JObkert", "1234523", "123", "12/15"));
	}

}
