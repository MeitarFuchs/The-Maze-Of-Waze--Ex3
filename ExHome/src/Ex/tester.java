package Ex;

	import java.awt.Color;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
	import java.lang.reflect.InvocationTargetException;
	import java.lang.reflect.Method;

	import javax.imageio.ImageIO;

	public class tester {
		
		public static void cropTest(String filePath,int x, int y, int width, int height,String getterMethodName) {

			try {
				
				BufferedImage im = ImageIO.read(new File(filePath));
				BufferedImage cropped = im.getSubimage(y,x,width,height);

				Picture pic1 = new Picture("myCrop",filePath);
				pic1.cropPicture(x, y, height, width);
				
				
				Pixel[][] picPixels = getPixels(cropped);
				Pixel[][] pic1Pixels = new Pixel[0][0];
				try {
					Method method = pic1.getClass().getMethod(getterMethodName);
					pic1Pixels = (Pixel[][])method.invoke(pic1);
				}
				catch (IllegalAccessException e) { System.out.println("ERROR WITH TESTER: IllegalAccessException");return; }
				catch (InvocationTargetException e) { System.out.println("ERROR WITH TESTER: InvocationTargetException");return; }
				catch (NoSuchMethodException e) { System.out.println("ERROR WITH TESTER: NoSuchMethodException");return; }

				
				if(picPixels.length != pic1Pixels.length) {
					System.out.println("height is not the same , java crop pic height: " + picPixels.length + " my crop pic height: " + pic1Pixels.length);
					return;
				}
				else if(picPixels[0].length != pic1Pixels[0].length) {
					System.out.println("width is not the same , java crop pic width: " + picPixels[0].length + " my crop pic width: " + pic1Pixels[0].length);
					return;
				}
				else {
					int counterS = 0;
					int counterF = 0;
					for (int i = 0; i < height; i++) {
						for (int j = 0; j < width; j++) {
							if(isPixelsEqual(getPixel(i, j,picPixels),pic1.getPixel(i, j)))
								counterS++;
							else {
								counterF++;
								System.out.println(
										"pixel java crop pic on x: " + i + ",y: " + j + " Pixel: " + getPixel(i,j,picPixels) +  
										" not equal to pixel of my crop pic on x: " + i + ",y: " + j + " Pixel: " + pic1.getPixel(i, j));
							}
						}
					}
					System.out.println("success: " + counterS + " failed: " + counterF);
					PictureIO.writePictureToFile("javaCrop", picPixels);
					pic1.output();
				}
				
			}

			catch (

			IOException e) {
				e.printStackTrace();
			}
		}
		
		public static boolean isPixelsEqual(Pixel p1,Pixel p2) {
			return p1.getRed() == p2.getRed() && p1.getGreen() == p2.getGreen() && p1.getBlue() == p2.getBlue(); 
		}
		
		private static Pixel getPixel(int x, int y,Pixel[][] pixels) {
			return pixels[x][y];
		}

		private static Pixel[][] getPixels(BufferedImage im){
			Pixel[][] pixels = new Pixel[im.getHeight()][im.getWidth()];
			for (int i = 0; i < pixels.length; i++) {
				for (int j = 0; j < pixels[0].length; j++) {
					Color c = new Color(im.getRGB(j, i));
					pixels[i][j] = new Pixel(c.getRed(), c.getGreen(), c.getBlue());
				}
			}
			return pixels;
		}
	}
