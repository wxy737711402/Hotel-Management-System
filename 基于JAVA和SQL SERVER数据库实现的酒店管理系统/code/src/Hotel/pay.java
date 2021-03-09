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
		super("�������");
		this.setBounds(400, 50, 450, 280);
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		namel = new JLabel("��������:");
		sexl = new JLabel("�����Ա�:");
		typel = new JLabel("����:");
		pricel = new JLabel("�۸�:");
		H_numberl = new JLabel("���������ķ���:");
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
		tips = new JLabel("�������");
		tips.setBounds(430, 20, 100, 50);
		tips.setFont(new Font("", 1, 20));
		tips.setForeground(Color.yellow);
		ok_button = new JButton("����");
		ok_button.setBounds(650, 600, 100, 20);
		select_button = new JButton("��ѯ������ס��Ϣ");
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
				setExtendedState(JFrame.ICONIFIED); // ʵ�ִ�����С��
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		setUndecorated(true); // ���ر����

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
				JOptionPane.showMessageDialog(null, "����Ҫ����:" + "  " + price.getText() + ".0", "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
				String sql = "update guess set name=" + "'" + "��" + "'" + "," + " sex=" + "'" + "��" + "'" + ","
						+ "Activity=" + "'" + "��" + "'" + "where H_number=" + H_number.getText();
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
						JOptionPane.showMessageDialog(null, "�����������!   ��������ǿյ�!", "�����������!   ��������ǿյ�!",
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