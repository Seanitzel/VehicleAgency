import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class Main_Menu extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	static final int NUM_OF_FLAGS = 7;
	
	//data structures
	private ArrayList<T_Vehicle> vehicles = new ArrayList<T_Vehicle>();		//Agency vehicle Array
	private ArrayList<Water_V> w_vehicles = new ArrayList<Water_V>();		//agency ship vehicle Array
	
	//Panels
	private JPanel main_menu_panel = new JPanel();
	private JPanel flag_change_panel = new JPanel();	
	
	//Combo Box
	private JComboBox<ImageIcon> flags = new JComboBox<ImageIcon>();
	
	//flag image array
	private ImageIcon[] flag_images = new ImageIcon[NUM_OF_FLAGS];
	
	//labels
	private JLabel title_lbl = new JLabel("Welcome To the Best Vehicle Agency Ever!");
	private JLabel choose_vehicle_lbl = new JLabel("These Are Our Vehicles:");
	private JLabel vehicle_info = new JLabel();
	private JLabel pick_title_lbl = new JLabel("<html>"+ "Chosen Vehicle:" +"</html>");
	private JLabel pick_lbl = new JLabel();
	private JLabel choose_flag_lbl = new JLabel("Choose Desired Flag!");
	private JLabel[] vehicle_lbls;
	
	//buttons
	private JButton add_vehicles_btn = new JButton("<html>"+ "Add Vehicles" +"</html>");
	private JButton buy_btn = new JButton("<html>"+ "Buy Vehicle" +"</html>");
	private JButton test_drive_btn = new JButton("<html>"+ "Test Drive" +"</html>");
	private JButton reset_distance_btn = new JButton("<html>"+ "Reset Distances" +"</html>");
	private JButton flag_change_btn = new JButton("<html>"+ "Change Flags" +"</html>");
	private JButton flag_choose_btn = new JButton("Choose");
	private JButton back_flag_choose_btn = new JButton("Back");
	private JButton exit_btn = new JButton("Exit");
	private JButton get_report = new JButton("Get Full Report");
	
	//user vehicle pick indicator
	private int pick;

	//mouse listener for vehicles
	private MouseListener mouse_listener;
	
	public Main_Menu()
	{		
		//adding action listeners to btns
		add_vehicles_btn.addActionListener(this);
		buy_btn.addActionListener(this);
		reset_distance_btn.addActionListener(this);
		test_drive_btn.addActionListener(this);
		flag_change_btn.addActionListener(this);
		flag_choose_btn.addActionListener(this);
		back_flag_choose_btn.addActionListener(this);
		get_report.addActionListener(this);

		//setting up flag images sources
		for(int i=1;i<NUM_OF_FLAGS + 1;i++)
			flag_images[i-1] = new ImageIcon("Images\\Flags\\f" + i + ".jpg");
		
		//setting up the mouse listener
		mouse_listener = new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {

				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				for(int i=0;i<vehicles.size();i++)
				{
					if(e.getSource() == vehicle_lbls[i])
					{
						vehicle_info.setText(null);
					}
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				for(int i=0;i<vehicles.size();i++)
				{
					if(e.getSource() == vehicle_lbls[i])
					{
						vehicle_info.setText("<html>"+ vehicles.get(i).toString() +"</html>");
					}
				}
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i=0;i<vehicles.size();i++)
				{
					if(e.getSource() == vehicle_lbls[i])
					{
						buy_btn.setEnabled(true);
						test_drive_btn.setEnabled(true);
						pick = i;
						pick_lbl.setIcon(vehicle_lbls[i].getIcon());
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		//setting up panels
		main_menu_panel.setLayout(null);
		main_menu_panel.setBackground(Color.YELLOW);
		flag_change_panel.setLayout(null);		
		flag_change_panel.setBackground(Color.CYAN);
		
		//setting up class details
		setSize(1280,980);
		setBorder(BorderFactory.createDashedBorder(Color.BLACK));           
		setLayout(new BorderLayout());
		         
		//----------------setting up panel components------------------------------------------------------------------------
		title_lbl.setFont(new Font("Courier", Font.BOLD,24));
		title_lbl.setBounds(10,-80,1000,200);
		
		choose_vehicle_lbl.setFont(new Font("Courier", Font.BOLD,20));
		choose_vehicle_lbl.setBounds(10,-40,1000,200);
		
		vehicle_info.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
		vehicle_info.setFont(new Font("Courier", Font.BOLD,16));
		vehicle_info.setBounds(4,340,800,80);
		
		pick_title_lbl.setBounds(10,420, 50,50);
		pick_lbl.setBounds(73, 430, 80, 80);
		
		buy_btn.setBounds(180,430,120,40);
		test_drive_btn.setBounds(180,470,120,40);
		reset_distance_btn.setBounds(310,430,130,80);
		flag_change_btn.setBounds(450,430,130,80);
		add_vehicles_btn.setBounds(590,430,130,80);
		exit_btn.setBounds(700, 0, 100, 50);
		get_report.setBounds(180, 515, 540, 40);
		buy_btn.setFont(new Font("Courier", Font.BOLD,14));
		test_drive_btn.setFont(new Font("Courier", Font.BOLD,14));
		reset_distance_btn.setFont(new Font("Courier", Font.BOLD,18));
		flag_change_btn.setFont(new Font("Courier", Font.BOLD,18));
		add_vehicles_btn.setFont(new Font("Courier", Font.BOLD,18));

		
		
		for(int i=0;i<NUM_OF_FLAGS;i++)
			flags.addItem(flag_images[i]);
		
		back_flag_choose_btn.setBounds(600, 200, 100, 220);
		flag_choose_btn.setBounds(450, 200, 100, 220);
		flags.setBounds(100,200,300,220);
		choose_flag_lbl.setBounds(180, -50, 600, 200);
		choose_flag_lbl.setFont(new Font("Courier", Font.BOLD,36));
		JComponent[] flag_choose_elements = {flag_choose_btn, flags, back_flag_choose_btn, choose_flag_lbl};
		add_elements(flag_change_panel, flag_choose_elements);
		
		buy_btn.setEnabled(false);
		test_drive_btn.setEnabled(false);

		JComponent[] main_menu_elements = {choose_vehicle_lbl, vehicle_info, title_lbl, buy_btn, test_drive_btn
											,reset_distance_btn, flag_change_btn,add_vehicles_btn, exit_btn, pick_lbl,pick_title_lbl, get_report};
		add_elements(main_menu_panel, main_menu_elements);
		//----------------------------------------------------------------------------------------------------------------
		
		//adding panels to class
		add(flag_change_panel, BorderLayout.CENTER);
		add(main_menu_panel, BorderLayout.CENTER);
	}
	public void update_vehicles_imgs()//update the vehicle imgs every time a new vehicle is added via the vehicle adding panel
	{
		if(vehicle_lbls != null)
		for(int i=0;i<vehicle_lbls.length;i++)
		{
			main_menu_panel.remove(vehicle_lbls[i]);
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
			if(i < 10)
				vehicle_lbls[i].setBounds(0 + i * 80,100,80,80);
			else if(i < 20)
				vehicle_lbls[i].setBounds(0 + i%10 * 80,180,80,80);
			else
				vehicle_lbls[i].setBounds(0 + i%10 * 80,260,80,80);
			main_menu_panel.add(vehicle_lbls[i]);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e)//handle btn clicks
	{
		if(e.getSource() == get_report)
		{
			//Main Frame
			JFrame frame = new JFrame("Vehicle Agency");		
			
			//Panels
			Vehicle_Adding_Class vehicle_adding = new Vehicle_Adding_Class();
			Main_Menu main_menu = new Main_Menu();
			
			//frame initialization
			frame.add(main_menu, BorderLayout.CENTER);
			frame.add(vehicle_adding, BorderLayout.CENTER);
			main_menu.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(820, 600);
			frame.setResizable(false);
			frame.setVisible(true);
		}
		if(e.getSource() == buy_btn)
		{
			vehicles.remove(pick);
			main_menu_panel.remove(vehicle_lbls[pick]);
			for(int i=0;i<vehicle_lbls.length;i++)
				main_menu_panel.remove(vehicle_lbls[i]);
			update_vehicles_imgs();
			buy_btn.setEnabled(false);
			test_drive_btn.setEnabled(false);
			vehicle_info.setText(null);
			JOptionPane.showMessageDialog(null, "You Just Bought A New Vehicle! \nCongratulations!!");
			pick_lbl.setIcon(null);
			repaint();
		}
		if(e.getSource() == test_drive_btn)
		{
			String distance = JOptionPane.showInputDialog(null, "How Much Distance Have You Traveled?");
			vehicles.get(pick).Travel_Distance(Integer.parseInt(distance));
			vehicle_info.setText("<html>"+ vehicles.get(pick).toString() +"</html>");
		}
		if(e.getSource() == reset_distance_btn)
		{
			for(int i = 0; i < vehicles.size();i++)
				vehicles.get(i).resetDistanceTraveled();
			vehicle_info.setText(null);
			JOptionPane.showMessageDialog(null, "Reset Successfull!");
		}
		if(e.getSource() == flag_change_btn)
		{
			main_menu_panel.setVisible(false);
			flag_change_panel.setVisible(true);
//			repaint();
			add(flag_change_panel, BorderLayout.CENTER);
		}
		if(e.getSource() == flag_choose_btn)
		{
			String flag = null;
			if(flags.getSelectedItem().toString().contains("f1"))
				flag = "Israel";
			if(flags.getSelectedItem().toString().contains("f2"))
				flag = "Germany";
			if(flags.getSelectedItem().toString().contains("f3"))
				flag = "USA";
			if(flags.getSelectedItem().toString().contains("f4"))
				flag = "Italy";
			if(flags.getSelectedItem().toString().contains("f5"))
				flag = "Greece";
			if(flags.getSelectedItem().toString().contains("f6"))
				flag = "PIRATE";
			if(flags.getSelectedItem().toString().contains("f7"))
				flag = "Sumalia";
			for(int i=0;i<w_vehicles.size();i++)
				w_vehicles.get(i).setFlag(flag);
			flag_change_panel.setVisible(false);
			main_menu_panel.setVisible(true);
			add(main_menu_panel, BorderLayout.CENTER);
		}
		if(e.getSource() == back_flag_choose_btn)
		{
			flag_change_panel.setVisible(false);
			main_menu_panel.setVisible(true);
			add(main_menu_panel, BorderLayout.CENTER);
		}
	}
	private void add_elements(JPanel panel, JComponent[] cmps)//add components to panel
	{
		for(int i=0;i<cmps.length;i++)
			panel.add(cmps[i]);
	}
	public JButton addVehicles()//call the vehicle adding panel
	{
		return add_vehicles_btn;
	}
	public void GetVehicles(ArrayList<T_Vehicle> vehicle_arr)//get the vehicles from the vehicle adding panel
	{
		vehicles = vehicle_arr;
	}
	public void GetWater_Vehicles(ArrayList<Water_V> w_vehicle_arr)//get the water vehicles from the vehicle adding panel
	{
		w_vehicles = w_vehicle_arr;
	}
	public JButton quit()
	{
		return exit_btn;
	}
	public JButton getReport()
	{
		return get_report;
	}
}
