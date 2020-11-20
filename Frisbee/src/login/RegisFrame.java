package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisFrame implements ActionListener {
	
	JFrame f;
	
	JLabel title;
	JLabel code;
	JLabel id;
	JLabel pw;
	JLabel notice;
	
	JTextField codetf;
	JTextField idtf;
	JPasswordField pwtf;
	
	JButton btOk;
	JButton btCancel;
	
	JPanel titleP;
	JPanel codeP;
	JPanel idP;
	JPanel pwP;
	JPanel btP;
	JPanel noticeP;
	
	LoginFrame toBack = null;
	
	public RegisFrame() {
		
	}
	
	public RegisFrame(LoginFrame lf) {
		
		toBack = lf;
		
		f = new JFrame("Frisbee Management");
		
		title = new JLabel("회원가입");
		title.setFont(new Font("돋움",Font.BOLD,24));
		code = new JLabel("직원코드");
		id = new JLabel("아이디");
		pw = new JLabel("비밀번호");
		notice = new JLabel();
		
		codetf = new JTextField("ex) ZZZ-11111");
		idtf = new JTextField("ID를 입력하세요");
		pwtf = new JPasswordField("입력하세요");
		pwtf.setEchoChar('*');
		
		btOk = new JButton("가입");
		btCancel = new JButton("취소");
		
		titleP = new JPanel();
		codeP = new JPanel();
		idP = new JPanel();
		pwP = new JPanel();
		btP = new JPanel();
		noticeP = new JPanel();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("가입")) {
			String code = codetf.getText();
			String id = idtf.getText();
			String pwd = String.copyValueOf(pwtf.getPassword());
			
			RegisDAO regidao = new RegisDAO();
			int cmd = regidao.findID(code, id, pwd);
			switch(cmd) {
			case 1:
				notice.setForeground(Color.RED);
				notice.setText("없는 직원 코드입니다.");
				break;
			case 2:
				notice.setForeground(Color.red);
				notice.setText("이미 회원가입이 되었습니다.");
				break;
			case 3:
				notice.setForeground(Color.red);
				notice.setText("ID가 존재합니다.");
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"회원가입에 실패하였습니다.","회원가입", JOptionPane.WARNING_MESSAGE);
				break;
			case 5:
				int result = JOptionPane.showConfirmDialog(null,"회원가입에 성공하였습니다.\n로그인 화면으로 돌아갑니다."
					,"회원가입", JOptionPane.YES_NO_OPTION);
				if(result ==1) {
					toBack.setFrame();
				}
				break;	
			}
			
			
		}else if(e.getActionCommand().equals("취소")) {
			toBack.setFrame();
		}
		
	}
	
	public void setFrame() {
		
		//button action -> id check&&empno check
		btOk.addActionListener(this);		
		btCancel.addActionListener(this);
		
		titleP.setLayout(null);
		title.setBounds(70,15,100,50);
		titleP.add(title);
		titleP.setBounds(0, 0, 1000, 70);
		titleP.setBackground(Color.white);
		
		codeP.setLayout(null);
		code.setBounds(70, 10, 90, 30);
		codetf.setBounds(170, 11, 150, 30);
		codeP.add(code);
		codeP.add(codetf);
		codeP.setBounds(0, 70, 1000, 50);
		codeP.setBackground(Color.white);
		
		idP.setLayout(null);
		id.setBounds(70, 10, 90, 30);
		idtf.setBounds(170, 11, 150, 30);
		idP.add(id);
		idP.add(idtf);
		idP.setBounds(0, 120, 1000, 50);
		idP.setBackground(Color.white);
		
		pwP.setLayout(null);
		pw.setBounds(70, 10, 90, 30);
		pwtf.setBounds(170, 11, 150, 30);
		pwP.add(pw);
		pwP.add(pwtf);
		pwP.setBounds(0, 170, 1000, 50);
		pwP.setBackground(Color.white);
		
		noticeP.setLayout(null);
		notice.setBounds(70, 20, 150, 30);
		noticeP.add(notice);
		noticeP.setBounds(0, 220, 1000, 200);
		noticeP.setBackground(Color.white);
		
		btP.setLayout(null);
		btOk.setBounds(70, 10,70,30);
		btCancel.setBounds(140, 10,70,30);
		btP.add(btOk);
		btP.add(btCancel);
		btP.setBounds(0,420,1000,280);
		btP.setBackground(Color.white);
		
		f.add(titleP);
		f.add(codeP);
		f.add(idP);
		f.add(pwP);
		f.add(noticeP);
		f.add(btP);
		
		f.setSize(1000, 700);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		
	}
	
}










