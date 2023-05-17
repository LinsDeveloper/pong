package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public boolean right, left;
	
	public int x, y;
	
	public int width, height;
	
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 100;
		this.height = 25;
	}
	
	public void tick() {
		
		if(right) {
			
			x = x + 5;
		}
		
		else if(left) {
			
			x = x - 5;
		}
		
		if(x+width > Game.width*3) {
			x = Game.width*3 - width;
		}
		
		else if(x < 0) {
			x = 0;
		}
		
	}
	
	
	
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
	
	
	

}
