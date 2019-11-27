package infos;

import org.apache.commons.io.FilenameUtils;

/**
 * @author Adel
 * C'est juste une classe test pour voir comment utiliser des classes non natives de java
 * 
 */
public class Extension {
	/**
	 * @param filename, it can be either a filename, or a path.
	 * @return file a extension. If the file has no extension, this method will return an empty string.
	 * If the filename is only an extension, this method will return the String after the dot.
	 */
	public String getExtensionByApacheCommonLib(String filename) {
	    return FilenameUtils.getExtension(filename);
	    
	}
}