package dp.structural.proxy;

public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;
	
	public CommandExecutorProxy(String user, String pwd) {
		if("abc".equals(user) && "123".equals(pwd)) {
			isAdmin=true;
			executor = new CommandExecutorImpl();
		}
	}
	
	@Override
	public void runCommand(String cmd) {
		if(isAdmin) {
			executor.runCommand(cmd);
		} else {
			if(cmd.trim().startsWith("rm")) {
				try {
					throw new Exception("rm command is not allowed for non-admin user");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				executor.runCommand(cmd);
			}
		}
	}
}
