package world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import graficos.Game;

public class World {
	
	private BufferedImage map;
	
	public static int WIDTH;
	public static int HEIGHT;
	
	public World(String caminho) {
		try {
			map = ImageIO.read(getClass().getResource(caminho));
			int[] pixels  = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void render(Graphics graphics) {
		graphics.drawImage(map, 0, 0, null);
	}
}
