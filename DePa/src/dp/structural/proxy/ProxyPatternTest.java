package dp.structural.proxy;

public class ProxyPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommandExecutor exe=new CommandExecutorProxy("abc","123");
		try {
		exe.runCommand("rm somefile");
		exe.runCommand("cd intofolder");
		} catch (Exception e) {
			System.out.println("Exception messages:"+ e.getMessage());
		}
	}
}
