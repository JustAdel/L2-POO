package infos;
import java.util.ArrayList;

public class ResultList {
	private ArrayList<Result> results = new ArrayList<Result>();
	
	public ArrayList<Result> getResults(){
		return results;
	}
	
	public void add(Result result) {
		results.add(result);
	}
	
	public int resultCount() {
		return results.size();
	}
	
	public String toString() {
		String tmp = "";
		for (Result result : results) {
			tmp += result.toString() + "\n";
		}

		return tmp;
	}
}