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
		okbutton = new JButton("��¼");
		okbutton.setSize(235, 38);
		okbutton.setLocation(180, 314);
		okbutton.setContentAreaFilled(false); // ���ð�ť͸��
		utext = new JTextField();
		ptext = new JPasswordField();
		utext.setSize(180, 29);
		utext.setLocation(220, 173);
		ptext.setSize(180, 29);
		ptext.setLocation(220, 213);
		username = new JLabel("�û���:");
		username.setForeground(Color.yellow);
		username.setFont(new Font("", 1, 16));
		username.setSize(60, 40);
		username.setLocation(150, 244);
		password = new JLabel("��   ��:");
		password.setForeground(Color.yellow);
		password.setFont(new Font("BLOD", 1, 16));
		password.setSize(60, 40);
		password.setLocation(150, 300);
		Toptext = new JLabel("�Ƶ����ϵͳ��¼");
		Toptext.setForeground(Color.yellow);
		Toptext.setSize(400, 180);
		Toptext.setLocation(195, 25);
		Toptext.setFont(new Font("", 1, 25));
		setUndecorated(true); // ���ڱ�����

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
					JOptionPane.showMessageDialog(null, "�������û���������!", "tips", JOptionPane.ERROR_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(null, "�û������������", "tips", JOptionPane.ERROR_MESSAGE);
				}
			}
		}); // �ڲ�����ʽ��Ӽ�����
		/*
		 * ptext.addKeyListener(new KeyAdapter() { public void
		 * KeyPressed(KeyEvent e) { //����������Enter��¼���ܣ�(δʵ��). if
		 * (e.getKeyCode()==KeyEvent.VK_ENTER ) { if
		 * (utext.getText().trim().equalsIgnoreCase("king") &&
		 * ptext.getText().trim().equalsIgnoreCase("123")) { // TODO //
		 * Auto-generated // method // stub JOptionPane errDialog = new
		 * JOptionPane(); Main_Activity main = new Main_Activity(); Hotel_login
		 * logo = new Hotel_login(); main.setVisible(true);
		 * logo.setVisible(false); // logo.dispose(); } else if
		 * (utext.getText().trim().equalsIgnoreCase("") &&
		 * ptext.getText().trim().equalsIgnoreCase("")) {
		 * JOptionPane.showMessageDialog(null, "�������û���������!", "�������û���������!",
		 * JOptionPane.ERROR_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null, "�û������������", "�û������������",
		 * JOptionPane.ERROR_MESSAGE); } }
		 * 
		 * } });
		 */
		add(utext);
		add(ptext);
		add(okbutton);
		add(Toptext);

		// ��ӹر�ͼ��
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

		// ʵ�ִ�����С����ť
		ImageIcon image2 = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/hide.png");
		hidebutton = new JButton("image2");
		hidebutton.setBounds(50, 300, 20, 20);

		hidebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.ICONIFIED); // ʵ�ִ�����С��
			}
		});

		// ��JPanel�������ͼ��

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
	 * JOptionPane.showMessageDialog(null, "�������û���������!", "�������û���������!",
	 * JOptionPane.ERROR_MESSAGE); } else { JOptionPane.showMessageDialog(null,
	 * "�û������������", "�û������������", JOptionPane.ERROR_MESSAGE); }
	 * 
	 * else{ JOptionPane.showMessageDialog(null, "�������û���", "alert",
	 * JOptionPane.ERROR_MESSAGE); }
	 * 
	 * }
	 * 
	 * }
	 */

}
