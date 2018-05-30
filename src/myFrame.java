import javax.swing.JFrame;
import javax.swing.JPanel;

public class myFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public myFrame(JPanel panel)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(820, 600);
		setResizable(false);
		setVisible(true);
		add(panel);
	}	
	
}
