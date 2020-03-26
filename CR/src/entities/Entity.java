package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import world.Camera;

public class Entity {
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	private BufferedImage bufferedImage;
	
	public Entity(int x, int y, int w, int h, BufferedImage bufferedImage) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.bufferedImage = bufferedImage;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	public void render(Graphics graphics) {
		graphics.drawImage(this.bufferedImage, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
	
	public void tick() {
		
	}

	public static boolean isColidding(Entity player, Entity atual) {
		Rectangle r1 = new Rectangle(player.getX(), player.getY(), player.getW(), player.getH());
		Rectangle r2 = new Rectangle(atual.getX(), atual.getY(), atual.getW(), atual.getH());
		return r1.intersects(r2);
	}
	
}
