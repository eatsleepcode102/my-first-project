package dp.behavioral.command;

public class OpenFileCommand implements Command {
	
	private FileSystemReceiver fileSystem;

	public OpenFileCommand(FileSystemReceiver fs) {
		this.fileSystem=fs;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.fileSystem.openFile();
	}
}
