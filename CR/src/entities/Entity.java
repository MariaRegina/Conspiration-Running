package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
		graphics.drawImage(this.bufferedImage, this.getX(), this.getY(), null);
	}
	
	public void tick() {
		
	}
	
}
