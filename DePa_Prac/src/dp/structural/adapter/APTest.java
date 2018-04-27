package dp.structural.adapter;

public class APTest {

	public static void main(String[] args) {
		SocketClassAdapterImpl socket=new SocketClassAdapterImpl();
		System.out.println(socket.get12Volts().getVolts());
	}
}
