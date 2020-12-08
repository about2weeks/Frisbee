package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class BuyP implements ActionListener, MouseListener{

	JPanel buyP;
	
	JLabel titleL;
	JLabel infoL;
	JLabel imgL;
	ImageIcon img;
	
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;
	
	JButton buy;
	JButton pick;
	
	String storeNo;
	
	
	public BuyP(String storeNo) {
		
		buyP = new JPanel();
		
		this.storeNo = storeNo;
		
		titleL = new JLabel("재고");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
	
		infoL = new JLabel();
		imgL = new JLabel();
		
		buy = new JButton("주문 요청");
		pick = new JButton("배송 요청");
		
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
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("주문 요청")) {
			String ans_str = (String) JOptionPane.showInputDialog(new JFrame(), 
				"품명 / 갯수를 쓰세요", "주문 요청", JOptionPane.PLAIN_MESSAGE, null, null, null);
		}
		if(e.getActionCommand().equals("배송 요청")) {
			String ans_str = (String) JOptionPane.showInputDialog(new JFrame(), 
					"품명 / 갯수를 쓰세요", "배송 요청", JOptionPane.PLAIN_MESSAGE, null, null, null);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==table) {
			TableModel md = (TableModel) table.getModel();
			int rowIndex = table.getSelectedRow();
			int colIndex = table.getSelectedColumn();
			String selectName = (String) md.getValueAt(rowIndex, colIndex);
			if(colIndex==0) {
				
				buyP.remove(imgL);
				
				img = new BLOBDAO().printGood(selectName, storeNo);
				imgL = new JLabel(img);
				
				Map map = new Map();
				
				StoreDAO sd = new StoreDAO();
				
				double min = Double.MAX_VALUE;
				String address = sd.getAddress(storeNo);
				String sName = "";
				Map temp = map.getLoc(address);
				double originX = temp.x;
				double originY = temp.y;
				
				ArrayList<StoreVo> sv = sd.getStore(selectName);
				for(int i = 0; i<sv.size(); i++) {
					StoreVo data = sv.get(i);
					
					address = data.getLoc();
					String name = data.getStoreName();
					temp = map.getLoc(address);
					double x = temp.x;
					double y = temp.y;
					
					double distance = map.getDistance(originX, originY, x, y);
					//System.out.println(distance);
					if(distance<min) {
						min = distance;
						sName = name;
					}
					
				}
				
				ArrayList<StockVo> list = new StockDAO().setStockProfile(storeNo,selectName);
				
				StockVo data = list.get(0);
				String goodNo = data.getGoodNo();
				String name = data.getName();
				String stocks = data.getStocks();
				int unitPrice = data.getUnitPrice();
				
				String info = "<html><body>제품명  :  "+name+"<br/>제품 코드  :  "+goodNo+"<br/>단가  :  "
						+unitPrice+"<br/>재고  :  "+stocks+"<br/>가까운 매장  :  "+sName+"</body></html>";
				
				infoL.setText(info);
				
				imgL.setBounds(330, 65, 200, 250);
				//buy.setBounds(r);
				buyP.add(imgL);
				buy.setVisible(true);
				pick.setVisible(true);
				buyP.revalidate();
				buyP.repaint();
				
			}
		}
	}
	
	public JPanel setPanel() {
		
		table.addMouseListener(this);
		pick.addActionListener(this);
		buy.addActionListener(this);
		
		titleL.setBounds(10, 10, 400, 50);
		tableP.setBounds(10, 65, 300, 400);
		infoL.setBounds(550, 40, 240, 200);
		imgL.setBounds(330, 65, 200, 250);
		buy.setBounds(550, 240, 100, 20);
		pick.setBounds(680, 240, 100, 20);
		
		buy.setVisible(false);
		pick.setVisible(false);
		
		buyP.setLayout(null);
		buyP.setBackground(Color.white);
		buyP.setBounds(0,100,960,570);
		buyP.add(buy);
		buyP.add(pick);
		buyP.add(titleL);
		buyP.add(tableP);
		buyP.add(infoL);
		buyP.add(imgL);
		
		return buyP;
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
