import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class edititem extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edititem frame = new edititem();
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
	public edititem() {
		setTitle(" Edit Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategory.setBounds(36, 66, 80, 26);
		contentPane.add(lblCategory);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(36, 103, 80, 26);
		contentPane.add(lblName);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(36, 140, 80, 26);
		contentPane.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(36, 177, 80, 26);
		contentPane.add(lblPrice);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(36, 214, 103, 26);
		contentPane.add(lblDescription);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(136, 182, 200, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(136, 219, 200, 80);
		contentPane.add(textField_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 145, 200, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 108, 200, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(136, 71, 200, 20);
		contentPane.add(textField_2);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBounds(36, 357, 89, 23);
		contentPane.add(btnCancel);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmit.setBounds(247, 359, 89, 23);
		contentPane.add(btnSubmit);
	}

}
