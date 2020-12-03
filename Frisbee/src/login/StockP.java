package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class StockP implements MouseListener {

	JPanel stockP;

	JPanel itemP;
	
	JLabel titleL;
	
	ImageIcon img;
	JLabel imgL;
	
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;
	
	public StockP(String storeNo) {
		
		stockP = new JPanel();
		
		itemP = new JPanel();
		
		//img = new BLOBDAO().printGood(goodNo);
		
		titleL = new JLabel("재고");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		
		model = new SetTable().setStockTable(new StockDAO().setAllStock(storeNo));
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		tableP = new JScrollPane(table);
		
		//재고 숫자만 왼쪽 정렬 
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(1).setCellRenderer(dtcr);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==table) {
			TableModel md = (TableModel) table.getModel();
			int rowIndex = table.getSelectedRow();
			int colIndex = table.getSelectedColumn();
			String selectNo = (String) md.getValueAt(rowIndex, colIndex);
			if(colIndex==0) {
				
			}
		}
	}
	
	
	public JPanel setPanel() {
		
		table.addMouseListener(this);
		
		
		itemP.setLayout(null);
		
		
		
		
		stockP.setLayout(null);
		stockP.setBounds(0,100,960,570);
		stockP.setBackground(Color.white);
		stockP.add(itemP);
		stockP.add(tableP);
		stockP.add(titleL);
		
		return stockP;
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
