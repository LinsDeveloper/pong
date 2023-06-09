package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	public static int width = 180;
	public  static int height = 120;
	public  static int scale = 3;
	public static Player player;
	public static inimigo inimigo;
	public static Ball ball;
	
	
	public BufferedImage layer = new BufferedImage(width*scale, height*scale, BufferedImage.TYPE_INT_RGB);
	
	
	
	public Game() {
		this.setPreferredSize(new Dimension(width*scale, height*scale));
		this.addKeyListener(this);
		player = new Player(300, 340);
		inimigo = new inimigo(100, 0);
		ball = new Ball(100, height-1);
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		new Thread(game).start();
		
		
	}
	
	public void tick() {
		player.tick();
		inimigo.tick();
		ball.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width*scale, height*scale);
		player.render(g);
		inimigo.render(g);
		ball.render(g);
		
		g = bs.getDrawGraphics();
		
		g.drawImage(layer, 0, 0, width*scale, height*scale, null);
		
		bs.show();
		
	}
	@Override
	public void run() {
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}




	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}






	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			player.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			player.left = true;
		}
		
	}




	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			player.left = false;
		}
		
	}
	

}
