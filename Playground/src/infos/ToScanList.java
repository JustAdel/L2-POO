package infos;

import java.util.ArrayList;

public class ToScanList {
	private ArrayList<ToScan> toScanList = new ArrayList<ToScan>();
	
	public ArrayList<ToScan> getScanList() {
		return toScanList;
	}
	
	public void addToScanList(ToScan element) {
		toScanList.add(element);
	}
	
	public void remove(ToScan file) {
		//A revoir...
		toScanList.remove(file);
	}
	
	public int getToScanListCount() {
		return toScanList.size();
	}
	
	public String toString() {
		String tmp = "";
		for(ToScan file : toScanList) {	
			tmp += file.toString();
		}
		return tmp;
	}
}