import java.awt.BorderLayout;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Info_Win extends myPanel implements ActionListener, Runnable{

	private static final long serialVersionUID = 1L;
	
	
	
	public Info_Win(String text) {
		
		JLabel lbl = new JLabel(text);
		lbl.setBounds(20,-20,80,80);
		
		frame = new JFrame("");
		setLayout(null);
		add(lbl);
	}

	@Override
	public void run() {
		makeFrame(200, 100);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
