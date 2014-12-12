package be.ephec.interfaceGraphique;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JLabel;

import be.ephec.ApplicationClient;
import be.ephec.Param;
import be.ephec.socketTPC.reseau.MonClientTCP;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class JPanelAccueilClient extends JPanel {
	private ApplicationClient applicationClient;
	private JTextField jTxtIpDuServeur;
	private JTextField jTxtNumroDePort;

	/**
	 * Create the panel.
	 */
	public JPanelAccueilClient(ApplicationClient applicationClient) {
		this.applicationClient = applicationClient;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblIpDuServeur = new JLabel("Ip du serveur : ");
		GridBagConstraints gbc_lblIpDuServeur = new GridBagConstraints();
		gbc_lblIpDuServeur.anchor = GridBagConstraints.EAST;
		gbc_lblIpDuServeur.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpDuServeur.gridx = 2;
		gbc_lblIpDuServeur.gridy = 1;
		add(lblIpDuServeur, gbc_lblIpDuServeur);
		
		jTxtIpDuServeur = new JTextField();
		jTxtIpDuServeur.setText("127.0.0.1");
		GridBagConstraints gbc_txtIpDuServeur = new GridBagConstraints();
		gbc_txtIpDuServeur.insets = new Insets(0, 0, 5, 0);
		gbc_txtIpDuServeur.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIpDuServeur.gridx = 3;
		gbc_txtIpDuServeur.gridy = 1;
		add(jTxtIpDuServeur, gbc_txtIpDuServeur);
		jTxtIpDuServeur.setColumns(10);
		
		JLabel lblNumroDePort = new JLabel("Num\u00E9ro de port :");
		GridBagConstraints gbc_lblNumroDePort = new GridBagConstraints();
		gbc_lblNumroDePort.anchor = GridBagConstraints.EAST;
		gbc_lblNumroDePort.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDePort.gridx = 2;
		gbc_lblNumroDePort.gridy = 2;
		add(lblNumroDePort, gbc_lblNumroDePort);
		
		jTxtNumroDePort = new JTextField();
		jTxtNumroDePort.setText(Param.NUMPORTDEBASE+""); // le +"" permet de changer l'entier en chaîne de caractères
		GridBagConstraints gbc_txtNumroDePort = new GridBagConstraints();
		gbc_txtNumroDePort.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumroDePort.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumroDePort.gridx = 3;
		gbc_txtNumroDePort.gridy = 2;
		add(jTxtNumroDePort, gbc_txtNumroDePort);
		jTxtNumroDePort.setColumns(10);
		
		JButton btnSeConnecterAu = new JButton("Se connecter au serveur");
		btnSeConnecterAu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					applicationClient.setClient(new MonClientTCP(Integer.parseInt(jTxtNumroDePort.getText()),applicationClient));
					
					applicationClient.getjFrameClient().setContentPane(new JPanelClient(applicationClient));
					applicationClient.getjFrameClient().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnSeConnecterAu = new GridBagConstraints();
		gbc_btnSeConnecterAu.gridx = 3;
		gbc_btnSeConnecterAu.gridy = 3;
		add(btnSeConnecterAu, gbc_btnSeConnecterAu);

	}

}
