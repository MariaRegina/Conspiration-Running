package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graficos.Game;

public class Tile extends Entity{
	
	public static BufferedImage flag = Game.spritesheet.getSprite(9 * 16, 0, 16, 16);
	
	public Tile(int x, int y) {
		super(x, y, 16, 16, flag);
	}
	
	public void render(Graphics graphics) {
		graphics.drawImage(flag, x, y, null);
	}
	
}
