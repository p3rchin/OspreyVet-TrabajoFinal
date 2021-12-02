package co.edu.unbosque.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AddPetPanel extends JPanel {

	private JPanel panelImageRegisterPet;
	private JLabel labelTitle, labelImageRegisterPet, labelName, labelSpecie, labelRace, labelColor, labelAge;
	private JTextField textFieldName;
	private JComboBox comboBoxSpecie, comboBoxRace, comboBoxColor;
	private JDateChooser dateBird;
	private JButton buttonRegisterPet;

	/**
	 * Create the panel.
	 */
	public AddPetPanel() {

		setSize(561, 421);
		setBackground(new Color(71, 120, 197));
		setLayout(null);
		setVisible(false);

		labelTitle = new JLabel("Registrar una mascota");
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		labelTitle.setBounds(179, 11, 231, 57);
		add(labelTitle);

		panelImageRegisterPet = new JPanel();
		panelImageRegisterPet.setBounds(238, 79, 301, 264);
		add(panelImageRegisterPet);
		panelImageRegisterPet.setLayout(null);

		labelImageRegisterPet = new JLabel("");
		labelImageRegisterPet
				.setIcon(new ImageIcon(AddPetPanel.class.getResource("/images/imagenRegistrarMascota.jpg")));
		labelImageRegisterPet.setBounds(0, 0, 301, 264);
		panelImageRegisterPet.add(labelImageRegisterPet);

		labelName = new JLabel("Nombre");
		labelName.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelName.setBounds(26, 54, 124, 30);
		add(labelName);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		textFieldName.setBounds(26, 80, 188, 20);
		add(textFieldName);
		textFieldName.setColumns(10);

		labelSpecie = new JLabel("Especie");
		labelSpecie.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelSpecie.setBounds(26, 111, 124, 30);
		add(labelSpecie);

		comboBoxSpecie = new JComboBox();
		comboBoxSpecie.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		comboBoxSpecie.addItem("Seleccione");
		comboBoxSpecie.setBounds(26, 137, 188, 22);
		add(comboBoxSpecie);

		labelRace = new JLabel("Raza");
		labelRace.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelRace.setBounds(26, 170, 124, 30);
		add(labelRace);

		comboBoxRace = new JComboBox();
		comboBoxRace.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		comboBoxRace.addItem("Seleccione");
		comboBoxRace.setBounds(26, 197, 188, 22);
		comboBoxRace.addActionListener(comboBoxColor);
		add(comboBoxRace);

		labelColor = new JLabel("Color");
		labelColor.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelColor.setBounds(26, 227, 124, 30);
		add(labelColor);

		comboBoxColor = new JComboBox();
		comboBoxColor.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		comboBoxColor.addItem("Seleccione");
		comboBoxColor.setBounds(26, 252, 188, 22);
		add(comboBoxColor);

		JLabel labelAge = new JLabel("A\u00F1o de nacimiento");
		labelAge.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelAge.setBounds(26, 285, 156, 30);
		add(labelAge);

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date dateN = new Date();
		dateBird = new JDateChooser(dateN, "yyyy/MM/dd");
		dateBird.setMaxSelectableDate(dateN);
		dateBird.setBounds(26, 313, 188, 30);
		add(dateBird);

		buttonRegisterPet = new JButton("Registrar");
		buttonRegisterPet.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonRegisterPet.setForeground(UIManager.getColor("Button.foreground"));
		buttonRegisterPet.setFont(new Font("Yu Gothic", Font.ITALIC, 12));
		buttonRegisterPet.setBackground(new Color(75, 0, 130));
		buttonRegisterPet.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonRegisterPet.setActionCommand("REGISTRARMASCOTA");
		buttonRegisterPet.setBounds(317, 369, 148, 30);
		add(buttonRegisterPet);

	}

	public void fillSpecies(ArrayList<String> species) {
		String item = "";
		for (int i = 0; i < species.size(); i++) {
			item = species.get(i);
			comboBoxSpecie.addItem(item);
		}
	}

	public void fillRaces(ArrayList<String> races) {
		comboBoxRace.removeAllItems();
		comboBoxRace.addItem("Seleccione");
		String item = "";
		for (int i = 0; i < races.size(); i++) {
			item = races.get(i);
			comboBoxRace.addItem(item);
		}
	}

	public void fillColors(ArrayList<String> colors) {
		String item = "";
		for (int i = 0; i < colors.size(); i++) {
			item = colors.get(i);
			comboBoxColor.addItem(item);
		}

	}

	public boolean verificateGaps(String textFiedName, String comboBoxSpecie, String comboBoxRace,
			String comboBoxColor) {
		boolean verification = false;

		if (!"".equals(textFiedName) && !"Seleccione".equals(comboBoxSpecie) && !"Seleccione".equals(comboBoxRace)
				&& !"Seleccione".equals(comboBoxColor)) {
			verification = true;
		}
		return verification;
	}

	public void cleanGaps() {

		textFieldName.setText("");
		comboBoxSpecie.setSelectedIndex(0);
		comboBoxRace.setSelectedIndex(0);
		comboBoxColor.setSelectedIndex(0);
		dateBird.setDate(new Date());

	}

	public void warningMessages(String message) {
		JOptionPane.showMessageDialog(null, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
	}

	public void errorMessages(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void informationMessages(String message) {
		JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * @return the textFieldName
	 */
	public JTextField getTextFieldName() {
		return textFieldName;
	}

	/**
	 * @param textFieldName the textFieldName to set
	 */
	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}

	/**
	 * @return the comboBoxSpecie
	 */
	public JComboBox getComboBoxSpecie() {
		return comboBoxSpecie;
	}

	/**
	 * @param comboBoxSpecie the comboBoxSpecie to set
	 */
	public void setComboBoxSpecie(JComboBox comboBoxSpecie) {
		this.comboBoxSpecie = comboBoxSpecie;
	}

	/**
	 * @return the comboBoxRace
	 */
	public JComboBox getComboBoxRace() {
		return comboBoxRace;
	}

	/**
	 * @param comboBoxRace the comboBoxRace to set
	 */
	public void setComboBoxRace(JComboBox comboBoxRace) {
		this.comboBoxRace = comboBoxRace;
	}

	/**
	 * @return the comboBoxColor
	 */
	public JComboBox getComboBoxColor() {
		return comboBoxColor;
	}

	/**
	 * @param comboBoxColor the comboBoxColor to set
	 */
	public void setComboBoxColor(JComboBox comboBoxColor) {
		this.comboBoxColor = comboBoxColor;
	}

	/**
	 * @return the dateBird
	 */
	public JDateChooser getDateBird() {
		return dateBird;
	}

	/**
	 * @param dateBird the dateBird to set
	 */
	public void setDateBird(JDateChooser dateBird) {
		this.dateBird = dateBird;
	}

	/**
	 * @return the buttonRegisterPet
	 */
	public JButton getButtonRegisterPet() {
		return buttonRegisterPet;
	}

	/**
	 * @param buttonRegisterPet the buttonRegisterPet to set
	 */
	public void setButtonRegisterPet(JButton buttonRegisterPet) {
		this.buttonRegisterPet = buttonRegisterPet;
	}

}
