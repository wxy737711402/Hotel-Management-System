package Hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Vip extends JFrame {
	JLabel n, s, a, p, tips;
	JTextField tn, ts, ta, tp;
	JButton okbutton;

	Vip() {
		super("Message_Vip");
		// setLayout(new FlowLayout());
		setBounds(750, 200, 400, 400);
		setLayout(null);
		tips = new JLabel("请输入要加入的会员的信息:");
		n = new JLabel("姓名:");
		s = new JLabel("性别:");
		a = new JLabel("i d:");
		p = new JLabel("电话:");
		tn = new JTextField();
		ts = new JTextField();
		ta = new JTextField();
		tp = new JTextField();
		tips.setBounds(20, 20, 200, 20);
		tn.setBounds(90, 50, 100, 20);
		ts.setBounds(90, 80, 100, 20);
		ta.setBounds(90, 110, 100, 20);
		tp.setBounds(90, 140, 100, 20);
		n.setBounds(50, 50, 40, 20);
		s.setBounds(50, 80, 40, 20);
		a.setBounds(50, 110, 40, 20);
		p.setBounds(50, 140, 40, 20);
		okbutton = new JButton("确定");
		okbutton.setBounds(100, 230, 70, 40);
		okbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String sql = "insert into vip(name,id,sex,phone) values(" + "'" + tn.getText().toString() + "'" + ","
						+ ta.getText() + "," + "'" + ts.getText().toString() + "'" + "," + tp.getText() + ")";
				DAO.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "加入会员成功", "提示", JOptionPane.INFORMATION_MESSAGE);
			}

		});
		add(okbutton);
		add(tips);
		add(n);
		add(s);
		add(a);
		add(p);
		add(tn);
		add(ts);
		add(ta);
		add(tp);

		this.setVisible(true);
	}
}
