package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JSeparator;
import javax.swing.JButton;

public class EmployeeView extends JFrame {

	private JPanel contentPane;
	private JPanel panel, panelInfo, panelHomeOwner;
	private JLabel labelIcon, labelUsername, labelName, labelLastname, labelImageHOme;
	private JButton buttonAddReports, buttonAddServices, buttonViewReports, buttonLogout;
	private JSeparator separator1, separator2, separator3, separator4, separator5;
	private JButton buttonBackhome;
	private AddPetPanel addPetPanel;
	private ViewPetUserPanel viewPetUserPanel;
	private AccountUserPanel accountUserPanel;
	private UpdateUserPanel updateUserPanel;

	public EmployeeView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(779, 460);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(false);

		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(23, 35, 51));
		panel.setBounds(0, 0, 203, 421);
		contentPane.add(panel);
		panel.setLayout(null);

		panelInfo = new JPanel();
		panelInfo.setBounds(202, 0, 561, 421);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);

		addPetPanel = new AddPetPanel();
		panelInfo.add(addPetPanel);

		viewPetUserPanel = new ViewPetUserPanel();
		panelInfo.add(viewPetUserPanel);

		accountUserPanel = new AccountUserPanel();
		panelInfo.add(accountUserPanel);

		updateUserPanel = new UpdateUserPanel();
		panelInfo.add(updateUserPanel);

		panelHomeOwner = new JPanel();
		panelHomeOwner.setBounds(0, 0, 561, 421);
		panelInfo.add(panelHomeOwner);
		panelHomeOwner.setLayout(null);

		labelImageHOme = new JLabel("");
		labelImageHOme.setIcon(new ImageIcon(EmployeeView.class.getResource("/images/imagenPortadaEmpleado.jpg")));
		labelImageHOme.setBounds(0, 0, 561, 421);
		panelHomeOwner.add(labelImageHOme);

		labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon(EmployeeView.class.getResource("/images/empleadoLogo.png")));
		labelIcon.setBounds(10, 23, 70, 60);
		panel.add(labelIcon);

		labelUsername = new JLabel("Nombre de usuario");
		labelUsername.setForeground(Color.WHITE);
		labelUsername.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		labelUsername.setBounds(90, 22, 109, 32);
		panel.add(labelUsername);

		labelName = new JLabel("Nombres");
		labelName.setForeground(Color.WHITE);
		labelName.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		labelName.setBounds(90, 39, 93, 32);
		panel.add(labelName);

		labelLastname = new JLabel("Apellidos");
		labelLastname.setForeground(Color.WHITE);
		labelLastname.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		labelLastname.setBounds(90, 55, 93, 32);
		panel.add(labelLastname);

		buttonAddReports = new JButton("Agregar facturas");
		buttonAddReports.setForeground(Color.WHITE);
		buttonAddReports.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonAddReports.setBackground(new Color(23, 35, 51));
		buttonAddReports.setActionCommand("AGREGARFACTURASEMPLEADO");
		buttonAddReports.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonAddReports.setBorderPainted(false);
		buttonAddReports.setContentAreaFilled(false);
		buttonAddReports.setFocusPainted(false);
		buttonAddReports.setBounds(10, 132, 173, 22);
		panel.add(buttonAddReports);

		buttonAddServices = new JButton("Agregar servicios");
		buttonAddServices.setForeground(Color.WHITE);
		buttonAddServices.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonAddServices.setBackground(new Color(23, 35, 51));
		buttonAddServices.setActionCommand("AGREGARSERVICIOSEMPLEADO");
		buttonAddServices.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonAddServices.setBorderPainted(false);
		buttonAddServices.setContentAreaFilled(false);
		buttonAddServices.setFocusPainted(false);
		buttonAddServices.setBounds(0, 165, 183, 22);
		panel.add(buttonAddServices);

		buttonViewReports = new JButton("Ver facturas");
		buttonViewReports.setForeground(Color.WHITE);
		buttonViewReports.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonViewReports.setBackground(new Color(23, 35, 51));
		buttonViewReports.setActionCommand("EMPEZARVERFACTURAS");
		buttonViewReports.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonViewReports.setBorderPainted(false);
		buttonViewReports.setContentAreaFilled(false);
		buttonViewReports.setFocusPainted(false);
		buttonViewReports.setBounds(-26, 198, 199, 22);
		panel.add(buttonViewReports);

		separator1 = new JSeparator();
		separator1.setBounds(14, 119, 169, 2);
		panel.add(separator1);

		separator2 = new JSeparator();
		separator2.setBounds(14, 152, 169, 2);
		panel.add(separator2);

		separator3 = new JSeparator();
		separator3.setBounds(14, 185, 169, 2);
		panel.add(separator3);

		separator4 = new JSeparator();
		separator4.setBounds(14, 219, 169, 2);
		panel.add(separator4);

		separator5 = new JSeparator();
		separator5.setBounds(14, 251, 169, 2);
		panel.add(separator5);

		buttonLogout = new JButton("Cerrar sesi\u00F3n");
		buttonLogout.setForeground(Color.WHITE);
		buttonLogout.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		buttonLogout.setBackground(new Color(23, 35, 51));
		buttonLogout.setActionCommand("CERRARSESIONEMPLEADO");
		buttonLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonLogout.setBorderPainted(false);
		buttonLogout.setContentAreaFilled(false);
		buttonLogout.setFocusPainted(false);
		buttonLogout.setIcon(new ImageIcon(UserView.class.getResource("/images/cerrarSesion.png")));
		buttonLogout.setBounds(-10, 372, 173, 49);
		panel.add(buttonLogout);

		buttonBackhome = new JButton("Volver al inicio");
		buttonBackhome.setForeground(Color.WHITE);
		buttonBackhome.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonBackhome.setFocusPainted(false);
		buttonBackhome.setContentAreaFilled(false);
		buttonBackhome.setBorderPainted(false);
		buttonBackhome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonBackhome.setBackground(new Color(23, 35, 51));
		buttonBackhome.setActionCommand("VOLVERINICIOEMPLEADO");
		buttonBackhome.setBounds(10, 231, 143, 22);
		panel.add(buttonBackhome);

	}

	/**
	 * @return the updateUserPanel
	 */
	public UpdateUserPanel getUpdateUserPanel() {
		return updateUserPanel;
	}

	/**
	 * @param updateUserPanel the updateUserPanel to set
	 */
	public void setUpdateUserPanel(UpdateUserPanel updateUserPanel) {
		this.updateUserPanel = updateUserPanel;
	}

	/**
	 * @return the accountUserPanel
	 */
	public AccountUserPanel getAccountUserPanel() {
		return accountUserPanel;
	}

	/**
	 * @param accountUserPanel the accountUserPanel to set
	 */
	public void setAccountUserPanel(AccountUserPanel accountUserPanel) {
		this.accountUserPanel = accountUserPanel;
	}

	/**
	 * @return the viewPetUserPanel
	 */
	public ViewPetUserPanel getViewPetUserPanel() {
		return viewPetUserPanel;
	}

	/**
	 * @param viewPetUserPanel the viewPetUserPanel to set
	 */
	public void setViewPetUserPanel(ViewPetUserPanel viewPetUserPanel) {
		this.viewPetUserPanel = viewPetUserPanel;
	}

	/**
	 * @return the panelInfo
	 */
	public JPanel getPanelInfo() {
		return panelInfo;
	}

	/**
	 * @param panelInfo the panelInfo to set
	 */
	public void setPanelInfo(JPanel panelInfo) {
		this.panelInfo = panelInfo;
	}

	/**
	 * @return the panelHomeOwner
	 */
	public JPanel getPanelHomeOwner() {
		return panelHomeOwner;
	}

	/**
	 * @param panelHomeOwner the panelHomeOwner to set
	 */
	public void setPanelHomeOwner(JPanel panelHomeOwner) {
		this.panelHomeOwner = panelHomeOwner;
	}

	/**
	 * @return the addPetPanel
	 */
	public AddPetPanel getAddPetPanel() {
		return addPetPanel;
	}

	/**
	 * @param addPetPanel the addPetPanel to set
	 */
	public void setAddPetPanel(AddPetPanel addPetPanel) {
		this.addPetPanel = addPetPanel;
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
	 * @return the buttonRegisterPet
	 */
	public JButton getButtonRegisterPet() {
		return buttonAddReports;
	}

	/**
	 * @param buttonRegisterPet the buttonRegisterPet to set
	 */
	public void setButtonRegisterPet(JButton buttonRegisterPet) {
		this.buttonAddReports = buttonRegisterPet;
	}

	/**
	 * @return the buttonViewPet
	 */
	public JButton getButtonViewPet() {
		return buttonAddServices;
	}

	/**
	 * @param buttonViewPet the buttonViewPet to set
	 */
	public void setButtonViewPet(JButton buttonViewPet) {
		this.buttonAddServices = buttonViewPet;
	}

	/**
	 * @return the buttonViewInfo
	 */
	public JButton getButtonViewInfo() {
		return buttonViewReports;
	}

	/**
	 * @param buttonViewInfo the buttonViewInfo to set
	 */
	public void setButtonViewInfo(JButton buttonViewInfo) {
		this.buttonViewReports = buttonViewInfo;
	}

	/**
	 * @return the buttonLogout
	 */
	public JButton getButtonLogout() {
		return buttonLogout;
	}

	/**
	 * @param buttonLogout the buttonLogout to set
	 */
	public void setButtonLogout(JButton buttonLogout) {
		this.buttonLogout = buttonLogout;
	}

	/**
	 * @return the buttonBackhome
	 */
	public JButton getButtonBackhome() {
		return buttonBackhome;
	}

	/**
	 * @param buttonBackhome the buttonBackhome to set
	 */
	public void setButtonBackhome(JButton buttonBackhome) {
		this.buttonBackhome = buttonBackhome;
	}

}
