package ctec.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
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
		int xPosition = (int)(Math.random() * getWidth());
		int yPosition = (int)(Math.random() * getHeight());
		int width = (int)(Math.random() * 200);
		
		Rectangle square = new Rectangle(xPosition, yPosition, width, width);
		squareList.add(square);
	}
	
	public void addEllipse()
	{
		int xPosition = (int)(Math.random() * 150);
		int yPosition = (int)(Math.random() * 100);
		int width = (int)(Math.random() * 200);
		int height = (int)(Math.random() * 100);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
		ellipseList.add(currentEllipse);
	}
	
	public void addCircle()
	{
		int xPosition = (int)(Math.random() * 150);
		int yPosition = (int)(Math.random() * 100);
		int width = (int)(Math.random() * 250);
		
		Ellipse2D circle = new Ellipse2D.Double(xPosition, yPosition, width, width);
		circleList.add(circle);
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
		
		for(Ellipse2D current : ellipseList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			mainGraphics.draw(current);
		}
		
		for(Rectangle current : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			mainGraphics.draw(current);
		}
		
		for(Rectangle current : squareList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			mainGraphics.draw(current);
		}
		
		for(Ellipse2D current : circleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			mainGraphics.draw(current);
		}
		
		//Cleaner code, but same code.
		drawShapes(mainGraphics, circleList);
		drawShapes(mainGraphics, ellipseList);
		drawShapes(mainGraphics, squareList);
		drawShapes(mainGraphics, rectangleList);
		drawShapes(mainGraphics, triangleList);
		drawShapes(mainGraphics, polygonList);
	}
	
	private void drawShapes(Graphics2D mainGraphics, ArrayList shapeList)
	{
		for(Object currentShape : shapeList)
		{
			currentShape = (Shape) currentShape;
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int penSize = (int)(Math.random() * 10) + 3;
			int alpha = (int)(Math.random() * 255);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			mainGraphics.setStroke(new BasicStroke(penSize));
			if(currentShape instanceof Polygon)
			{
				mainGraphics.draw((Shape)currentShape);
			}
			else
			{
				mainGraphics.fill((Shape)currentShape);
			}
		}
	}
	
	public void clear()
	{
		polygonList.clear();
		triangleList.clear();
		circleList.clear();
		squareList.clear();
		rectangleList.clear();
		ellipseList.clear();
	}
}
