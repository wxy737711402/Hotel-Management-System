package Hotel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class guess extends JFrame {

	JLabel tips, image, name, price, h_number;
	JComboBox type, Sex;
	JTextField name_text, price_text, h_text;
	JButton okbutton, quitbutton;
	private Object Types[] = { "��׼˫�˷�", "��ͳ�׷�", "����˫�˼�", "����󴲷�", "������", "����󴲷�" };
	private Object sex[] = { "��", "Ů" };

	guess() {
		super("������ס��Ϣ");
		setBounds(750, 200, 400, 400);
		// this.setBounds(600, 200, 400, 400);
		okbutton = new JButton("ȷ����ס");
		quitbutton = new JButton("ȡ��");
		name = new JLabel("��������:");
		price = new JLabel("�۸�:");
		h_number = new JLabel("�������ŵķ�����:");
		name_text = new JTextField();
		price_text = new JTextField("168.0");
		h_text = new JTextField();
		Sex = new JComboBox(sex);
		type = new JComboBox(Types);
		okbutton.setBounds(250, 450, 100, 30);
		okbutton.setContentAreaFilled(false); // ���ð�ť͸��
		okbutton.setForeground(Color.green);
		quitbutton.setBounds(550, 450, 100, 30);
		quitbutton.setContentAreaFilled(false); // ���ð�ť͸��
		quitbutton.setForeground(Color.green);
		name.setBounds(50, 50, 70, 20);
		price.setBounds(710, 50, 100, 20);
		price.setForeground(Color.yellow);
		h_number.setBounds(250, 350, 180, 20);
		h_number.setForeground(Color.orange);
		h_text.setBounds(370, 350, 100, 20);
		price_text.setBounds(750, 50, 100, 20);
		name_text.setBounds(120, 50, 100, 20);
		Sex.setBounds(300, 50, 100, 20);
		type.setBounds(540, 50, 100, 20);
		type.setMaximumRowCount(4);
		tips = new JLabel("����д��Ļ�����Ϣ~");
		name.setForeground(Color.YELLOW);
		tips.setBounds(400, 10, 100, 50);
		tips.setForeground(Color.yellow);
		tips.setSize(250, 50);
		ImageIcon image_icon = new ImageIcon("F:/Android project/Android_First/Hotel/src/Hotel/Guess.png");
		image = new JLabel();
		image.setIcon(image_icon);
		this.add(price);
		this.add(quitbutton);
		this.add(okbutton);
		this.add(name);
		this.add(h_number);
		this.add(h_text);
		this.add(name_text);
		this.add(price_text);
		this.add(Sex);
		this.add(tips);
		this.add(type);
		this.add(image);
		// setUndecorated(true); ʹ��ܲ��ɼ�
		this.pack();
		setVisible(true);

		okbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "��ס�ɹ�!  ���ķ������" + h_text.getText(),
						"��ס�ɹ�!  ���ķ������" + h_text.getText(), JOptionPane.INFORMATION_MESSAGE);
				// TODO Auto-generated method stub
				// String sql="insert into
				// guess(type,name,sex,price,H_number,Activity)
				// values("+"'"+type.getSelectedItem()+"'"+","+"'"+name_text.getText().toString()+"'"+","
				// +
				// "'"+Sex.getSelectedItem()+"'"+","+price_text.getText()+","+h_text.getText()+","+"'"+"����ס"+"'"
				// +")";
				String sql = "update guess set type=" + "'" + type.getSelectedItem().toString() + "'" + "," + "name="
						+ "'" + name_text.getText().toString() + "'" + "," + "sex=" + "'" + Sex.getSelectedItem() + "'"
						+ "," + "price=" + price_text.getText() + "," + "Activity=" + "'" + "����ס" + "'"
						+ "where H_number=" + h_text.getText(); /* ; */
				DAO.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "��ס�ɹ�!  ���ķ������" + h_text.getText(), "��ʾ",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		type.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (type.getSelectedItem().toString() == "��ͳ�׷�") {
					price_text.setText("888.0");
				} else if (type.getSelectedItem().toString() == "����󴲷�") {
					price_text.setText("258.0");
				} else if (type.getSelectedItem().toString() == "��׼˫�˷�") {
					price_text.setText("168.0");
				} else if (type.getSelectedItem().toString() == "����˫�˼�") {
					price_text.setText("268.0");
				}

			}
		});
	}
}
