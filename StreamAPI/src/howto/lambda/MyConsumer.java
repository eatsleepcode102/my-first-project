package howto.lambda;

import java.util.function.Consumer;

public class MyConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<Trade> consumer= x-> x.setQuantity(x.getQuantity() * 2);
		Trade t = new Trade(1,"XT",1000,"NEW");
		System.out.println("T's qty before:"+ t.getQuantity());
		consumer.accept(t);
		System.out.println("T's qty after:"+ t.getQuantity());
	}

}

class Trade {

	  private int tradeId = 0;
	  private String issuer = null;
	  private int quantity = 0;
	  private String status = null;

	  public Trade(int id, String issuer, int quantity, String status) {
	    this.tradeId = id;
	    this.issuer = issuer;
	    this.quantity = quantity;
	    this.status = status;
	  }

	  public int getTradeId() {
	    return tradeId;
	  }

	  public void setTradeId(int tradeId) {
	    this.tradeId = tradeId;
	  }

	  public String getIssuer() {
	    return issuer;
	  }

	  public void setIssuer(String issuer) {
	    this.issuer = issuer;
	  }

	  public int getQuantity() {
	    return quantity;
	  }

	  public void setQuantity(int quantity) {
	    this.quantity = quantity;
	  }

	  public String getStatus() {
	    return status;
	  }

	  public void setStatus(String status) {
	    this.status = status;
	  }

	  @Override
	  public String toString() {
	    return "Trade{" + "tradeId=" + tradeId + ", issuer=" + issuer
	        + ", quantity=" + quantity + ", status=" + status + '}';
	  }

	}