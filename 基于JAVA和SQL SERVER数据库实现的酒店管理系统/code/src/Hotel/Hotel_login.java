package Hotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Hotel_login extends JFrame {
	private JButton okbutton, quitbutton, hidebutton;
	JTextField utext;
	JPasswordField ptext;
	private JLabel username, password, Toptext;

	public Hotel_login() {
		super("Hotel_login");
		setBounds(750, 200, 600, 490);
		setLayout(null);
		okbutton = new JButton("登录");
		okbutton.setSize(235, 38);
		okbutton.setLocation(180, 314);
		okbutton.setContentAreaFilled(false); // 设置按钮透明
		utext = new JTextField();
		ptext = new JPasswordField();
		utext.setSize(180, 29);
		utext.setLocation(220, 173);
		ptext.setSize(180, 29);
		ptext.setLocation(220, 213);
		username = new JLabel("用户名:");
		username.setForeground(Color.yellow);
		username.setFont(new Font("", 1, 16));
		username.setSize(60, 40);
		username.setLocation(150, 244);
		password = new JLabel("密   码:");
		password.setForeground(Color.yellow);
		password.setFont(new Font("BLOD", 1, 16));
		password.setSize(60, 40);
		password.setLocation(150, 300);
		Toptext = new JLabel("酒店管理系统登录");
		Toptext.setForeground(Color.yellow);
		Toptext.setSize(400, 180);
		Toptext.setLocation(195, 25);
		Toptext.setFont(new Font("", 1, 25));
		setUndecorated(true); // 窗口标题栏

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("F:/Android project/Android_First/Hotel/src/Hotel/icon.png"); 
		
		setIconImage(img);

		okbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				if (utext.getText().trim().equalsIgnoreCase("king") && ptext.getText().trim().equalsIgnoreCase("123")) {
					JOptionPane errDialog = new JOptionPane();
					Main_Activity main = new Main_Activity();
					main.setVisible(true);
					dispose();
				} else if (utext.getText().trim().equalsIgnoreCase("") && ptext.getText().trim().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "请输入用户名和密码!", "tips", JOptionPane.ERROR_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误", "tips", JOptionPane.ERROR_MESSAGE);
				}
			}
		}); // 内部类形式添加监听器
		/*
		 * ptext.addKeyListener(new KeyAdapter() { public void
		 * KeyPressed(KeyEvent e) { //想密码框添加Enter登录功能，(未实现). if
		 * (e.getKeyCode()==KeyEvent.VK_ENTER ) { if
		 * (utext.getText().trim().equalsIgnoreCase("king") &&
		 * ptext.getText().trim().equalsIgnoreCase("123")) { // TODO //
		 * Auto-generated // method // stub JOptionPane errDialog = new
		 * JOptionPane(); Main_Activity main = new Main_Activity(); Hotel_login
		 * logo = new Hotel_login(); main.setVisible(true);
		 * logo.setVisible(false); // logo.dispose(); } else if
		 * (utext.getText().trim().equalsIgnoreCase("") &&
		 * ptext.getText().trim().equalsIgnoreCase("")) {
		 * JOptionPane.showMessageDialog(null, "请输入用户名和密码!", "请输入用户名和密码!",
		 * JOptionPane.ERROR_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null, "用户名或密码错误", "用户名或密码错误",
		 * JOptionPane.ERROR_MESSAGE); } }
		 * 
		 * } });
		 */
		add(utext);
		add(ptext);
		add(okbutton);
		add(Toptext);

		// 添加关闭图标
		ImageIcon image1 = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/dispose.png");
		quitbutton = new JButton(image1);
		quitbutton.setBounds(580, 0, 20, 20);

		quitbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		// 实现窗体最小化按钮
		ImageIcon image2 = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/hide.png");
		hidebutton = new JButton("image2");
		hidebutton.setBounds(50, 300, 20, 20);

		hidebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.ICONIFIED); // 实现窗口最小化
			}
		});

		// 非JPanel方法添加图标

		ImageIcon image = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/logo.png"); // F:/Android
																										// project/Android_First/Hotel/src/Hotel/Hotel.png
		JLabel imagelabel = new JLabel(image);
		imagelabel.setSize(600, 450);
		imagelabel.setLocation(0, 0);
		add(imagelabel);
		

		add(quitbutton);

		// add(hidebutton);

		setVisible(true);
	}

	JPanel mainPanel = new JPanel();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel_login login = new Hotel_login();
	}

	/*
	 * public class dl implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { if
	 * (utext.getText().trim().equalsIgnoreCase("king") &&
	 * ptext.getText().trim().equalsIgnoreCase("123")) { // TODO //
	 * Auto-generated // method // stub JOptionPane errDialog = new
	 * JOptionPane(); Main_Activity main = new Main_Activity(); Hotel_login logo
	 * = new Hotel_login(); main.setVisible(true); logo.setVisible(false);
	 * logo.dispose(); } else if (utext.getText().trim().equalsIgnoreCase("") &&
	 * ptext.getText().trim().equalsIgnoreCase("")) {
	 * JOptionPane.showMessageDialog(null, "请输入用户名和密码!", "请输入用户名和密码!",
	 * JOptionPane.ERROR_MESSAGE); } else { JOptionPane.showMessageDialog(null,
	 * "用户名或密码错误", "用户名或密码错误", JOptionPane.ERROR_MESSAGE); }
	 * 
	 * else{ JOptionPane.showMessageDialog(null, "请输入用户名", "alert",
	 * JOptionPane.ERROR_MESSAGE); }
	 * 
	 * }
	 * 
	 * }
	 */

}
