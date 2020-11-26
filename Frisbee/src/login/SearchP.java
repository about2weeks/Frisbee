package login;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchP {

	JPanel searchP;
	ImageIcon search;
	JLabel searchL;
	JTextField searchtf;
	JButton searchBt;
		
	public SearchP() {
		searchP = new JPanel();
		search = new ImageIcon("/Users/kai/Documents/Project/Frisbee/img/search.png");
		searchL = new JLabel(search);
		searchtf = new JTextField("검색하시오");
		searchBt = new JButton("검색");
	}
	
	public JPanel setPanel() {
		
		searchP.setLayout(null);
		searchL.setBounds(20,20,40, 40);
		searchtf.setBounds(62, 20, 150, 40);
		searchBt.setBounds(208,25,50,30);
		searchP.add(searchL);
		searchP.add(searchtf);
		searchP.add(searchBt);
		searchP.setBackground(Color.white);
		searchP.setBounds(0, 0, 300, 70);
		
		
		return searchP;
	}
	
}
