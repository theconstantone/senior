import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Path2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JPanel;

public class MazeDisplay extends JPanel implements Printable,
ActionListener, KeyListener{
	MazeM m1;
	int offsetX = 10;
	int offsetY = 10;
	int cellSize = 20;
	
	Integer counter = 0;
	
	int pointX, pointY,oldX,oldY;
	
	boolean erase;
	
	public MazeDisplay() {
		m1 = new MazeM();
		pointX = offsetX + cellSize / 2;
		pointY = offsetY + cellSize /2;
		oldX = pointX;
		oldY = pointY;
		addKeyListener(this);	
	}
	public MazeDisplay(MazeM m2) {
		m1 = m2;
		pointX = offsetX + cellSize / 2;
		pointY = offsetY + cellSize /2;
		oldX = pointX;
		oldY = pointY;
		addKeyListener(this);	
	}
	
	MazeDisplay(MazeM m2, int cellSize2){
		m1 = m2;
		cellSize = cellSize2;
		pointX = offsetX + cellSize / 2;
		pointY = offsetY + cellSize /2;
		oldX = pointX;
		oldY = pointY;
		addKeyListener(this);
	}
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.blue);
		
		Dimension size = getSize();
		Insets insets = getInsets();
		
		int w = size.width - insets.left - insets.right;
		int h = size.height - insets.top - insets.bottom;
		
		g2d.setBackground(Color.white);
		g2d.clearRect(0, 0, w, h);
		
		Path2D mazeShape = new Path2D.Double();
		
		int x,y;
		for(Integer i = 0; i< m1.sx; i ++) {
			x = i * cellSize + offsetX;
			for(Integer j = 0; j <m1.sy; j++) {
				y = j * cellSize + offsetY;
			
			
			if (m1.cells[i][j].walls[0] == 1) {
				mazeShape.moveTo(x, y);
				mazeShape.lineTo(x+ cellSize, y);
				g2d.drawLine(x, y, x + cellSize, y);
			}
			if (m1.cells[i][j].walls[1] == 1) {
				mazeShape.moveTo(x + cellSize, y);
				mazeShape.lineTo(x+ cellSize, y + cellSize);
				g2d.drawLine(x+ cellSize, y, x + cellSize, y+ cellSize);
			}
			if (m1.cells[i][j].walls[2] == 1) {
				mazeShape.moveTo(x + cellSize, y);
				mazeShape.lineTo(x+ cellSize, y + cellSize);
				g2d.drawLine(x, y+cellSize, x + cellSize, y + cellSize);
			}
			if (m1.cells[i][j].walls[3] == 1) {
				mazeShape.moveTo(x, y);
				mazeShape.lineTo(x, y + cellSize);
				g2d.drawLine(x, y, x, y + cellSize);
			}
			}
		}
		x = (oldX - offsetX - cellSize /2) / cellSize;
		y = (oldY - offsetY - cellSize /2) / cellSize;
		
		if( x >= 0 && x < m1.sx && oldX > pointX 
				&& m1.cells[x][y].walls[3] ==1) {
			pointX = oldX;
			pointY = oldY;
		}
		else if( x >= 0 && x < m1.sx && oldX < pointX 
				&& m1.cells[x][y].walls[1] ==1) {
			pointX = oldX;
			pointY = oldY;
		}
		else if( y >= 0 && y < m1.sy && oldY > pointY
				&& m1.cells[x][y].walls[0] ==1) {
			pointX = oldX;
			pointY = oldY;
		}
		else if( y >= 0 && y < m1.sy && oldY < pointY
				&& m1.cells[x][y].walls[2] ==1) {
			pointX = oldX;
			pointY = oldY;
		}
		
		if(pointX != oldX || pointY != oldY) {
			counter ++;
		}
		
		g2d.drawString("Moves: " +counter.toString()
		,m1.sx * cellSize + offsetX + 20 ,20);
		g2d.drawString("Move: Arrow Keys",m1.sx * cellSize + offsetX + 20
				, 60);
		
		if( y == m1.sy -1 && x == m1.sx - 1) {
			g2d.drawString("You WON!!!!!", m1.sx * cellSize + offsetX
					+ 20, 100);
		}
		
		g.setColor(Color.black);
		g.fillRect(pointX - 2, pointY -2, 4, 4);
		
	}
	
	@Override
	public void paintComponent( Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void keyPressed(KeyEvent key) {
		oldX = pointX;
		oldY = pointY;
		
		if(key.getKeyCode() == key.VK_DOWN) {
			pointY = pointY + cellSize;
			if(pointY > getBounds().height) {
				pointY = getBounds().height;
			}
		}
		if (key.getKeyCode()== key.VK_UP) {
			pointY = pointY - cellSize;
			if(pointY < 0) {
				pointY = 0;
			}
		}
		if(key.getKeyCode()== key.VK_LEFT) {
			pointX = pointX - cellSize;
			if(pointX < 0) {
				pointX = 0;
			}
		}
		if (key.getKeyCode()== key.VK_RIGHT){
			pointX = pointX + cellSize;
			if (pointX > getBounds().width) {
				pointX = getBounds().width;
			}
		}
		
		repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int print(Graphics arg0, PageFormat arg1, int arg2) throws PrinterException {
		// TODO Auto-generated method stub
		return 0;
	}
}
