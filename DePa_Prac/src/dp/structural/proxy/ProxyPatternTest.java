package dp.structural.proxy;

public class ProxyPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommandExecutor cx=new CommandExecutorProxy("abcd", "123");
		cx.runCommand("rm filenam.txt");
	}

}
