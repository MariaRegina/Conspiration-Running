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
	
	public void tick() {
	}
	
	public void render(Graphics graphics, int cont) {
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(new Color(0, 0, 0, 190));
		graphics2d.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		graphics.setColor(Color.white);

		switch (cont) {
		case 1:
			pergunta1(graphics);
			break;
		case 2:
			pergunta2(graphics);
			break;
		case 3:
			pergunta3(graphics);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + cont);
		}
		
	}

	private void pergunta1(Graphics graphics) {
		List<String> pergunta = new ArrayList<String>();
		List<String> respostas = new ArrayList<String>();
		
		pergunta.add("1 - Considerando que a dist�ncia entre o planeta Terra e");
		pergunta.add("    o Sol � cerca de 150 milh�es de quil�metros");
		pergunta.add("    Quanto tempo a luz do Sol leva para chegar at� nosso planeta?");
		
		respostas.add("1) Aproximadamente 8 minutos");
		respostas.add("2) Aproximadamente 3 minutos");
		respostas.add("3) Aproximadamente 8 segundos");
		respostas.add("4) Aproximadamente 3 segundos"); 
		
		
		graphics.setFont(new Font("arial", Font.BOLD, 20));
		graphics.drawString(pergunta.get(0), 100, 190);
		graphics.drawString(pergunta.get(1), 110, 215);
		graphics.drawString(pergunta.get(2), 110, 240);
		
		graphics.drawString(respostas.get(0), 110, 350);
		graphics.drawString(respostas.get(1), 110, 400);
		
		graphics.drawString(respostas.get(2), 470, 350);
		graphics.drawString(respostas.get(3), 470, 400);
	}
	
	private void pergunta2(Graphics graphics) {
		List<String> pergunta = new ArrayList<String>();
		List<String> respostas = new ArrayList<String>();
		
		pergunta.add("2 - Segundo Einstein o que � a gravidade?");
		
		respostas.add("1) A for�a de atra��o entre dois corpos");
		respostas.add("2) A influ�ncia que a curvatura do espa�o-tempo produz sobre objetos que estejam nele");
		respostas.add("3) A tendencia que um corpo tem de permanecer no estado em que est�");
		respostas.add("4) Agente f�sico capaz de alterar o estado de repouso ou de movimento uniforme de"); 
		respostas.add("   um corpo material");
		
		graphics.setFont(new Font("arial", Font.BOLD, 20));
		graphics.drawString(pergunta.get(0), 100, 190);
		
		graphics.drawString(respostas.get(0), 50, 350);
		graphics.drawString(respostas.get(1), 50, 400);
		
		graphics.drawString(respostas.get(2), 50, 450);
		graphics.drawString(respostas.get(3), 50, 500);
		graphics.drawString(respostas.get(4), 55, 525);
	}
	
	private void pergunta3(Graphics graphics) {
		List<String> pergunta = new ArrayList<String>();
		List<String> respostas = new ArrayList<String>();
		
		pergunta.add("3 - A busca da origem do universo remonta �s mais antigas mitologias registradas."); 
		pergunta.add("    Atualmente, a explica��o cient�fica mais aceita � a teoria da Grande Explos�o (Big Bang)."); 
		pergunta.add("    Mas afinal quem anunciou essa teoria?");
		
		respostas.add("1) Edwin Hubble");
		respostas.add("2) Albert Einsten");
		respostas.add("3) Georges Lema�tre");
		respostas.add("4) Issac Newton"); 
		
		graphics.setFont(new Font("arial", Font.BOLD, 20));
		graphics.drawString(pergunta.get(0), 100, 190);
		
		graphics.drawString(respostas.get(0), 110, 350);
		graphics.drawString(respostas.get(1), 110, 400);
		graphics.drawString(respostas.get(2), 470, 350);
		graphics.drawString(respostas.get(3), 470, 400);
	}
}
