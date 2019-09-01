import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class viewreports extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewreports frame = new viewreports();
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
	public viewreports() {
		setTitle("View Reports");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMonthlyReports = new JButton("Monthly Reports");
		btnMonthlyReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMonthlyReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMonthlyReports.setBounds(32, 96, 221, 39);
		contentPane.add(btnMonthlyReports);
		
		JButton btnMachineryCheckReports = new JButton("Machinery Check Reports");
		btnMachineryCheckReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMachineryCheckReports.setBounds(32, 181, 221, 39);
		contentPane.add(btnMachineryCheckReports);
	}

}
