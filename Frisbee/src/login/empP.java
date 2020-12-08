package login;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

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
	JPanel plusP;
	
	JLabel titleL;
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;
	
	JTextField tf1;
	JButton bt1;
	
	JButton plus;
	JButton back;
	JButton ok;
	JButton cancel;
		
	PlusP pp = new PlusP();
	
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
		
		plusP = pp.setAccount();
		
	    cancel = new JButton("취소");
		ok = new JButton("확인");
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("+")) {
			tableP.setVisible(false);
			plusP.setVisible(true);
			plus.setVisible(false);
			ok.setVisible(true);
			cancel.setVisible(true);
		}
		if(e.getActionCommand().equals("<")) {
			selectP.setVisible(false);
			tableP.setVisible(true);
			back.setVisible(false);
			plus.setVisible(true);
		}
		if(e.getActionCommand().equals("확인")) {
			
			String name = pp.tf1.getText();
			String rank = pp.tf2.getText();
			String code = pp.tf3.getText();
			String start = pp.tf4.getText();
			String phone = pp.tf5.getText();
			String email = pp.tf6.getText();
			
			
			System.out.println(model.getRowCount());
			
			if(new AccountDAO().insertAccount(name, empno, rank, code, start, phone, email, storeNo)==1) {
				try {
					pp.notice.setText("등록되었습니다");
					System.out.println(model.getRowCount());
					TimeUnit.SECONDS.sleep(1);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				plusP.setVisible(false);
				
				empP.remove(tableP);
				
				model = new SetTable().setWorkerTable(new AccountDAO().setWorker(storeNo));
				table = new JTable(model);
				JTableHeader header = table.getTableHeader();
				header.setForeground(Color.white);
				tableP = new JScrollPane(table);
				tableP.setBounds(10, 50, 900, 450);
				empP.add(tableP);
				
				tableP.setVisible(true);
				plus.setVisible(true);
				ok.setVisible(false);
				cancel.setVisible(false);
				
				empP.revalidate();
				empP.repaint();
			}else {
				pp.notice.setText("등록에 실패했습니다.");
			}
		}
		if(e.getActionCommand().equals("취소")) {
			plusP.setVisible(false);
			tableP.setVisible(true);
			ok.setVisible(false);
			cancel.setVisible(false);
			plus.setVisible(true);
		}
	}
	
	
	
	public void mouseClicked(MouseEvent e) {
		 //TODO Auto-generated method stub
		if(e.getComponent()==table) {
			TableModel md = (TableModel) table.getModel();
			int rowIndex = table.getSelectedRow();
			String selectNo = (String) md.getValueAt(rowIndex, 1);
	
			ProfileP pf = new ProfileP(selectNo, storeNo);
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
	
	public JPanel setPanel() {
		
		plus.addActionListener(this);
		back.addActionListener(this);
		table.addMouseListener(this);
		cancel.addActionListener(this);
		ok.addActionListener(this);
		
		titleL.setBounds(10, 10, 100, 40);
		plus.setBounds(110, 15, 30, 30);
		back.setBounds(110, 15, 30, 30);
		cancel.setBounds(70, 300, 40, 20);
		ok.setBounds(10, 300, 40, 20);
		
		ok.setVisible(false);
		cancel.setVisible(false);
		back.setVisible(false);
		plusP.setVisible(false);
		
		tableP.setBounds(10, 50, 900, 450);
		
		//selectP.setBackground(Color.white);
		
		empP.setLayout(null);
		empP.setBounds(0,100,960,575);
		empP.setBackground(Color.white);
		empP.add(plus);
		empP.add(ok);
		empP.add(cancel);
		empP.add(plusP);
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
