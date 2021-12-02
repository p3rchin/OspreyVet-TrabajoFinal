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

public class ViewPetsAdminPanel extends JPanel {
	private JTable table;
	private JTable tablePetData;
	private JScrollPane scrollPaneTable;
	private JLabel labelTitle;
	private Button buttonDeletePet;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public ViewPetsAdminPanel() {

		setSize(561, 421);
		setBackground(new Color(71, 120, 197));
		setLayout(null);
		setVisible(false);

		scrollPaneTable = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPaneTable.setBounds(0, 35, 491, 386);
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
		model.addColumn("ID usuario");
		model.addColumn("Username");

		buttonDeletePet = new Button("Eliminar");
		buttonDeletePet.setBackground(new Color(75, 0, 130));
		buttonDeletePet.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		buttonDeletePet.setActionCommand("BORRARMASCOTADESDEADMIN");
		buttonDeletePet.setBounds(497, 200, 54, 22);
		add(buttonDeletePet);

		labelTitle = new JLabel("Informaci\u00F3n de mascotas");
		labelTitle.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		labelTitle.setBounds(169, 11, 259, 24);
		add(labelTitle);

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date dateN = new Date();
		Font font1 = new Font("Yu Gothic", Font.ITALIC, 10);
		Map attributes = font1.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

	}
	
	
	public Pet takeInfoTable(int row) {
		
		
		Pet pet = new Pet();
		pet.setId( Integer.parseInt(model.getValueAt(row, 0).toString()));
		pet.setName(model.getValueAt(row, 1).toString());
		pet.setName_specie(model.getValueAt(row, 2).toString());
		pet.setName_race(model.getValueAt(row, 3).toString());
		pet.setName_color(model.getValueAt(row, 4).toString());
		pet.setDate_bird((Date) model.getValueAt(row, 5));
		pet.setId_user((int) model.getValueAt(row, 6));
		pet.setName_user(model.getValueAt(row, 7).toString());
		
		return pet;
	}

	public void infoTable(ArrayList<Pet> petList) {
		for (Pet pet : petList) {
			Object[] fila = new Object[8];
			fila[0] = pet.getId();
			fila[1] = pet.getName();
			fila[2] = pet.getName_specie();
			fila[3] = pet.getName_race();
			fila[4] = pet.getName_color();
			fila[5] = pet.getDate_bird();
			fila[6] = pet.getId_user();
			fila[7] = pet.getName_user();

			model.addRow(fila);
		}
		tablePetData.setDefaultEditor(Object.class, null);
		tablePetData.setModel(model);
		TableColumnModel columnModel = tablePetData.getColumnModel();
		scrollPaneTable.setViewportView(tablePetData);
	}

	public void removeInfoTable() {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
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
