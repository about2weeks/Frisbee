package login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainFrame {
	
	JFrame f;

	String empno;
	String storeName;
	
	
	
	JPanel searchP;
	JPanel accP;
	JPanel homeP;
	JPanel homegP;	//home - stock
	JPanel homenP;	//home - notice
	JPanel profileP;
	
	JTabbedPane tabP;	//탭 
	
	
	
	JPanel sellP;
	
	JPanel stockP;
	
	JPanel buyP;
	
	JPanel empP;
	
	CardLayout cd = new CardLayout();
	
	public MainFrame(String empno) {
		
		AccountDAO ad = new AccountDAO();
		ArrayList<AccountVo> list = ad.setAccount(empno);
		AccountVo data = list.get(0);
		storeName = data.getStoreName();
		String storeNo = data.getStoreNo();
		String empname = data.getName();
		String emprank = data.getRank();
		
	
		
		f = new JFrame();
		tabP = new JTabbedPane();
		
		searchP = new SearchP().setPanel();
		profileP = new ProfileP(empno).setPanel();
		accP = new AccountP(tabP,empno,empname,emprank).setPanel();
		
		homeP = new JPanel();
		homegP = new HomeGoodP(storeName,storeNo).setPanel();

		
		empP = new empP(empno, storeNo).setPanel();
		
		sellP = new SellP(storeNo).setPanel();
		
		stockP = new JPanel();
		
		//tabP = new JPanel();
		
		
	}
	
	public void setFrame() {
		
		FlowLayout fl = new FlowLayout();
		
		homeP.setLayout(null);
		homeP.setBackground(Color.white);
		homeP.setBounds(20, 20, 900, 570);
		homeP.add(homegP);
		
		//tabP.setLayout(null);
		tabP.add("홈",homeP);
		tabP.add("매출",sellP);
		tabP.add("재고",stockP);
		tabP.add("주문",buyP);
		tabP.add("직원",empP);
		tabP.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabP.add("",profileP);
		//int index = tabP.indexOfComponent(profileP);
		//tabP.removeTabAt(index);
		tabP.setTabPlacement(JTabbedPane.TOP);
		tabP.setBounds(20,40,960,600);
		
		
		f.add(searchP);
		f.add(accP);
		f.add(tabP);
		
		
		f.setSize(1000, 700);
		f.setLayout(null);
		f.getContentPane().setBackground(Color.white); //delte
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		
		
	}
	
	// static void main(String[] args) {
	//	MainFrame mf = new MainFrame("AAA-12345");
	//	mf.setFrame();
	//}
	
	
}
