package infos;

import java.io.File;
import java.io.FileNotFoundException;

public abstract class ToScan extends File {

	public ToScan(String pathname) throws FileNotFoundException {
		super(pathname);
		if (!exists())
			throw new FileNotFoundException("File not found");
	}

	//public abstract ResultList scan();
}