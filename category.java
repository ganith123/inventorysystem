import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class category extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					category frame = new category();
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
	public category() {
		setTitle("Category");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String id = "";
		String name = "";
		
		String[] columnNames = {"Id", "Name"};
		DefaultTableModel categoryTypes = new DefaultTableModel();
		categoryTypes.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(categoryTypes);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
			Statement stmt=con.createStatement();
			String sql="Select * from categories";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				id = rs.getString("id");
				name = rs.getString("name");
				categoryTypes.addRow(new Object[] {id, name});
			}
		}catch(Exception ex) {
			
		}
		
		JScrollPane pane = new JScrollPane(table); 
		
		pane.setBounds(27, 34, 270, 269);
		contentPane.add(pane);
		//contentPane.add(new JScrollPane(table));
		
		JButton btnNewCategory = new JButton("New Category");
		btnNewCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewCategory.setBounds(336, 34, 170, 29);
		contentPane.add(btnNewCategory);
		
		JButton btnUpdateCategory = new JButton("Update Category");
		btnUpdateCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateCategory.setBounds(336, 94, 170, 29);
		contentPane.add(btnUpdateCategory);
		
		JButton btnDeleteCategory = new JButton("Delete Category");
		btnDeleteCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteCategory.setBounds(336, 156, 170, 29);
		contentPane.add(btnDeleteCategory);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminsup frame = new adminsup();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(417, 280, 89, 23);
		contentPane.add(btnBack);
	}
}
