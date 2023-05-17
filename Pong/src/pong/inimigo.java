package pong;

import java.awt.Color;
import java.awt.Graphics;

public class inimigo {
	
	public double x, y;
	
	public int width, height;
	
	public inimigo(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 100;
		this.height = 25;
	}
	
	public void tick() {
		
		x += (Game.ball.x - x - 40)* 1.6;
		
	
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
	}

}
