package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	
	
		public int x, y;
		
		public int width, height;
		
		
		public double dx, dy;
		public double speed = 3.6;
		
		public Ball(int x, int y) {
			this.x = x;
			this.y = y;
			this.width = 8;
			this.height = 8;
			
			
			
			int angle = new Random().nextInt(160);
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			
			
		}
		
		public void tick() {
			
			if(x+(dx*speed) + width >= Game.width*3) {
				dx*=-1;
			}
			
			else if(x+(dx*speed) < 0) {
				dx*=-1;
			}
			
			if(y >= Game.height*3) {
				
				System.out.println("Ponto do inimigo, que pena!");
				new Game();
				return;
				
			}else if(y < 0) {
				System.out.println("Ponto seu! Hurrulll");
				new Game();
				return;
			}
			
			
			Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), width, height);
			
			Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
			
			Rectangle boundsInimigo = new Rectangle((int)Game.inimigo.x, (int)Game.inimigo.y, Game.inimigo.width, Game.inimigo.height);
			
			if(bounds.intersects(boundsPlayer)) {
				dy*=-1;
			}
			
			if(bounds.intersects(boundsInimigo)) {
				dy*=-1;
			}
			
			x+=dx*speed;
			y+=dy*speed;
		}
		
		
		public void render(Graphics g) {
			g.setColor(Color.yellow);
			g.fillRect(x, y, width, height);
		}

}
