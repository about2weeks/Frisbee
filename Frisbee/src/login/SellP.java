package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SellP implements ActionListener {

	JPanel sellP;
	
	JLabel titleL;
	JLabel sumL;
	
	JComboBox<String> monthBox;
	
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;
	int cnt = 0;
	long money = 0;
	
	String storeNo;
	
	public SellP(String storeNo) {
		
		this.storeNo = storeNo;
		
		sellP = new JPanel();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM");
		String sysmonth = format1.format(cal.getTime());
		
		titleL = new JLabel(sysmonth+" 매출");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		
		monthBox =	new JComboBox<String>(new SellDAO().countMonth(storeNo));
		monthBox.setSelectedItem(sysmonth);
		
		model = new SetTable().setSellTable(new SellDAO().setSellP(storeNo, sysmonth));
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		tableP = new JScrollPane(table);
		
		cnt = model.getRowCount();
		for(int i= 0; i<cnt; i++) {
			money += (long) model.getValueAt(i, 4);
		}
		
		sumL = new JLabel("총 수량   :   "+cnt+"    총액   :   "+money);
		sumL.setFont(new Font("돋움",Font.BOLD,20));
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox<String> j = (JComboBox<String>) e.getSource();
		String selectM = (String) j.getSelectedItem();
		sellP.remove(tableP);
		
		model = new SetTable().setSellTable(new SellDAO().setSellP(storeNo, selectM));
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		tableP = new JScrollPane(table);
		tableP.setBounds(10, 50, 900, 450);
		sellP.add(tableP);
		
		cnt = 0;
		money = 0;
		for(int i= 0; i<model.getRowCount(); i++) {
			cnt+= (int) model.getValueAt(i, 2);
			money += (long) model.getValueAt(i, 4);
		}
		
		sumL.setText("총 수량   :   "+cnt+"    총액   :   "+money);
		
	}
	
	public JPanel setPanel() {
		
		monthBox.addActionListener(this);
		
		titleL.setBounds(10, 10, 250, 50);
		sumL.setBounds(10, 505, 500, 50);
		
		tableP.setBounds(10, 50, 900, 450);
		monthBox.setBounds(750, 22, 150, 20);
		
		sellP.setLayout(null);
		sellP.setBounds(0,100,960,570);
		sellP.setBackground(Color.white);
		sellP.add(monthBox);
		sellP.add(titleL);
		sellP.add(tableP);
		sellP.add(sumL);
		
		return sellP;
	}

	
	
}
