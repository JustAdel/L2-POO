package infos;

public class AnalysisPushed extends Analysis {
	private Boolean unzippedFile;
	private Boolean special = false;

	public AnalysisPushed(FileInfo file1) {
		super(file1);
		if (file1.getFileExtension().equals("zip")) {
			special = true;
			unzip();
		} else {
			if (file1.getFileExtension().toString().equals("jpg")|| file1.getFileExtension().toString().equals("png")) {
				special = true;
				dim();
			}
		}
	}


	
	public String toString() {
		String tmp = super.toString();
		if(special) {
			if(getFile().getFileExtension().equals("zip")) {
				tmp += "Unzipped: " + unzippedFile + "\n";
			}else {
				tmp += dim();
			}
		}
		return tmp;
	}

}
