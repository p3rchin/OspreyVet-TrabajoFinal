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
import javax.swing.JPasswordField;

public class AddEmployeePanel extends JPanel {
	private JLabel labelTitle, labelUsername, labelName, labelPassword, labelLastname;
	private JTextField textFieldUsername;
	private JButton buttonRegisterEmployee;
	private JTextField textFieldName;
	private JTextField textFieldLastname;
	private JTextField textFieldNumTel;
	private JTextField textFieldNumCedula;
	private JTextField textFieldAddress;
	private JTextField textFieldAge;
	private JPasswordField textFieldPassword;

	/**
	 * Create the panel.
	 */
	public AddEmployeePanel() {

		setSize(561, 421);
		setBackground(new Color(71, 120, 197));
		setLayout(null);
		setVisible(false);

		labelTitle = new JLabel("Registrar un empleado");
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		labelTitle.setBounds(142, 30, 242, 57);
		add(labelTitle);

		labelUsername = new JLabel("Nombre de usuario");
		labelUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelUsername.setBounds(34, 98, 153, 30);
		add(labelUsername);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		textFieldUsername.setBounds(34, 124, 188, 20);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);

		labelName = new JLabel("Nombres");
		labelName.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelName.setBounds(34, 155, 124, 30);
		add(labelName);

		labelPassword = new JLabel("Contrase\u00F1a");
		labelPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelPassword.setBounds(306, 98, 124, 30);
		add(labelPassword);

		labelLastname = new JLabel("Apellidos");
		labelLastname.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelLastname.setBounds(306, 155, 124, 30);
		add(labelLastname);

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date dateN = new Date();

		buttonRegisterEmployee = new JButton("Registrar");
		buttonRegisterEmployee.setVerticalAlignment(SwingConstants.BOTTOM);
		buttonRegisterEmployee.setForeground(UIManager.getColor("Button.foreground"));
		buttonRegisterEmployee.setFont(new Font("Yu Gothic", Font.ITALIC, 12));
		buttonRegisterEmployee.setBackground(new Color(75, 0, 130));
		buttonRegisterEmployee.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonRegisterEmployee.setActionCommand("REGISTRAREMPLEADO");
		buttonRegisterEmployee.setBounds(194, 359, 148, 30);
		add(buttonRegisterEmployee);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		textFieldName.setColumns(10);
		textFieldName.setBounds(34, 182, 188, 20);
		add(textFieldName);

		textFieldLastname = new JTextField();
		textFieldLastname.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		textFieldLastname.setColumns(10);
		textFieldLastname.setBounds(306, 182, 188, 20);
		add(textFieldLastname);

		textFieldNumTel = new JTextField();
		textFieldNumTel.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		textFieldNumTel.setColumns(10);
		textFieldNumTel.setBounds(34, 297, 188, 20);
		add(textFieldNumTel);

		JLabel labelNumTel = new JLabel("N\u00FAmero de tel\u00E9fono");
		labelNumTel.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNumTel.setBounds(34, 270, 153, 30);
		add(labelNumTel);

		textFieldNumCedula = new JTextField();
		textFieldNumCedula.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		textFieldNumCedula.setColumns(10);
		textFieldNumCedula.setBounds(34, 239, 188, 20);
		add(textFieldNumCedula);

		JLabel labelNumCedula = new JLabel("N\u00FAmero de c\u00E9dula");
		labelNumCedula.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelNumCedula.setBounds(34, 213, 153, 30);
		add(labelNumCedula);

		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(306, 297, 188, 20);
		add(textFieldAddress);

		JLabel labelAddress = new JLabel("Direcci\u00F3n");
		labelAddress.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelAddress.setBounds(306, 270, 124, 30);
		add(labelAddress);

		textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(306, 239, 188, 20);
		add(textFieldAge);

		JLabel labelAge = new JLabel("Edad");
		labelAge.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		labelAge.setBounds(306, 213, 124, 30);
		add(labelAge);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(306, 123, 188, 20);
		add(textFieldPassword);

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

	public void cleanGaps() {

		textFieldUsername.setText("");
		textFieldPassword.setText("");
		textFieldName.setText("");
		textFieldLastname.setText("");
		textFieldPassword.setText("");
		textFieldNumCedula.setText("");
		textFieldAge.setText("");
		textFieldNumTel.setText("");
		textFieldAddress.setText("");
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
	 * @return the labelTitle
	 */
	public JLabel getLabelTitle() {
		return labelTitle;
	}

	/**
	 * @param labelTitle the labelTitle to set
	 */
	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
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
	 * @return the labelName
	 */
	public JLabel getLabelName() {
		return labelName;
	}

	/**
	 * @param labelName the labelName to set
	 */
	public void setLabelName(JLabel labelName) {
		this.labelName = labelName;
	}

	/**
	 * @return the labelPassword
	 */
	public JLabel getLabelPassword() {
		return labelPassword;
	}

	/**
	 * @param labelPassword the labelPassword to set
	 */
	public void setLabelPassword(JLabel labelPassword) {
		this.labelPassword = labelPassword;
	}

	/**
	 * @return the labelLastname
	 */
	public JLabel getLabelLastname() {
		return labelLastname;
	}

	/**
	 * @param labelLastname the labelLastname to set
	 */
	public void setLabelLastname(JLabel labelLastname) {
		this.labelLastname = labelLastname;
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
	 * @return the buttonRegisterEmployee
	 */
	public JButton getButtonRegisterEmployee() {
		return buttonRegisterEmployee;
	}

	/**
	 * @param buttonRegisterEmployee the buttonRegisterEmployee to set
	 */
	public void setButtonRegisterEmployee(JButton buttonRegisterEmployee) {
		this.buttonRegisterEmployee = buttonRegisterEmployee;
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
	 * @return the textFieldLastname
	 */
	public JTextField getTextFieldLastname() {
		return textFieldLastname;
	}

	/**
	 * @param textFieldLastname the textFieldLastname to set
	 */
	public void setTextFieldLastname(JTextField textFieldLastname) {
		this.textFieldLastname = textFieldLastname;
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
	 * @return the textFieldNumCedula
	 */
	public JTextField getTextFieldNumCedula() {
		return textFieldNumCedula;
	}

	/**
	 * @param textFieldNumCedula the textFieldNumCedula to set
	 */
	public void setTextFieldNumCedula(JTextField textFieldNumCedula) {
		this.textFieldNumCedula = textFieldNumCedula;
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
