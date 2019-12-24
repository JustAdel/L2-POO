package infos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageIntegrity implements IntegrityInterface{
	private int width;
	private int height;
	public boolean validatedIntegrity(File file) {
		boolean isImage = false;		
		try {
			BufferedImage bimg = ImageIO.read(file);
			width = bimg.getWidth();
			height = bimg.getHeight();
			if (bimg != null) {
				isImage = true;
			}
		} catch (IOException e) {
			System.err.println("problème de dim\n");
		}
		return isImage;
	}
	public String toString() {
		String tmp = "";
		tmp += "dimensions : width = " + width + " height = " + height +"\n";
		return tmp;
	}
}
