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
		FlagChange flag_change = new FlagChange();
		
		Thread vehicle_adding_thread = new Thread((Runnable) vehicle_adding);
		Thread main_menu_thread = new Thread((Runnable) main_menu);
		Thread flag_change_thread = new Thread((Runnable) flag_change);

		main_menu_thread.start();
		vehicle_adding_thread.start();

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
				
			}
		});
		main_menu.ChangeFlag().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				flag_change_thread.start();
			}
		});
		
	}
}