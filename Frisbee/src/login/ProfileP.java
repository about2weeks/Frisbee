package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ProfileP implements ActionListener{

	
	JPanel profileP;
	
	JPanel nameP;
	JLabel titleL;
	JLabel nameL;
	JLabel emailL;
	JLabel salL;
	JLabel timeL;
	
	DefaultTableModel model;
	JTable table;
	JScrollPane tableP;

	PlusP pp = new PlusP();
	JPanel plusP;
	
	JButton ok;
	JButton cancel;
	JButton plus;
	
	String empno;
	String storeNo;
	
	public ProfileP(String empno, String storeNo) {
		
		this.empno = empno;
		this.storeNo = storeNo;
		
		AccountDAO ad = new AccountDAO();
		ArrayList<AccountVo> list = ad.setProfile(empno);
		AccountVo data = list.get(0);
		String name = data.getName();
		//String rank = data.getRank();
		String phone = data.getPhone();
		String email = data.getEmail();
		//String superC = data.getSuperC();
		String sal = data.getSal().substring(0, 10);
		String start = data.getStart().substring(0,10);
		String end = data.getEnd().substring(0,10);
		String superN = data.getSuperN();
		
		
		profileP = new JPanel();
		plusP = pp.setProfile();
		
		nameP = new JPanel();
		titleL = new JLabel("내 계정");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		nameL = new JLabel("이름  :  "+name+"              직원 코드  :  "+empno+"              관리자 이름  :  "+superN);
		emailL = new JLabel("연락처  :  "+phone+"              이메일  :  "+email);
		salL = new JLabel("월급일 : "+sal+"       시작일 : "+start+"       종료일 : "+end);
		
		cancel = new JButton("취소");
		ok = new JButton("확인");
		plus = new JButton("+"); 
		
		model = new SetTable().setAttendPTable(new AttendDAO().setAttendP(empno));
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.white);
		tableP = new JScrollPane(table);
		
		
		int attend = table.getRowCount();
		int sum = 0;
		for(int i= 0; i<attend; i++) {
			sum += Integer.parseInt((String) table.getValueAt(i, 4));
		}
		timeL = new JLabel("총 근무일 : "+attend+"일   총 근무 시간 : "+sum+"시간");
		timeL.setFont(new Font("돋움",Font.BOLD,18));
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("+")) {
			nameP.setVisible(false);
			tableP.setVisible(false);
			plusP.setVisible(true);
			ok.setVisible(true);
			cancel.setVisible(true);
		}
		if(e.getActionCommand().equals("확인")) {
			String date = pp.tf1.getText();
			String start = pp.tf2.getText();
			String end = pp.tf3.getText();
			String whole = pp.tf4.getText();
		
			if(new AttendDAO().insertAttend(empno, storeNo, date, start, end, whole)==1) {
				try {
					pp.notice.setText("등록되었습니다");
					TimeUnit.SECONDS.sleep(1);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				plusP.setVisible(false);
				
				profileP.remove(tableP);
				
				model = new SetTable().setAttendPTable(new AttendDAO().setAttendP(empno));
				table = new JTable(model);
				JTableHeader header = table.getTableHeader();
				header.setForeground(Color.white);
				tableP = new JScrollPane(table);
				
				
				int attend = table.getRowCount();
				int sum = 0;
				for(int i= 0; i<attend; i++) {
					sum += Integer.parseInt((String) table.getValueAt(i, 4));
				}
				timeL.setText("총 근무일 : "+attend+"일   총 근무 시간 : "+sum+"시간");
				timeL.setFont(new Font("돋움",Font.BOLD,18));
				tableP.setBounds(10,210,900,320);
				profileP.add(tableP);
				
				tableP.setVisible(true);
				nameP.setVisible(true);
				plus.setVisible(true);
				ok.setVisible(false);
				cancel.setVisible(false);
				
				nameP.revalidate();
				nameP.repaint();
				profileP.revalidate();
				profileP.repaint();
			}else {
				pp.notice.setText("등록에 실패했습니다.");
			}
			
		}
		if(e.getActionCommand().equals("취소")) {
			tableP.setVisible(true);
			nameP.setVisible(true);
			plus.setVisible(true);
			ok.setVisible(false);
			cancel.setVisible(false);
		}
	}
	
	public JPanel setPanel() {
		
		plus.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		cancel.setBounds(70, 270, 40, 20);
		ok.setBounds(10, 270, 40, 20);
		plusP.setVisible(false);
		cancel.setVisible(false);
		ok.setVisible(false);
		
		nameP.setLayout(null);
		nameP.setBounds(0, 0, 960, 210);
		titleL.setBounds(10, 10, 100, 50);
		nameL.setBounds(10, 60, 940, 30);
		emailL.setBounds(10, 90, 940, 30);
		salL.setBounds(10, 120, 940, 30);
		timeL.setBounds(10,160,800,40);
		plus.setBounds(870, 160, 40, 40);
		nameP.add(titleL);
		nameP.add(nameL);
		nameP.add(emailL);
		nameP.add(salL);
		nameP.add(timeL);
		nameP.add(plus);
		nameP.setBackground(Color.white);
		
		tableP.setBounds(10,210,900,320);
		
		profileP.setLayout(null);
		profileP.setBounds(0,100,960,570);
		profileP.setBackground(Color.white);
		profileP.add(nameP);
		profileP.add(tableP);
		profileP.add(plusP);
		profileP.add(ok);
		profileP.add(cancel);
		
		
		
		return profileP;
	}
	
}
