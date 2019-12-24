package infos;

public class NoTestAvailableException extends Exception {
	public NoTestAvailableException(String fileExtension){
		super("No integrity test is available for this extension: "+ fileExtension);
	}
}
