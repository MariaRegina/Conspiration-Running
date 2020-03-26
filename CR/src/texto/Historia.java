package texto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Historia {
	
	public static final int WIDTH = 160;
	public static final int HEIGHT = 120;
	public static final int SCALE = 6;
	
	
	
	public void render(Graphics graphics) {
		Constantes constantes = new Constantes();
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(Color.black);
		graphics2d.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		graphics.setColor(Color.white);
		
		graphics.setFont(new Font("arial", Font.BOLD, 30));
		graphics.drawString(constantes.titulo, 80, 100);
		
		graphics.setFont(new Font("arial", Font.BOLD, 20));
		graphics.drawString(constantes.inicioHistoria.get(0), 80, 250);
		graphics.drawString(constantes.inicioHistoria.get(1), 80, 290);
		graphics.drawString(constantes.inicioHistoria.get(2), 80, 330);
		
		graphics.setFont(new Font("arial", Font.BOLD, 15));
		graphics.drawString(constantes.continar, 690, 650);
		
	}
}
