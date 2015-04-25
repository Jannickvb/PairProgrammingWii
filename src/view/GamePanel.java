package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.RemoteController;

public class GamePanel extends JPanel implements ActionListener{
	
	BufferedImage background;
	int screenHeight;
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	RemoteController rem;
	public GamePanel()
	{
		rem = RemoteController.instance;
		this.screenHeight = 560;
		background = loadImage("images/background.png");
		Timer timer = new Timer(1000/20, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawShapes(g2);
//		drawForeground(g2);
	}
	public void drawShapes(Graphics2D g2)
	{
		Shape s1 = new Rectangle2D.Double(0,0,screenHeight/2,screenHeight/2);
		Shape s2 = new Rectangle2D.Double(0,screenHeight/2,screenHeight/2,screenHeight/2);
		Shape s3 = new Rectangle2D.Double(screenHeight/2,0,screenHeight/2,screenHeight/2);
		Shape s4 = new Rectangle2D.Double(screenHeight/2,screenHeight/2,screenHeight/2,screenHeight/2);
		
		shapes.add(s1);
		shapes.add(s2);
		shapes.add(s3);
		shapes.add(s4);
		for(Shape s: shapes){
			g2.draw(s);
		}
//		Shape textblock = new Rectangle2D.Double(175, 220, 220, 80);
//		g2.setColor(Color.WHITE);
//		g2.fill(textblock);
//		g2.draw(textblock);
	}
	
	int i = 0;
	public void selectColor(){
		
	}
	
	
	public void drawForeground(Graphics2D g2){
		
		g2.drawImage(background,0,0,screenHeight,screenHeight,null);
	}
	
	BufferedImage loadImage(String fileName)
	{

		BufferedImage img = null;

		try {
			img = ImageIO.read(new File(fileName));
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return img;
	}
}
