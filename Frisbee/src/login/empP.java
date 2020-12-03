package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class empP implements ActionListener, MouseListener{

	JFrame f = new JFrame();
	String empno;
	String storeNo;
	
	
	JPanel empP;
	JPanel selectP;
	
	JLabel titleL;
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;
	
	JTextField tf1;
	JButton bt1;
	
	JButton plus;
	JButton back;
	
	public empP(String empno, String storeNo) {
		
		this.empno = empno;
		this.storeNo = storeNo;
		
		
		empP = new JPanel();
		
		titleL = new JLabel("직원 관리");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		
		
		model = new SetTable().setWorkerTable(new AccountDAO().setWorker(storeNo));
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		tableP = new JScrollPane(table);
		
		plus = new JButton("+");
		back = new JButton("<");
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		DialogP dp = new DialogP(f, "직원 등록",model);
		if(e.getActionCommand().equals("+")) {
			dp.setAccount(empno, storeNo);
			dp.setVisible(true);
		}
		if(e.getActionCommand().equals("<")) {
			selectP.setVisible(false);
			tableP.setVisible(true);
			back.setVisible(false);
			plus.setVisible(true);
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		 //TODO Auto-generated method stub
		if(e.getComponent()==table) {
			TableModel md = (TableModel) table.getModel();
			int rowIndex = table.getSelectedRow();
			int colIndex = table.getSelectedColumn();
			String selectNo = (String) md.getValueAt(rowIndex, colIndex);
			if(colIndex==1) {
			ProfileP pf = new ProfileP(selectNo);
			pf.titleL.setText("");

			selectP = pf.setPanel();
			selectP.revalidate();
			selectP.repaint();
			
			
			selectP.setBounds(0, 0, 950, 530);
			empP.add(selectP);
			
			empP.revalidate();
			empP.repaint();
			
			selectP.setVisible(true);
			tableP.setVisible(false);
			plus.setVisible(false);
			back.setVisible(true);
			}
		}
	}
	
	public JPanel setPanel() {
		
		plus.addActionListener(this);
		back.addActionListener(this);
		table.addMouseListener(this);
		
		titleL.setBounds(10, 10, 100, 40);
		plus.setBounds(110, 15, 30, 30);
		back.setBounds(110, 15, 30, 30);
		back.setVisible(false);
		
		tableP.setBounds(10, 50, 900, 450);
		
		//selectP.setBackground(Color.white);
		
		empP.setLayout(null);
		empP.setBounds(0,100,960,575);
		empP.setBackground(Color.white);
		empP.add(plus);
		empP.add(tableP);
		empP.add(titleL);
		empP.add(back);
		
		
		return empP;
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
