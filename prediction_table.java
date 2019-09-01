import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class prediction_table extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prediction_table frame = new prediction_table();
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
	public prediction_table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		String id = "";
		String month = "";
		String pc_type = "";
		String product_cost = "";
		String selling_price = "";
		String quantity = "";
		String salary = "";
		String rent = "";
		String transport = "";
		String material_cost = "";
		String other_cost = "";
		String added_at = "";
		
		String[] columnNames = {"ID", "Month", "P/C Type", "Product Cost", "Selling Price", "Quantity", "Salary", "Rent", "Transport", "Maretial Cost", "Other Cost", "Added Time"};
		DefaultTableModel itemTypes = new DefaultTableModel();
		itemTypes.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(itemTypes);
		//JScrollPane scroll = new JScrollPane(table);
		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
			Statement stmt=con.createStatement();
			String sql="Select * from predictions";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				id = rs.getString("id");
			    month = rs.getString("month");
				pc_type =  rs.getString("pc_type");
				product_cost =  rs.getString("product_cost");
				selling_price =  rs.getString("selling_price");
				quantity =  rs.getString("quantity");
				salary =  rs.getString("salary");
				rent =  rs.getString("rent");
				transport =  rs.getString("transport");
				material_cost =  rs.getString("material_cost");
				other_cost =  rs.getString("other_cost");
				added_at =  rs.getString("added_at");
				itemTypes.addRow(new Object[] {id, month, pc_type, product_cost, selling_price, quantity, salary, rent, transport, material_cost, other_cost, added_at });
			}
		}catch(Exception e) {
			
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 744, 233);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminsup frame = new adminsup();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 279, 154, 34);
		contentPane.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(600, 279, 154, 34);
		contentPane.add(btnSubmit);
	}
}
