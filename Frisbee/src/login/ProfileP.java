package login;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ProfileP {

	
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

	
	
	public ProfileP(String empno) {
		
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
		
		nameP = new JPanel();
		titleL = new JLabel("내 계정");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		nameL = new JLabel("이름  :  "+name+"              직원 코드  :  "+empno+"              관리자 이름  :  "+superN);
		emailL = new JLabel("연락처  :  "+phone+"              이메일  :  "+email);
		salL = new JLabel("월급일 : "+sal+"       시작일 : "+start+"       종료일 : "+end);
		
		
		
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
	
	public JPanel setPanel() {
		
		nameP.setLayout(null);
		nameP.setBounds(0, 0, 960, 210);
		titleL.setBounds(10, 10, 100, 50);
		nameL.setBounds(10, 60, 940, 30);
		emailL.setBounds(10, 90, 940, 30);
		salL.setBounds(10, 120, 940, 30);
		timeL.setBounds(10,160,940,40);
		nameP.add(titleL);
		nameP.add(nameL);
		nameP.add(emailL);
		nameP.add(salL);
		nameP.add(timeL);
		nameP.setBackground(Color.white);
		
		tableP.setBounds(10,210,900,320);
		
		profileP.setLayout(null);
		profileP.setBounds(0,100,960,570);
		profileP.setBackground(Color.white);
		profileP.add(nameP);
		profileP.add(tableP);
		
		
		return profileP;
	}
	
}
