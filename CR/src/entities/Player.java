package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graficos.Game;
import texto.Perguntas;

public class Player extends Entity{

	public Boolean right, up, left, down, um, dois, tres, quatro;
	public Integer jump = 1;
	public Boolean pergunta = false;
	
	private int frames = 0, maxFrame = 5, idx = 0, maxIdx = 3;
	private Boolean moved;
	private BufferedImage[] direita;
	private BufferedImage[] esquerda;
	
	public Player(int x, int y, int w, int h, BufferedImage bufferedImage) {
		super(x, y, w, h, bufferedImage);
		right = up = left = down = um = dois = tres = quatro = false;
		
		direita = new BufferedImage[4];
		esquerda = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			direita[i] = Game.spritesheet.getSprite(i * 16, 0, 16, 16);
			esquerda[i] = Game.spritesheet.getSprite(64 + i * 16, 0, 16, 16);
		}
	}

	public void tick() {
		moved = false;
		if(this.right /*&& sem_colisao(x + this.jump, y)*/) {
			moved = true;
			x += this.jump;	
		}else if(this.left /*&& sem_colisao(x - this.jump, y)*/) {
			moved = true;
			x -= this.jump;
		}
		if(this.up /*&& sem_colisao(x, y - this.jump)*/) {
			moved = true;
			y -= this.jump;
		}else if(this.down /*&& sem_colisao(x, y + this.jump)*/) {
			moved = true;
			y += this.jump;
		}
		if(moved) {
			frames++;
			if(frames == maxFrame) {
				frames = 0;
				idx++;
				if(idx > maxIdx)
					idx = 0;
			}
		}
		
		this.checkColisao();
		
		this.terminou();
		
		//Camera.x = Camera.clamp(this.getX() - (Game.WIDTH/2), 0, World.WIDTH);
		//Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT/2), 0, World.HEIGHT);
	}

	private void terminou() {
		
	}

	private void checkColisao() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity atual = Game.entities.get(i);
			if(atual == this)
				continue;
			if(Entity.isColidding(this, atual)) {
				Game.entities.remove(atual);
				Game.cont++;
				if(Game.cont == 1) {
					pergunta = true;
				}
			}
		}
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
	
	public void render(Graphics graphics) {
		if(this.getRight()) {
			graphics.drawImage(direita[idx], this.getX(), this.getY(), null);
		}else if(this.getLeft()) {
			graphics.drawImage(esquerda[idx], this.getX(), this.getY(), null);
		}else {
			graphics.drawImage(direita[idx], this.getX(), this.getY(), null);
		}
	}
}
