package infos;

public class Command {

	private String command;

	public Command(String command) {
		this.command = command;
		
	}
	
	public String instruction() {
		

		
		if(command.equals("-f"))

		{
			System.out.println("c'est l'analyse d'un fichier que vous souhaitez lancer\n");
			Fichier fic = new Fichier(args[1]);
			fic.read();
		}if(command.equals("-d"))
		{
			System.out.println("c'est l'analyse d'un dossier que vous souhaitez lancer\n");

		}if(command.equals("-h"))
		{
			System.out.println("Liste de commande :\n");
			System.out.println("-f : analyse fichier");
			System.out.println("-d : analyse dossier");
			System.out.println("-s : sauvegarde d'une analyse");
			System.out.println("-h : help");
		}
	}
	
	
	
	public String toString() {
		
	}
}
