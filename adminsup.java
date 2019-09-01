import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class adminsup extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldSearch;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminsup frame = new adminsup();
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
	public adminsup() {
		setTitle("Admin Stock Update Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEditItem = new JButton("Edit Item");
		btnEditItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditItem.setBounds(39, 52, 191, 35);
		contentPane.add(btnEditItem);
		
		JButton btnRemoveItem = new JButton("Remove Item");
		btnRemoveItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveItem.setBounds(39, 108, 191, 35);
		contentPane.add(btnRemoveItem);
		
		JButton btnAddNewItem = new JButton("Add New Item");
		btnAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddNewItem.setBounds(39, 165, 191, 35);
		contentPane.add(btnAddNewItem);
		
		JButton btnCategory = new JButton("Category");
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				category ct = new category();
				ct.setVisible(true);
				
			}
		});
		btnCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCategory.setBounds(39, 227, 191, 35);
		contentPane.add(btnCategory);
		
		String id = "";
		String name = "";
		String description = "";
		String category_id = "";
		String unit_price = "";
		String qty_available = "";
		String qty_sold = "";
		String income = "";
		
		String[] columnNames = {"Id", "Name", "Description", "Category", "Unit Price", "Quantity Available", "Qantity Sold", "Income"};
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
			String sql="Select * from items";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				id = rs.getString("id");
				name = rs.getString("name");
				description = rs.getString("description");
				category_id = rs.getString("category_id");
				unit_price = rs.getString("unit_price");
				qty_available = rs.getString("qty_available");
				qty_sold = rs.getString("qty_sold");
				income = rs.getString("income");
				itemTypes.addRow(new Object[] {id, name, description, category_id, unit_price, qty_available, qty_sold, income});
			}
		}catch(Exception e) {
			
		}
		
		
		JScrollPane pane = new JScrollPane(table); 
		
		pane.setBounds(257, 52, 590, 318);
		contentPane.add(pane);
		//contentPane.add(new JScrollPane(table));
		
		
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
				Statement stmt=con.createStatement();
				String sql="Select * from items";
				ResultSet rs=stmt.executeQuery(sql);
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch (Exception e) {
					
				}
				
			}
		}
				
		);
		textFieldSearch.setBounds(316, 21, 531, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch.setBounds(257, 24, 67, 14);
		contentPane.add(lblSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminui frame = new adminui();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(758, 397, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnPredictionData = new JButton("Prediction Data");
		btnPredictionData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				prediction_table frame = new prediction_table();
				frame.setVisible(true);
			}
		});
		btnPredictionData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPredictionData.setBounds(39, 335, 191, 35);
		contentPane.add(btnPredictionData);
		

	}
}
