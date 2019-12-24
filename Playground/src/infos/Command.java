package infos;

import java.io.FileNotFoundException;

public class Command {
	private String[] commands;

	public Command(String[] commands) {
		this.commands = commands;

	}

	public void runCommand() throws UnknownCommandException {
		if (commands.length > 1) {
			switch (commands[0].toLowerCase()) {
			// Selon la documentation Java 7, le compilateur java génère un bytecode plus
			// efficace à partir d'instructions switch qui utilisent des objets String, qu'à
			// partir d'instructions if-then-else chaînées.
			// La méthode toLowerCase est utilisée pour rendre l'utilisation des commandes
			// insensible à la casse.
			case "-f":
				fileAnalysis(commands[1]);
				break;
			case "-d":
				folderAnalysis(commands[1]);
				break;
			case "-h":
				help();
				break;
			default:
				throw new UnknownCommandException(commands[0]);
			}
		} else {
			System.out.println("Merci d'entrer des paramêtres.");
			help();
		}
	}

	public void fileAnalysis(String pathName) {
		try {
			FileInfo file = new FileInfo(pathName);
			file.scan();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NotAFileException e) {
			System.err.println(e.getMessage());
		}
	}

	public void folderAnalysis(String pathName) {
		try {
			Folder folder = new Folder(pathName);
			folder.scan();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NotADirectoryException e) {
			System.err.println(e.getMessage());
		}
	}

	public void help() {
		System.out.println("Liste de commandes :");
		System.out.println("\t-f : analyse fichier");
		System.out.println("\t-d : analyse dossier");
		System.out.println("\t-s : sauvegarde d'une analyse");
		System.out.println("\t-h : help");
	}
}
