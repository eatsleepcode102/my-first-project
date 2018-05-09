package dp.behavioral.command;

public class WriteFileCommand implements Command {
	
	private FileSystemReceiver fileSystem;

	public WriteFileCommand(FileSystemReceiver fs) {
		this.fileSystem=fs;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.fileSystem.writeFile();
	}
}
