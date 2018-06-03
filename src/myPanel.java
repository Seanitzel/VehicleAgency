import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class myPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	protected boolean alive = true;
	protected JFrame frame;
	
	public myPanel()
	{
		super();
	}	
	protected void makeFrame(int width, int height)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(this);
	}
	protected void add_elements(JPanel panel, JComponent[] cmps)//add array of elements to panel 
	{
		for(int i=0;i<cmps.length;i++)
			panel.add(cmps[i]);
	}
}
