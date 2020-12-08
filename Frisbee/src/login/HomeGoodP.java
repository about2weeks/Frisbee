package login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class HomeGoodP {

	JPanel homegP;
	
	JLabel titleL;
	
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;
	
	public HomeGoodP(String storeName,String storeNo) {
		
		homegP = new JPanel();
		
		titleL = new JLabel(storeName+" 재고");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		
		
		model = new SetTable().setStockTable(new StockDAO().setStock(storeNo));
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		tableP = new JScrollPane(table);
		
		//재고 숫자만 왼쪽 정렬 
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(1).setCellRenderer(dtcr);
		
	}
	
	public JPanel setPanel() {
		
		titleL.setBounds(10, 0, 400, 50);
		tableP.setBounds(10, 52,300, 400);
		
		homegP.setLayout(null);
		homegP.setBackground(Color.white);
		homegP.setBounds(10, 10, 400, 600);
		homegP.add(titleL);
		homegP.add(tableP);
		
		return homegP;
	}
	
	
	
}
