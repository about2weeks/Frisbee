package login;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SetTable {	
	
	Vector<String> title;
	Vector contents;
	Vector output;
	JTable table;
	
	
	public DefaultTableModel setStockTable(ArrayList<StockVo> list) {
		
		title = new Vector();
		output = new Vector();
		
		title.addElement("품명");
		title.addElement("재고");
		
		for(int i = 0; i<list.size(); i++) {
			contents = new Vector();
			StockVo data = (StockVo) list.get(i);
			String name = data.getName();
			String stocks = data.getStocks();
			
			contents.addElement(name);
			contents.addElement(stocks);
			output.add(contents);
		}
		
		
		DefaultTableModel model = new DefaultTableModel(output,title) {
			public boolean isCellEditable(int row, int column) {
				
				return false;
				}	
					
			};
		
		return model;
	}
	
	public DefaultTableModel setAttendPTable(ArrayList<AttendVo> list) {
		
		title = new Vector();
		output = new Vector();
		
		title.add("No.");
		title.add("출근일");
		title.add("시작 시간");
		title.add("종료 시간");
		title.add("총 시간");
		
		for(int i = 0; i<list.size(); i++) {
			contents = new Vector();
			AttendVo data = (AttendVo) list.get(i);
			String no = data.getRowNum();
			String attendTime = data.getAttendTime().substring(0,10);
			String startTime = data.getStartTime().substring(11,16);
			String endTime = data.getEndTime().substring(11,16);
			String wholeTime = data.getWholeTime();
			
			
			contents.addElement(no);
			contents.addElement(attendTime);
			contents.addElement(startTime);
			contents.addElement(endTime);
			contents.addElement(wholeTime);
			output.add(contents);
		}
		
		//output.add(contents);
		
		DefaultTableModel model = new DefaultTableModel(output,title) {
			public boolean isCellEditable(int row, int column) {
				
				return false;
				}	
					
			};
		
		return model;
		
	}
	
	public DefaultTableModel setWorkerTable(ArrayList<AccountVo> list) {
		
		title = new Vector<String>();
		output = new Vector();
		
		title.add("No.");
		title.add("직원 코드");
		title.add("직급");
		title.add("이름");
		title.add("입사 일자");
		title.add("연락처");
		
		for(int i = 0; i<list.size(); i++) {
			contents = new Vector<String>();
			AccountVo data = (AccountVo) list.get(i);
			String no = data.getRowNum();
			String empno = data.getEmpno();
			String rank = data.getRank();
			String name = data.getName();
			String start = data.getStart().substring(0, 10);
			String phone = data.getPhone();
			
			
			contents.add(no);
			contents.add(empno);
			contents.add(rank);
			contents.add(name);
			contents.add(start);
			contents.add(phone);
			
			output.add(contents);
			
		}
		
		//output.add(contents);
		DefaultTableModel model = new DefaultTableModel(output,title) {
		public boolean isCellEditable(int row, int column) {
			
			return false;
			}	
				
		};
		
		return model;
		
	}
	
	public DefaultTableModel setSellTable(ArrayList<SellVo> list) {
		
		
		title = new Vector<String>();
		output = new Vector();
		
		title.add("날짜");
		title.add("품목명");
		title.add("수량");
		title.add("단가");
		title.add("총액");
		
		for(int i = 0; i<list.size(); i++) {
			contents = new Vector<String>();
			
			SellVo data = (SellVo) list.get(i);
			
			String goodsNo = data.getGoodsNo();
			String sellTime = data.getSellTime().substring(0, 10);
			String goodsName = data.getGoodsName();
			int qtty = data.getQtty();
			long unitPrice = data.getUnitPrice();
			
			long whole = qtty * unitPrice;
			
			
			contents.add(sellTime);
			contents.add(goodsName);
			contents.add(qtty);
			contents.add(unitPrice);
			contents.add(whole);
			
			output.add(contents);
			
		}
		
		
		
		DefaultTableModel model = new DefaultTableModel(output,title) {
			public boolean isCellEditable(int row, int column) {
				
				return false;
				}	
					
			};
		
		return model;
	}
		
	public DefaultTableModel setNoticeTable(ArrayList<NoticeVo> list) {
		
		
		title = new Vector<String>();
		output = new Vector();
		
		title.add("번호");
		title.add("내용");
		
		for(int i = 0; i<list.size(); i++) {
			contents = new Vector<String>();
			
			NoticeVo data = (NoticeVo) list.get(i);
			
			String no = data.getNo();
			String content = data.getContent();
			
			
			contents.add(no);
			contents.add(content);

			
			output.add(contents);
			
		}
		
		DefaultTableModel model = new DefaultTableModel(output,title) {
			public boolean isCellEditable(int row, int column) {
				
				return false;
				}	
					
			};
		
		return model;
	}
	
	

	
}

