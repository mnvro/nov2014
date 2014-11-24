package be.ephec.nov21_2014;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MaFenetre2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIp;
	private JTextField textFieldMasque;
	private JLabel lblAdresseRseau; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaFenetre2 frame = new MaFenetre2();
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
	public MaFenetre2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblAdresseIp = new JLabel("Adresse IP : ");
		GridBagConstraints gbc_lblAdresseIp = new GridBagConstraints();
		gbc_lblAdresseIp.anchor = GridBagConstraints.EAST;
		gbc_lblAdresseIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseIp.gridx = 3;
		gbc_lblAdresseIp.gridy = 2;
		panel.add(lblAdresseIp, gbc_lblAdresseIp);
		
		textFieldIp = new JTextField();
		textFieldIp.setText("192.168.0.1");
		GridBagConstraints gbc_textFieldIp = new GridBagConstraints();
		gbc_textFieldIp.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIp.gridx = 4;
		gbc_textFieldIp.gridy = 2;
		panel.add(textFieldIp, gbc_textFieldIp);
		textFieldIp.setColumns(10);
		
		JLabel lblMasque = new JLabel("Masque :");
		GridBagConstraints gbc_lblMasque = new GridBagConstraints();
		gbc_lblMasque.anchor = GridBagConstraints.EAST;
		gbc_lblMasque.insets = new Insets(0, 0, 5, 5);
		gbc_lblMasque.gridx = 3;
		gbc_lblMasque.gridy = 3;
		panel.add(lblMasque, gbc_lblMasque);
		
		textFieldMasque = new JTextField();
		textFieldMasque.setText("255.255.255.0");
		GridBagConstraints gbc_textFieldMasque = new GridBagConstraints();
		gbc_textFieldMasque.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMasque.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMasque.gridx = 4;
		gbc_textFieldMasque.gridy = 3;
		panel.add(textFieldMasque, gbc_textFieldMasque);
		textFieldMasque.setColumns(10);
		
		lblAdresseRseau = new JLabel("Adresse r\u00E9seau :");
		GridBagConstraints gbc_lblAdresseRseau = new GridBagConstraints();
		gbc_lblAdresseRseau.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseRseau.gridx = 3;
		gbc_lblAdresseRseau.gridy = 4;
		panel.add(lblAdresseRseau, gbc_lblAdresseRseau);
		
		JLabel label = new JLabel("192.168.0.0");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 4;
		gbc_label.gridy = 4;
		panel.add(label, gbc_label);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldIp.setText("");
				textFieldMasque.setText("");
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 6;
		panel.add(btnCancel, gbc_btnCancel);
		
		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridx = 4;
		gbc_btnOk.gridy = 6;
		panel.add(btnOk, gbc_btnOk);
	}

}
