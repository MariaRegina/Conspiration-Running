package graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import entities.Entity;
import entities.Player;
import world.World;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static JFrame frame;
	
	private final int WIDTH = 160;
	private final int HEIGHT = 120;
	private final int SCALE = 3;
	
	private BufferedImage bufferedImage;
	
	private Thread thread;
	private Boolean flag;
	
	private Spritesheet spritesheet;
	
	public static World world;
	
	public List<Entity> entities;
	private Player player;
	
	public Game() {
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.iniciarGame();
		
		world = new World("/map.png");
		
		bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		entities = new ArrayList<Entity>();
		spritesheet = new Spritesheet("/geison.png");
		
		player = new Player(0, 0, 16, 16, spritesheet.getSprite(0, 0, 16, 16));
		entities.add(player);
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
				System.out.println("FPS: " + frames);
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
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(new Color(19,19,19 ));
		graphics.fillRect(0, 0, WIDTH, HEIGHT); //desenha um retangulo
		
		//mensagem
		/*graphics.setFont(new Font("Arial", Font.BOLD, 12));
		graphics.setColor(Color.WHITE);
		graphics.drawString("Conspiration Running", 19, 19);*/
		
		//graphics.drawImage(player, 20, 40, null); //, dy2, sx1, sy1, sx2, sy2, observer)
		
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
		bufferStrategy.show();
	}
	
	private void tick() {
		for(int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			entity.tick();
		}
	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}
}








