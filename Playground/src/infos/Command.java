package infos;

public class Command {
	private String[] commands;

	public Command(String[] commands) {
		this.commands = commands;

	}

	public void runCommand() throws UnknownCommandException {
		for (String s : commands) {
			switch (s.toLowerCase()) {
			case "-f":
				fileAnalysis();
				break;
			case "-h":
				help();
				break;
			default:
				throw new UnknownCommandException(s);
			}
		}
	}
	
	public void fileAnalysis() throws IllegalArgumentException{
		
	}
	public void help() {
		
	}
}
