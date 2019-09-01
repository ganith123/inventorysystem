import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setBounds(204, 115, 146, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(204, 159, 146, 20);
		contentPane.add(password);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(99, 115, 82, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(99, 159, 82, 20);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from users where Username='"+username.getText().toString()+"' and Password='"+password.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
				
					while(rs.next()) {
						String userType = rs.getString("user_type");
						System.out.println(userType);
						
						if(userType instanceof String) {
							System.out.println("string");
						}
						else {
							System.out.println("oth");
						}
						
						String type="admin";
						String staff="staff";
						if(type.compareTo(userType)==0) {
							System.out.println(userType);
							dispose();
							
							adminui ad = new adminui();
							ad.setVisible(true);
						}
						else if(staff.compareTo(userType)==0) {
							dispose();
							userui us = new userui();
							us.setVisible(true);
						}
					}
					
//					if (rs.next())
//						JOptionPane.showMessageDialog(null, "Sucessfully Logged");
//					else
//						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
//					con.close();
				}catch(Exception e) {System.out.print(e);}
				
			}
		});
		btnLogin.setBounds(204, 216, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblLogin.setBounds(174, 31, 119, 40);
		contentPane.add(lblLogin);
	}
}
