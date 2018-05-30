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

public class FlagChange extends JPanel implements ActionListener, Runnable{
	
	private static final long serialVersionUID = 1L;
	
	JFrame flag_change_frame = new JFrame("Flag Change");	

	static final int NUM_OF_FLAGS = 7;
		
	private JComboBox<ImageIcon> flags = new JComboBox<ImageIcon>();
	
	//flag image array
	private ImageIcon[] flag_images = new ImageIcon[NUM_OF_FLAGS];
	
	private JLabel choose_flag_lbl = new JLabel("Choose Desired Flag!");
	
	private JButton flag_choose_btn = new JButton("Choose");
	private JButton back_flag_choose_btn = new JButton("Back");
	
	public FlagChange()
	{
		flag_choose_btn.addActionListener(this);
		back_flag_choose_btn.addActionListener(this);
		
		//setting up flag images sources
		for(int i=1;i<NUM_OF_FLAGS + 1;i++)
			flag_images[i-1] = new ImageIcon("Images\\Flags\\f" + i + ".jpg");
		
		setLayout(null);		
		setBackground(Color.CYAN);
		
		for(int i=0;i<NUM_OF_FLAGS;i++)
			flags.addItem(flag_images[i]);	
		
		back_flag_choose_btn.setBounds(600, 200, 100, 220);
		flag_choose_btn.setBounds(450, 200, 100, 220);
		flags.setBounds(100,200,300,220);
		choose_flag_lbl.setBounds(180, -50, 600, 200);
		choose_flag_lbl.setFont(new Font("Courier", Font.BOLD,36));
		JComponent[] flag_choose_elements = {flag_choose_btn, flags, back_flag_choose_btn, choose_flag_lbl};
		add_elements(this, flag_choose_elements);
	}

	@Override
	public void run() {
		flag_change_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		flag_change_frame.setSize(820, 600);
		flag_change_frame.setResizable(false);
		flag_change_frame.setVisible(true);
		flag_change_frame.add(this);
	}

	private void add_elements(JPanel panel, JComponent[] cmps)//add components to panel
	{
		for(int i=0;i<cmps.length;i++)
			panel.add(cmps[i]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
			flag_change_frame.dispose();
		}
	}
}
