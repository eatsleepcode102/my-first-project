package howto.lambdainterface;

import java.util.function.Consumer;

public class ChainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mailer.send(mailer -> mailer.to("to@example.com").from("from@exmaple.com")
		          .subject("Some subject").body("Some content"));
	}
}

class Mailer {
	public Mailer to(String address) {
		System.out.println("To: "+address);
		return this;
	}
	
	public Mailer from(String address) {
		System.out.println("From: "+address);
		return this;
	}
	
	public Mailer subject(String sub) {
		System.out.println("Subject: "+sub);
		return this;
	}
	
	public Mailer body(String address) {
		System.out.println("Body: "+address);
		return this;
	}
	
	public static void send(Consumer<Mailer> mailerOperator) {
		Mailer mailer=new Mailer();
		mailerOperator.accept(mailer);
		System.out.println("Sending...");
	}
}