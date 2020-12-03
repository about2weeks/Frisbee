package login;

import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;

public class DialogP extends JDialog{

	
	JButton ok;
	JButton cancel;
	
	JLabel notice;
	
	DefaultTableModel model;
	
	public DialogP(JFrame f,String title, DefaultTableModel model) {
		
		super(f, title);
		this.model = model;
		
		
		
	}
	
	public void setAccount(String superC, String storeNo) {
		
		
		JLabel name = new JLabel("이름");
		name.setBounds(30, 30, 50, 20);
		JLabel rank = new JLabel("직급");
		rank.setBounds(30, 50, 50, 20);
		JLabel code = new JLabel("직원 코드");
		code.setBounds(30, 70, 50, 20);
		JLabel start = new JLabel("시작일");
		start.setBounds(30, 90, 50, 20);
		JLabel phone = new JLabel("연락처");
		phone.setBounds(30, 110, 50, 20);
		JLabel email = new JLabel("이메일");
		email.setBounds(30, 130, 50, 20);
		
		JTextField tf1 = new JTextField();	//name
		tf1.setBounds(85, 30, 120, 20);
		JTextField tf2 = new JTextField();	//rank
		tf2.setBounds(85, 50, 120, 20);
		JTextField tf3 = new JTextField();	//code
		tf3.setBounds(85, 70, 120, 20);
		JTextField tf4 = new JTextField();	//start date
		tf4.setBounds(85, 90, 120, 20);
		JTextField tf5 = new JTextField();	//phone
		tf5.setBounds(85, 110, 120, 20);
		JTextField tf6 = new JTextField();	//email
		tf6.setBounds(85, 130, 120, 20);
	
		notice = new JLabel();
		notice.setBounds(30, 160, 150, 15);
			
		ok = new JButton("확인");
		ok.setBackground(Color.white);
		ok.setBounds(65, 200, 40, 20);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<String> data = new Vector<String>();
				
				String name = tf1.getText();
				String rank = tf2.getText();
				String code = tf3.getText();
				String start = tf4.getText();
				String phone = tf5.getText();
				String email = tf6.getText();
						
				data.add(name);
				data.add(rank);
				data.add(code);
				data.add(start);
				data.add(phone);
				data.add(email);
				
				
				System.out.println(model.getRowCount());
				
				if(new AccountDAO().insertAccount(name, superC, rank, code, start, phone, email, storeNo)==1) {
					try {
						notice.setText("등록되었습니다");
						//model = new RefreshTable().refreshAccount(model, data);
						System.out.println(model.getRowCount());
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					setVisible(false);
				}else {
					notice.setText("등록에 실패했습니다.");
				}
			}
		});
		
		cancel = new JButton("취소");
		cancel.setBounds(185, 200, 40, 20);
		cancel.setBackground(Color.white);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		add(name);
		add(rank);
		add(code);
		add(start);
		add(phone);
		add(email);
		add(notice);
		
		add(ok);
		add(cancel);
		
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
		
		
		setLayout(null);
		setSize(250,300);
		setBackground(Color.white);
		setLocationRelativeTo(null);
	}

	
	
	
}
