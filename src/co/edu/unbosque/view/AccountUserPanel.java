package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Button;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AccountUserPanel extends JPanel {

	
	private JTextField textFieldNames, textFieldLastnames, textFieldUsername, textFieldCedula, textFieldAge,
			textFieldNumTel, textFieldNumTel2, textFieldNumTel3, textFieldAddress;
	private JLabel labelNames, labelLastnames, labelUsername, labelNumCedula, labelAge, labelNumTel, labelNumTel2,
			labelNumTel3, labelAddress, labelTitle;
	private Button buttonUpdateUser;

	public AccountUserPanel() {

		setSize(561, 421);
		setBackground(new Color(71, 120, 197));
		setLayout(null);
		setVisible(false);

		labelNames = new JLabel("Nombres:");
		labelNames.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNames.setBounds(181, 107, 92, 52);
		add(labelNames);

		textFieldNames = new JTextField("");
		textFieldNames.setEditable(false);
		textFieldNames.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		textFieldNames.setBounds(263, 124, 165, 20);
		textFieldNames.setBackground(new Color(71, 120, 197));
		textFieldNames.setBorder(new LineBorder(Color.BLACK, 0));
		textFieldNames.setHorizontalAlignment(SwingConstants.LEFT);
		add(textFieldNames);

		labelLastnames = new JLabel("Apellidos:");
		labelLastnames.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelLastnames.setBounds(181, 138, 92, 52);
		add(labelLastnames);

		textFieldLastnames = new JTextField("");
		textFieldLastnames.setEditable(false);
		textFieldLastnames.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		textFieldLastnames.setBackground(new Color(71, 120, 197));
		textFieldLastnames.setBorder(new LineBorder(Color.BLACK, 0));
		textFieldLastnames.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLastnames.setBounds(263, 155, 165, 20);
		add(textFieldLastnames);

		labelUsername = new JLabel("Nombre de usuario:");
		labelUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelUsername.setBounds(110, 76, 178, 52);
		add(labelUsername);

		textFieldUsername = new JTextField();
		textFieldUsername.setText("");
		textFieldUsername.setEditable(false);
		textFieldUsername.setBackground(new Color(71, 120, 197));
		textFieldUsername.setBounds(263, 124, 165, 20);
		textFieldUsername.setBorder(new LineBorder(Color.BLACK, 0));
		textFieldUsername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		textFieldUsername.setBounds(263, 93, 165, 20);
		add(textFieldUsername);

		labelNumCedula = new JLabel("N\u00FAmero de c\u00E9dula\r\n:");
		labelNumCedula.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNumCedula.setBounds(110, 170, 143, 52);
		add(labelNumCedula);

		textFieldCedula = new JTextField("");
		textFieldCedula.setEditable(false);
		textFieldCedula.setBounds(263, 187, 165, 20);
		textFieldCedula.setBackground(new Color(71, 120, 197));
		textFieldCedula.setBorder(new LineBorder(Color.BLACK, 0));
		textFieldCedula.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldCedula.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		textFieldCedula.setBounds(263, 184, 165, 20);
		add(textFieldCedula);

		labelAge = new JLabel("Edad:");
		labelAge.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelAge.setBounds(207, 198, 92, 52);
		add(labelAge);

		textFieldAge = new JTextField("");
		textFieldAge.setEditable(false);
		textFieldAge.setBackground(new Color(71, 120, 197));
		textFieldAge.setBorder(new LineBorder(Color.BLACK, 0));
		textFieldAge.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAge.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		textFieldAge.setBounds(263, 215, 165, 20);
		add(textFieldAge);

		textFieldNumTel = new JTextField("");
		textFieldNumTel.setEditable(false);
		textFieldNumTel.setBounds(263, 250, 165, 22);
		textFieldNumTel.setBackground(new Color(71, 120, 197));
		textFieldNumTel.setBorder(new LineBorder(Color.BLACK, 0));
		textFieldNumTel.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNumTel.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		textFieldNumTel.setBounds(263, 246, 165, 20);
		add(textFieldNumTel);

		labelNumTel = new JLabel("N\u00FAmero de tel\u00E9fono\r\n:");
		labelNumTel.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNumTel.setBounds(100, 233, 163, 52);
		add(labelNumTel);

		labelAddress = new JLabel("Direcci\u00F3n:");
		labelAddress.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelAddress.setBounds(181, 261, 92, 52);
		add(labelAddress);

		textFieldAddress = new JTextField("");
		textFieldAddress.setEditable(false);
		textFieldAddress.setBounds(263, 314, 165, 20);
		textFieldAddress.setBackground(new Color(71, 120, 197));
		textFieldAddress.setBorder(new LineBorder(Color.BLACK, 0));
		textFieldAddress.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAddress.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		textFieldAddress.setBounds(263, 278, 165, 20);
		add(textFieldAddress);

		buttonUpdateUser = new Button("Actualizar");
		buttonUpdateUser.setBackground(new Color(75, 0, 130));
		buttonUpdateUser.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonUpdateUser.setActionCommand("ACTUALIZARUSUARIO");
		buttonUpdateUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonUpdateUser.setBounds(238, 342, 92, 38);
		add(buttonUpdateUser);

		labelTitle = new JLabel("Informaci\u00F3n de usuario");
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		labelTitle.setBounds(156, 29, 270, 36);
		add(labelTitle);
		setVisible(false);
		

	}

	
	
	/**
	 * @return the textFieldNames
	 */
	public JTextField getTextFieldNames() {
		return textFieldNames;
	}

	/**
	 * @param textFieldNames the textFieldNames to set
	 */
	public void setTextFieldNames(JTextField textFieldNames) {
		this.textFieldNames = textFieldNames;
	}

	/**
	 * @return the textFieldLastnames
	 */
	public JTextField getTextFieldLastnames() {
		return textFieldLastnames;
	}

	/**
	 * @param textFieldLastnames the textFieldLastnames to set
	 */
	public void setTextFieldLastnames(JTextField textFieldLastnames) {
		this.textFieldLastnames = textFieldLastnames;
	}

	/**
	 * @return the textFieldUsername
	 */
	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	/**
	 * @param textFieldUsername the textFieldUsername to set
	 */
	public void setTextFieldUsername(JTextField textFieldUsername) {
		this.textFieldUsername = textFieldUsername;
	}

	/**
	 * @return the textFieldCedula
	 */
	public JTextField getTextFieldCedula() {
		return textFieldCedula;
	}

	/**
	 * @param textFieldCedula the textFieldCedula to set
	 */
	public void setTextFieldCedula(JTextField textFieldCedula) {
		this.textFieldCedula = textFieldCedula;
	}

	/**
	 * @return the textFieldAge
	 */
	public JTextField getTextFieldAge() {
		return textFieldAge;
	}

	/**
	 * @param textFieldAge the textFieldAge to set
	 */
	public void setTextFieldAge(JTextField textFieldAge) {
		this.textFieldAge = textFieldAge;
	}

	/**
	 * @return the textFieldNumTel
	 */
	public JTextField getTextFieldNumTel() {
		return textFieldNumTel;
	}

	/**
	 * @param textFieldNumTel the textFieldNumTel to set
	 */
	public void setTextFieldNumTel(JTextField textFieldNumTel) {
		this.textFieldNumTel = textFieldNumTel;
	}

	/**
	 * @return the textFieldNumTel2
	 */
	public JTextField getTextFieldNumTel2() {
		return textFieldNumTel2;
	}

	/**
	 * @param textFieldNumTel2 the textFieldNumTel2 to set
	 */
	public void setTextFieldNumTel2(JTextField textFieldNumTel2) {
		this.textFieldNumTel2 = textFieldNumTel2;
	}

	/**
	 * @return the textFieldNumTel3
	 */
	public JTextField getTextFieldNumTel3() {
		return textFieldNumTel3;
	}

	/**
	 * @param textFieldNumTel3 the textFieldNumTel3 to set
	 */
	public void setTextFieldNumTel3(JTextField textFieldNumTel3) {
		this.textFieldNumTel3 = textFieldNumTel3;
	}

	/**
	 * @return the textFieldAddress
	 */
	public JTextField getTextFieldAddress() {
		return textFieldAddress;
	}

	/**
	 * @param textFieldAddress the textFieldAddress to set
	 */
	public void setTextFieldAddress(JTextField textFieldAddress) {
		this.textFieldAddress = textFieldAddress;
	}

	/**
	 * @return the labelUsername
	 */
	public JLabel getLabelUsername() {
		return labelUsername;
	}

	/**
	 * @param labelUsername the labelUsername to set
	 */
	public void setLabelUsername(JLabel labelUsername) {
		this.labelUsername = labelUsername;
	}

	/**
	 * @return the buttonUpdateUser
	 */
	public Button getButtonUpdateUser() {
		return buttonUpdateUser;
	}

	/**
	 * @param buttonUpdateUser the buttonUpdateUser to set
	 */
	public void setButtonUpdateUser(Button buttonUpdateUser) {
		this.buttonUpdateUser = buttonUpdateUser;
	}

	
}