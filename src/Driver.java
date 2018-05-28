/*Made By: Sean Dvir - 311329015	Nastaran MOTIEE
 * 
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver {

	public static void main(String[] args) {

		//Main Frame
		JFrame frame = new JFrame("Vehicle Agency");		
		

		
		//Panels
		Vehicle_Adding_Class vehicle_adding = new Vehicle_Adding_Class();
		Main_Menu main_menu = new Main_Menu();
		
		Thread v_adding = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
		
		//frame initialization
		frame.add(main_menu, BorderLayout.CENTER);
		frame.add(vehicle_adding, BorderLayout.CENTER);
		main_menu.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(820, 600);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//Handeling Panel Switching
		vehicle_adding.GOTO_agency().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				vehicle_adding.setVisible(false);
				main_menu.GetVehicles(vehicle_adding.getVehicles());
				main_menu.update_vehicles_imgs();
				main_menu.GetWater_Vehicles(vehicle_adding.getWater_Vehicles());
				main_menu.setVisible(true);
			}
		});
		main_menu.addVehicles().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				main_menu.setVisible(false);
				vehicle_adding.setVisible(true);
			}
		});
		main_menu.quit().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}