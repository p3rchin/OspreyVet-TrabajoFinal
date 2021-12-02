package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.font.TextAttribute;

import javax.swing.JButton;
import java.util.Map;
import java.awt.Button;

import javax.swing.ImageIcon;

public class LoginView extends JFrame {

	private JPanel content, panelImage, panelLogo;
	private JTextField textFieldUser; 
	private JPasswordField textFieldPassword;
	private JLabel labelUser, labelPassword, labelLogo, labelImage, labelLogin;
	private Button login;
	private JButton register;

	public LoginView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 471);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);

		content = new JPanel();
		content.setBackground(new Color(245, 245, 245));
		content.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(content);
		content.setLayout(null);

		textFieldUser = new JTextField();
		textFieldUser.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldUser.setBounds(40, 177, 282, 30);
		content.add(textFieldUser);
		textFieldUser.setColumns(10);

		labelUser = new JLabel("Nombre de usuario");
		labelUser.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		labelUser.setBounds(40, 151, 193, 30);
		content.add(labelUser);

		labelPassword = new JLabel("Contrase\u00F1a");
		labelPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		labelPassword.setBounds(37, 218, 130, 30);
		content.add(labelPassword);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(40, 247, 282, 30);
		content.add(textFieldPassword);

		login = new Button("Entrar");
		login.setForeground(new Color(245, 245, 245));
		login.setFont(new Font("Yu Gothic", Font.ITALIC, 14));
		login.setBackground(new Color(153, 50, 204));
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		login.setActionCommand("INGRESAR");
		login.setBounds(98, 300, 135, 43);
		content.add(login);

		panelLogo = new JPanel();
		panelLogo.setBackground(new Color(245, 245, 245));
		panelLogo.setBounds(0, 0, 342, 101);
		content.add(panelLogo);
		panelLogo.setLayout(null);

		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(LoginView.class.getResource("/images/logo.png")));
		labelLogo.setBounds(0, 0, 345, 90);
		panelLogo.add(labelLogo);

		panelImage = new JPanel();
		panelImage.setBounds(342, -12, 455, 444);
		content.add(panelImage);
		panelImage.setLayout(null);

		labelImage = new JLabel("");
		labelImage.setBounds(-263, 11, 936, 623);
		labelImage.setIcon(new ImageIcon(LoginView.class.getResource("/images/portadalogin.jpg")));
		panelImage.add(labelImage);
		labelLogin = new JLabel("Iniciar sesi\u00F3n");
		labelLogin.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		labelLogin.setBounds(98, 110, 193, 30);
		content.add(labelLogin);

		register = new JButton("\u00BFNo est\u00E1s registrado? - Reg\u00EDstrate aqu\u00ED");
		Font font = new Font("Yu Gothic", Font.ITALIC, 13);
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		register.setFont(font.deriveFont(attributes));
		register.setBorderPainted(false);
		register.setContentAreaFilled(false);
		register.setFocusPainted(false);
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		register.setActionCommand("REGISTRARSE");
		register.setBounds(17, 349, 315, 45);
		content.add(register);

	}

	public boolean verificateGaps(String textFieldUsername, String textFieldPassword) {
		boolean verification = false;

		if (!"".equals(textFieldUsername) && !"".equals(textFieldPassword)) {
			verification = true;
		}
		return verification;
	}

	public void cleanGaps() {

		textFieldUser.setText("");
		textFieldPassword.setText("");
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
	 * @return the textFieldUser
	 */
	public JTextField getTextFieldUser() {
		return textFieldUser;
	}

	/**
	 * @param textFieldUser the textFieldUser to set
	 */
	public void setTextFieldUser(JTextField textFieldUser) {
		this.textFieldUser = textFieldUser;
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
	 * @return the login
	 */
	public Button getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Button login) {
		this.login = login;
	}

	/**
	 * @return the register
	 */
	public JButton getRegister() {
		return register;
	}

	/**
	 * @param register the register to set
	 */
	public void setRegister(JButton register) {
		this.register = register;
	}
}
