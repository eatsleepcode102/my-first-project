package dp.behavioral.command;

public class CloseFileCommand implements Command {
	
	private FileSystemReceiver fileSystem;

	public CloseFileCommand(FileSystemReceiver fs) {
		this.fileSystem=fs;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.fileSystem.closeFile();
	}
}