import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewstocks extends JFrame {

	private JPanel contentPane;
	private JTable tblPhoneCases;
	private JTable tblWoodTypes;
	private JTable tblRawMaterials;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewstocks frame = new viewstocks();
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
	public viewstocks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String phoneCases = "Phone Cases";
		int qty_available;
		
		String[] phoneCasesColumnNames = {"Phone Cases", "Quantity Available"};
		DefaultTableModel phoneCasesModel = new DefaultTableModel();
		phoneCasesModel.setColumnIdentifiers(phoneCasesColumnNames);
		tblPhoneCases = new JTable();
		tblPhoneCases.setModel(phoneCasesModel);
		tblPhoneCases.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblPhoneCases.setFillsViewportHeight(true);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
			Statement stmt=con.createStatement();
			String sql="Select * from items where category_id = 1";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				phoneCases = rs.getString("name");
				qty_available = rs.getInt("qty_available");
				phoneCasesModel.addRow(new Object[] {phoneCases, qty_available});
			}
		}catch(Exception e) {
			
		}
		JScrollPane pane = new JScrollPane(tblPhoneCases);
		pane.setBounds(10, 11, 294, 320);
		contentPane.add(pane);
		
		String woodType = "Wood Type";
		int qty_available2;
		String[] woodTypeColumnNames = {"Wood Type", "Quantity Available"};
		DefaultTableModel woodTypeModel = new DefaultTableModel();
		woodTypeModel.setColumnIdentifiers(woodTypeColumnNames);
		tblWoodTypes = new JTable();
		tblWoodTypes.setModel(woodTypeModel);
		tblWoodTypes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblWoodTypes.setFillsViewportHeight(true);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
			Statement stmt=con.createStatement();
			String sql="Select * from items where category_id = 2";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				woodType = rs.getString("name");
				qty_available2 = rs.getInt("qty_available");
				woodTypeModel.addRow(new Object[] {woodType, qty_available2});
				}
		}catch(Exception e) {
			
		}
		JScrollPane pane2 = new JScrollPane(tblWoodTypes);
		pane2.setBounds(329, 11, 236, 156);
		contentPane.add(pane2);
		
		String rawMaterials = "Raw Materials";
		int qty_available3;
		String[] rawMaterialColumnNames = {"Raw Meterials","Quatity Available"};
		DefaultTableModel rawMaterialModel = new DefaultTableModel();
		rawMaterialModel.setColumnIdentifiers(rawMaterialColumnNames);
		tblRawMaterials = new JTable();
		tblRawMaterials.setModel(rawMaterialModel);
		tblRawMaterials.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblRawMaterials.setFillsViewportHeight(true);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ganith1.1","root","");
			Statement stmt=con.createStatement();
			String sql="Select * from items where category_id = 3";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				rawMaterials = rs.getString("name");
				qty_available3 = rs.getInt("qty_available");
				rawMaterialModel.addRow(new Object[] {rawMaterials, qty_available3});
				}
		}catch(Exception e) {
			
		}
		JScrollPane pane3 = new JScrollPane(tblRawMaterials);
		pane3.setBounds(329, 190, 236, 141);
		contentPane.add(pane3);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminui frame = new adminui();
				frame.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(476, 364, 89, 23);
		contentPane.add(btnBack);
	}
}
