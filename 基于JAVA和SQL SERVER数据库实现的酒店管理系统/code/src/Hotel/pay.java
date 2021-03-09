package Hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class pay extends JFrame {

	JButton select_button, ok_button, cancel, hide;
	JLabel backgruond, tips, namel, sexl, typel, pricel, H_numberl;
	JTextField name, sex, type, price, H_number;

	pay() {
		super("结账离店");
		this.setBounds(400, 50, 450, 280);
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		namel = new JLabel("您的姓名:");
		sexl = new JLabel("您的性别:");
		typel = new JLabel("房型:");
		pricel = new JLabel("价格:");
		H_numberl = new JLabel("请输入您的房号:");
		H_numberl.setBounds(35, 150, 100, 20);
		namel.setBounds(35, 300, 100, 20);
		sexl.setBounds(235, 300, 100, 20);
		typel.setBounds(535, 300, 100, 20);
		pricel.setBounds(735, 300, 100, 20);
		H_numberl.setForeground(Color.blue);
		namel.setForeground(Color.orange);
		sexl.setForeground(Color.yellow);
		typel.setForeground(Color.yellow);
		pricel.setForeground(Color.yellow);
		name = new JTextField();
		sex = new JTextField();
		type = new JTextField();
		price = new JTextField();
		H_number = new JTextField();
		name.setBounds(100, 300, 100, 20);
		sex.setBounds(300, 300, 100, 20);
		type.setBounds(580, 300, 100, 20);
		price.setBounds(780, 300, 100, 20);
		H_number.setBounds(140, 150, 100, 20);
		tips = new JLabel("结账离店");
		tips.setBounds(430, 20, 100, 50);
		tips.setFont(new Font("", 1, 20));
		tips.setForeground(Color.yellow);
		ok_button = new JButton("结账");
		ok_button.setBounds(650, 600, 100, 20);
		select_button = new JButton("查询您的入住信息");
		select_button.setBounds(230, 600, 150, 20);
		ImageIcon image = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/new.png");
		backgruond = new JLabel(image);
		// backgruond.setIcon(image);
		backgruond.setOpaque(true);
		panel.add(backgruond);
		add(ok_button);
		add(select_button);
		add(tips);

		ImageIcon image1 = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/dispose.png");
		cancel = new JButton(image1);
		cancel.setIcon(image1);
		cancel.setBounds(980, 0, 20, 20);
		this.add(cancel);

		ImageIcon image2 = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/hide.png");
		hide = new JButton(image2);
		hide.setBounds(960, 0, 20, 20);
		this.add(hide);

		hide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.ICONIFIED); // 实现窗口最小化
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		setUndecorated(true); // 隐藏标题框

		this.add(H_numberl);
		this.add(namel);
		this.add(sexl);
		this.add(typel);
		this.add(pricel);
		this.add(type);
		this.add(name);
		this.add(sex);
		this.add(price);
		this.add(H_number);
		this.add(panel);
		this.pack();
		/*
		 * dispose(); this.setUndecorated(true);
		 */
		this.setVisible(true);
		ok_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "您需要付款:" + "  " + price.getText() + ".0", "提示",
						JOptionPane.INFORMATION_MESSAGE);
				String sql = "update guess set name=" + "'" + "无" + "'" + "," + " sex=" + "'" + "无" + "'" + ","
						+ "Activity=" + "'" + "空" + "'" + "where H_number=" + H_number.getText();
				DAO.executeUpdate(sql);
			}
		});
		select_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sql = "select * from guess where H_number" + "=" + H_number.getText();
				ResultSet rs = DAO.executeQuery(sql);
				try {
					if (rs == null) {
						JOptionPane.showMessageDialog(null, "房号输入错误!   这个房间是空的!", "房号输入错误!   这个房间是空的!",
								JOptionPane.ERROR_MESSAGE);
					}
					String result = rs.getString("name").trim();
					System.out.println(result);
					name.setText(result);
					result = rs.getString("sex").trim();
					sex.setText(result);
					String Type = rs.getString("type").trim();
					type.setText(Type);
					String Price = rs.getString("price").trim();
					System.out.println(Price);
					price.setText(Price);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block

					e1.printStackTrace();
				}

			}
		});
	}

}