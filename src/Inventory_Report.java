import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;


public class Inventory_Report extends myPanel implements ActionListener, Runnable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<T_Vehicle> vehicles;		//Agency vehicle Array
	
	private JPanel vehicles_panel = new JPanel();
	private JPanel container = new JPanel();
	private JScrollPane scroll_pane;
	
	private JLabel[] vehicle_lbls = null;
	private JLabel vehicle_info = new JLabel();
	private JLabel title_lbl = new JLabel("Inventory");
	private JLabel vehicle_details_lbl = new JLabel("Vehicle Details:");
	private JLabel pick_lbl = new JLabel();
	
	private JButton exit = new JButton("Exit");
		
	private MouseListener mouse_listener;
	
	public boolean rebuild = false;
	
	public Inventory_Report(ArrayList<T_Vehicle> vehicles) {
		frame = new JFrame("Test Drive");
		this.vehicles = vehicles;
		
		
//		vehicle_lbls = new JLabel[vehicles.size()];
		//setting up the mouse listener
		mouse_listener = new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				for(int i=0;i<vehicle_lbls.length;i++)
				{
					if(e.getSource() == vehicle_lbls[i])
					{
						vehicle_info.setText(null);
						pick_lbl.setIcon(null);
					}
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				for(int i=0;i<vehicle_lbls.length;i++)
				{
					if(e.getSource() == vehicle_lbls[i])
					{
						vehicle_info.setText("<html>"+ vehicles.get(i).toString() +"</html>");
						ImageIcon img = new ImageIcon(vehicles.get(i).getImageSource());
						Image newimg = img.getImage();
						newimg = newimg.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
						img = new ImageIcon(newimg);
						pick_lbl.setIcon(img);
					}
				}
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}
		};
		
		scroll_pane = new JScrollPane(vehicles_panel);
		
//		for(int i=0;i<vehicle_lbls.length;i++)
//		{
//			ImageIcon img = new ImageIcon(vehicles.get(i).getImageSource());
//			Image newimg = img.getImage();
//			newimg = newimg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//			img = new ImageIcon(newimg);
//			vehicle_lbls[i] = new JLabel(img);
//			vehicle_lbls[i].addMouseListener(mouse_listener);
//			vehicles_panel.add(vehicle_lbls[i]);
//		}
				
		setLayout(null);		
		setBackground(Color.CYAN);
		vehicles_panel.setBackground(Color.CYAN);
		container.setBackground(Color.cyan);
		vehicles_panel.setLayout(new FlowLayout());
		container.setLayout(new FlowLayout());

		title_lbl.setBounds(155,0,200,100);
		title_lbl.setFont(new Font("Courier", Font.BOLD,36));
		
		vehicle_details_lbl.setBounds(530, 0,250,100);
		vehicle_details_lbl.setFont(new Font("Courier", Font.BOLD,24));
		
		pick_lbl.setBounds(550, 105, 150, 150);
		
		vehicle_info.setBounds(530, 230, 250, 300);
		vehicle_info.setFont(new Font("Courier", Font.BOLD,18));
		vehicle_info.setBackground(Color.ORANGE);
		vehicles_panel.setPreferredSize(new Dimension(480, (vehicles.size() * 110)/4));

		scroll_pane.setPreferredSize(new Dimension(500, 450));
		
		container.add(scroll_pane);
		container.setBounds(0,100,520,470);
		//container.setBounds(0, 50, 600, 600);
		JComponent[] elements = {container, title_lbl, vehicle_details_lbl,vehicle_info, pick_lbl, exit};
		add_elements(this, elements);
		
		update_vehicles_imgs();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit)
			exit();
	}
	public void update_vehicles(ArrayList<T_Vehicle> vehicles)
	{
		this.vehicles = vehicles;
	}
	public void update_vehicles_imgs()//update the vehicle imgs every time a new vehicle is added via the vehicle adding panel
	{
		if(vehicle_lbls != null)
		for(int i=0;i<vehicle_lbls.length;i++)
		{
			vehicles_panel.remove(vehicle_lbls[i]);
		}
		vehicle_lbls = new JLabel[vehicles.size()];
		for(int i=0;i<vehicle_lbls.length;i++)
		{
			ImageIcon img = new ImageIcon(vehicles.get(i).getImageSource());
			Image newimg = img.getImage();
			newimg = newimg.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			img = new ImageIcon(newimg);			
			vehicle_lbls[i] = new JLabel(img);
			vehicle_lbls[i].addMouseListener(mouse_listener);
			vehicle_lbls[i].setBorder(BorderFactory.createDashedBorder(Color.BLACK));         
			vehicles_panel.add(vehicle_lbls[i]);
		}
		vehicle_info.setText(null);
		System.out.println(vehicle_lbls.length);
	}
	@Override
	public void run() {
		makeFrame(820, 600);
		while(alive == true)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(frame.isFocused());
			if(rebuild == true && frame.isFocused() == true)
			{
				rebuild = false;
				update_vehicles_imgs();
				System.out.println(vehicles);
			}
		}
	}
	public void exit()
	{
		frame.dispose();
		alive = false;
	}
}
