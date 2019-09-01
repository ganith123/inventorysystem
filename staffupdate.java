import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class staffupdate extends JFrame {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	
	
	private JPanel contentPane;
	private JTextField id;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField email;
	private JTextField username;
	private JTextField password;
	private JTextField telephone;
	private JTextField user_type;
	private JTextField added_at;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffupdate frame = new staffupdate();
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
	public staffupdate() {
		setTitle("Staff Update");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(22, 36, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(22, 61, 94, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(22, 86, 94, 14);
		contentPane.add(lblLastName);
		
		JLabel lblTel = new JLabel("Password :");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTel.setBounds(22, 161, 94, 14);
		contentPane.add(lblTel);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(22, 111, 94, 14);
		contentPane.add(lblEmail);
		
		id = new JTextField();
		id.setBounds(126, 35, 175, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		first_name = new JTextField();
		first_name.setColumns(10);
		first_name.setBounds(126, 60, 175, 20);
		contentPane.add(first_name);
		
		last_name = new JTextField();
		last_name.setColumns(10);
		last_name.setBounds(126, 85, 175, 20);
		contentPane.add(last_name);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(126, 110, 175, 20);
		contentPane.add(email);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(126, 135, 175, 20);
		contentPane.add(username);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "INSERT INTO users"
							+"(first_name, last_name, email, username, password, telephone, user_type, added_at)"
							+ " VALUES (?,?,?,?,?,?,?,?)"; 
								
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
							pst = con.prepareStatement(sql);
							pst.setString(1,first_name.getText());
							pst.setString(2,last_name.getText());
							pst.setString(3,email.getText());
							pst.setString(4,username.getText());
							pst.setString(5,password.getText());
							pst.setString(6,telephone.getText());
							pst.setString(7,user_type.getText());
							pst.setString(8,added_at.getText());
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Inserted Successfully");
							
								
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setBounds(122, 278, 100, 23);
		contentPane.add(btnInsert);
		
		JButton btnEdit = new JButton("Update");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "UPDATE users SET first_name=?, last_name=?,email=?, username=?, password=?, telephone=?, user_type=?, added_at=? WHERE id=?"; 
								
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
							pst = con.prepareStatement(sql);
							pst.setString(9,id.getText());
							pst.setString(1,first_name.getText());
							pst.setString(2,last_name.getText());
							pst.setString(3,email.getText());
							pst.setString(4,username.getText());
							pst.setString(5,password.getText());
							pst.setString(6,telephone.getText());
							pst.setString(7,user_type.getText());
							pst.setString(8,added_at.getText());
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Updated Successfully");
							
								
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
			public void showTableData() {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
					String sql = "SELECT * FROM users";
					pst = con.prepareStatement(sql);
					rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
			}
			
			}});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(325, 278, 100, 23);
		contentPane.add(btnEdit);
		
		JButton btnRemove = new JButton("Delete");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sql = "DELETE FROM users WHERE id=?";
								
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
							pst = con.prepareStatement(sql);
							pst.setString(1,id.getText());
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Delete Successfully");
							
								
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
			
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemove.setBounds(513, 278, 100, 23);
		contentPane.add(btnRemove);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminui frame = new adminui();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(715, 278, 100, 23);
		contentPane.add(btnBack);
		
		password = new JTextField();
		password.setBounds(126, 160, 175, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(22, 136, 94, 14);
		contentPane.add(lblUsername);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(126, 185, 175, 20);
		contentPane.add(telephone);
		
		user_type = new JTextField();
		user_type.setColumns(10);
		user_type.setBounds(126, 209, 175, 20);
		contentPane.add(user_type);
		
		JLabel lblTel_1 = new JLabel("Tel :");
		lblTel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTel_1.setBounds(22, 186, 94, 14);
		contentPane.add(lblTel_1);
		
		JLabel lblType = new JLabel("User Type :");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblType.setBounds(22, 207, 94, 20);
		contentPane.add(lblType);
		
		JLabel lblAddedDate = new JLabel("Added Date :");
		lblAddedDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddedDate.setBounds(22, 238, 94, 14);
		contentPane.add(lblAddedDate);
		
		added_at = new JTextField();
		added_at.setColumns(10);
		added_at.setBounds(126, 237, 175, 20);
		contentPane.add(added_at);
		
		String id = "";
		String first_name = "";
		String last_name = "";
		String email = "";
		String username = "";
		String password = "";
		String telephone = "";
		String user_type = "";
		String added_at = "";
		
		String[] columnNames = {"ID", "First Name", "Last Name ", "Email", "Username", "Password", "Telephone", "User Type ", "Added Time"};
		DefaultTableModel userTypes = new DefaultTableModel();
		userTypes.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(userTypes);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
			Statement stmt=con.createStatement();
			String sql="Select * from users";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				id = rs.getString("id");
				first_name = rs.getString("first_name");
				last_name = rs.getString("last_name");
				email = rs.getString("email");
				username = rs.getString("username");
				password = rs.getString("password");
				telephone = rs.getString("telephone");
				user_type = rs.getString("user_type");
				added_at = rs.getString("added_at");
				userTypes.addRow(new Object[] {id, first_name, last_name, email, username, password, telephone, user_type, added_at });
			}
		}catch(Exception ex) {
			
		}
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 36, 478, 225);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
	}	
}
