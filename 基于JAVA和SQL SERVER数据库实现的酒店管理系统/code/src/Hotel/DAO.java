package Hotel;

//数据访问层

import java.util.*;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DAO {
	static String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
	static String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Hotel";// 数据源注意IP地址和端口号，数据库名字！！！

	// 主函数

	public static void main(String args[]) {

		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("数据库驱动成功");

	}

	// 更新方法

	static int executeUpdate(String sql) {
		try {
			String user = "Hotelmaster";// 你自己创建的用户名字和密码！！！！！！！！！！！！
			String password = "123456";
			Connection con = DriverManager.getConnection(connectDB, user, password);// 连接数据库对象
			System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();// 创建SQL命令对象 //创建表
			System.out.println("开始删除数据");
			// 更新方法
			System.out.println("开始插入数据");
			stmt.executeUpdate(sql);
			System.out.println("数据插入成功!");
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接*/

		}

		catch (SQLException e) {
			e.printStackTrace(); //
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return 0;
	}

	// 查询方法

	static ResultSet executeQuery(String sql) {

		try {
			String user = "Hotelmaster";// 你自己创建的用户名字和密码！！！！！！！！！！！！
			String password = "123456";
			Connection con = DriverManager.getConnection(connectDB, user, password);// 连接数据库对象
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);// 创建SQL命令对象
																												// //创建表
			System.out.println("查询");
			System.out.println("您要查找的信息是:");

			ResultSet rs = stmt.executeQuery(sql);// 返回SQL语句查询结果集(集合)

			while (rs.next()) {
				System.out.println("读取完毕");
				return rs;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;

	}

	// 查询方法2

	static ResultSet executeQuery2(String sql) {

		try {
			String user = "Hotelmaster";// 你自己创建的用户名字和密码！！！！！！！！！！！！
			String password = "123456";
			Connection con = DriverManager.getConnection(connectDB, user, password);// 连接数据库对象
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);// 创建SQL命令对象
																												// //创建表
			System.out.println("查询");
			System.out.println("您要查找的信息是:");

			// String str = "select * from House";
			ResultSet rs = stmt.executeQuery(sql);// 返回SQL语句查询结果集(集合)

			while (rs.next()) {

				System.out.println(rs.getString("Type") + rs.getInt("H_number") + rs.getString("Activity"));
				System.out.println("读取完毕"); // 关闭连接

				return rs;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;

	}

}

// 修改方法

/*
 * String sql="update student set sex='男'"+"where sname='宋玉'";
 * stmt.executeUpdate(sql); System.out.println("更改成功"); stmt.close();
 * con.close();
 */

// 删除方法

/*
 * String sql="delete from student where sname='韦冬艳'"; stmt.executeUpdate(sql);
 * System.out.println("删除成功"); stmt.close(); con.close();
 */
