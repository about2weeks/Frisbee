package login;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

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
		
		
		table = new JTable(output,title);
		
		
		return table;
	}
	
}

