package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JList;
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

public class ViewPetUserPanel extends JPanel {

	private JPanel panel;
	private JTable table;
	private JTable tablePetData;
	private JTextField textFieldNamePet;
	private JTextField textFieldSearchPet;
	private JScrollPane scrollPaneTable;
	private JLabel labelImage, labelTitle, labelNamePet, labelSpecie, labelRace, labelColor, labelBirdDate;
	private JComboBox comboBoxSpecie, comboBoxRace, comboBoxColor, comboBoxTypeSearch;
	private Button buttonSearchPet, buttonUpdatePet, buttonDeletePet;
	private JButton buttonShowAll;
	private DefaultTableModel model;
	private JDateChooser dateBird;

	/**
	 * Create the panel.
	 */
	public ViewPetUserPanel() {

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
		model.addColumn("Nombre");
		model.addColumn("Especie");
		model.addColumn("Raza");
		model.addColumn("Color");
		model.addColumn("Fecha de nacimiento");

		textFieldNamePet = new JTextField();
		textFieldNamePet.setBounds(375, 33, 116, 20);
		add(textFieldNamePet);
		textFieldNamePet.setColumns(10);

		labelNamePet = new JLabel("Nombre:");
		labelNamePet.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelNamePet.setBounds(311, 35, 79, 22);
		add(labelNamePet);

		labelSpecie = new JLabel("Especie:");
		labelSpecie.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelSpecie.setBounds(311, 64, 79, 23);
		add(labelSpecie);

		comboBoxSpecie = new JComboBox();
		comboBoxSpecie.setBounds(375, 64, 116, 22);
		add(comboBoxSpecie);

		labelRace = new JLabel("Raza:");
		labelRace.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelRace.setBounds(331, 101, 79, 23);
		add(labelRace);

		comboBoxRace = new JComboBox();
		comboBoxRace.setBounds(375, 98, 116, 22);
		add(comboBoxRace);

		labelColor = new JLabel("Color:");
		labelColor.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelColor.setBounds(331, 134, 46, 23);
		add(labelColor);

		comboBoxColor = new JComboBox();
		comboBoxColor.setBounds(375, 131, 116, 22);
		add(comboBoxColor);

		textFieldSearchPet = new JTextField();
		textFieldSearchPet.setBounds(191, 202, 122, 21);
		add(textFieldSearchPet);
		textFieldSearchPet.setColumns(10);

		buttonSearchPet = new Button("Buscar");
		buttonSearchPet.setBackground(new Color(75, 0, 130));
		buttonSearchPet.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonSearchPet.setActionCommand("BUSCARMASCOTA");
		buttonSearchPet.setBounds(459, 195, 79, 33);
		add(buttonSearchPet);

		comboBoxTypeSearch = new JComboBox();
		comboBoxTypeSearch.setBounds(323, 202, 126, 21);
		comboBoxTypeSearch.addItem("Seleccione");
		comboBoxTypeSearch.addItem("Nombre");
		comboBoxTypeSearch.addItem("Especie");
		comboBoxTypeSearch.addItem("Raza");
		comboBoxTypeSearch.addItem("Color");
		comboBoxTypeSearch.addItem("Año de nacimiento");
		add(comboBoxTypeSearch);

		buttonUpdatePet = new Button("Actualizar");
		buttonUpdatePet.setBackground(new Color(75, 0, 130));
		buttonUpdatePet.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonUpdatePet.setActionCommand("ACTUALIZARMASCOTA");
		buttonUpdatePet.setBounds(497, 84, 54, 22);
		add(buttonUpdatePet);

		buttonDeletePet = new Button("Eliminar");
		buttonDeletePet.setBackground(new Color(75, 0, 130));
		buttonDeletePet.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonDeletePet.setActionCommand("BORRARMASCOTA");
		buttonDeletePet.setBounds(497, 112, 54, 22);
		add(buttonDeletePet);

		panel = new JPanel();
		panel.setBounds(25, 11, 234, 180);
		add(panel);
		panel.setLayout(null);

		labelImage = new JLabel("");
		labelImage.setIcon(new ImageIcon(ViewPetUserPanel.class.getResource("/images/imagenEditarMascota.jpg")));
		labelImage.setBounds(0, 0, 234, 180);
		panel.add(labelImage);

		labelTitle = new JLabel("Informaci\u00F3n de mascotas");
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		labelTitle.setBounds(269, 11, 259, 24);
		add(labelTitle);

		labelBirdDate = new JLabel("F. nacimiento:");
		labelBirdDate.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		labelBirdDate.setBounds(274, 168, 99, 23);
		add(labelBirdDate);

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date dateN = new Date();
		dateBird = new JDateChooser(dateN, "yyyy/MM/dd");
		dateBird.setMaxSelectableDate(dateN);
		dateBird.setBounds(373, 159, 116, 30);
		add(dateBird);

		buttonShowAll = new JButton("Mostrar todo");
		Font font1 = new Font("Yu Gothic", Font.ITALIC, 10);
		Map attributes = font1.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		buttonShowAll.setFont(font1.deriveFont(attributes));
		buttonShowAll.setBorderPainted(false);
		buttonShowAll.setContentAreaFilled(false);
		buttonShowAll.setFocusPainted(false);
		buttonShowAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonShowAll.setActionCommand("MOSTRARTODO");
		buttonShowAll.setBounds(-11, 210, 116, 36);
		add(buttonShowAll);

	}

