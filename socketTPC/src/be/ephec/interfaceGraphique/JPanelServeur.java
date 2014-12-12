package be.ephec.interfaceGraphique;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import be.ephec.ApplicationServeur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class JPanelServeur extends JPanel {
	private JTextField txtMessageEnvoyer;
	
	private ApplicationServeur applicationServeur;
	
	public JPanelServeur(ApplicationServeur applicationServeur) {
		this.applicationServeur = applicationServeur;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{199, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		txtMessageEnvoyer = new JTextField();
		txtMessageEnvoyer.setText("Message \u00E0 envoyer \u00E0 un client");
		GridBagConstraints gbc_txtMessageEnvoyer = new GridBagConstraints();
		gbc_txtMessageEnvoyer.insets = new Insets(0, 0, 5, 5);
		gbc_txtMessageEnvoyer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessageEnvoyer.gridx = 0;
		gbc_txtMessageEnvoyer.gridy = 1;
		add(txtMessageEnvoyer, gbc_txtMessageEnvoyer);
		txtMessageEnvoyer.setColumns(10);
		
		applicationServeur.getjFrameServeur().setComboBox(new JComboBox<ElementJcomboBox>());
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"un", "deux", "trois"}));
		applicationServeur.getjFrameServeur().getComboBox().addItem(new ElementJcomboBox("envoyer à tous les clients",0,-1));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		add(applicationServeur.getjFrameServeur().getComboBox(), gbc_comboBox);
		
		JButton JButtonEnvoyer = new JButton("Envoyer");
		JButtonEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("applicationServeur.getjFrameServeur().getComboBox().getSelectedIndex() = "+applicationServeur.getjFrameServeur().getComboBox().getSelectedIndex());
				//System.out.println("on écrit sur le client = "+applicationServeur.getjFrameServeur().getListeNumClient().get(applicationServeur.getjFrameServeur().getComboBox().getSelectedIndex()));
				applicationServeur.getServeur().ecrire(applicationServeur.getjFrameServeur().getListeNumClient().get(applicationServeur.getjFrameServeur().getComboBox().getSelectedIndex()), txtMessageEnvoyer.getText());
			}
		});
		GridBagConstraints gbc_JButtonEnvoyer = new GridBagConstraints();
		gbc_JButtonEnvoyer.insets = new Insets(0, 0, 5, 0);
		gbc_JButtonEnvoyer.anchor = GridBagConstraints.NORTH;
		gbc_JButtonEnvoyer.gridx = 1;
		gbc_JButtonEnvoyer.gridy = 2;
		add(JButtonEnvoyer, gbc_JButtonEnvoyer);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;	
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		applicationServeur.getjFrameServeur().setjTextAreaObjetsRecus(new JTextArea());
		scrollPane.setViewportView(applicationServeur.getjFrameServeur().getjTextAreaObjetsRecus());
		applicationServeur.getjFrameServeur().getjTextAreaObjetsRecus().setEditable(false);
		//textPaneObjetRecu.setText("blablabla\nblablabla\n");
		applicationServeur.getjFrameServeur().getjTextAreaObjetsRecus().setCaretPosition(applicationServeur.getjFrameServeur().getjTextAreaObjetsRecus().getText().length());
		applicationServeur.getjFrameServeur().getjTextAreaObjetsRecus().setText("Messages reçus et console du serveur :");
		

	}

}
