package Hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main_Activity extends JFrame {
	private JLabel vip_label, image_label,tips;
	JButton cancel,hidebutton;
	private JButton vip_button, select_button, in_button, guests_button, money_button;

	public Main_Activity() {
		super("Main_Acitivity");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 关闭按钮处理事件
		setBounds(550, 200, 1000, 800);
		setSize(800, 600);
		JPanel jpanel = new JPanel(); // 主面板
		jpanel.setLayout(new BorderLayout());
		JPanel t_jpanel = new JPanel(); // 上面板
		//JPanel m_jpanel = new JPanel();
		JPanel f_jpanel = new JPanel();
		cancel=new JButton("");
		FlowLayout flowlayout = new FlowLayout();
		flowlayout.setHgap(20);
		flowlayout.setVgap(5);
		// 图片
		ImageIcon image = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/mm.png");
		image_label = new JLabel(image);
		image_label.setIcon(image);
		vip_button = new JButton("加入会员"); // 功能按钮 打开录入信息界面
		select_button = new JButton("查询房间状态");
		guests_button = new JButton("宾客入住");
		money_button = new JButton("结账");
		f_jpanel.add(select_button);
		f_jpanel.add(vip_button);
		f_jpanel.add(guests_button);
		f_jpanel.add(money_button);
		tips=new JLabel("欢迎来到Tracy_Hotel !! ");
		jpanel.add(cancel,BorderLayout.NORTH);
	//	
		jpanel.add(tips, BorderLayout.NORTH);
		cancel.setBounds(780, 0, 20, 20);
		cancel.setContentAreaFilled(true);
		
		ImageIcon image2 = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/hide.png");
		hidebutton=new JButton(image2);
		hidebutton.setBounds(760, 0, 20, 20);
		jpanel.add(hidebutton,BorderLayout.NORTH);
		hidebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 setExtendedState(JFrame.ICONIFIED);   //实现窗口最小化
			}
		});
		
		ImageIcon image1 = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/dispose.png");
		cancel.setIcon(image1);
		tips.setBounds(350, 20, 700, 90);
		tips.setFont(new Font("",1,25));
		//tips.setSize(400, 400);
		tips.setForeground(Color.yellow);
		f_jpanel.setBackground(Color.orange);
		jpanel.add(image_label, BorderLayout.NORTH);
		jpanel.add(f_jpanel, BorderLayout.CENTER);
		this.add(jpanel);
		setUndecorated(true);  //隐藏标题框
		money_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new pay();
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		guests_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new guess();
			}
		});
		vip_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Vip();
			}
		});

		select_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				//	new House();
					new Vip_able();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		// m_jpanel.setBackground(Color.BLUE);
		/*
		 * jpanel.add(vip_button); jpanel.add(select_button);
		 */
		// jpanel.add(m_jpanel,BorderLayout.WEST);

		setVisible(true);
		this.pack();
	}

}
