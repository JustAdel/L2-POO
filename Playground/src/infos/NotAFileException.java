package infos;

public class NotAFileException extends Exception {
	public NotAFileException(String pathname) {
		super(pathname + " is not a file");
	}
}
