package ctec.view;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
	
	public GraphPanel()
	{
		//initialize graphSource here
		graphSource = new int[] {5,10,180,69,34,17,35,23,3,7};
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.cyan);
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		for(int index = 0; index < graphSource.length; index++)
		{
			//Draw a rectangle for each value in the array.
			//Height constant, width value array
			int height = this.getHeight()/graphSource.length;
			int width = (int)((graphSource[index] / 200.00) * this.getWidth());
			int xPosition = 0;
			int yPosition = height * index;
			
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(new Rectangle(xPosition, yPosition, width, height));
			
		}
	}
}
