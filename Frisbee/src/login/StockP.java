package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
	
	JLabel titleL;
	
	ImageIcon img;
	JLabel imgL;
	JLabel infoL;
	
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;
	
	String storeNo;
	
	public StockP(String storeNo) {
		
		this.storeNo = storeNo;
		
		
		stockP = new JPanel();
		
		
		titleL = new JLabel("재고");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		
		infoL = new JLabel();
		imgL = new JLabel();
		
		model = new SetTable().setStockTable(new StockDAO().setAllStock(storeNo));
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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==table) {
			TableModel md = (TableModel) table.getModel();
			int rowIndex = table.getSelectedRow();
			int colIndex = table.getSelectedColumn();
			String selectName = (String) md.getValueAt(rowIndex, colIndex);
			if(colIndex==0) {
				
				stockP.remove(imgL);
				
				img = new BLOBDAO().printGood(selectName, storeNo);
				imgL = new JLabel(img);
				
				ArrayList<StockVo> list = new StockDAO().setStockProfile(storeNo,selectName);
				
				StockVo data = list.get(0);
				String goodNo = data.getGoodNo();
				String name = data.getName();
				String stocks = data.getStocks();
				int unitPrice = data.getUnitPrice();
				String loc = data.getLoc();
				
				String info = "<html><body>제품명  :  "+name+"<br/>제품 코드  :  "+goodNo+"<br/>단가  :  "
						+unitPrice+"<br/>재고  :  "+stocks+"<br/>재고 위치  :  "+loc+"</body></html>";
				
				infoL.setText(info);
				
				imgL.setBounds(330, 65, 200, 250);
				stockP.add(imgL);
				stockP.revalidate();
				stockP.repaint();
				
			}
		}
	}
	
	
	public JPanel setPanel() {
		
		table.addMouseListener(this);
		
		titleL.setBounds(10, 10, 250, 50);
		infoL.setBounds(550, 40, 240, 200);
		imgL.setBounds(330, 65, 200, 250);
	
		tableP.setBounds(10,65,300,450);


		stockP.setLayout(null);
		stockP.setBounds(0,100,960,570);
		stockP.setBackground(Color.white);
		stockP.add(tableP);
		stockP.add(titleL);
		stockP.add(infoL);
		stockP.add(imgL);
		
		
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
