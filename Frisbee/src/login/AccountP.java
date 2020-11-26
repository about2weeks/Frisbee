package login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AccountP implements MouseListener{
	
	JTabbedPane tabP;
	JPanel accP;
	JPanel nameP;
	JPanel imgP;
	JPanel profileP;
	
	ImageIcon acctI;
	JLabel imgL;
	JLabel acctL;
	JLabel nameL;
	JLabel rankL;
	
	String empname;
	String emprank;
	
	CardLayout cd;
	
	public AccountP() {
		
	}
	
	
	public AccountP(JTabbedPane tabP,String empno, String empname, String emprank) {
		
		this.tabP = tabP;
		this.empname = empname;
		this.emprank = emprank;
		//this.profileP = profileP;
		
		accP = new JPanel();
		nameP = new JPanel();
		imgP = new JPanel();
		
		acctI = new BLOBDAO().PrintIcon(empno);
		imgL = new JLabel(acctI);
		nameL = new JLabel("이름 : "+empname);
		rankL = new JLabel("직급 : "+emprank);
		
		
	}
	
	public JPanel setPanel() {
		
		
		imgL.addMouseListener(this);
		
		nameP.setLayout(null);
		nameL.setBounds(10,20,100,18);
		rankL.setBounds(10,38,100,18);
		nameP.add(nameL);
		nameP.add(rankL);
		nameP.setBackground(Color.white);
		nameP.setBounds(0, 0, 100, 60);
		
		
		imgP.setLayout(null);
		imgL.setBounds(5, 10, 50, 50);
		imgP.add(imgL);
		imgP.setBackground(Color.white);
		imgP.setBounds(100,0,60,60);
		
		accP.setLayout(null);
		accP.setBounds(800,0,200,70);
		accP.setBackground(Color.white);
		accP.add(nameP);
		accP.add(imgP);
		
		
		return accP;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==imgL) {
			tabP.setSelectedIndex(5);
			//f.add(profileP);
			//cd.show(mainP, "profile");
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
