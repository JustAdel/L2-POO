package infos;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;

public class Folder {
	private File folder;
	private ArrayList<File> files;

	public Folder(String folderName) throws FileNotFoundException {
		folder = new File(folderName);
		if (folder.exists() && folder.isDirectory()) {
			files = new ArrayList<File>();
			remplissage(folder);
		} else {
			throw new FileNotFoundException(folderName + " was not found or is not a directory.");
		}
	}

	public void remplissage(File folder) // BOUCLE RECURSIVE
	{
		try {
			File[] fileInfos = folder.listFiles();
			for (File file : fileInfos) {
				if (file.isDirectory()) {
					remplissage(file); // Folders are not added to the ArrayList.
				} else {
					files.add(file);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public ArrayList<File> getArray() {
		return files;
	}

	public String toString() {
		Iterator<File> iter = files.iterator();
		String res = "Votre dossier " + folder.getName() + " contient les fichiers suivants :\n\n ";
		while (iter.hasNext()) {
			res += iter.next().toString() + "\n";
		}
		return res;
	}
}
