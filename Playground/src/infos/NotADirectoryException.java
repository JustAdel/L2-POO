package infos;

public class NotADirectoryException extends Exception {
	public NotADirectoryException(String pathName) {
		super(pathName + " is not a directory");
	}
}