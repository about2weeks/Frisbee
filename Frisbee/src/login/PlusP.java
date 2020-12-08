package login;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PlusP {

	JPanel plusP;
	
	JLabel notice;
	
	JTextField tf1 = new JTextField();
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
	JTextField tf6;
	
	
	public PlusP() {
		
		plusP = new JPanel();
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		
		notice = new JLabel();
		
	}
	
	public JPanel setAccount() {
		
		JLabel name = new JLabel("이름");
		name.setBounds(0, 30, 50, 20);
		JLabel rank = new JLabel("직급");
		rank.setBounds(0, 60, 50, 20);
		JLabel code = new JLabel("직원 코드");
		code.setBounds(0, 90, 50, 20);
		JLabel start = new JLabel("시작일");
		start.setBounds(0, 120, 50, 20);
		JLabel phone = new JLabel("연락처");
		phone.setBounds(0, 150, 50, 20);
		JLabel email = new JLabel("이메일");
		email.setBounds(0, 180, 50, 20);
		
			//name
		tf1.setBounds(60, 30, 120, 20);
		tf2.setBounds(60, 60, 120, 20);
		tf3.setBounds(60, 90, 120, 20);
		tf4.setBounds(60, 120, 120, 20);
		tf5.setBounds(60, 150, 120, 20);
		tf6.setBounds(60, 180, 120, 20);
	
		notice.setBounds(30, 210, 150, 15);
		
		plusP.add(name);
		plusP.add(rank);
		plusP.add(code);
		plusP.add(start);
		plusP.add(phone);
		plusP.add(email);
		plusP.add(notice);
		
		plusP.add(tf1);
		plusP.add(tf2);
		plusP.add(tf3);
		plusP.add(tf4);
		plusP.add(tf5);
		plusP.add(tf6);
		
		
		plusP.setLayout(null);
		plusP.setBounds(10,50,600,300);
		plusP.setBackground(Color.white);
		
		
		return plusP;
	}

	public JPanel setProfile() {
		
		JLabel date = new JLabel("날짜");
		date.setBounds(0, 30, 50, 20);
		JLabel start = new JLabel("시작 시간");
		start.setBounds(0, 60, 50, 20);
		JLabel end = new JLabel("종료 시간");
		end.setBounds(0, 90, 50, 20);
		JLabel whole = new JLabel("총 시간");
		whole.setBounds(0, 120, 50, 20);
		
		tf1.setBounds(60, 30, 120, 20);
		tf2.setBounds(60, 60, 120, 20);
		tf3.setBounds(60, 90, 120, 20);
		tf4.setBounds(60, 120, 120, 20);
		
		notice.setBounds(30, 160, 150, 15);
		
		
		plusP.add(date);
		plusP.add(start);
		plusP.add(end);
		plusP.add(whole);
		plusP.add(notice);
		
		plusP.add(tf1);
		plusP.add(tf2);
		plusP.add(tf3);
		plusP.add(tf4);
		
		plusP.setLayout(null);
		plusP.setBounds(10,50,600,200);
		plusP.setBackground(Color.white);
		
		return plusP;
	}
	
	
}
