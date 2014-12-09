package be.ephec.interfaceGraphique;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JTextArea;

import be.ephec.ApplicationClient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelClient extends JPanel {
	private JTextField txtMessageEnvoyer;
	private ApplicationClient applicationClient;
	//private JTextArea jTextAreaObjetsRecus;

	/*public JTextArea getjTextAreaObjetsRecus() {
		return jTextAreaObjetsRecus;
	}

	public void setjTextAreaObjetsRecus(JTextArea jTextAreaObjetsRecus) {
		this.jTextAreaObjetsRecus = jTextAreaObjetsRecus;
	}*/


	public JPanelClient(ApplicationClient applicationClient) {
		this.applicationClient = applicationClient;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtMessageEnvoyer = new JTextField();
		txtMessageEnvoyer.setText("Message \u00E0 envoyer au serveur");
		GridBagConstraints gbc_txtMessageEnvoyer = new GridBagConstraints();
		gbc_txtMessageEnvoyer.insets = new Insets(0, 0, 5, 5);
		gbc_txtMessageEnvoyer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessageEnvoyer.gridx = 5;
		gbc_txtMessageEnvoyer.gridy = 2;
		add(txtMessageEnvoyer, gbc_txtMessageEnvoyer);
		txtMessageEnvoyer.setColumns(10);
		
		JButton btnEnvoyerMessageAu = new JButton("Envoyer message au serveur");
		btnEnvoyerMessageAu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				applicationClient.getClient().ecrireMessage(txtMessageEnvoyer.getText());
			}
		});
		GridBagConstraints gbc_btnEnvoyerMessageAu = new GridBagConstraints();
		gbc_btnEnvoyerMessageAu.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnvoyerMessageAu.gridx = 6;
		gbc_btnEnvoyerMessageAu.gridy = 2;
		add(btnEnvoyerMessageAu, gbc_btnEnvoyerMessageAu);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		
		
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		applicationClient.getjFrameClient().setjTextAreaObjetsRecus(new JTextArea());
		scrollPane.setViewportView(applicationClient.getjFrameClient().getjTextAreaObjetsRecus());
		
		
		applicationClient.getjFrameClient().getjTextAreaObjetsRecus().setText("Voici les les messages re\u00E7us par le client");
		
		applicationClient.getjFrameClient().getjTextAreaObjetsRecus().setCaretPosition(applicationClient.getjFrameClient().getjTextAreaObjetsRecus().getText().length());

	}

}
