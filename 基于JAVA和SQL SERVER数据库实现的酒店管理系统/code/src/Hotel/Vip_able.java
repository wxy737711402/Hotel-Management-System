package Hotel;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Vip_able extends JFrame {

	Vip_able() throws SQLException {
		JPanel jp = new JPanel();// 主面板
		jp.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();// 上面版
		JPanel jp2 = new JPanel();// 中面板
		JPanel jp3 = new JPanel();// 下面板
		
		JLabel tips=new JLabel("这是当前住房状态");
		
		String sql = "select * from guess ";
		ResultSet rs = DAO.executeQuery(sql);
		
		DefaultTableModel dt=new DefaultTableModel();
		JTable table=new JTable(dt);
		ResultSetMetaData rsmd=rs.getMetaData();
		int numberOfColums=rsmd.getColumnCount();
		int b=1;
		while(b<=numberOfColums)
		{
			dt.addColumn(rsmd.getColumnName(b));
			b++;
		}
		Vector newRow;
		
		while(rs.next())
		{
			newRow=new Vector();
			int i=1;
			while(i<=numberOfColums){
				newRow.addElement(rs.getString(i).trim());
				i++;
			}
			dt.addRow(newRow);
		}
		
		/*String[] title = { "房型", "状态", "房号", "价格" };

		Object[][] data = { { "1", "hlp", "hcit", "13811112222" }, { "1", "hlp", "hcit", "13811112222" },
				{ "1", "hlp", "hcit", "13811112222" }, { "1", "hlp", "hcit", "13811112222" },
				{ "1", "hlp", "hcit", "13811112222" }, { "1", "hlp", "hcit", "13811112222" },
				{ "1", "hlp", "hcit", "13811112222" }, { "1", "hlp", "hcit", "13811112222" },
				{ "1", "hlp", "hcit", "13811112222" }, { "1", "hlp", "hcit", "13811112222" },
				{ "1", "hlp", "hcit", "13811112222" }, { "1", "hlp", "hcit", "13811112222" },
				{ "1", "hlp", "hcit", "13811112222" }, { "1", "hlp", "hcit", "13811112222" },
				{ "1", "hlp", "hcit", "13811112222" }, { "1", "hlp", "hcit", "13811112222" },
				{ "1", "hlp", "hcit", "13811112222" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" } };
		JTable table = new JTable(data, title);
		JScrollPane scrollPane = new JScrollPane(table);// 使表头显示
		int i = 0;
		while (rs.next()) {
			table.setValueAt(rs.getString("type").trim(), i, 0);
			table.setValueAt(rs.getString("Activity"), i, 1);
			table.setValueAt(rs.getInt("H_number"), i, 2);
			table.setValueAt(rs.getString("price").trim(), i, 3);
			i++;
		}
*/
		/*
		 * ArrayList<Map<String, String>> stuList = new
		 * ArrayList<Map<String,String>>(); Map<String,String> map= null; while
		 * (rs.next()) { map = new HashMap<String,String>(); map.put("type",
		 * rs.getString(1)); map.put("Acivity", rs.getString(2));
		 * map.put("H_number", rs.getString(3)); map.put("price",
		 * rs.getString(4)); stuList.add(map); }
		 * 
		 * for (int i1 = 0; i1 < data.length; i1++) { for (int j = 0; j <
		 * data.length-1; j++) { table.setValueAt(stuList.get(i1).get("type"),
		 * i1, j); } }
		 */
		
		jp1.add(tips);
		jp2.add(table);
		JScrollPane scrollPane = new JScrollPane(table);// 使表头显示
		jp2.add(scrollPane);
		jp.add(jp1, BorderLayout.NORTH);
		jp.add(jp2, BorderLayout.CENTER);
		this.add(jp);
		this.pack(); // 是调整外部容器大小的方法， 比如你外部容器FollowLayout的布局装了几个按钮，
						// 在使用pack（）之后会使这个外部容器自动调整成刚好装下这几个按钮的大小的尺寸。
		this.setLocation(50, 50);
		this.setVisible(true);
	}

}
