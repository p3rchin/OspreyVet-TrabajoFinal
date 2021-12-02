package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Button;

public class RegisterView extends JFrame {

	private JPanel contentPane, panelLogo, panelImage;
	private JTextField textFieldUsername, textFieldNames, textFieldLastname, textFieldCedula, textFieldAge,
			textFieldNumberCel, textFieldAdress;
	private JPasswordField textFieldPassword;
	private JLabel labelImage, labelLogo, labelUsername, labelPassword, labelName, labelLastname, labelCedula, labelAge,
			labelTitle;
	private Button register;
	private JButton loginInRegister;

	public RegisterView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 460);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelImage = new JPanel();
		panelImage.setBounds(410, 0, 353, 431);
		contentPane.add(panelImage);
		panelImage.setLayout(null);

		labelImage = new JLabel("");
		labelImage.setBounds(-443, -183, 871, 655);
		panelImage.add(labelImage);
		labelImage.setIcon(new ImageIcon(RegisterView.class.getResource("/images/portadaregister.jpg")));

		panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 410, 97);
		contentPane.add(panelLogo);
		panelLogo.setLayout(null);

		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(RegisterView.class.getResource("/images/logoRegistrarse.png")));
		labelLogo.setBounds(0, 0, 410, 97);
		panelLogo.add(labelLogo);

		labelUsername = new JLabel("Nombre de usuario");
		labelUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelUsername.setBounds(10, 155, 133, 31);
		contentPane.add(labelUsername);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldUsername.setBounds(10, 178, 175, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		labelPassword = new JLabel("Contrase\u00F1a");
		labelPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelPassword.setBounds(214, 151, 133, 39);
		contentPane.add(labelPassword);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(214, 178, 175, 20);
		contentPane.add(textFieldPassword);

		labelName = new JLabel("Nombres");
		labelName.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelName.setBounds(10, 209, 133, 20);
		contentPane.add(labelName);

		labelCedula = new JLabel("N\u00FAmero de c\u00E9dula");
		labelCedula.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelCedula.setBounds(10, 251, 133, 39);
		contentPane.add(labelCedula);

		textFieldNames = new JTextField();
		textFieldNames.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldNames.setColumns(10);
		textFieldNames.setBounds(10, 227, 175, 20);
		contentPane.add(textFieldNames);

		labelLastname = new JLabel("Apellidos");
		labelLastname.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelLastname.setBounds(214, 200, 133, 39);
		contentPane.add(labelLastname);

		textFieldLastname = new JTextField();
		textFieldLastname.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldLastname.setColumns(10);
		textFieldLastname.setBounds(214, 227, 175, 20);
		contentPane.add(textFieldLastname);

		textFieldCedula = new JTextField();
		textFieldCedula.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldCedula.setColumns(10);
		textFieldCedula.setBounds(10, 279, 175, 20);
		contentPane.add(textFieldCedula);

		labelAge = new JLabel("Edad");
		labelAge.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelAge.setBounds(214, 251, 133, 39);
		contentPane.add(labelAge);

		textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(214, 279, 175, 20);
		contentPane.add(textFieldAge);

		labelTitle = new JLabel("Registrarse");
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		labelTitle.setBounds(153, 117, 143, 26);
		contentPane.add(labelTitle);

		register = new Button("Registrar");
		register.setForeground(new Color(245, 245, 245));
		register.setFont(new Font("Yu Gothic", Font.ITALIC, 14));
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		register.setBackground(new Color(153, 50, 204));
		register.setActionCommand("COMPLETARREGISTRO");
		register.setBounds(134, 360, 115, 31);
		contentPane.add(register);

		loginInRegister = new JButton("\u00BFYa tienes una cuenta? - Incia sesi\u00F3n");
		Font font = new Font("Yu Gothic", Font.ITALIC, 13);
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		loginInRegister.setFont(font.deriveFont(attributes));
		loginInRegister.setBorderPainted(false);
		loginInRegister.setContentAreaFilled(false);
		loginInRegister.setFocusPainted(false);
		loginInRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginInRegister.setActionCommand("VOLVERAINICIOSESION");
		loginInRegister.setBounds(32, 378, 315, 66);
		contentPane.add(loginInRegister);

		JLabel labelTelefono = new JLabel("N\u00FAmero de tel\u00E9fono");
		labelTelefono.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelTelefono.setBounds(10, 306, 133, 39);
		contentPane.add(labelTelefono);

		textFieldNumberCel = new JTextField();
		textFieldNumberCel.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldNumberCel.setColumns(10);
		textFieldNumberCel.setBounds(10, 334, 175, 20);
		contentPane.add(textFieldNumberCel);

		JLabel labelDireccion = new JLabel("Direcci\u00F3n");
		labelDireccion.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelDireccion.setBounds(214, 306, 133, 39);
		contentPane.add(labelDireccion);

		textFieldAdress = new JTextField();
		textFieldAdress.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldAdress.setColumns(10);
		textFieldAdress.setBounds(214, 334, 175, 20);
		contentPane.add(textFieldAdress);
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
		textFieldNames.setText("");
		textFieldLastname.setText("");
		textFieldPassword.setText("");
		textFieldNumberCel.setText("");
		textFieldAge.setText("");
		textFieldNumberCel.setText("");
		textFieldAdress.setText("");
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
	 * @return the register
	 */
	public Button getRegister() {
		return register;
	}

	/**
	 * @param register the register to set
	 */
	public void setRegister(Button register) {
		this.register = register;
	}

	/**
	 * @return the loginInRegister
	 */
	public JButton getLoginInRegister() {
		return loginInRegister;
	}

	/**
	 * @param loginInRegister the loginInRegister to set
	 */
	public void setLoginInRegister(JButton loginInRegister) {
		this.loginInRegister = loginInRegister;
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
	 * @return the textFieldNumberCel
	 */
	public JTextField getTextFieldNumberCel() {
		return textFieldNumberCel;
	}

	/**
	 * @param textFieldNumberCel the textFieldNumberCel to set
	 */
	public void setTextFieldNumberCel(JTextField textFieldNumberCel) {
		this.textFieldNumberCel = textFieldNumberCel;
	}

	/**
	 * @return the textFieldAdress
	 */
	public JTextField getTextFieldAdress() {
		return textFieldAdress;
	}

	/**
	 * @param textFieldAdress the textFieldAdress to set
	 */
	public void setTextFieldAdress(JTextField textFieldAdress) {
		this.textFieldAdress = textFieldAdress;
	}
}