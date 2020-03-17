package entities;

import java.awt.image.BufferedImage;

public class Player extends Entity{

	public Boolean right, up, left, down;
	public Integer speed;
	public Integer jump = 1;
	
	public Player(int x, int y, int w, int h, BufferedImage bufferedImage) {
		super(x, y, w, h, bufferedImage);
		right = up = left = down = false;
	}

	public void tick() {
		if(this.right)
			x += this.jump;
		else if(this.left)
			x -= this.jump;
		if(this.up)
			y -= this.jump;
		else if(this.down)
			y += this.jump;
	}

	public Boolean getRight() {
		return right;
	}

	public void setRight(Boolean right) {
		this.right = right;
	}

	public Boolean getUp() {
		return up;
	}

	public void setUp(Boolean up) {
		this.up = up;
	}

	public Boolean getLeft() {
		return left;
	}

	public void setLeft(Boolean left) {
		this.left = left;
	}

	public Boolean getDown() {
		return down;
	}

	public void setDown(Boolean down) {
		this.down = down;
	}
}
