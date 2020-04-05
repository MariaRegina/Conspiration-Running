package graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import entities.Entity;
import entities.Player;
import entities.Tile;
import texto.Constantes;
import texto.Perguntas;
import world.World;	

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static JFrame frame;
	
	public static final int WIDTH = 160;
	public static final int HEIGHT = 120;
	public static final int SCALE = 6;
	
	public static int cont = 0;
	
	private BufferedImage bufferedImage;
	
	private Thread thread;
	private Boolean flag;
	
	public static Spritesheet spritesheet;
	
	public static World world;
	
	public static List<Entity> entities;
	public static Player player;
	public static Tile [] bandeira;
	
	public static String estado = "MENU";
	public Menu menu;
	public Perguntas perguntas;
	
	public static Graphics graphics;

	private boolean continuar;
	
	private int certo = 0;
	
	public Game() {
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.iniciarGame();
		
		
		bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		entities = new ArrayList<Entity>();
		spritesheet = new Spritesheet("/geison.png");
		world = new World("/fase1.png");
		player = new Player(15, 100, 16, 16, spritesheet.getSprite(0, 0, 16, 16));
		entities.add(player);
		
		bandeira = new Tile[3];
		
		for(int i = 0; i < 3; i++) {
			bandeira[i] = new Tile(41 + 34 * i, i % 2 == 0 ? 15 : 85);
			entities.add(bandeira[i]);
		}
		
		menu = new Menu();
		perguntas = new Perguntas();
	}
	
	public void iniciarGame() {
		frame = new JFrame("Cospiration Running");
		frame.add(this);
		frame.setResizable(false); // usuario não pode redimencionar
		frame.pack();
		frame.setLocationRelativeTo(null); // janela no centro
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fecha o jogo e não minimiza
		frame.setVisible(true); 
	}
	
	public synchronized void start() {
		thread =  new Thread(this);
		flag = true;
		thread.start();
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.start();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double fps = 60.0;
		double ns = 1e9 / fps;
		double delta = 0;
		
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		while(flag) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				this.tick();
				this.render();
				
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000) {
				frames = 0;
				timer += 1000;
			}
		}
		this.stop();
	}

	private void stop() {
		flag = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void render() {
		BufferStrategy bufferStrategy = getBufferStrategy();
		if(bufferStrategy == null) {
			createBufferStrategy(3);
			return;
		}
		graphics = bufferedImage.getGraphics();
		graphics.setColor(new Color(19,19,19 ));
		graphics.fillRect(0, 0, WIDTH, HEIGHT); //desenha um retangulo
		
		world.render(graphics);
		
		////////////////////////
		
		
		//renderiza personagem
		for(int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			entity.render(graphics);
		}
		
		//////////////////
		
		graphics.dispose(); //limpar dados melhora performace
		graphics = bufferStrategy.getDrawGraphics();
		graphics.drawImage(bufferedImage, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		
		if(player.getX() > 150 && player.getY() > 80) {
			this.estado = "FIM";
		}
		
		if(this.estado == "MENU") {
			menu.render(graphics);
		}else if(this.estado == "PERGUNTA") {
			perguntas.render(graphics, Game.cont);
		}else if(this.estado == "FIM") {
			this.fim();
		}
		
		bufferStrategy.show();
	}
	
	private void fim() {
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(new Color(0, 0, 0, 190));
		graphics2d.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		graphics.setColor(Color.white);
		
		graphics.setFont(new Font("arial", Font.BOLD, 20));
		graphics.drawString("Repostas certas: " + certo, 150, 100);
		
		graphics.setFont(new Font("arial", Font.BOLD, 30));
		graphics.drawString(Constantes.fimFase1.get(0), 100, 190);
		graphics.drawString(Constantes.fimFase1.get(1), 100, 230);
		graphics.drawString(Constantes.fimFase1.get(2), 100, 270);
		
	}

	private void tick() {
		if(player.pergunta) {
			this.estado = "PERGUNTA";
		}
		if(this.estado == "RODANDO") {
			for(int i = 0; i < entities.size(); i++) {
				Entity entity = entities.get(i);
				entity.tick();
				if(this.estado != "RODANDO") break;
			}
		}
		if(this.estado == "MENU") {
			menu.tick();
			if(this.continuar)
				this.estado = "RODANDO";
		}
		if(this.estado == "PERGUNTA") {
			if(this.player.um || this.player.dois || this.player.tres || this.player.quatro) {
				if(this.player.um && Game.cont == 1) {
					certo++;
				}else if(this.player.dois && Game.cont == 2) {
					certo++;
				}else if(this.player.tres && Game.cont == 3) {
					certo++;
				}
				this.estado = "RODANDO";
				this.continuar = false;
				player.pergunta = false;
			}
		}
	}

	private void update() {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Integer action = e.getKeyCode();
		switch (action) {
		case KeyEvent.VK_RIGHT:
			this.player.right = true;
			break;
		case KeyEvent.VK_D:
			this.player.right = true;
			break;
		case KeyEvent.VK_LEFT:
			this.player.left = true;
			break;
		case KeyEvent.VK_A:
			this.player.left = true;
			break;
		case KeyEvent.VK_UP:
			this.player.up = true;
			break;
		case KeyEvent.VK_W:
			this.player.up = true;
			break;
		case KeyEvent.VK_DOWN:
			this.player.down = true;
			break;
		case KeyEvent.VK_S:
			this.player.down = true;
			break;
		case KeyEvent.VK_E:
			this.continuar = true;
			break;
		case KeyEvent.VK_1:
			this.player.um = true;
			break;
		case KeyEvent.VK_2:
			this.player.dois = true;
			break;
		case KeyEvent.VK_3:
			this.player.tres = true;
			break;
		case KeyEvent.VK_4:
			this.player.quatro = true;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Integer action = e.getKeyCode();
		switch (action) {
		case KeyEvent.VK_RIGHT:
			this.player.right = false;
			break;
		case KeyEvent.VK_D:
			this.player.right = false;
			break;
		case KeyEvent.VK_LEFT:
			this.player.left = false;
			break;
		case KeyEvent.VK_A:
			this.player.left = false;
			break;
		case KeyEvent.VK_UP:
			this.player.up = false;
			break;
		case KeyEvent.VK_W:
			this.player.up = false;
			break;
		case KeyEvent.VK_DOWN:
			this.player.down = false;
			break;
		case KeyEvent.VK_S:
			this.player.down = false;
			break;
		case KeyEvent.VK_E:
			this.continuar = false;
			break;
		case KeyEvent.VK_1:
			this.player.um = false;
			break;
		case KeyEvent.VK_2:
			this.player.dois = false;
			break;
		case KeyEvent.VK_3:
			this.player.tres = false;
			break;
		case KeyEvent.VK_4:
			this.player.quatro = false;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}
}
