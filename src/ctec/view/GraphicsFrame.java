package ctec.view;

import javax.swing.JFrame;

import ctec.controller.GraphicsController;


public class GraphicsFrame extends JFrame
{
	private GraphicsController baseController;
	private DrawingPanel basePanel;
	
	public GraphicsFrame(GraphicsController bsaeController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Graphics");
		this.setSize(500,500);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public GraphicsController getBaseController()
	{
		return baseController;
	}
}
