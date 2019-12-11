package infos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Result {

	private AnalysisPushed an;
	
	public Result (AnalysisPushed fileAnalysis) {
		an = fileAnalysis;
	}
	
	public void save(String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); //Here true is to append the content to file
				//VI
				String fileInfos = an.getFile().toString();
				String anResult = an.toString();
				writer.write(fileInfos + anResult);
				writer.newLine();
			
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	public String toString() {
		String tmp = "";
		tmp += an.getFile().toString() + an.toString();
		return tmp;
	}
}
