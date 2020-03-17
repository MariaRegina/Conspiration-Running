package graficos;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	private BufferedImage bufferedImage;
	
	public Spritesheet(String caminho) {
		try {
			bufferedImage = ImageIO.read(getClass().getResource(caminho));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int x, int y, int w, int h) {
		return bufferedImage.getSubimage(x, y, w, h);
	}
	
}
