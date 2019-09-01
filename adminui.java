import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminui frame = new adminui();
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
	public adminui() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalesUpdate = new JButton("Sales Update");
		btnSalesUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				adminsup ad = new adminsup();
				ad.setVisible(true);
			}
		});
		btnSalesUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalesUpdate.setBounds(103, 48, 122, 33);
		contentPane.add(btnSalesUpdate);
		
		JButton btnViewStocks = new JButton("View Stocks");
		btnViewStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				viewstocks ad = new viewstocks();
				ad.setVisible(true);
			}
		});
		btnViewStocks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewStocks.setBounds(103, 114, 122, 33);
		contentPane.add(btnViewStocks);
		
		JButton btnViewReports = new JButton("View Reports");
		btnViewReports.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewReports.setBounds(103, 179, 122, 33);
		contentPane.add(btnViewReports);
		
		JButton btnUserUpdate = new JButton("User Update");
		btnUserUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffupdate frame = new staffupdate();
				frame.setVisible(true);
				dispose();
			}
		});
		btnUserUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUserUpdate.setBounds(103, 246, 122, 33);
		contentPane.add(btnUserUpdate);
		
		JButton btnPredictions = new JButton("Predictions");
		btnPredictions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPredictions.setBounds(103, 311, 122, 33);
		contentPane.add(btnPredictions);
	}
}
