package dp.structural.proxy;

public class CommandExecutorImpl implements CommandExecutor{

	@Override
	public void runCommand(String cmd) {
		// TODO Auto-generated method stub
		System.out.println("'"+cmd+"'"+ "command executed");
	}
}
