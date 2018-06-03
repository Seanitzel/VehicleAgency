import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Test_Drive extends myPanel implements ActionListener, Runnable{

	private static final long serialVersionUID = 1L;
		
	private ArrayList<T_Vehicle> vehicles;		//Agency vehicle Array
	private T_Vehicle vehicle_tested;
	
	private boolean driving = false;
	
	JLabel title_lbl = new JLabel("Test Driving!");
	
	private JButton finish_drive_btn = new JButton("Finish Drive!");
	
	private JTextField distance = new JTextField("0");
	
	public Test_Drive(ArrayList<T_Vehicle> vehicles, T_Vehicle vehicle_tested) {
		frame = new JFrame("Test Drive");
		this.vehicles = vehicles;
		this.vehicle_tested = vehicle_tested;
		
		setLayout(null);		
		setBackground(Color.red);
		
		finish_drive_btn.addActionListener(this);
		
		title_lbl.setBounds(20, 0, 250, 100);
		title_lbl.setFont(new Font("Courier", Font.BOLD,30));
		finish_drive_btn.setBounds(20, 150, 200, 100);
		finish_drive_btn.setFont(new Font("Courier", Font.BOLD,20));
		distance.setBounds(90, 90, 70, 50);
		JComponent[] flag_choose_elements = {title_lbl, finish_drive_btn, distance};
		add_elements(this, flag_choose_elements);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == finish_drive_btn)
		{
			driving = true;
			title_lbl.setText("Driving...");
			try {
				Thread.sleep(100*Integer.parseInt(distance.getText()));
			} catch (NumberFormatException | InterruptedException e1) {
				e1.printStackTrace();
			}
			exit();
		}
	}
	@Override
	public void run() {
		makeFrame(280, 300);
		
		while(alive == true)
		{
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			if(driving == true)
			{
				title_lbl.setText("Driving...");
				try {
					Thread.sleep(100*Integer.parseInt(distance.getText()));
				} catch (NumberFormatException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			//System.out.println("yay");
//			if(vehicles.contains(vehicle_tested) == false)
//			{
//				JOptionPane.showMessageDialog(null, "Sorry, Someone just bought this vehicle..."); 
//				frame.dispose();
//				alive = false;
//			}
		}
	}
	public void exit()
	{
		vehicle_tested.Travel_Distance(Integer.parseInt(distance.getText()));
		frame.dispose();
		alive = false;
	}
}
