/*Made By: Sean Dvir - 311329015	Nastaran Motiee
 * 
 * 
 */
import java.awt.event.*;
import java.util.ArrayList;

public class Driver {

	private static Inventory_Report inventory_report = null;
	static boolean report_open = false;

	public static void main(String[] args) {		
		
		//Panels
		Vehicle_Adding vehicle_adding = new Vehicle_Adding();
		Main_Menu main_menu = new Main_Menu();
		FlagChange flag_change = new FlagChange();
		
		ArrayList<T_Vehicle> vehicles_in_test_drive = new ArrayList<T_Vehicle>();
		
		Thread vehicle_adding_thread = new Thread((Runnable) vehicle_adding);
		Thread main_menu_thread = new Thread((Runnable) main_menu);
//		(new Thread(new Info_Win("yay"))).start();

		main_menu_thread.start();
		vehicle_adding_thread.start();

		vehicle_adding.GOTO_agency().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				main_menu.updateVehicles(vehicle_adding.getVehicles());
				main_menu.updateWater_Vehicles(vehicle_adding.getWater_Vehicles());
				main_menu.update_vehicles_imgs();				
				if(report_open == true)
				{
					inventory_report.update_vehicles(main_menu.getVehicles());
					//inventory_report.update_vehicles_imgs();
					inventory_report.rebuild = true;
				}
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
				main_menu.exit();
				vehicle_adding.exit();
				if(flag_change.isRunning() == true)
					flag_change.exit();
			}
		});
		main_menu.ChangeFlag().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				flag_change.updateVehicles(main_menu.getWaterVehicles());
				if(flag_change.isRunning() == false)
					(new Thread((Runnable)flag_change)).start();
			}
		});
		flag_change.exitWin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				main_menu.updateVehicles(vehicle_adding.getVehicles());
				main_menu.update_vehicles_imgs();
				main_menu.updateWater_Vehicles(vehicle_adding.getWater_Vehicles());
			}
		});
		main_menu.testDrive().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(vehicles_in_test_drive.contains(main_menu.getPick()) == false)
				{
					(new Thread(new Test_Drive(main_menu.getVehicles(), main_menu.getPick()))).start();;
				}
				vehicles_in_test_drive.add(main_menu.getPick());
			}
		});
		main_menu.getReport().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(report_open == false)
				{
					inventory_report = new Inventory_Report(main_menu.getVehicles());
					(new Thread(inventory_report)).start();;
					report_open = true;
				}				
			}
		});
	}
}