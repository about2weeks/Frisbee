package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{
	
	ImageIcon title;
	ImageIcon idIcon;
	ImageIcon pwIcon;
	ImageIcon mgIcon;
	JLabel titlelb;
	JLabel maglb;				//management label
	JLabel idlb;				//아이디 라벨 
	JLabel pwlb;				//비밀번호 라벨 
	JLabel notice;
	JTextField idtf;				//ID textfield
	JPasswordField pwdtf;				//password textfield
	JButton btLog;				//login button
	JButton btRegis;			//register button
	JFrame f;
	JPanel titleP;
	JPanel idP;
	JPanel pwdP;
	JPanel noticeP;
	JPanel btnP;
	
	public LoginFrame(){
		title = new ImageIcon("/Users/kai/Documents/Project/Frisbee/img/frisbee.jpg");
		idIcon = new ImageIcon("/Users/kai/Documents/Project/Frisbee/img/idIcon.png");
		pwIcon = new ImageIcon("/Users/kai/Documents/Project/Frisbee/img/pwdIcon.png");
		
		
		titlelb = new JLabel(title);
		idlb = new JLabel(idIcon);
		pwlb = new JLabel(pwIcon);
		notice = new JLabel();
		
		idtf = new JTextField("id",10);
		pwdtf = new JPasswordField("password",10);
		
		btLog = new JButton("로그인");
		btRegis = new JButton("회원가입");
		
		f = new JFrame("Frisbee Management");
		
		titleP = new JPanel();
		idP = new JPanel();
		pwdP = new JPanel();
		noticeP = new JPanel();
		btnP = new JPanel();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("로그인")) {
			String id = idtf.getText();
			String pwd = new String(pwdtf.getPassword());
			LoginDAO ld = new LoginDAO();
			String cmd = ld.login(id, pwd);
			
			if(cmd.equals("wrong")) {
				notice.setText("아이디 또는 비밀번호가 틀렸습니다.");
			}else if(cmd!=null){
				notice.setForeground(Color.black);
				notice.setText("로그인 성공");
				//MainFrame mf = new MainFrame(cmd);
				//mf.setFrame();
				System.out.println(cmd);
			}
		}else if(e.getActionCommand().equals("회원가입")) {
			RegisFrame rf = new RegisFrame(this);
			rf.setFrame();
		}
		
	}
	
	
	public void setFrame(){
		
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		
		btLog.addActionListener(this);
		btRegis.addActionListener(this);
		
		
		titleP.setLayout(new BorderLayout());
		titleP.setBackground(Color.white);
		titleP.setBounds(0,0,1000,375);
		titleP.add("Center",titlelb);
		
		idP.setLayout(fl);
		idP.setBackground(Color.white);
		idP.setBounds(0, 375, 1000, 50);
		idP.add(idlb);
		idP.add(idtf);
		
		pwdP.setLayout(fl);
		pwdP.setBackground(Color.white);
		pwdP.setBounds(0, 425, 1000, 50);
		pwdP.add(pwlb);
		pwdP.add(pwdtf);
		
		noticeP.setLayout(fl);
		notice.setForeground(Color.red);
		noticeP.setBackground(Color.white);
		noticeP.setBounds(0, 475, 1000, 20);
		noticeP.add(notice);
		
		btnP.setLayout(fl);
		btnP.setBackground(Color.white);
		btnP.setBounds(0,495,1000,205);
		btnP.add(btLog);
		btnP.add(btRegis);
		
		f.add(titleP);
		f.add(idP);
		f.add(pwdP);
		f.add(noticeP);
		f.add(btnP);
		
		
		f.setSize(1000, 700);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		
		
		
	}
	
	
	
}
