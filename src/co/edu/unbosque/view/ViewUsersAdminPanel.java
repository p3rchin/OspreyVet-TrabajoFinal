package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.w3c.dom.events.MouseEvent;

import com.toedter.calendar.JDateChooser;

import co.edu.unbosque.model.Pet;
import co.edu.unbosque.model.Username;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ViewUsersAdminPanel extends JPanel {
	private JTable table;
	private JTable tablePetData;
	private JTextField textFieldNameUser;
	private JTextField textFieldSearchUser;
	private JScrollPane scrollPaneTable;
	private JLabel labelTitle, labelNameUser, labelPasswordUser;
	private JComboBox comboBoxTypeSearchUser;
	private Button buttonSearchUser, buttonUpdateUser, buttonDeleteUser;
	private JButton buttonShowAllUsers;
	private DefaultTableModel model;
	private JPasswordField textFieldPasswordUser;
	private JTextField textFieldNamesUser;
	private JTextField textFieldLastnamesUser;
	private JLabel labelCedulaUsers;
	private JTextField textFieldNumCedulaUser;
	private JLabel labelAgeUsers;
	private JTextField textFieldAgeUser;
	private JLabel labelAddress;
	private JTextField textFieldAddressUser;

	/**
	 * Create the panel.
	 */
	public ViewUsersAdminPanel() {

		setSize(561, 421);
		setBackground(new Color(71, 120, 197));
		setLayout(null);
		setVisible(false);

		scrollPaneTable = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPaneTable.setBounds(0, 234, 561, 187);
		add(scrollPaneTable);
		tablePetData = new JTable();
		tablePetData.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		tablePetData.getTableHeader().setEnabled(false);
		tablePetData.getTableHeader().setBackground(new Color(71, 120, 197));
		tablePetData.getTableHeader().setForeground(Color.black);
		tablePetData.getTableHeader().isBackgroundSet();
		Font font = new Font("Yu Gothic", Font.BOLD, 12);
		tablePetData.getTableHeader().setFont(font);
		tablePetData.setGridColor(new Color(71, 120, 197));
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("T. usuario");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Nombres");
		model.addColumn("Apellidos");
		model.addColumn("N. cédula");
		model.addColumn("Edad");
		model.addColumn("Dirección");

		textFieldNameUser = new JTextField();
		textFieldNameUser.setBounds(145, 64, 116, 20);
		add(textFieldNameUser);
		textFieldNameUser.setColumns(10);

		labelNameUser = new JLabel("Nombre de usuario:");
		labelNameUser.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelNameUser.setBounds(10, 66, 134, 22);
		add(labelNameUser);

		labelPasswordUser = new JLabel("Contrase\u00F1a:");
		labelPasswordUser.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelPasswordUser.setBounds(56, 95, 79, 23);
		add(labelPasswordUser);

		textFieldSearchUser = new JTextField();
		textFieldSearchUser.setBounds(191, 202, 122, 21);
		add(textFieldSearchUser);
		textFieldSearchUser.setColumns(10);

		buttonSearchUser = new Button("Buscar");
		buttonSearchUser.setBackground(new Color(75, 0, 130));
		buttonSearchUser.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonSearchUser.setActionCommand("BUSCARMASCOTA");
		buttonSearchUser.setBounds(459, 195, 79, 33);
		add(buttonSearchUser);

		comboBoxTypeSearchUser = new JComboBox();
		comboBoxTypeSearchUser.setBounds(323, 202, 126, 21);
		comboBoxTypeSearchUser.addItem("Seleccione");
		comboBoxTypeSearchUser.addItem("ID");
		comboBoxTypeSearchUser.addItem("T. usuario");
		comboBoxTypeSearchUser.addItem("Username");
		comboBoxTypeSearchUser.addItem("Nombres");
		comboBoxTypeSearchUser.addItem("Apellidos");
		comboBoxTypeSearchUser.addItem("N. cédula");
		comboBoxTypeSearchUser.addItem("Edad");
		comboBoxTypeSearchUser.addItem("Dirección");
		add(comboBoxTypeSearchUser);

		buttonUpdateUser = new Button("Actualizar");
		buttonUpdateUser.setBackground(new Color(75, 0, 130));
		buttonUpdateUser.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonUpdateUser.setActionCommand("ACTUALIZARUSUARIO");
		buttonUpdateUser.setBounds(497, 84, 54, 22);
		add(buttonUpdateUser);

		buttonDeleteUser = new Button("Eliminar");
		buttonDeleteUser.setBackground(new Color(75, 0, 130));
		buttonDeleteUser.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonDeleteUser.setActionCommand("BORRARUSUARIO");
		buttonDeleteUser.setBounds(497, 112, 54, 22);
		add(buttonDeleteUser);

		labelTitle = new JLabel("Informaci\u00F3n de usuarios");
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		labelTitle.setBounds(153, 11, 259, 24);
		add(labelTitle);

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date dateN = new Date();

		buttonShowAllUsers = new JButton("Mostrar todo");
		Font font1 = new Font("Yu Gothic", Font.ITALIC, 10);
		Map attributes = font1.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		buttonShowAllUsers.setFont(font1.deriveFont(attributes));
		buttonShowAllUsers.setBorderPainted(false);
		buttonShowAllUsers.setContentAreaFilled(false);
		buttonShowAllUsers.setFocusPainted(false);
		buttonShowAllUsers.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonShowAllUsers.setActionCommand("MOSTRARTODOUSUARIOS");
		buttonShowAllUsers.setBounds(-11, 210, 116, 36);
		add(buttonShowAllUsers);

		textFieldPasswordUser = new JPasswordField();
		textFieldPasswordUser.setBounds(145, 93, 116, 20);
		add(textFieldPasswordUser);

		JLabel labelNamesUsers = new JLabel("Nombres:");
		labelNamesUsers.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelNamesUsers.setBounds(72, 129, 72, 22);
		add(labelNamesUsers);

		textFieldNamesUser = new JTextField();
		textFieldNamesUser.setColumns(10);
		textFieldNamesUser.setBounds(145, 127, 116, 20);
		add(textFieldNamesUser);

		JLabel labelLastnamesUsers = new JLabel("Apellidos:");
		labelLastnamesUsers.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelLastnamesUsers.setBounds(72, 161, 72, 22);
		add(labelLastnamesUsers);

		textFieldLastnamesUser = new JTextField();
		textFieldLastnamesUser.setColumns(10);
		textFieldLastnamesUser.setBounds(145, 159, 116, 20);
		add(textFieldLastnamesUser);

		labelCedulaUsers = new JLabel("N. C\u00E9dula:");
		labelCedulaUsers.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelCedulaUsers.setBounds(271, 68, 72, 22);
		add(labelCedulaUsers);

		textFieldNumCedulaUser = new JTextField();
		textFieldNumCedulaUser.setColumns(10);
		textFieldNumCedulaUser.setBounds(344, 66, 116, 20);
		add(textFieldNumCedulaUser);

		labelAgeUsers = new JLabel("Edad:");
		labelAgeUsers.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelAgeUsers.setBounds(302, 97, 48, 22);
		add(labelAgeUsers);

		textFieldAgeUser = new JTextField();
		textFieldAgeUser.setColumns(10);
		textFieldAgeUser.setBounds(344, 96, 116, 20);
		add(textFieldAgeUser);

		labelAddress = new JLabel("Direcci\u00F3n:");
		labelAddress.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelAddress.setBounds(271, 131, 72, 22);
		add(labelAddress);

		textFieldAddressUser = new JTextField();
		textFieldAddressUser.setColumns(10);
		textFieldAddressUser.setBounds(344, 129, 116, 20);
		add(textFieldAddressUser);

	}

	public void infoTable(ArrayList<Username> usernameList) {
		for (Username username : usernameList) {
			Object[] fila = new Object[9];
			fila[0] = username.getId();
			fila[1] = username.getTypeuser_id();
			fila[2] = username.getUsername();
			fila[3] = username.getPassword();
			fila[4] = username.getNames();
			fila[5] = username.getLastnames();
			fila[6] = username.getNum_cedula();
			fila[7] = username.getAge();
			fila[8] = username.getAddress();

			model.addRow(fila);
		}
		tablePetData.setDefaultEditor(Object.class, null);
		tablePetData.setModel(model);
		TableColumnModel columnModel = tablePetData.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(3);
		columnModel.getColumn(1).setPreferredWidth(3);
		columnModel.getColumn(2).setPreferredWidth(5);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(4).setPreferredWidth(5);
		columnModel.getColumn(5).setPreferredWidth(5);
		columnModel.getColumn(6).setPreferredWidth(3);
		columnModel.getColumn(7).setPreferredWidth(4);
		columnModel.getColumn(8).setPreferredWidth(4);
		scrollPaneTable.setViewportView(tablePetData);
	}

	public boolean verificateGaps(String textFieldUsername, String textFieldPassword, String textFieldNames,
			String textFieldLastnames, String textFieldNumCedula, String textFieldAge, String textFieldAddress) {

		boolean verification = false;

		if (!"".equals(textFieldUsername) && !"".equals(textFieldPassword) && !"".equals(textFieldNames)
				&& !"".equals(textFieldLastnames) && !"".equals(textFieldNumCedula) && !"".equals(textFieldAge)
				&& !"".equals(textFieldAddress)) {

			verification = true;
		}
		return verification;
	}

	public boolean verificateGapsSearch(String textFieldSearchUsers, String comboBoxTypeSearch) {
		boolean verification = false;

		if (!"".equals(textFieldSearchUsers) && !"Seleccione".equals(comboBoxTypeSearch)) {
			verification = true;
		}
		return verification;
	}

	public String[] takeInfoTable(int row) {
		String[] returnInfo = new String[2];
		int id_user = Integer.parseInt(model.getValueAt(row, 0).toString());
		textFieldNameUser.setText(model.getValueAt(row, 2).toString());
		textFieldPasswordUser.setText(model.getValueAt(row, 3).toString());
		textFieldNamesUser.setText(model.getValueAt(row, 4).toString());
		textFieldLastnamesUser.setText(model.getValueAt(row, 5).toString());
		textFieldNumCedulaUser.setText(model.getValueAt(row, 6).toString());
		textFieldAgeUser.setText(model.getValueAt(row, 7).toString());
		textFieldAddressUser.setText(model.getValueAt(row, 8).toString());
		returnInfo[0] = model.getValueAt(row, 0).toString();
		returnInfo[1] = model.getValueAt(row, 2).toString();

		return returnInfo;
	}

	public void removeInfoTable() {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	public void cleanGaps() {

		textFieldNameUser.setText("");
		textFieldPasswordUser.setText("");
		textFieldNamesUser.setText("");
		textFieldLastnamesUser.setText("");
		textFieldNumCedulaUser.setText("");
		textFieldAgeUser.setText("");
		textFieldAddressUser.setText("");
		textFieldSearchUser.setText("");

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
	 * @return the textFieldNameUser
	 */
	public JTextField getTextFieldNameUser() {
		return textFieldNameUser;
	}

	/**
	 * @param textFieldNameUser the textFieldNameUser to set
	 */
	public void setTextFieldNameUser(JTextField textFieldNameUser) {
		this.textFieldNameUser = textFieldNameUser;
	}

	/**
	 * @return the textFieldSearchUser
	 */
	public JTextField getTextFieldSearchUser() {
		return textFieldSearchUser;
	}

	/**
	 * @param textFieldSearchUser the textFieldSearchUser to set
	 */
	public void setTextFieldSearchUser(JTextField textFieldSearchUser) {
		this.textFieldSearchUser = textFieldSearchUser;
	}

	/**
	 * @return the textFieldPasswordUser
	 */
	public JPasswordField getTextFieldPasswordUser() {
		return textFieldPasswordUser;
	}

	/**
	 * @param textFieldPasswordUser the textFieldPasswordUser to set
	 */
	public void setTextFieldPasswordUser(JPasswordField textFieldPasswordUser) {
		this.textFieldPasswordUser = textFieldPasswordUser;
	}

	/**
	 * @return the textFieldNamesUser
	 */
	public JTextField getTextFieldNamesUser() {
		return textFieldNamesUser;
	}

	/**
	 * @param textFieldNamesUser the textFieldNamesUser to set
	 */
	public void setTextFieldNamesUser(JTextField textFieldNamesUser) {
		this.textFieldNamesUser = textFieldNamesUser;
	}

	/**
	 * @return the textFieldLastnamesUser
	 */
	public JTextField getTextFieldLastnamesUser() {
		return textFieldLastnamesUser;
	}

	/**
	 * @param textFieldLastnamesUser the textFieldLastnamesUser to set
	 */
	public void setTextFieldLastnamesUser(JTextField textFieldLastnamesUser) {
		this.textFieldLastnamesUser = textFieldLastnamesUser;
	}

	/**
	 * @return the textFieldNumCedulaUser
	 */
	public JTextField getTextFieldNumCedulaUser() {
		return textFieldNumCedulaUser;
	}

	/**
	 * @param textFieldNumCedulaUser the textFieldNumCedulaUser to set
	 */
	public void setTextFieldNumCedulaUser(JTextField textFieldNumCedulaUser) {
		this.textFieldNumCedulaUser = textFieldNumCedulaUser;
	}

	/**
	 * @return the textFieldAgeUser
	 */
	public JTextField getTextFieldAgeUser() {
		return textFieldAgeUser;
	}

	/**
	 * @param textFieldAgeUser the textFieldAgeUser to set
	 */
	public void setTextFieldAgeUser(JTextField textFieldAgeUser) {
		this.textFieldAgeUser = textFieldAgeUser;
	}

	/**
	 * @return the textFieldAddressUser
	 */
	public JTextField getTextFieldAddressUser() {
		return textFieldAddressUser;
	}

	/**
	 * @param textFieldAddressUser the textFieldAddressUser to set
	 */
	public void setTextFieldAddressUser(JTextField textFieldAddressUser) {
		this.textFieldAddressUser = textFieldAddressUser;
	}

	/**
	 * @return the model
	 */
	public DefaultTableModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	/**
	 * @return the buttonShowAll
	 */
	public JButton getButtonShowAll() {
		return buttonShowAllUsers;
	}

	/**
	 * @param buttonShowAll the buttonShowAll to set
	 */
	public void setButtonShowAll(JButton buttonShowAll) {
		this.buttonShowAllUsers = buttonShowAll;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * @return the tablePetData
	 */
	public JTable getTablePetData() {
		return tablePetData;
	}

	/**
	 * @param tablePetData the tablePetData to set
	 */
	public void setTablePetData(JTable tablePetData) {
		this.tablePetData = tablePetData;
	}

	/**
	 * @return the textFieldNamePet
	 */
	public JTextField getTextFieldNamePet() {
		return textFieldNameUser;
	}

	/**
	 * @param textFieldNamePet the textFieldNamePet to set
	 */
	public void setTextFieldNamePet(JTextField textFieldNamePet) {
		this.textFieldNameUser = textFieldNamePet;
	}

	/**
	 * @return the textFieldSearchPet
	 */
	public JTextField getTextFieldSearchPet() {
		return textFieldSearchUser;
	}

	/**
	 * @param textFieldSearchPet the textFieldSearchPet to set
	 */
	public void setTextFieldSearchPet(JTextField textFieldSearchPet) {
		this.textFieldSearchUser = textFieldSearchPet;
	}

	/**
	 * @return the scrollPaneTable
	 */
	public JScrollPane getScrollPaneTable() {
		return scrollPaneTable;
	}

	/**
	 * @param scrollPaneTable the scrollPaneTable to set
	 */
	public void setScrollPaneTable(JScrollPane scrollPaneTable) {
		this.scrollPaneTable = scrollPaneTable;
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
	 * @return the labelNamePet
	 */
	public JLabel getLabelNamePet() {
		return labelNameUser;
	}

	/**
	 * @param labelNamePet the labelNamePet to set
	 */
	public void setLabelNamePet(JLabel labelNamePet) {
		this.labelNameUser = labelNamePet;
	}

	/**
	 * @return the labelSpecie
	 */
	public JLabel getLabelSpecie() {
		return labelPasswordUser;
	}

	/**
	 * @param labelSpecie the labelSpecie to set
	 */
	public void setLabelSpecie(JLabel labelSpecie) {
		this.labelPasswordUser = labelSpecie;
	}

	/**
	 * @return the comboBoxTypeSearch
	 */
	public JComboBox getComboBoxTypeSearch() {
		return comboBoxTypeSearchUser;
	}

	/**
	 * @param comboBoxTypeSearch the comboBoxTypeSearch to set
	 */
	public void setComboBoxTypeSearch(JComboBox comboBoxTypeSearch) {
		this.comboBoxTypeSearchUser = comboBoxTypeSearch;
	}

	/**
	 * @return the buttonSearchPet
	 */
	public Button getButtonSearchPet() {
		return buttonSearchUser;
	}

	/**
	 * @param buttonSearchPet the buttonSearchPet to set
	 */
	public void setButtonSearchPet(Button buttonSearchPet) {
		this.buttonSearchUser = buttonSearchPet;
	}

	/**
	 * @return the buttonUpdatePet
	 */
	public Button getButtonUpdatePet() {
		return buttonUpdateUser;
	}

	/**
	 * @param buttonUpdatePet the buttonUpdatePet to set
	 */
	public void setButtonUpdatePet(Button buttonUpdatePet) {
		this.buttonUpdateUser = buttonUpdatePet;
	}

	/**
	 * @return the buttonDeletePet
	 */
	public Button getButtonDeletePet() {
		return buttonDeleteUser;
	}

	/**
	 * @param buttonDeletePet the buttonDeletePet to set
	 */
	public void setButtonDeletePet(Button buttonDeletePet) {
		this.buttonDeleteUser = buttonDeletePet;
	}
}