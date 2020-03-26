package texto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Perguntas {
	
	public static final int WIDTH = 160;
	public static final int HEIGHT = 120;
	public static final int SCALE = 6;
	
	public static List<String> pergunta = new ArrayList<String>();
	public static List<String> respostas = new ArrayList<String>();
	
	
	public void tick() {
	}
	
	public void renderPergunta1(Graphics graphics) {
		pergunta.add("1 - Resposta de todas as perguntas do universo");
		respostas.add("1) 42");
		respostas.add("2) 11");
		respostas.add("3) 666");
		respostas.add("4) 04"); 
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(new Color(0, 0, 0, 190));
		graphics2d.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		graphics.setColor(Color.white);
		
		graphics.setFont(new Font("arial", Font.BOLD, 25));
		graphics.drawString(pergunta.get(0), 200, 190);
		
		graphics.drawString(respostas.get(0), 200, 300);
		graphics.drawString(respostas.get(1), 200, 350);
		
		graphics.drawString(respostas.get(2), 470, 300);
		graphics.drawString(respostas.get(3), 470, 350);
	}
}
