package be.ephec.interfaceGraphique;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JLabel;

import be.ephec.ApplicationServeur;
import be.ephec.Param;

import be.ephec.socketTPC.reseau.MonServeurTCP;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.InetAddress;

public class JPanelAccueilServeur extends JPanel {
	private ApplicationServeur applicationServeur;
	private JTextField textField;

	public JPanelAccueilServeur(ApplicationServeur applicationServeur) {
		this.applicationServeur = applicationServeur;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JComboBox comboBox = new JComboBox();
		
		InetAddress ia[] = MonServeurTCP.trouveToutesLesIpsDuServeur(); 
		String tabS[] = new String[ia.length];
		for (int i=0;i<tabS.length;i++){
			tabS[i]=ia[i].getHostAddress();
			comboBox.addItem(tabS[i]);
		}
		
		JLabel lblPourInfoVoici = new JLabel("Pour info, voici toutes les ip de votre serveur");
		GridBagConstraints gbc_lblPourInfoVoici = new GridBagConstraints();
		gbc_lblPourInfoVoici.gridwidth = 2;
		gbc_lblPourInfoVoici.insets = new Insets(0, 0, 5, 5);
		gbc_lblPourInfoVoici.gridx = 0;
		gbc_lblPourInfoVoici.gridy = 0;
		add(lblPourInfoVoici, gbc_lblPourInfoVoici);
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		
		add(comboBox, gbc_comboBox);
		
		JLabel lblNumroDePort = new JLabel("Num\u00E9ro de port :");
		GridBagConstraints gbc_lblNumroDePort = new GridBagConstraints();
		gbc_lblNumroDePort.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDePort.anchor = GridBagConstraints.EAST;
		gbc_lblNumroDePort.gridx = 0;
		gbc_lblNumroDePort.gridy = 2;
		add(lblNumroDePort, gbc_lblNumroDePort);
		
		textField = new JTextField();
		textField.setText(Param.NUMPORTDEBASE+"");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnDmarrerLeServeur = new JButton("D\u00E9marrer le serveur");
		
		btnDmarrerLeServeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//MonServeurTCP serveur = new MonServeurTCP();
					applicationServeur.setServeur(new MonServeurTCP(Integer.parseInt(textField.getText()),applicationServeur));
					applicationServeur.getjFrameServeur().setContentPane(new JPanelServeur(applicationServeur));
					applicationServeur.getjFrameServeur().setVisible(true);
					applicationServeur.getjFrameServeur().setTitle("Serveur "+tabS[comboBox.getSelectedIndex()]+":"+applicationServeur.getServeur().getLocalPort());
					applicationServeur.getjFrameServeur().getjTextAreaObjetsRecus().append("\nA communiquer aux clients : \nle serveur écoute sur \n\n"+
							tabS[comboBox.getSelectedIndex()]+" : "+applicationServeur.getServeur().getLocalPort()
					);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		GridBagConstraints gbc_btnDmarrerLeServeur = new GridBagConstraints();
		gbc_btnDmarrerLeServeur.gridx = 1;
		gbc_btnDmarrerLeServeur.gridy = 3;
		add(btnDmarrerLeServeur, gbc_btnDmarrerLeServeur);
	}
}
