package Ex;
package default;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Pixel;

public class PictureIO {
	
	public static Pixel[][] readPictureFromFile(String fileName) {
		try {
			BufferedImage im = ImageIO.read(new File(fileName));
			Pixel[][] pixels = new Pixel[im.getHeight()][im.getWidth()];
			for (int i = 0; i < pixels.length; i++) {
				for (int j = 0; j < pixels[0].length; j++) {
					Color c = new Color(im.getRGB(j, i));
					pixels[i][j] = new Pixel(c.getRed(), c.getGreen(), c.getBlue());
				}
			}
			return pixels;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writePictureToFile(String fileName, Pixel[][] pixels) {
		BufferedImage im = new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_INT_RGB);
		Graphics g = im.createGraphics();
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[0].length; j++) {
				g.setColor(new Color(pixels[i][j].getRed(),pixels[i][j].getGreen(),pixels[i][j].getBlue()));
				g.fillRect(j, i, 1, 1);
			}
		}
		try {
			fileName = fileName + ".jpg";
		    ImageIO.write(im, "jpg", new File(fileName));
		    }catch (IOException e) { 
		       e.printStackTrace();
		    }
	}
}
