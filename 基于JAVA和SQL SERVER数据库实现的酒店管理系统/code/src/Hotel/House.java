package Hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class House extends JFrame {

	private JTextArea show;
	private JLabel tips,type,ac,h,p;
	
	House() throws SQLException {
		super("��ס��Ϣ");
		JPanel main_jpanel = new JPanel(new BorderLayout());
		JPanel top_jpanel = new JPanel(); // �����
	//	main_jpanel.setBounds(500, 300, 800, 600);
	//	top_jpanel.setLayout(null);
		top_jpanel.setSize(200, 200);
		top_jpanel.setBackground(Color.GREEN);
		JPanel m_jpanel = new JPanel(new FlowLayout());
		/*FlowLayout flowlayout=new FlowLayout();
		flowlayout.setHgap(100);
		flowlayout.setVgap(50);*/
		JPanel f_jpanel = new JPanel();
		f_jpanel.setLayout(null);
		JLabel type=new JLabel("����:");
		JLabel ac=new JLabel("״̬:");
		JLabel h=new JLabel("����:");
		JLabel p=new JLabel("�۸�:");
		tips = new JLabel("���ǵ�ǰ����ס��Ϣ");
		show=new JTextArea();
		type.setBounds(105, 120, 100, 100);
		ac.setBounds(275,120,100,100);
		h.setBounds(365,120,100,100);
		p.setBounds(445, 120, 100, 100);
		m_jpanel.add(show);
		m_jpanel.add(new JScrollPane(show));
		String sql="select * from guess";
	    ResultSet rs=DAO.executeQuery2(sql);
	    while(rs.next()) {
	    	show.append(rs.getString("Type")+"\t"+rs.getInt("H_number")+"\t"+rs.getString("Activity")+"\n");
	    }
		top_jpanel.add(tips);
	
		f_jpanel.add(p);
		main_jpanel.add(f_jpanel,BorderLayout.CENTER);
		main_jpanel.add(top_jpanel, BorderLayout.NORTH);
		main_jpanel.add(m_jpanel, BorderLayout.SOUTH);	
		this.add(main_jpanel);
		setBounds(550, 200, 600, 600);
	//	this.pack();
		this.setLocation(250, 250);
		this.setVisible(true);
	}
	
	
	
}

