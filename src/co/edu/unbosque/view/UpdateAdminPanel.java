package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Button;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class UpdateAdminPanel extends JPanel {

	private JTextField textFieldNames, textFieldLastnames, textFieldUsername, textFieldCedula, textFieldAge,
			textFieldNumTel, textFieldAddress;
	private JLabel labelNames, labelLastnames, labelUsername, labelNumCedula, labelAge, labelNumTel, labelNumTel2,
			labelNumTel3, labelAddress, labelTitle;
	private Button buttonFinishUpdateUser;
	private JTextField textFieldNumTel2;
	private JTextField textFieldNumTel3;
	private JPasswordField textFieldPassword;
	private JLabel labelPassword;

	public UpdateAdminPanel() {

		setSize(561, 421);
		setBackground(new Color(71, 120, 197));
		setVisible(false);
		setLayout(null);

		labelNames = new JLabel("Nombres:");
		labelNames.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNames.setBounds(179, 112, 92, 20);
		add(labelNames);

		textFieldNames = new JTextField();
		textFieldNames.setEditable(true);
		textFieldNames.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldNames.setBounds(261, 112, 165, 20);
		add(textFieldNames);

		labelLastnames = new JLabel("Apellidos:");
		labelLastnames.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelLastnames.setBounds(179, 143, 92, 27);
		add(labelLastnames);

		textFieldLastnames = new JTextField();
		textFieldLastnames.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldLastnames.setBounds(261, 143, 165, 20);
		add(textFieldLastnames);

		labelUsername = new JLabel("Nombre de usuario:");
		labelUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelUsername.setBounds(108, 49, 178, 23);
		add(labelUsername);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldUsername.setBounds(261, 49, 165, 20);
		add(textFieldUsername);

		labelNumCedula = new JLabel("N\u00FAmero de c\u00E9dula\r\n:");
		labelNumCedula.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNumCedula.setBounds(108, 158, 143, 52);
		add(labelNumCedula);

		textFieldCedula = new JTextField();
		textFieldCedula.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldCedula.setBounds(261, 172, 165, 20);
		add(textFieldCedula);

		labelAge = new JLabel("Edad:");
		labelAge.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelAge.setBounds(204, 189, 92, 52);
		add(labelAge);

		textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldAge.setBounds(261, 203, 165, 20);
		add(textFieldAge);

		textFieldNumTel = new JTextField();
		textFieldNumTel.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldNumTel.setBounds(261, 234, 165, 20);
		add(textFieldNumTel);

		labelNumTel = new JLabel("N\u00FAmero de tel\u00E9fono (1)\r\n:");
		labelNumTel.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNumTel.setBounds(69, 221, 217, 52);
		add(labelNumTel);

		labelAddress = new JLabel("Direcci\u00F3n:");
		labelAddress.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelAddress.setBounds(179, 315, 92, 52);
		add(labelAddress);

		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldAddress.setBounds(261, 329, 165, 20);
		add(textFieldAddress);

		buttonFinishUpdateUser = new Button("Confirmar cambios");
		buttonFinishUpdateUser.setBackground(new Color(75, 0, 130));
		buttonFinishUpdateUser.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonFinishUpdateUser.setActionCommand("TERMINARACTUALIZARADMIN");
		buttonFinishUpdateUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonFinishUpdateUser.setBounds(239, 373, 120, 38);
		add(buttonFinishUpdateUser);

		labelTitle = new JLabel("Informaci\u00F3n de usuario");
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		labelTitle.setBounds(156, 11, 270, 36);
		add(labelTitle);

		textFieldNumTel2 = new JTextField();
		textFieldNumTel2.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldNumTel2.setBounds(261, 265, 165, 20);
		add(textFieldNumTel2);

		textFieldNumTel3 = new JTextField();
		textFieldNumTel3.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldNumTel3.setBounds(261, 298, 165, 20);
		add(textFieldNumTel3);

		labelNumTel2 = new JLabel("N\u00FAmero de tel\u00E9fono (2)\r\n:");
		labelNumTel2.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNumTel2.setBounds(69, 249, 217, 52);
		add(labelNumTel2);

		labelNumTel3 = new JLabel("N\u00FAmero de tel\u00E9fono (3)\r\n:");
		labelNumTel3.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNumTel3.setBounds(69, 284, 217, 52);
		add(labelNumTel3);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldPassword.setBounds(261, 81, 165, 20);
		add(textFieldPassword);

		labelPassword = new JLabel("Contrase\u00F1a:");
		labelPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelPassword.setBounds(164, 80, 178, 27);
		add(labelPassword);

	}

	public boolean verificateGaps(String textFieldUsername, String textFieldPassword, String textFieldNames,
			String textFieldLastnames, String textFieldNumCedula, String textFieldAge, String textFieldNumTel,
			String textFieldAddress) {

		boolean verification = false;

		if (!"".equals(textFieldUsername) && !"".equals(textFieldPassword) && !"".equals(textFieldNames)
				&& !"".equals(textFieldLastnames) && !"".equals(textFieldNumCedula) && !"".equals(textFieldAge)
				&& !"".equals(textFieldNumTel) && !"".equals(textFieldAddress)) {

			verification = true;
		}
		return verification;
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
	 * @return the buttonFinishUpdateUser
	 */
	public Button getButtonFinishUpdateUser() {
		return buttonFinishUpdateUser;
	}

	/**
	 * @param buttonFinishUpdateUser the buttonFinishUpdateUser to set
	 */
	public void setButtonFinishUpdateUser(Button buttonFinishUpdateUser) {
		this.buttonFinishUpdateUser = buttonFinishUpdateUser;
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
	 * @return the textFieldPassword
	 */
	public JPasswordField getTextFieldPassword() {
		return textFieldPassword;
	}

	/**
	 * @param textFieldPassword the textFieldPassword to set
	 */
	public void setTextFieldPassword(JPasswordField textFieldPassword) {
		this.textFieldPassword = textFieldPassword;
	}
}

