package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class NoticeP implements ActionListener {
	

	JPanel noticeP;
	
	JLabel titleL;
	JLabel notice;
	
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;
	
	String storeNo;
	String empno;
	
	JButton plus;
	
	public NoticeP(String empno, String storeNo) {
		
		this.storeNo = storeNo;
		this.empno = empno;
		
		noticeP = new JPanel();
		
		model = new SetTable().setNoticeTable(new NoticeDAO().setNoticeP(storeNo));
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		tableP = new JScrollPane(table);
		
		plus = new JButton("+");
		
		titleL = new JLabel("공지");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("+")) {
			String ans_str = (String) JOptionPane.showInputDialog(new JFrame(), 
					"공지를 쓰십시오.", "공지 등록", JOptionPane.PLAIN_MESSAGE, null, null, null);
			
			if(new NoticeDAO().insertNotice(ans_str,storeNo)==1) {
				
				
				noticeP.remove(tableP);
				
				model = new SetTable().setNoticeTable(new NoticeDAO().setNoticeP(storeNo));
				table = new JTable(model);
				JTableHeader header = table.getTableHeader();
				header.setForeground(Color.white);
				tableP = new JScrollPane(table);
				tableP.setBounds(10, 52, 350, 400);
				noticeP.add(tableP);
				
				noticeP.revalidate();
				noticeP.repaint();
			}else {
				JOptionPane.showMessageDialog(null, "등록에 실패하였습니다.","경고",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	
	public JPanel setPanel() {
		
		plus.addActionListener(this);
		
		titleL.setBounds(10, 0, 200, 50);
		tableP.setBounds(10, 52, 350, 400);
		plus.setBounds(320, 5, 30, 30);
		
		
		noticeP.setLayout(null);
		noticeP.setBackground(Color.white);
		noticeP.setBounds(520, 10, 400, 600);
		noticeP.add(titleL);
		noticeP.add(tableP);
		if(empno.charAt(0)=='A') {
			noticeP.add(plus);
		}
		
		return noticeP;
	}

}
