import java.awt.Color;
import java.awt.Graphics;

public class Board {
	//tilesize variable
	public static final int tileSize = 100;
	//drawBoard method
	public void drawBoard(Graphics g) {
		//set color
		g.setColor(new Color(200,150,100));
		//draw squares
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				g.fillRect(i*tileSize*2+tileSize, j*tileSize*2, tileSize, tileSize);
				g.fillRect(i*tileSize*2, j*tileSize*2+tileSize, tileSize, tileSize);
			}
		}
	}
}
