package ctec.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 
 * @author Alejandro Magallanes
 *
 */
public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	
	public ShapePanel()
	{
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		circleList = new ArrayList<Ellipse2D>();
		ellipseList = new ArrayList<Ellipse2D>();
	}
	
	public void addRectangle()
	{
		//random info here//
		rectangleList.add(new Rectangle(10, 20, 50, 10));
	}
	
	public void addSquare()
	{
		
	}
	
	public void addEllipse()
	{
		
	}
	
	public void addCircle()
	{
		
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int [3];
		int [] yPoints = new int [3];
		xPoints[0] = (int)(Math.random() * 250);
		xPoints = new int [] {(int)(Math.random() * 250), (int)(Math.random() * 250), (int)(Math.random() * 250)};
		yPoints = new int [] {(int)(Math.random() * 250), (int)(Math.random() * 250), (int)(Math.random() * 250)};
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		
		triangleList.add(triangle);
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 10) + 3;
		int [] xPoints = new int [numberOfSides];
		int [] yPoints = new int [numberOfSides];
		
		for (int sides = 0; sides < numberOfSides; sides++)
		{
			xPoints[sides] = (int)(Math.random() * 300);
			yPoints[sides] = (int)(Math.random() * 300);
		}
		
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		//Loops to do lists.
		
		for(Polygon currentTriangle :triangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentTriangle);
		}
		
		for(Polygon current : polygonList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(current);
		}
	}
}
