import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class userui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userui frame = new userui();
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
	public userui() {
		setTitle("User Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStockUpdate = new JButton("Stock Update");
		btnStockUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStockUpdate.setBounds(51, 144, 222, 23);
		contentPane.add(btnStockUpdate);
		
		JButton btnMachineryCheckReport = new JButton("Machinery Check Report");
		btnMachineryCheckReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMachineryCheckReport.setBounds(51, 209, 222, 23);
		contentPane.add(btnMachineryCheckReport);
	}
}
