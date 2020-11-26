package login;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SetTable {	
	
	Vector<String> title;
	Vector<String> contents;
	Vector<Vector> output;
	JTable table;
	
	
	public JTable setStockTable(ArrayList<StockVo> list) {
		
		title = new Vector();
		contents = new Vector();
		output = new Vector();
		
		title.add("품명");
		title.add("재고");
		
		for(int i = 0; i<list.size(); i++) {
			StockVo data = (StockVo) list.get(i);
			String name = data.getName();
			String stocks = data.getStocks();
			
			contents.add(name);
			contents.add(stocks);
		}
		
		output.add(contents);
		
		
		DefaultTableModel model = new DefaultTableModel(output,title);
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		
		return table;
	}
	
	public JTable setAttendPTable(ArrayList<AttendVo> list) {
		
		title = new Vector<String>();
		contents = new Vector<String>();
		output = new Vector();
		
		title.add("No.");
		title.add("출근일");
		title.add("시작 시간");
		title.add("종료 시간");
		title.add("총 시간");
		
		for(int i = 0; i<list.size(); i++) {
			AttendVo data = (AttendVo) list.get(i);
			String no = data.getRowNum();
			String attendTime = data.getAttendTime();
			String startTime = data.getStartTime();
			String endTime = data.getEndTime();
			String wholeTime = data.getWholeTime();
			
			
			contents.add(no);
			contents.add(attendTime);
			contents.add(startTime);
			contents.add(endTime);
			contents.add(wholeTime);
		}
		
		output.add(contents);
		
		DefaultTableModel model = new DefaultTableModel(output,title);
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		
		return table;
		
	}
	
	public JTable setWorkerTable(ArrayList<AccountVo> list) {
		
		title = new Vector<String>();
		contents = new Vector<String>();
		output = new Vector();
		
		title.add("No.");
		title.add("직원 코드");
		title.add("직급");
		title.add("이름");
		title.add("입사 일자");
		title.add("연락처");
		
		for(int i = 0; i<list.size(); i++) {
			AccountVo data = (AccountVo) list.get(i);
			String no = data.getRowNum();
			String empno = data.getEmpno();
			String rank = data.getRank();
			String name = data.getName();
			String start = data.getStart();
			String phone = data.getPhone();
			
			
			contents.add(no);
			contents.add(empno);
			contents.add(rank);
			contents.add(name);
			contents.add(start);
			contents.add(phone);
		}
		
		output.add(contents);
		
		table = new JTable(output,title);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		
		return table;
		
	}
	
}

