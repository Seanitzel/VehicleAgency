/*Made By: Sean Dvir - 311329015	Nastaran Motiee
 * 
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver {

	public static void main(String[] args) {		
		
		//Panels
		Vehicle_Adding_Class vehicle_adding = new Vehicle_Adding_Class();
		Main_Menu main_menu = new Main_Menu();
		
		Thread vehicle_adding_thread = new Thread((Runnable) vehicle_adding);
		Thread main_menu_thread = new Thread((Runnable) main_menu);
		main_menu_thread.start();
		vehicle_adding_thread.start();
		//v_adding_frame initialization
//		agency_frame.add(main_menu, BorderLayout.CENTER);
//		v_adding_frame.add(vehicle_adding, BorderLayout.CENTER);

//		v_adding_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		v_adding_frame.setSize(820, 600);
//		v_adding_frame.setResizable(false);
//		v_adding_frame.setVisible(true);
		
//		agency_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		agency_frame.setSize(820, 600);
//		agency_frame.setResizable(false);
//		agency_frame.setVisible(false);
		
		//Handeling Panel Switching
		vehicle_adding.GOTO_agency().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				main_menu.GetVehicles(vehicle_adding.getVehicles());
				main_menu.update_vehicles_imgs();
				main_menu.GetWater_Vehicles(vehicle_adding.getWater_Vehicles());
				
				main_menu.repaint();
			}
		});
		main_menu.addVehicles().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		main_menu.quit().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vehicle_adding_thread.stop();
				main_menu_thread.stop();
			}
		});
	}
}