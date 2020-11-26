package login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class empP {

	
	JPanel empP;
	
	JLabel titleL;
	
	JTable table;
	JScrollPane tableP;
	
	JTextField tf1;
	JButton bt1;
	
	JButton plus;
	
	public empP(String storeNo) {
		
		empP = new JPanel();
		
		titleL = new JLabel("직원 관리");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		
		
		table = new SetTable().setWorkerTable(new AccountDAO().setWorker(storeNo));
		tableP = new JScrollPane(table);
		
		
	}
	
	public JPanel setPanel() {
		
		titleL.setBounds(10, 10, 100, 40);
		tableP.setBounds(10, 50, 900, 450);		
		
		empP.setLayout(null);
		empP.setBounds(0,100,960,575);
		empP.setBackground(Color.white);
		empP.add(tableP);
		empP.add(titleL);
		
		
		return empP;
	}
	
	
	
}
