package ctec.view;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
	
	public GraphPanel()
	{
		//initialize graphSource here
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		for(int index = 0; index < graphSource.length; index++)
		{
			//Draw a rectangle for each val in the array.
		}
	}
}
