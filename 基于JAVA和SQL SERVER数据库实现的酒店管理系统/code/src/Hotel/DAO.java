package Hotel;

//���ݷ��ʲ�

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
	static String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
	static String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Hotel";// ����Դע��IP��ַ�Ͷ˿ںţ����ݿ����֣�����

	// ������

	public static void main(String args[]) {

		try {
			Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		}
		System.out.println("���ݿ������ɹ�");

	}

	// ���·���

	static int executeUpdate(String sql) {
		try {
			String user = "Hotelmaster";// ���Լ��������û����ֺ����룡����������������������
			String password = "123456";
			Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
			System.out.println("�������ݿ�ɹ�");
			Statement stmt = con.createStatement();// ����SQL������� //������
			System.out.println("��ʼɾ������");
			// ���·���
			System.out.println("��ʼ��������");
			stmt.executeUpdate(sql);
			System.out.println("���ݲ���ɹ�!");
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����*/

		}

		catch (SQLException e) {
			e.printStackTrace(); //
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return 0;
	}

	// ��ѯ����

	static ResultSet executeQuery(String sql) {

		try {
			String user = "Hotelmaster";// ���Լ��������û����ֺ����룡����������������������
			String password = "123456";
			Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);// ����SQL�������
																												// //������
			System.out.println("��ѯ");
			System.out.println("��Ҫ���ҵ���Ϣ��:");

			ResultSet rs = stmt.executeQuery(sql);// ����SQL����ѯ�����(����)

			while (rs.next()) {
				System.out.println("��ȡ���");
				return rs;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;

	}

	// ��ѯ����2

	static ResultSet executeQuery2(String sql) {

		try {
			String user = "Hotelmaster";// ���Լ��������û����ֺ����룡����������������������
			String password = "123456";
			Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);// ����SQL�������
																												// //������
			System.out.println("��ѯ");
			System.out.println("��Ҫ���ҵ���Ϣ��:");

			// String str = "select * from House";
			ResultSet rs = stmt.executeQuery(sql);// ����SQL����ѯ�����(����)

			while (rs.next()) {

				System.out.println(rs.getString("Type") + rs.getInt("H_number") + rs.getString("Activity"));
				System.out.println("��ȡ���"); // �ر�����

				return rs;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;

	}

}

// �޸ķ���

/*
 * String sql="update student set sex='��'"+"where sname='����'";
 * stmt.executeUpdate(sql); System.out.println("���ĳɹ�"); stmt.close();
 * con.close();
 */

// ɾ������

/*
 * String sql="delete from student where sname='Τ����'"; stmt.executeUpdate(sql);
 * System.out.println("ɾ���ɹ�"); stmt.close(); con.close();
 */
