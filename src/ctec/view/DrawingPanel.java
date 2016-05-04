package ctec.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import ctec.controller.GraphicsController;

public class DrawingPanel extends JPanel
{
	private GraphicsController baseController;
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	private JButton drawRectangleButton;
	private JButton drawCircleButton;
	private JButton drawSquareButton;
	private JButton drawTriangleButton;
	private JButton drawEllipseButton;
	private JButton drawPolygonButton;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(GraphicsController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		shapePanel = new ShapePanel();
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 24, SpringLayout.WEST, this);
		rectangleList = new ArrayList<Rectangle>();
		drawRectangleButton = new JButton("Draw the rectangle");
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -23, SpringLayout.NORTH, drawRectangleButton);
		drawSquareButton = new JButton("Draw the square");
		drawTriangleButton = new JButton("Draw the triangle");
		drawPolygonButton = new JButton("Draw the polygon");
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, -187, SpringLayout.NORTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 279, SpringLayout.EAST, drawPolygonButton);
		drawCircleButton = new JButton("Draw the circle");
		drawEllipseButton = new JButton("Draw the Ellipse");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(drawRectangleButton);
		this.add(drawPolygonButton);
		this.add(drawCircleButton);
		this.add(drawEllipseButton);
		this.add(drawTriangleButton);
		this.add(drawSquareButton);
		this.add(shapePanel);
		this.setBackground(Color.DARK_GRAY);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 209, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawRectangleButton, -151, SpringLayout.EAST, this);
		
		baseLayout.putConstraint(SpringLayout.EAST, drawSquareButton, -10, SpringLayout.EAST, this);
		
		baseLayout.putConstraint(SpringLayout.WEST, drawSquareButton, 6, SpringLayout.EAST, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawTriangleButton, 6, SpringLayout.SOUTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 0, SpringLayout.WEST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawTriangleButton, 0, SpringLayout.EAST, drawRectangleButton);
		
		baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 209, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 6, SpringLayout.EAST, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawPolygonButton, 148, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, drawPolygonButton, 10, SpringLayout.WEST, this);
		
		baseLayout.putConstraint(SpringLayout.NORTH, drawSquareButton, 6, SpringLayout.SOUTH, drawCircleButton);
		baseLayout.putConstraint(SpringLayout.EAST, drawCircleButton, 0, SpringLayout.EAST, drawSquareButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawCircleButton, 0, SpringLayout.NORTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawCircleButton, 6, SpringLayout.EAST, drawRectangleButton);
		
		baseLayout.putConstraint(SpringLayout.EAST, drawEllipseButton, 0, SpringLayout.EAST, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 6, SpringLayout.SOUTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawEllipseButton, 10, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * 800);
				int yPosition = (int)(Math.random() * 800);
				int width = (int)(Math.random() * 50);
				int height = (int)(Math.random() * 50);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				shapePanel.addTriangle();
				repaint();
			}
		});
		
		drawPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
		});
		
		drawEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			}
		});
		
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			}
		});
		
		drawSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				repaint();
			}
		});
		
		drawTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});
		
		drawCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
	}
	
	private void drawShapes(Graphics2D mainGraphics, ArrayList shapeList)
	{
		for(Object currentShape : shapeList)
		{
			currentShape = (Shape) currentShape;
			int penSize = (int)(Math.random() * 10) +3;
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
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
}
