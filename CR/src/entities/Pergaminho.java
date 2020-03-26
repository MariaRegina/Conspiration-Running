package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graficos.Spritesheet;
import world.World;

public class Pergaminho extends Entity{
	
	public static BufferedImage pergaminho = new Spritesheet("/pergaminho.png").getSprite(0, 0, 160, 120);
	
	public Pergaminho() {
		super(0, 0, World.WIDTH, World.HEIGHT, pergaminho);
	}
	
	public void render(Graphics graphics) {
		graphics.drawImage(pergaminho, x, y, null);
	}
	
}