	public void infoTable(ArrayList<Pet> petList) {
		for (Pet pet : petList) {
			Object[] fila = new Object[6];
			fila[0] = pet.getId();
			fila[1] = pet.getName();
			fila[2] = pet.getName_specie();
			fila[3] = pet.getName_race();
			fila[4] = pet.getName_color();
			fila[5] = pet.getDate_bird();

			model.addRow(fila);
		}
		tablePetData.setDefaultEditor(Object.class, null);
		tablePetData.setModel(model);
		TableColumnModel columnModel = tablePetData.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(3);
		columnModel.getColumn(1).setPreferredWidth(5);
		columnModel.getColumn(2).setPreferredWidth(5);
		columnModel.getColumn(4).setPreferredWidth(5);
		scrollPaneTable.setViewportView(tablePetData);
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

	public boolean verificateGapsSearch(String textFieldSearchPet, String comboBoxTypeSearch) {
		boolean verification = false;

		if (!"".equals(textFieldSearchPet) && !"Seleccione".equals(comboBoxTypeSearch)) {
			verification = true;
		}
		return verification;
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

	public int takeInfoTable(int row) {
		int id_pet = Integer.parseInt(model.getValueAt(row, 0).toString());
		textFieldNamePet.setText(model.getValueAt(row, 1).toString());
		comboBoxSpecie.setSelectedItem(model.getValueAt(row, 2).toString());
		comboBoxRace.setSelectedItem(model.getValueAt(row, 3).toString());
		comboBoxColor.setSelectedItem(model.getValueAt(row, 4).toString());
		dateBird.setDate((Date) model.getValueAt(row, 5));
		return id_pet;
	}

	public void removeInfoTable() {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	public void cleanGaps() {

		textFieldNamePet.setText("");
		textFieldSearchPet.setText("");
		comboBoxSpecie.setSelectedIndex(0);
		comboBoxRace.setSelectedIndex(0);
		comboBoxColor.setSelectedIndex(0);
		comboBoxTypeSearch.setSelectedIndex(0);
		dateBird.setDate(new Date());

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
		return buttonShowAll;
	}

	/**
	 * @param buttonShowAll the buttonShowAll to set
	 */
	public void setButtonShowAll(JButton buttonShowAll) {
		this.buttonShowAll = buttonShowAll;
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
		return textFieldNamePet;
	}

	/**
	 * @param textFieldNamePet the textFieldNamePet to set
	 */
	public void setTextFieldNamePet(JTextField textFieldNamePet) {
		this.textFieldNamePet = textFieldNamePet;
	}

	/**
	 * @return the textFieldSearchPet
	 */
	public JTextField getTextFieldSearchPet() {
		return textFieldSearchPet;
	}

	/**
	 * @param textFieldSearchPet the textFieldSearchPet to set
	 */
	public void setTextFieldSearchPet(JTextField textFieldSearchPet) {
		this.textFieldSearchPet = textFieldSearchPet;
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
	 * @return the labelImage
	 */
	public JLabel getLabelImage() {
		return labelImage;
	}

	/**
	 * @param labelImage the labelImage to set
	 */
	public void setLabelImage(JLabel labelImage) {
		this.labelImage = labelImage;
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
		return labelNamePet;
	}

	/**
	 * @param labelNamePet the labelNamePet to set
	 */
	public void setLabelNamePet(JLabel labelNamePet) {
		this.labelNamePet = labelNamePet;
	}

	/**
	 * @return the labelSpecie
	 */
	public JLabel getLabelSpecie() {
		return labelSpecie;
	}

	/**
	 * @param labelSpecie the labelSpecie to set
	 */
	public void setLabelSpecie(JLabel labelSpecie) {
		this.labelSpecie = labelSpecie;
	}

	/**
	 * @return the labelRace
	 */
	public JLabel getLabelRace() {
		return labelRace;
	}

	/**
	 * @param labelRace the labelRace to set
	 */
	public void setLabelRace(JLabel labelRace) {
		this.labelRace = labelRace;
	}

	/**
	 * @return the labelColor
	 */
	public JLabel getLabelColor() {
		return labelColor;
	}

	/**
	 * @param labelColor the labelColor to set
	 */
	public void setLabelColor(JLabel labelColor) {
		this.labelColor = labelColor;
	}

	/**
	 * @return the labelBirdDate
	 */
	public JLabel getLabelBirdDate() {
		return labelBirdDate;
	}

	/**
	 * @param labelBirdDate the labelBirdDate to set
	 */
	public void setLabelBirdDate(JLabel labelBirdDate) {
		this.labelBirdDate = labelBirdDate;
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
	 * @return the comboBoxTypeSearch
	 */
	public JComboBox getComboBoxTypeSearch() {
		return comboBoxTypeSearch;
	}

	/**
	 * @param comboBoxTypeSearch the comboBoxTypeSearch to set
	 */
	public void setComboBoxTypeSearch(JComboBox comboBoxTypeSearch) {
		this.comboBoxTypeSearch = comboBoxTypeSearch;
	}

	/**
	 * @return the buttonSearchPet
	 */
	public Button getButtonSearchPet() {
		return buttonSearchPet;
	}

	/**
	 * @param buttonSearchPet the buttonSearchPet to set
	 */
	public void setButtonSearchPet(Button buttonSearchPet) {
		this.buttonSearchPet = buttonSearchPet;
	}

	/**
	 * @return the buttonUpdatePet
	 */
	public Button getButtonUpdatePet() {
		return buttonUpdatePet;
	}

	/**
	 * @param buttonUpdatePet the buttonUpdatePet to set
	 */
	public void setButtonUpdatePet(Button buttonUpdatePet) {
		this.buttonUpdatePet = buttonUpdatePet;
	}

	/**
	 * @return the buttonDeletePet
	 */
	public Button getButtonDeletePet() {
		return buttonDeletePet;
	}

	/**
	 * @param buttonDeletePet the buttonDeletePet to set
	 */
	public void setButtonDeletePet(Button buttonDeletePet) {
		this.buttonDeletePet = buttonDeletePet;
	}
}
