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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private JPanel panel, panelInfo, panelHomeAdmin;
	private JLabel labelIcon, labelUsername, labelName, labelLastname, labelImageHOme;
	private JButton buttonRegisterEmployee, buttonViewReports, buttonViewInfo, buttonViewUsers, buttonBackhome,
			buttonViewPets, buttonAdminAttributes, buttonLogout;
	private JSeparator separator1, separator2, separator3, separator4, separator5, separator6, separator7, separator8;
	private JSeparator separator9;
	private JButton buttonViewServices;
	private AddEmployeePanel addEmployeePanel;
	private AccountAdminPanel accountAdminPanel;
	private UpdateAdminPanel updateAdminPanel;
	private ViewUsersAdminPanel viewUsersAdminPanel;
	private ViewPetsAdminPanel viewpetsAdminPanel;

	public AdminView() {

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

		panelHomeAdmin = new JPanel();
		panelHomeAdmin.setBounds(0, 0, 561, 421);
		panelInfo.add(panelHomeAdmin);
		panelHomeAdmin.setLayout(null);

		addEmployeePanel = new AddEmployeePanel();
		panelInfo.add(addEmployeePanel);

		accountAdminPanel = new AccountAdminPanel();
		panelInfo.add(accountAdminPanel);

		updateAdminPanel = new UpdateAdminPanel();
		panelInfo.add(updateAdminPanel);

		viewUsersAdminPanel = new ViewUsersAdminPanel();
		panelInfo.add(viewUsersAdminPanel);

		viewpetsAdminPanel = new ViewPetsAdminPanel();
		panelInfo.add(viewpetsAdminPanel);

		labelImageHOme = new JLabel("");
		labelImageHOme.setIcon(new ImageIcon(AdminView.class.getResource("/images/imagenPortadaAdmin.jpg")));
		labelImageHOme.setBounds(0, 0, 561, 421);
		panelHomeAdmin.add(labelImageHOme);

		labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon(AdminView.class.getResource("/images/adminLogo.png")));
		labelIcon.setBounds(4, 24, 70, 60);
		panel.add(labelIcon);

		labelUsername = new JLabel("Nombre de usuario");
		labelUsername.setForeground(Color.WHITE);
		labelUsername.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		labelUsername.setBounds(74, 33, 109, 32);
		panel.add(labelUsername);

		labelName = new JLabel("Nombres");
		labelName.setForeground(Color.WHITE);
		labelName.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		labelName.setBounds(74, 49, 113, 32);
		panel.add(labelName);

		labelLastname = new JLabel("Apellidos");
		labelLastname.setForeground(Color.WHITE);
		labelLastname.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		labelLastname.setBounds(74, 64, 119, 32);
		panel.add(labelLastname);

		buttonRegisterEmployee = new JButton("Registrar empleado");
		buttonRegisterEmployee.setForeground(Color.WHITE);
		buttonRegisterEmployee.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonRegisterEmployee.setBackground(new Color(23, 35, 51));
		buttonRegisterEmployee.setActionCommand("EMPEZAREGISTROEMPLEADO");
		buttonRegisterEmployee.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonRegisterEmployee.setBorderPainted(false);
		buttonRegisterEmployee.setContentAreaFilled(false);
		buttonRegisterEmployee.setFocusPainted(false);
		buttonRegisterEmployee.setBounds(2, 107, 183, 22);
		panel.add(buttonRegisterEmployee);

		buttonViewReports = new JButton("Ver facturas");
		buttonViewReports.setForeground(Color.WHITE);
		buttonViewReports.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonViewReports.setBackground(new Color(23, 35, 51));
		buttonViewReports.setActionCommand("EMPEZARVERFACTURAS");
		buttonViewReports.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonViewReports.setBorderPainted(false);
		buttonViewReports.setContentAreaFilled(false);
		buttonViewReports.setFocusPainted(false);
		buttonViewReports.setBounds(-52, 239, 245, 22);
		panel.add(buttonViewReports);

		buttonViewInfo = new JButton("Mi cuenta");
		buttonViewInfo.setForeground(Color.WHITE);
		buttonViewInfo.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonViewInfo.setBackground(new Color(23, 35, 51));
		buttonViewInfo.setActionCommand("EMPEZARVERINFOADMIN");
		buttonViewInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonViewInfo.setBorderPainted(false);
		buttonViewInfo.setContentAreaFilled(false);
		buttonViewInfo.setFocusPainted(false);
		buttonViewInfo.setBounds(-34, 140, 199, 22);
		panel.add(buttonViewInfo);

		buttonViewUsers = new JButton("Ver usuarios");
		buttonViewUsers.setForeground(Color.WHITE);
		buttonViewUsers.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonViewUsers.setBackground(new Color(23, 35, 51));
		buttonViewUsers.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonViewUsers.setActionCommand("EMPEZARVERUSUARIOS");
		buttonViewUsers.setBorderPainted(false);
		buttonViewUsers.setContentAreaFilled(false);
		buttonViewUsers.setFocusPainted(false);
		buttonViewUsers.setBounds(10, 173, 128, 22);
		panel.add(buttonViewUsers);

		separator1 = new JSeparator();
		separator1.setBounds(6, 94, 169, 2);
		panel.add(separator1);

		separator2 = new JSeparator();
		separator2.setBounds(10, 128, 169, 2);
		panel.add(separator2);

		separator3 = new JSeparator();
		separator3.setBounds(10, 261, 169, 2);
		panel.add(separator3);

		separator4 = new JSeparator();
		separator4.setBounds(14, 161, 169, 2);
		panel.add(separator4);

		separator5 = new JSeparator();
		separator5.setBounds(14, 193, 169, 2);
		panel.add(separator5);

		buttonLogout = new JButton("Cerrar sesi\u00F3n");
		buttonLogout.setForeground(Color.WHITE);
		buttonLogout.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		buttonLogout.setBackground(new Color(23, 35, 51));
		buttonLogout.setActionCommand("CERRARSESIONADMIN");
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
		buttonBackhome.setActionCommand("VOLVERINICIOADMIN");
		buttonBackhome.setBounds(10, 340, 143, 22);
		panel.add(buttonBackhome);

		separator6 = new JSeparator();
		separator6.setBounds(10, 360, 169, 2);
		panel.add(separator6);

		buttonViewPets = new JButton("Ver mascotas");
		buttonViewPets.setForeground(Color.WHITE);
		buttonViewPets.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonViewPets.setFocusPainted(false);
		buttonViewPets.setContentAreaFilled(false);
		buttonViewPets.setBorderPainted(false);
		buttonViewPets.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonViewPets.setBackground(new Color(23, 35, 51));
		buttonViewPets.setActionCommand("EMPEZARVERMASCOTASADMIN");
		buttonViewPets.setBounds(4, 206, 149, 22);
		panel.add(buttonViewPets);

		separator7 = new JSeparator();
		separator7.setBounds(8, 227, 169, 2);
		panel.add(separator7);

		buttonAdminAttributes = new JButton("Administrar atributos");
		buttonAdminAttributes.setForeground(Color.WHITE);
		buttonAdminAttributes.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonAdminAttributes.setFocusPainted(false);
		buttonAdminAttributes.setContentAreaFilled(false);
		buttonAdminAttributes.setBorderPainted(false);
		buttonAdminAttributes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonAdminAttributes.setBackground(new Color(23, 35, 51));
		buttonAdminAttributes.setActionCommand("EMPEZARADMINISTRARATRIBUTOS");
		buttonAdminAttributes.setBounds(-10, 307, 217, 22);
		panel.add(buttonAdminAttributes);

		separator8 = new JSeparator();
		separator8.setBounds(14, 329, 169, 2);
		panel.add(separator8);

		separator9 = new JSeparator();
		separator9.setBounds(10, 294, 169, 2);
		panel.add(separator9);

		buttonViewServices = new JButton("Ver servicios");
		buttonViewServices.setForeground(Color.WHITE);
		buttonViewServices.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		buttonViewServices.setFocusPainted(false);
		buttonViewServices.setContentAreaFilled(false);
		buttonViewServices.setBorderPainted(false);
		buttonViewServices.setBackground(new Color(23, 35, 51));
		buttonViewServices.setActionCommand("EMPEZARVERSERVICIOS");
		buttonViewServices.setBounds(-52, 272, 245, 22);
		panel.add(buttonViewServices);

	}

	/**
	 * @return the viewpetsAdminPanel
	 */
	public ViewPetsAdminPanel getViewpetsAdminPanel() {
		return viewpetsAdminPanel;
	}

	/**
	 * @param viewpetsAdminPanel the viewpetsAdminPanel to set
	 */
	public void setViewpetsAdminPanel(ViewPetsAdminPanel viewpetsAdminPanel) {
		this.viewpetsAdminPanel = viewpetsAdminPanel;
	}

	/**
	 * @return the buttonViewReports
	 */
	public JButton getButtonViewReports() {
		return buttonViewReports;
	}

	/**
	 * @param buttonViewReports the buttonViewReports to set
	 */
	public void setButtonViewReports(JButton buttonViewReports) {
		this.buttonViewReports = buttonViewReports;
	}

	/**
	 * @return the buttonViewServices
	 */
	public JButton getButtonViewServices() {
		return buttonViewServices;
	}

	/**
	 * @param buttonViewServices the buttonViewServices to set
	 */
	public void setButtonViewServices(JButton buttonViewServices) {
		this.buttonViewServices = buttonViewServices;
	}

	/**
	 * @return the accountAdminPanel
	 */
	public AccountAdminPanel getAccountAdminPanel() {
		return accountAdminPanel;
	}

	/**
	 * @param accountAdminPanel the accountAdminPanel to set
	 */
	public void setAccountAdminPanel(AccountAdminPanel accountAdminPanel) {
		this.accountAdminPanel = accountAdminPanel;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the labelIcon
	 */
	public JLabel getLabelIcon() {
		return labelIcon;
	}

	/**
	 * @param labelIcon the labelIcon to set
	 */
	public void setLabelIcon(JLabel labelIcon) {
		this.labelIcon = labelIcon;
	}

	/**
	 * @return the labelImageHOme
	 */
	public JLabel getLabelImageHOme() {
		return labelImageHOme;
	}

	/**
	 * @param labelImageHOme the labelImageHOme to set
	 */
	public void setLabelImageHOme(JLabel labelImageHOme) {
		this.labelImageHOme = labelImageHOme;
	}

	/**
	 * @return the buttonAdminAttributes
	 */
	public JButton getButtonAdminAttributes() {
		return buttonAdminAttributes;
	}

	/**
	 * @param buttonAdminAttributes the buttonAdminAttributes to set
	 */
	public void setButtonAdminAttributes(JButton buttonAdminAttributes) {
		this.buttonAdminAttributes = buttonAdminAttributes;
	}

	/**
	 * @return the addEmployeePanel
	 */
	public AddEmployeePanel getAddEmployeePanel() {
		return addEmployeePanel;
	}

	/**
	 * @param addEmployeePanel the addEmployeePanel to set
	 */
	public void setAddEmployeePanel(AddEmployeePanel addEmployeePanel) {
		this.addEmployeePanel = addEmployeePanel;
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
	 * @return the panelHomeAdmin
	 */
	public JPanel getPanelHomeAdmin() {
		return panelHomeAdmin;
	}

	/**
	 * @param panelHomeAdmin the panelHomeAdmin to set
	 */
	public void setPanelHomeAdmin(JPanel panelHomeAdmin) {
		this.panelHomeAdmin = panelHomeAdmin;
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
	 * @return the buttonRegisterAdmin
	 */
	public JButton getButtonRegisterAdmin() {
		return buttonViewReports;
	}

	/**
	 * @param buttonRegisterAdmin the buttonRegisterAdmin to set
	 */
	public void setButtonRegisterAdmin(JButton buttonRegisterAdmin) {
		this.buttonViewReports = buttonRegisterAdmin;
	}

	/**
	 * @return the buttonViewInfo
	 */
	public JButton getButtonViewInfo() {
		return buttonViewInfo;
	}

	/**
	 * @param buttonViewInfo the buttonViewInfo to set
	 */
	public void setButtonViewInfo(JButton buttonViewInfo) {
		this.buttonViewInfo = buttonViewInfo;
	}

	/**
	 * @return the buttonViewUsers
	 */
	public JButton getButtonViewUsers() {
		return buttonViewUsers;
	}

	/**
	 * @param buttonViewUsers the buttonViewUsers to set
	 */
	public void setButtonViewUsers(JButton buttonViewUsers) {
		this.buttonViewUsers = buttonViewUsers;
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

	/**
	 * @return the buttonViewPets
	 */
	public JButton getButtonViewPets() {
		return buttonViewPets;
	}

	/**
	 * @param buttonViewPets the buttonViewPets to set
	 */
	public void setButtonViewPets(JButton buttonViewPets) {
		this.buttonViewPets = buttonViewPets;
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
	 * @return the updateAdminPanel
	 */
	public UpdateAdminPanel getUpdateAdminPanel() {
		return updateAdminPanel;
	}

	/**
	 * @param updateAdminPanel the updateAdminPanel to set
	 */
	public void setUpdateAdminPanel(UpdateAdminPanel updateAdminPanel) {
		this.updateAdminPanel = updateAdminPanel;
	}

	/**
	 * @return the viewUsersAdminPanel
	 */
	public ViewUsersAdminPanel getViewUsersAdminPanel() {
		return viewUsersAdminPanel;
	}

	/**
	 * @param viewUsersAdminPanel the viewUsersAdminPanel to set
	 */
	public void setViewUsersAdminPanel(ViewUsersAdminPanel viewUsersAdminPanel) {
		this.viewUsersAdminPanel = viewUsersAdminPanel;
	}

}