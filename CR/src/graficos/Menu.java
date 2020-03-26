package graficos;

import java.awt.Graphics;

import texto.Historia;

public class Menu {
	
	public boolean continuar = false;
	
	public void tick() {
		
	}
	
	public void render(Graphics graphics) {
		Historia historia = new Historia();
		historia.render(graphics);
	}
}
