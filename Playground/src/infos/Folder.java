package infos;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;

public class Folder extends ToScan {
	private ArrayList<File> files;

	public Folder(String pathName) throws FileNotFoundException, NotADirectoryException {
		super(pathName);
		if (this.isDirectory()) {
			files = new ArrayList<File>();
			addToList(this);
		} else {
			throw new NotADirectoryException(pathName);
		}
	}

	public void addToList(File folder) // BOUCLE RECURSIVE
	{
		if (folder.isFile()) {
			files.add(folder);
		} else {
			try {
				File[] fileInfos = folder.listFiles();
				for (File file : fileInfos) {
					if (file.isDirectory()) {
						addToList(file); // Folders are not added to the ArrayList.
					} else {
						files.add(file);
					}
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public ArrayList<File> getArray() {
		return files;
	}

	public void scan() {
		try {
			Iterator<File> iter = getArray().iterator();
			while (iter.hasNext()) {
				FileInfo file;
				try {
					file = new FileInfo(iter.next().getPath());
					file.scan();
					System.out.println("-----------------------------");
				} catch (NotAFileException e) {
					System.err.println(e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	public String toString() {
		Iterator<File> iter = files.iterator();
		String res = "Votre dossier " + getName() + " contient les fichiers suivants :\n\n ";
		while (iter.hasNext()) {
			res += iter.next().toString() + "\n";
		}
		return res;
	}
}