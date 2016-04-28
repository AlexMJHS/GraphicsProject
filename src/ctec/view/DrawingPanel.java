package ctec.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JPanel;

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
		rectangleList = new ArrayList<Rectangle>();
		drawRectangleButton = new JButton("Draw the rectangle");
		drawPolygonButton = new JButton("Draw the polygon!");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(drawRectangleButton);
		this.add(drawPolygonButton);
		this.add(shapePanel);
		this.setBackground(Color.DARK_GRAY);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 230, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawPolygonButton, -237, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 0, SpringLayout.NORTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 17, SpringLayout.EAST, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 44, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 81, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -88, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 366, SpringLayout.WEST, this);
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
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.GREEN);
		mainGraphics.setStroke(new BasicStroke(5));
		mainGraphics.draw(new Rectangle(90,10,20,40));
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
	}
	
	private void drawShape(Graphics2D mainGraphics, ArrayList shapeList)
	{
		for()
	}
	
	public void clear()
	{
		
	}
}
