package login;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ProfileP {

	
	JPanel profileP;
	
	JPanel nameP;
	JLabel titleL;
	JLabel nameL;
	JLabel emailL;
	JLabel salL;
	
	JTable table;

	
	
	public ProfileP(String empno) {
		
		AccountDAO ad = new AccountDAO();
		ArrayList<AccountVo> list = ad.setProfile(empno);
		AccountVo data = list.get(0);
		String name = data.getName();
		String rank = data.getRank();
		String phone = data.getPhone();
		String email = data.getEmail();
		String superC = data.getSuperC();
		String sal = data.getSal();
		String start = data.getStart();
		String end = data.getEnd();
		String superN = data.getSuperN();
		
		
		profileP = new JPanel();
		
		nameP = new JPanel();
		titleL = new JLabel("내 계정");
		titleL.setFont(new Font("돋움",Font.BOLD,20));
		nameL = new JLabel("이름 : "+name+"\t	직원 코드 : "+empno+"\t관리자 이름 : "+superN);
		emailL = new JLabel("연락처 : "+phone+"\t이메일 : "+email);
		salL = new JLabel("월급일 : "+sal+"\t시작일 : "+start+"\t종료일 : "+end);
		
		
	}
	
	public JPanel setPanel() {
		
		nameP.setLayout(null);
		titleL.setBounds(10, 10, 100, 30);
		nameL.setBounds(10, 40, 600, 20);
		emailL.setBounds(10, 60, 600, 20);
		salL.setBounds(10, 80, 600, 20);
		nameP.add(titleL);
		nameP.add(nameL);
		nameP.add(emailL);
		nameP.add(salL);
		nameP.setBackground(Color.white);
		
		profileP.setLayout(null);
		profileP.setBounds(20,100,960,575);
		profileP.setBackground(Color.blue);
		profileP.add(nameP);
		
		
		return profileP;
	}
	
}
