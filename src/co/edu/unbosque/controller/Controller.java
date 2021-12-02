package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import co.edu.unbosque.model.Conection;
import co.edu.unbosque.model.Pet;
import co.edu.unbosque.model.PetDAO;
import co.edu.unbosque.model.Phone;
import co.edu.unbosque.model.Username;
import co.edu.unbosque.model.UsernameDAO;
import co.edu.unbosque.view.AdminView;
import co.edu.unbosque.view.EmployeeView;
import co.edu.unbosque.view.LoginView;
import co.edu.unbosque.view.RegisterView;
import co.edu.unbosque.view.UserView;

public class Controller implements ActionListener {

	private Conection conectionDB;
	private LoginView loginView;
	private RegisterView registerView;
	private UserView userView;
	private AdminView adminView;
	private EmployeeView employeeView;
	private Username usernameClass;
	private UsernameDAO usernameDAO;
	private Pet petClass;
	private PetDAO petDAO;
	String passwordLoginNoEncrypt = "";
	String usernameLogin = "";
	ArrayList<Object> userInfo = new ArrayList<Object>();
	Username usernameInfo = new Username();
	Phone phoneInfo = new Phone();
	ArrayList<Object> adminInfo = new ArrayList<Object>();
	Username adminAccInfo = new Username();
	Phone phoneAdminInfo = new Phone();
	int IDMascotaToEditOrDelete = 0;
	int IDUserToEditOrDelete = 0;
	String usernameTOEditOrDelete = "";
	String passwordUserToEditOrDelete = "";
	Pet petToDelete = new Pet();

	public Controller() throws Exception {

		conectionDB = new Conection();
		loginView = new LoginView();
		registerView = new RegisterView();
		userView = new UserView();
		adminView = new AdminView();
		employeeView = new EmployeeView();
		usernameClass = new Username();
		usernameDAO = new UsernameDAO();
		petDAO = new PetDAO();
		petClass = new Pet();
		assignListeners();
	}

	public void assignListeners() {

		loginView.getLogin().addActionListener(this);
		loginView.getRegister().addActionListener(this);
		registerView.getRegister().addActionListener(this);
		registerView.getLoginInRegister().addActionListener(this);
		userView.getButtonRegisterPet().addActionListener(this);
		userView.getButtonViewPet().addActionListener(this);
		userView.getButtonViewInfo().addActionListener(this);
		userView.getAccountUserPanel().getButtonUpdateUser().addActionListener(this);
		userView.getUpdateUserPanel().getButtonFinishUpdateUser().addActionListener(this);
		userView.getAddPetPanel().getButtonRegisterPet().addActionListener(this);
		userView.getViewPetUserPanel().getButtonSearchPet().addActionListener(this);
		userView.getViewPetUserPanel().getButtonUpdatePet().addActionListener(this);
		userView.getViewPetUserPanel().getButtonDeletePet().addActionListener(this);
		userView.getViewPetUserPanel().getButtonShowAll().addActionListener(this);
		userView.getButtonBackhome().addActionListener(this);
		userView.getButtonLogout().addActionListener(this);
		adminView.getButtonRegisterEmployee().addActionListener(this);
		adminView.getAddEmployeePanel().getButtonRegisterEmployee().addActionListener(this);
		adminView.getButtonViewInfo().addActionListener(this);
		adminView.getAccountAdminPanel().getButtonUpdateUser().addActionListener(this);
		adminView.getUpdateAdminPanel().getButtonFinishUpdateUser().addActionListener(this);
		adminView.getButtonViewUsers().addActionListener(this);
		adminView.getViewUsersAdminPanel().getButtonUpdatePet().addActionListener(this);
		adminView.getViewUsersAdminPanel().getButtonDeletePet().addActionListener(this);
		adminView.getViewUsersAdminPanel().getButtonShowAll().addActionListener(this);
		adminView.getViewUsersAdminPanel().getButtonSearchPet().addActionListener(this);
		adminView.getButtonViewPets().addActionListener(this);
		adminView.getViewpetsAdminPanel().getButtonDeletePet().addActionListener(this);
		adminView.getButtonLogout().addActionListener(this);
		adminView.getButtonBackhome().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		// —————————————————————————————————— INICIO DE SESIÓN
		// —————————————————————————————————— \\
		if (command.equals("INGRESAR")) {

			usernameLogin = loginView.getTextFieldUser().getText();
			passwordLoginNoEncrypt = loginView.getTextFieldPassword().getText();
			String passwordLogin = usernameClass.encrypt(passwordLoginNoEncrypt);
			if (!loginView.verificateGaps(usernameLogin, passwordLogin)) {
				registerView.warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				String[] aux = usernameDAO.login(usernameLogin, passwordLogin);
				if (!aux[0].equals("true")) {
					registerView.errorMessages("No existe ese usuario o los datos están mal. Verifica o regístrate");
				} else if ("1".equals(aux[1])) {
					loginView.informationMessages("Bienvenido " + usernameLogin + ". Haz ingresado con éxito.");
					loginView.cleanGaps();
					loginView.setVisible(false);
					adminView.setVisible(true);
					adminView.getLabelUsername().setText(usernameLogin);
					adminView.getLabelName().setText(aux[2]);
					adminView.getLabelLastname().setText(aux[3]);

				} else if ("2".equals(aux[1])) {
					loginView.informationMessages("Bienvenido " + usernameLogin + ". Haz ingresado con éxito.");
					loginView.cleanGaps();
					loginView.setVisible(false);
					employeeView.setVisible(true);
					employeeView.getPanelHomeOwner().setVisible(true);
					employeeView.getLabelUsername().setText(usernameLogin);
					employeeView.getLabelName().setText(aux[2]);
					employeeView.getLabelLastname().setText(aux[3]);

				} else if ("3".equals(aux[1])) {
					loginView.informationMessages("Bienvenido " + usernameLogin + ". Haz ingresado con éxito.");
					loginView.cleanGaps();
					loginView.setVisible(false);
					userView.setVisible(true);
					userView.getPanelHomeOwner().setVisible(true);
					userView.getLabelUsername().setText(usernameLogin);
					userView.getLabelName().setText(aux[2]);
					userView.getLabelLastname().setText(aux[3]);
				}

			}

			// —————————————————————————————————— PANEL DE USUARIO //
			// —————————————————————————————————— \\

			// —————————————————————————————————— APARTADO DE MASCOTA //
			// —————————————————————————————————— \\

		} else if (command.equals("EMPEZAREGISTROMASCOTA")) {

			userView.getPanelHomeOwner().setVisible(false);
			userView.getViewPetUserPanel().setVisible(false);
			userView.getAccountUserPanel().setVisible(false);
			userView.getUpdateUserPanel().setVisible(false);
			userView.getAddPetPanel().getComboBoxSpecie().removeAllItems();
			userView.getAddPetPanel().getComboBoxColor().removeAllItems();
			userView.getAddPetPanel().getComboBoxRace().removeAllItems();
			userView.getAddPetPanel().getComboBoxSpecie().addItem("Seleccione");
			userView.getAddPetPanel().getComboBoxRace().addItem("Seleccione");
			userView.getAddPetPanel().getComboBoxColor().addItem("Seleccione");
			ArrayList<String> species = new ArrayList<String>();
			species = petDAO.speciesComboBox();
			userView.getAddPetPanel().fillSpecies(species);
			userView.getAddPetPanel().getComboBoxSpecie().addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					ArrayList<String> races = new ArrayList<String>();
					races = petDAO.raceComboBox(userView.getAddPetPanel().getComboBoxSpecie().getSelectedIndex());
					userView.getAddPetPanel().fillRaces(races);
				}

			});
			ArrayList<String> colors = new ArrayList<String>();
			colors = petDAO.colorComboBox();
			userView.getAddPetPanel().fillColors(colors);
			userView.getAddPetPanel().setVisible(true);

		} else if (command.equals("REGISTRARMASCOTA")) {
			String namePet = userView.getAddPetPanel().getTextFieldName().getText();
			String speciePet = userView.getAddPetPanel().getComboBoxSpecie().getSelectedItem().toString();
			String racePet = userView.getAddPetPanel().getComboBoxRace().getSelectedItem().toString();
			String colorPet = userView.getAddPetPanel().getComboBoxColor().getSelectedItem().toString();
			int speciePetID = userView.getAddPetPanel().getComboBoxSpecie().getSelectedIndex();
			int racePetID = userView.getAddPetPanel().getComboBoxRace().getSelectedIndex();
			int colorPetID = userView.getAddPetPanel().getComboBoxColor().getSelectedIndex();
			Date datePet = userView.getAddPetPanel().getDateBird().getDate();

			if (!userView.getAddPetPanel().verificateGaps(namePet, speciePet, speciePet, racePet)) {
				userView.getAddPetPanel().warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				if (!petClass.onlyLetters(namePet) || !petClass.onlyLettersAndNumbers(namePet)) {
					userView.getAddPetPanel().errorMessages(
							"El nombre de la mascota no puede contener carácteres especiales. Escríbelo bien");
				} else {
					int idUser = usernameDAO.returnIDUser(userView.getLabelUsername().getText());
					System.out.println(colorPetID);
					Pet newPet = new Pet(idUser, namePet, speciePet, racePet, colorPetID, datePet);
					if (!petDAO.add(newPet)) {
						userView.getAddPetPanel()
								.errorMessages("Surgió un error. Intenta agregar de nuevo tu mascotaº");
					} else {
						userView.getAddPetPanel()
								.informationMessages("Felicidades " + namePet + " ha sido registrado con éxito.");

						userView.getAddPetPanel().cleanGaps();
					}
				}
			}

		} else if (command.equals("EMPEZARVERMASCOTA")) {

			userView.getViewPetUserPanel().removeInfoTable();
			int idUser1 = usernameDAO.returnIDUser(userView.getLabelUsername().getText());
			ArrayList<Pet> infoPet = new ArrayList<Pet>();
			infoPet = petDAO.infoPet(idUser1);

			userView.getViewPetUserPanel().infoTable(infoPet);
			userView.getViewPetUserPanel().getTextFieldNamePet().setText("");
			userView.getViewPetUserPanel().getComboBoxSpecie().removeAllItems();
			userView.getViewPetUserPanel().getComboBoxColor().removeAllItems();
			userView.getViewPetUserPanel().getComboBoxRace().removeAllItems();
			userView.getViewPetUserPanel().getDateBird().setDate(new Date());
			userView.getViewPetUserPanel().getTextFieldSearchPet().setText("");
			userView.getViewPetUserPanel().getComboBoxSpecie().addItem("Seleccione");
			userView.getViewPetUserPanel().getComboBoxRace().addItem("Seleccione");
			userView.getViewPetUserPanel().getComboBoxColor().addItem("Seleccione");
			ArrayList<String> species = new ArrayList<String>();
			species = petDAO.speciesComboBox();
			userView.getViewPetUserPanel().fillSpecies(species);
			userView.getViewPetUserPanel().getComboBoxSpecie().addActionListener(new ActionListener() {
				ArrayList<String> races = new ArrayList<String>();

				public void actionPerformed(ActionEvent arg0) {
					races = petDAO.raceComboBox(userView.getViewPetUserPanel().getComboBoxSpecie().getSelectedIndex());
					userView.getViewPetUserPanel().fillRaces(races);
				}

			});
			ArrayList<String> colors = new ArrayList<String>();
			colors = petDAO.colorComboBox();
			userView.getViewPetUserPanel().fillColors(colors);

			userView.getViewPetUserPanel().getTablePetData().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					int row = userView.getViewPetUserPanel().getTablePetData().getSelectedRow();
					IDMascotaToEditOrDelete = userView.getViewPetUserPanel().takeInfoTable(row);
				}
			});

			userView.getPanelHomeOwner().setVisible(false);
			userView.getAddPetPanel().setVisible(false);
			userView.getAccountUserPanel().setVisible(false);
			userView.getUpdateUserPanel().setVisible(false);
			userView.getViewPetUserPanel().setVisible(true);

		} else if (command.equals("ACTUALIZARMASCOTA")) {

			int id_pet = IDMascotaToEditOrDelete;
			String name_pet = userView.getViewPetUserPanel().getTextFieldNamePet().getText().toString();
			String specie_pet = userView.getViewPetUserPanel().getComboBoxSpecie().getSelectedItem().toString();
			String race_pet = userView.getViewPetUserPanel().getComboBoxRace().getSelectedItem().toString();
			String color_pet = userView.getViewPetUserPanel().getComboBoxColor().getSelectedItem().toString();
			Date bird_dateToEdit = userView.getViewPetUserPanel().getDateBird().getDate();
			if (!userView.getViewPetUserPanel().verificateGaps(name_pet, specie_pet, race_pet, color_pet)) {
				userView.getAddPetPanel().warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				int id_specie = userView.getViewPetUserPanel().getComboBoxSpecie().getSelectedIndex();
				int id_color = userView.getViewPetUserPanel().getComboBoxColor().getSelectedIndex();
				if (!petClass.onlyLetters(name_pet) || !petClass.onlyLettersAndNumbers(name_pet)) {
					userView.getAddPetPanel().errorMessages(
							"El nombre de la mascota no puede contener carácteres especiales. Escríbelo bien");
				} else {
					int idUser = usernameDAO.returnIDUser(userView.getLabelUsername().getText());
					Pet newPet = new Pet(id_pet, idUser, name_pet, id_specie, race_pet, id_color, bird_dateToEdit);
					if (!petDAO.edit(newPet)) {
						userView.getAddPetPanel().errorMessages("Surgió un error. Intenta editar de nuevo tu mascotaº");

					} else {
						userView.getAddPetPanel()
								.informationMessages("Felicidades " + name_pet + " ha sido actualizada con éxito.");

						userView.getViewPetUserPanel().removeInfoTable();
						int idUser1 = usernameDAO.returnIDUser(userView.getLabelUsername().getText());
						ArrayList<Pet> infoPet = new ArrayList<Pet>();
						infoPet = petDAO.infoPet(idUser1);
						userView.getViewPetUserPanel().infoTable(infoPet);
						userView.getViewPetUserPanel().cleanGaps();
					}
				}
			}

		} else if (command.equals("BORRARMASCOTA")) {

			int id_pet = IDMascotaToEditOrDelete;
			String name_petToDelete = userView.getViewPetUserPanel().getTextFieldNamePet().getText().toString();
			String specie_petToDelete = userView.getViewPetUserPanel().getComboBoxSpecie().getSelectedItem().toString();
			String race_petToDelete = userView.getViewPetUserPanel().getComboBoxRace().getSelectedItem().toString();
			String color_petToDelete = userView.getViewPetUserPanel().getComboBoxColor().getSelectedItem().toString();
			Date bird_dateToEdit = userView.getViewPetUserPanel().getDateBird().getDate();
			if (!userView.getViewPetUserPanel().verificateGaps(name_petToDelete, specie_petToDelete, race_petToDelete,
					color_petToDelete)) {
				userView.getAddPetPanel().warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				int id_specieToDelete = userView.getViewPetUserPanel().getComboBoxSpecie().getSelectedIndex();
				int id_colorToDelete = userView.getViewPetUserPanel().getComboBoxColor().getSelectedIndex();
				if (!petClass.onlyLetters(name_petToDelete) || !petClass.onlyLettersAndNumbers(name_petToDelete)) {
					userView.getAddPetPanel().errorMessages(
							"El nombre de la mascota no puede contener carácteres especiales. Escríbelo bien");
				} else {
					int idUser = usernameDAO.returnIDUser(userView.getLabelUsername().getText());
					Pet newPet = new Pet(id_pet, idUser, name_petToDelete, id_specieToDelete, race_petToDelete,
							id_colorToDelete, bird_dateToEdit);
					if (!petDAO.delete(newPet)) {
						userView.getAddPetPanel().errorMessages("Surgió un error. Intenta borrar de nuevo tu mascota");

					} else {
						userView.getAddPetPanel().informationMessages(
								"Felicidades " + name_petToDelete + " ha sido eliminada con éxito.");

						userView.getViewPetUserPanel().removeInfoTable();
						int idUser1 = usernameDAO.returnIDUser(userView.getLabelUsername().getText());
						ArrayList<Pet> infoPet = new ArrayList<Pet>();
						infoPet = petDAO.infoPet(idUser1);
						userView.getViewPetUserPanel().infoTable(infoPet);
						userView.getViewPetUserPanel().cleanGaps();
					}
				}
			}

		} else if (command.equals("BUSCARMASCOTA")) {

			int idUser2 = usernameDAO.returnIDUser(userView.getLabelUsername().getText());
			String toSearch = userView.getViewPetUserPanel().getTextFieldSearchPet().getText().toString();
			String filter = userView.getViewPetUserPanel().getComboBoxTypeSearch().getSelectedItem().toString();

			if (!userView.getViewPetUserPanel().verificateGapsSearch(toSearch, filter)) {
				userView.getAddPetPanel().warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				ArrayList<Pet> infoSearchPet = new ArrayList<Pet>();
				infoSearchPet = petDAO.filterPet(idUser2, filter, toSearch);
				System.out.println(infoSearchPet.size());
				if (infoSearchPet.size() != 0) {
					userView.getViewPetUserPanel().removeInfoTable();
					userView.getViewPetUserPanel().infoTable(infoSearchPet);
					userView.getViewPetUserPanel().cleanGaps();
				} else {
					userView.getAddPetPanel().warningMessages("No se encontró la mascota");

				}
			}

		} else if (command.equals("MOSTRARTODO")) {

			userView.getViewPetUserPanel().cleanGaps();
			userView.getViewPetUserPanel().removeInfoTable();
			int idUser1 = usernameDAO.returnIDUser(userView.getLabelUsername().getText());
			ArrayList<Pet> infoPet = new ArrayList<Pet>();
			infoPet = petDAO.infoPet(idUser1);
			userView.getViewPetUserPanel().infoTable(infoPet);
			userView.getViewPetUserPanel().cleanGaps();

			// —————————————————————————————————— APARTADO DE LA INFORMACIÓN DEL USUARIO //
			// —————————————————————————————————— \\

		} else if (command.equals("EMPEZARVERINFORMACION")) {

			userView.getPanelHomeOwner().setVisible(false);
			userView.getAddPetPanel().setVisible(false);
			userView.getViewPetUserPanel().setVisible(false);
			userView.getUpdateUserPanel().setVisible(false);
			userView.getAccountUserPanel().setVisible(true);
			userInfo = usernameDAO.infoUser(userView.getLabelUsername().getText());
			usernameInfo = (Username) userInfo.get(0);
			phoneInfo = (Phone) userInfo.get(1);
			userView.getAccountUserPanel().getTextFieldUsername().setText(usernameInfo.getUsername());
			userView.getAccountUserPanel().getTextFieldNames().setText(usernameInfo.getNames());
			userView.getAccountUserPanel().getTextFieldLastnames().setText(usernameInfo.getLastnames());
			userView.getAccountUserPanel().getTextFieldCedula().setText(usernameInfo.getNum_cedula());
			userView.getAccountUserPanel().getTextFieldAge().setText(usernameInfo.getAge());
			userView.getAccountUserPanel().getTextFieldNumTel().setText(phoneInfo.getPhone_number());
			userView.getAccountUserPanel().getTextFieldAddress().setText(usernameInfo.getAddress());

		} else if (command.equals("ACTUALIZARUSUARIO")) {

			userView.getPanelHomeOwner().setVisible(false);
			userView.getAddPetPanel().setVisible(false);
			userView.getViewPetUserPanel().setVisible(false);
			userView.getUpdateUserPanel().setVisible(false);
			userView.getAccountUserPanel().setVisible(false);
			userView.getUpdateUserPanel().setVisible(true);
			userView.getUpdateUserPanel().getTextFieldUsername().setText(usernameInfo.getUsername());
			userView.getUpdateUserPanel().getTextFieldPassword().setText(passwordLoginNoEncrypt);
			userView.getUpdateUserPanel().getTextFieldNames().setText(usernameInfo.getNames());
			userView.getUpdateUserPanel().getTextFieldLastnames().setText(usernameInfo.getLastnames());
			userView.getUpdateUserPanel().getTextFieldCedula().setText(usernameInfo.getNum_cedula());
			userView.getUpdateUserPanel().getTextFieldAge().setText(usernameInfo.getAge());
			userView.getUpdateUserPanel().getTextFieldNumTel().setText(phoneInfo.getPhone_number());
			userView.getUpdateUserPanel().getTextFieldAddress().setText(usernameInfo.getAddress());

		} else if (command.equals("TERMINARACTUALIZARUSUARIO")) {

			String usernameEdit = userView.getUpdateUserPanel().getTextFieldUsername().getText();
			String passwordEditNoEncrypt = userView.getUpdateUserPanel().getTextFieldPassword().getText();
			String passwordEdit = usernameClass.encrypt(passwordEditNoEncrypt);
			String namesEdit = userView.getUpdateUserPanel().getTextFieldNames().getText();
			String lastnamesEdit = userView.getUpdateUserPanel().getTextFieldLastnames().getText();
			String cedulaEdit = userView.getUpdateUserPanel().getTextFieldCedula().getText();
			String ageEdit = userView.getUpdateUserPanel().getTextFieldAge().getText();
			String phoneNumberEdit = userView.getUpdateUserPanel().getTextFieldNumTel().getText();
			String phoneNumberEdit2 = userView.getUpdateUserPanel().getTextFieldNumTel2().getText();
			String phoneNumberEdit3 = userView.getUpdateUserPanel().getTextFieldNumTel3().getText();
			String addressEdit = userView.getUpdateUserPanel().getTextFieldAddress().getText();
			if (!userView.getUpdateUserPanel().verificateGaps(usernameEdit, passwordEdit, namesEdit, lastnamesEdit,
					cedulaEdit, ageEdit, phoneNumberEdit, addressEdit)) {
				userView.getUpdateUserPanel().warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				if (!usernameClass.onlyLettersAndNumbers(usernameEdit)) {
					userView.getUpdateUserPanel().errorMessages(
							"El nombre de usuario no puede contener carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.correctPassword(passwordEdit)) {
					userView.getUpdateUserPanel()
							.errorMessages("La contraseña tiene que contener 8 o más carácteres. Escríbela bien");
				} else if (!usernameClass.onlyLetters(namesEdit) || !usernameClass.onlyLettersAndNumbers(namesEdit)) {
					userView.getUpdateUserPanel().errorMessages(
							"El nombre solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyLetters(lastnamesEdit)
						|| !usernameClass.onlyLettersAndNumbers(lastnamesEdit)) {
					userView.getUpdateUserPanel().errorMessages(
							"El apellido solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(cedulaEdit) || !usernameClass.correctCedula(cedulaEdit)) {
					userView.getUpdateUserPanel()
							.errorMessages("La cédula solo puede contener 10 números. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(ageEdit) || !usernameClass.correctAge(ageEdit)) {
					userView.getUpdateUserPanel().errorMessages(
							"No puedes registrarte si eres menor de edad. Si no, que se registre tu tutor legal.");
				} else if (!usernameClass.onlyNumbers(phoneNumberEdit)
						|| !usernameClass.correctNumber(phoneNumberEdit)) {
					userView.getUpdateUserPanel().errorMessages(
							"Debes digitar un número de teléfono válido. 10 números como longitud máxima");
				} else {

					Username usernameToEdit = new Username(usernameEdit, passwordEdit, namesEdit, lastnamesEdit,
							cedulaEdit, ageEdit, addressEdit);
					Phone phoneToEdit = new Phone(phoneNumberEdit);
					if (!usernameDAO.edit(userView.getLabelUsername().getText(), usernameToEdit, phoneToEdit)) {
						userView.getUpdateUserPanel()
								.errorMessages("Ya existe ese usuario. Deberás crear un usuario diferente");
					} else {
						userView.getLabelUsername().setText(usernameEdit);
						userView.getLabelName().setText(namesEdit);
						userView.getLabelLastname().setText(lastnamesEdit);
						userView.getUpdateUserPanel()
								.informationMessages("Tu información ha sido actualizada con éxito");
						userView.getUpdateUserPanel().setVisible(false);
						userView.getPanelHomeOwner().setVisible(true);
					}

				}

			}

		} else if (command.equals("VOLVERINICIOUSUARIO")) {

			userView.getAddPetPanel().setVisible(false);
			userView.getViewPetUserPanel().setVisible(false);
			userView.getAccountUserPanel().setVisible(false);
			userView.getUpdateUserPanel().setVisible(false);
			userView.getPanelHomeOwner().setVisible(true);

		} else if (command.equals("CERRARSESIONUSUARIO")) {

			userView.getPanelHomeOwner().setVisible(false);
			userView.getAddPetPanel().setVisible(false);
			userView.getAccountUserPanel().setVisible(false);
			userView.getUpdateUserPanel().setVisible(false);
			userView.setVisible(false);
			loginView.setVisible(true);

		} else if (command.equals("VOLVERAINICIOSESION")) {

			registerView.setVisible(false);
			loginView.setVisible(true);
		}

		// —————————————————————————————————— REGISTRO DE USUARIO
		// —————————————————————————————————— \\

		if (command.equals("REGISTRARSE")) {

			loginView.setVisible(false);
			registerView.setVisible(true);

		} else if (command.equals("COMPLETARREGISTRO")) {

			String username = registerView.getTextFieldUsername().getText();
			String password = usernameClass.encrypt(registerView.getTextFieldPassword().getText());
			String names = registerView.getTextFieldNames().getText();
			String lastnames = registerView.getTextFieldLastname().getText();
			String cedula = registerView.getTextFieldCedula().getText();
			String age = registerView.getTextFieldAge().getText();
			String phoneNumber = registerView.getTextFieldNumberCel().getText();
			String address = registerView.getTextFieldAdress().getText();

			if (!registerView.verificateGaps(username, password, names, lastnames, cedula, age, phoneNumber, address)) {
				registerView.warningMessages("No puedes dejar ningún espacio sin llenar");

			} else {
				if (!usernameClass.onlyLettersAndNumbers(username)) {
					registerView.errorMessages(
							"El nombre de usuario no puede contener carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.correctPassword(password)) {
					registerView.errorMessages("La contraseña tiene que contener 8 o más carácteres. Escríbela bien");
				} else if (!usernameClass.onlyLetters(names) || !usernameClass.onlyLettersAndNumbers(names)) {
					registerView.errorMessages(
							"El nombre solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyLetters(lastnames) || !usernameClass.onlyLettersAndNumbers(lastnames)) {
					registerView.errorMessages(
							"El apellido solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(cedula) || !usernameClass.correctCedula(cedula)) {
					registerView.errorMessages("La cédula solo puede contener 10 números. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(age) || !usernameClass.correctAge(age)) {
					registerView.errorMessages(
							"No puedes registrarte si eres menor de edad. Si no, que se registre tu tutor legal.");
				} else if (!usernameClass.onlyNumbers(phoneNumber) || !usernameClass.correctNumber(phoneNumber)) {
					registerView.errorMessages(
							"Debes digitar un número de teléfono válido. 10 números como longitud máxima");
				} else {

					Username newUsername = new Username((short) 3, username, password, names, lastnames, cedula, age,
							address, 'A');
					Phone newPhone = new Phone(phoneNumber, 'A');

					if (!usernameDAO.register(newUsername, newPhone)) {
						registerView.errorMessages("Ya existe ese usuario. Deberás crear un usuario diferente");
					} else {
						registerView.informationMessages("Bienvenido " + username + ". Haz sido registrado con éxito.");
						registerView.cleanGaps();
						registerView.setVisible(false);
						loginView.setVisible(true);
					}

				}
			}
		}

		// —————————————————————————————————— SECCIÓN DE EMPLEADO
		// —————————————————————————————————— \\

		if (command.equals("EMPEZAREGISTROEMPLEADO")) {

			adminView.getPanelHomeAdmin().setVisible(false);
			adminView.getAccountAdminPanel().setVisible(false);
			adminView.getUpdateAdminPanel().setVisible(false);
			userView.getViewPetUserPanel().setVisible(false);
			adminView.getAddEmployeePanel().setVisible(true);

		} else if (command.equals("REGISTRAREMPLEADO")) {

			String username = adminView.getAddEmployeePanel().getTextFieldUsername().getText();
			String password = usernameClass.encrypt(adminView.getAddEmployeePanel().getTextFieldPassword().getText());
			String names = adminView.getAddEmployeePanel().getTextFieldName().getText();
			String lastnames = adminView.getAddEmployeePanel().getTextFieldLastname().getText();
			String cedula = adminView.getAddEmployeePanel().getTextFieldNumCedula().getText();
			String age = adminView.getAddEmployeePanel().getTextFieldAge().getText();
			String phoneNumber = adminView.getAddEmployeePanel().getTextFieldNumTel().getText();
			String address = adminView.getAddEmployeePanel().getTextFieldAddress().getText();

			if (!adminView.getAddEmployeePanel().verificateGaps(username, password, names, lastnames, cedula, age,
					phoneNumber, address)) {
				adminView.getAddEmployeePanel().warningMessages("No puedes dejar ningún espacio sin llenar");

			} else {
				if (!usernameClass.onlyLettersAndNumbers(username)) {
					adminView.getAddEmployeePanel().errorMessages(
							"El nombre de usuario no puede contener carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.correctPassword(password)) {
					adminView.getAddEmployeePanel()
							.errorMessages("La contraseña tiene que contener 8 o más carácteres. Escríbela bien");
				} else if (!usernameClass.onlyLetters(names) || !usernameClass.onlyLettersAndNumbers(names)) {
					adminView.getAddEmployeePanel().errorMessages(
							"El nombre solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyLetters(lastnames) || !usernameClass.onlyLettersAndNumbers(lastnames)) {
					adminView.getAddEmployeePanel().errorMessages(
							"El apellido solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(cedula) || !usernameClass.correctCedula(cedula)) {
					adminView.getAddEmployeePanel()
							.errorMessages("La cédula solo puede contener 10 números. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(age) || !usernameClass.correctAge(age)) {
					adminView.getAddEmployeePanel().errorMessages(
							"No puedes registrarte si eres menor de edad. Si no, que se registre tu tutor legal.");
				} else if (!usernameClass.onlyNumbers(phoneNumber) || !usernameClass.correctNumber(phoneNumber)) {
					adminView.getAddEmployeePanel().errorMessages(
							"Debes digitar un número de teléfono válido. 10 números como longitud máxima");
				} else {

					Username newUsername = new Username((short) 2, username, password, names, lastnames, cedula, age,
							address, 'A');
					Phone newPhone = new Phone(phoneNumber, 'A');

					if (!usernameDAO.register(newUsername, newPhone)) {
						adminView.getAddEmployeePanel()
								.errorMessages("Ya existe ese usuario. Deberás crear un usuario diferente");
					} else {
						adminView.getAddEmployeePanel()
								.informationMessages("Bienvenido " + username + ". Haz sido registrado con éxito.");
						adminView.getAddEmployeePanel().cleanGaps();
						adminView.getAddEmployeePanel().setVisible(false);
						adminView.getPanelHomeAdmin().setVisible(true);
					}
				}
			}

		} else if (command.equals("EMPEZARVERINFOADMIN")) {

			adminView.getPanelHomeAdmin().setVisible(false);
			adminView.getAddEmployeePanel().setVisible(false);
			adminView.getUpdateAdminPanel().setVisible(false);
			userView.getViewPetUserPanel().setVisible(false);
			adminView.getViewpetsAdminPanel().setVisible(false);
			adminView.getAccountAdminPanel().setVisible(true);

			adminInfo = usernameDAO.infoUser(adminView.getLabelUsername().getText());
			adminAccInfo = (Username) adminInfo.get(0);
			phoneAdminInfo = (Phone) adminInfo.get(1);
			adminView.getAccountAdminPanel().getTextFieldUsername().setText(adminAccInfo.getUsername());
			adminView.getAccountAdminPanel().getTextFieldNames().setText(adminAccInfo.getNames());
			adminView.getAccountAdminPanel().getTextFieldLastnames().setText(adminAccInfo.getLastnames());
			adminView.getAccountAdminPanel().getTextFieldCedula().setText(adminAccInfo.getNum_cedula());
			adminView.getAccountAdminPanel().getTextFieldAge().setText(adminAccInfo.getAge());
			adminView.getAccountAdminPanel().getTextFieldNumTel().setText(phoneAdminInfo.getPhone_number());
			adminView.getAccountAdminPanel().getTextFieldAddress().setText(adminAccInfo.getAddress());

		} else if (command.equals("ACTUALIZARADMIN")) {

			adminView.getPanelHomeAdmin().setVisible(false);
			adminView.getAddEmployeePanel().setVisible(false);
			adminView.getAccountAdminPanel().setVisible(false);
			userView.getViewPetUserPanel().setVisible(false);
			adminView.getViewpetsAdminPanel().setVisible(false);
			adminView.getUpdateAdminPanel().setVisible(true);
			adminView.getUpdateAdminPanel().getTextFieldUsername().setText(adminAccInfo.getUsername());
			adminView.getUpdateAdminPanel().getTextFieldPassword().setText(passwordLoginNoEncrypt);
			adminView.getUpdateAdminPanel().getTextFieldNames().setText(adminAccInfo.getNames());
			adminView.getUpdateAdminPanel().getTextFieldLastnames().setText(adminAccInfo.getLastnames());
			adminView.getUpdateAdminPanel().getTextFieldCedula().setText(adminAccInfo.getNum_cedula());
			adminView.getUpdateAdminPanel().getTextFieldAge().setText(adminAccInfo.getAge());
			adminView.getUpdateAdminPanel().getTextFieldNumTel().setText(phoneAdminInfo.getPhone_number());
			adminView.getUpdateAdminPanel().getTextFieldAddress().setText(adminAccInfo.getAddress());

		} else if (command.equals("TERMINARACTUALIZARADMIN")) {

			String usernameEdit = adminView.getUpdateAdminPanel().getTextFieldUsername().getText();
			String passwordEditNoEncrypt = adminView.getUpdateAdminPanel().getTextFieldPassword().getText();
			String passwordEdit = usernameClass.encrypt(passwordEditNoEncrypt);
			String namesEdit = adminView.getUpdateAdminPanel().getTextFieldNames().getText();
			String lastnamesEdit = adminView.getUpdateAdminPanel().getTextFieldLastnames().getText();
			String cedulaEdit = adminView.getUpdateAdminPanel().getTextFieldCedula().getText();
			String ageEdit = adminView.getUpdateAdminPanel().getTextFieldAge().getText();
			String phoneNumberEdit = adminView.getUpdateAdminPanel().getTextFieldNumTel().getText();
			String phoneNumberEdit2 = adminView.getUpdateAdminPanel().getTextFieldNumTel2().getText();
			String phoneNumberEdit3 = adminView.getUpdateAdminPanel().getTextFieldNumTel3().getText();
			String addressEdit = adminView.getUpdateAdminPanel().getTextFieldAddress().getText();
			if (!adminView.getUpdateAdminPanel().verificateGaps(usernameEdit, passwordEdit, namesEdit, lastnamesEdit,
					cedulaEdit, ageEdit, phoneNumberEdit, addressEdit)) {
				adminView.getUpdateAdminPanel().warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				if (!usernameClass.onlyLettersAndNumbers(usernameEdit)) {
					adminView.getUpdateAdminPanel().errorMessages(
							"El nombre de usuario no puede contener carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.correctPassword(passwordEdit)) {
					adminView.getUpdateAdminPanel()
							.errorMessages("La contraseña tiene que contener 8 o más carácteres. Escríbela bien");
				} else if (!usernameClass.onlyLetters(namesEdit) || !usernameClass.onlyLettersAndNumbers(namesEdit)) {
					adminView.getUpdateAdminPanel().errorMessages(
							"El nombre solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyLetters(lastnamesEdit)
						|| !usernameClass.onlyLettersAndNumbers(lastnamesEdit)) {
					adminView.getUpdateAdminPanel().errorMessages(
							"El apellido solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(cedulaEdit) || !usernameClass.correctCedula(cedulaEdit)) {
					adminView.getUpdateAdminPanel()
							.errorMessages("La cédula solo puede contener 10 números. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(ageEdit) || !usernameClass.correctAge(ageEdit)) {
					adminView.getUpdateAdminPanel().errorMessages(
							"No puedes registrarte si eres menor de edad. Si no, que se registre tu tutor legal.");
				} else if (!usernameClass.onlyNumbers(phoneNumberEdit)
						|| !usernameClass.correctNumber(phoneNumberEdit)) {
					adminView.getUpdateAdminPanel().errorMessages(
							"Debes digitar un número de teléfono válido. 10 números como longitud máxima");
				} else {

					Username usernameToEdit = new Username(usernameEdit, passwordEdit, namesEdit, lastnamesEdit,
							cedulaEdit, ageEdit, addressEdit);
					Phone phoneToEdit = new Phone(phoneNumberEdit);
					if (!usernameDAO.edit(adminView.getLabelUsername().getText(), usernameToEdit, phoneToEdit)) {
						adminView.getUpdateAdminPanel()
								.errorMessages("Ya existe ese usuario. Deberás crear un usuario diferente");
					} else {
						adminView.getLabelUsername().setText(usernameEdit);
						adminView.getLabelName().setText(namesEdit);
						adminView.getLabelLastname().setText(lastnamesEdit);
						adminView.getUpdateAdminPanel()
								.informationMessages("Tu información ha sido actualizada con éxito");
						adminView.getUpdateAdminPanel().setVisible(false);
						adminView.getPanelHomeAdmin().setVisible(true);
					}

				}
			}
		} else if (command.equals("EMPEZARVERUSUARIOS")) {

			adminView.getPanelHomeAdmin().setVisible(false);
			adminView.getAddEmployeePanel().setVisible(false);
			adminView.getAccountAdminPanel().setVisible(false);
			adminView.getUpdateAdminPanel().setVisible(false);
			adminView.getViewpetsAdminPanel().setVisible(false);
			adminView.getViewUsersAdminPanel().setVisible(true);
			adminView.getViewUsersAdminPanel().removeInfoTable();
			int idUser1 = usernameDAO.returnIDUser(adminView.getLabelUsername().getText());
			ArrayList<Username> infoUsers = new ArrayList<Username>();
			infoUsers = usernameDAO.infoUsers();

			adminView.getViewUsersAdminPanel().infoTable(infoUsers);

			adminView.getViewUsersAdminPanel().getTablePetData().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					int row = adminView.getViewUsersAdminPanel().getTablePetData().getSelectedRow();
					String[] aux = adminView.getViewUsersAdminPanel().takeInfoTable(row);
					IDUserToEditOrDelete = Integer.parseInt(aux[0]);
					usernameTOEditOrDelete = aux[1];

				}
			});

		} else if (command.equals("ACTUALIZARUSUARIO")) {

			int id_usuario = IDUserToEditOrDelete;
			String name_user = adminView.getViewUsersAdminPanel().getTextFieldNamePet().getText().toString();
			String password_user = usernameClass
					.encrypt(adminView.getViewUsersAdminPanel().getTextFieldPasswordUser().getText().toString());
			String names_user = adminView.getViewUsersAdminPanel().getTextFieldNamesUser().getText().toString();
			String lastname_user = adminView.getViewUsersAdminPanel().getTextFieldLastnamesUser().getText().toString();
			String numcedula_user = adminView.getViewUsersAdminPanel().getTextFieldNumCedulaUser().getText().toString();
			String age_user = adminView.getViewUsersAdminPanel().getTextFieldAgeUser().getText().toString();
			String address_user = adminView.getViewUsersAdminPanel().getTextFieldAddressUser().getText().toString();

			if (!adminView.getViewUsersAdminPanel().verificateGaps(name_user, password_user, names_user, lastname_user,
					numcedula_user, age_user, address_user)) {
				registerView.warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				if (!usernameClass.onlyLettersAndNumbers(name_user)) {
					adminView.getViewUsersAdminPanel().errorMessages(
							"El nombre de usuario no puede contener carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.correctPassword(password_user)) {
					adminView.getViewUsersAdminPanel()
							.errorMessages("La contraseña tiene que contener 8 o más carácteres. Escríbela bien");
				} else if (!usernameClass.onlyLetters(names_user) || !usernameClass.onlyLettersAndNumbers(names_user)) {
					adminView.getViewUsersAdminPanel().errorMessages(
							"El nombre solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyLetters(lastname_user)
						|| !usernameClass.onlyLettersAndNumbers(lastname_user)) {
					adminView.getViewUsersAdminPanel().errorMessages(
							"El apellido solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(numcedula_user) || !usernameClass.correctCedula(numcedula_user)) {
					adminView.getViewUsersAdminPanel()
							.errorMessages("La cédula solo puede contener 10 números. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(age_user) || !usernameClass.correctAge(age_user)) {
					adminView.getViewUsersAdminPanel().errorMessages(
							"No puedes registrarte si eres menor de edad. Si no, que se registre tu tutor legal.");
				} else {

					int idUserToEdit = IDUserToEditOrDelete;
					short idTypeUserToEdit = (short) usernameDAO.returnIDTypeUser(name_user);
					Username newUsername = new Username(idUserToEdit, idTypeUserToEdit, name_user, password_user,
							names_user, lastname_user, numcedula_user, age_user, address_user, 'A');

					if (!usernameDAO.editUser(usernameTOEditOrDelete, newUsername)) {
						adminView.getViewUsersAdminPanel()
								.errorMessages("Surgió un error. Intenta editar de nuevo el usuario");

					} else {
						adminView.getViewUsersAdminPanel()
								.informationMessages("Felicidades " + name_user + " ha sido actualizado con éxito.");

						adminView.getViewUsersAdminPanel().removeInfoTable();
						ArrayList<Username> infoUsers = new ArrayList<Username>();
						infoUsers = usernameDAO.infoUsers();
						System.out.println(infoUsers.size());

						adminView.getViewUsersAdminPanel().infoTable(infoUsers);
						adminView.getViewUsersAdminPanel().cleanGaps();
					}
				}
			}
		} else if (command.equals("BORRARUSUARIO")) {
			int id_usuario = IDUserToEditOrDelete;
			String name_user = adminView.getViewUsersAdminPanel().getTextFieldNamePet().getText().toString();
			String password_user = usernameClass
					.encrypt(adminView.getViewUsersAdminPanel().getTextFieldPasswordUser().getText().toString());
			String names_user = adminView.getViewUsersAdminPanel().getTextFieldNamesUser().getText().toString();
			String lastname_user = adminView.getViewUsersAdminPanel().getTextFieldLastnamesUser().getText().toString();
			String numcedula_user = adminView.getViewUsersAdminPanel().getTextFieldNumCedulaUser().getText().toString();
			String age_user = adminView.getViewUsersAdminPanel().getTextFieldAgeUser().getText().toString();
			String address_user = adminView.getViewUsersAdminPanel().getTextFieldAddressUser().getText().toString();

			if (!adminView.getViewUsersAdminPanel().verificateGaps(name_user, password_user, names_user, lastname_user,
					numcedula_user, age_user, address_user)) {
				registerView.warningMessages("No puedes dejar ningún espacio sin llenar");
			} else {
				if (!usernameClass.onlyLettersAndNumbers(name_user)) {
					adminView.getViewUsersAdminPanel().errorMessages(
							"El nombre de usuario no puede contener carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.correctPassword(password_user)) {
					adminView.getViewUsersAdminPanel()
							.errorMessages("La contraseña tiene que contener 8 o más carácteres. Escríbela bien");
				} else if (!usernameClass.onlyLetters(names_user) || !usernameClass.onlyLettersAndNumbers(names_user)) {
					adminView.getViewUsersAdminPanel().errorMessages(
							"El nombre solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyLetters(lastname_user)
						|| !usernameClass.onlyLettersAndNumbers(lastname_user)) {
					adminView.getViewUsersAdminPanel().errorMessages(
							"El apellido solo puede contener letras. Nada de números o carácteres especiales. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(numcedula_user) || !usernameClass.correctCedula(numcedula_user)) {
					adminView.getViewUsersAdminPanel()
							.errorMessages("La cédula solo puede contener 10 números. Escríbelo bien");
				} else if (!usernameClass.onlyNumbers(age_user) || !usernameClass.correctAge(age_user)) {
					adminView.getViewUsersAdminPanel().errorMessages(
							"No puedes registrarte si eres menor de edad. Si no, que se registre tu tutor legal.");
				} else {

					int idUserToEdit = IDUserToEditOrDelete;
					short idTypeUserToEdit = (short) usernameDAO.returnIDTypeUser(name_user);
					Username newUsername = new Username(idUserToEdit, idTypeUserToEdit, name_user, password_user,
							names_user, lastname_user, numcedula_user, age_user, address_user, 'A');

					if (!usernameDAO.deleteUser(usernameTOEditOrDelete, newUsername)) {
						adminView.getViewUsersAdminPanel()
								.errorMessages("Surgió un error. Intenta borrar de nuevo el usuario");

					} else {
						adminView.getViewUsersAdminPanel()
								.informationMessages("Felicidades " + name_user + " ha sido borrado con éxito.");

						adminView.getViewUsersAdminPanel().removeInfoTable();
						ArrayList<Username> infoUsers = new ArrayList<Username>();
						infoUsers = usernameDAO.infoUsers();

						adminView.getViewUsersAdminPanel().infoTable(infoUsers);
						adminView.getViewUsersAdminPanel().cleanGaps();
					}
				}
			}

		} else if (command.equals("EMPEZARVERMASCOTASADMIN")) {

			adminView.getPanelHomeAdmin().setVisible(false);
			adminView.getAddEmployeePanel().setVisible(false);
			adminView.getAccountAdminPanel().setVisible(false);
			adminView.getUpdateAdminPanel().setVisible(false);
			adminView.getViewUsersAdminPanel().setVisible(false);
			adminView.getViewpetsAdminPanel().setVisible(true);
			adminView.getViewpetsAdminPanel().removeInfoTable();

			ArrayList<Pet> infoPetsUsers = new ArrayList<Pet>();
			infoPetsUsers = petDAO.infoPetsUsers();

			adminView.getViewpetsAdminPanel().infoTable(infoPetsUsers);

			adminView.getViewpetsAdminPanel().getTablePetData().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					int row = adminView.getViewpetsAdminPanel().getTablePetData().getSelectedRow();

					petToDelete = adminView.getViewpetsAdminPanel().takeInfoTable(row);

				}
			});

		} else if (command.equals("BORRARMASCOTADESDEADMIN")) {

			if (!petDAO.deleteFromAdmin(petToDelete)) {
				adminView.getViewUsersAdminPanel().errorMessages("Surgió un error. Intenta borrar de nuevo la mascota");

			} else {
				adminView.getViewUsersAdminPanel()
						.informationMessages("Felicidades " + petToDelete.getName() + " ha sido borrado con éxito.");

				adminView.getViewpetsAdminPanel().removeInfoTable();
				ArrayList<Pet> infoPetsUsers = new ArrayList<Pet>();
				infoPetsUsers = petDAO.infoPetsUsers();

				adminView.getViewpetsAdminPanel().infoTable(infoPetsUsers);
			}

		} else if (command.equals("VOLVERINICIOADMIN")) {

			adminView.getAddEmployeePanel().setVisible(false);
			adminView.getAccountAdminPanel().setVisible(false);
			adminView.getUpdateAdminPanel().setVisible(false);
			adminView.getViewUsersAdminPanel().setVisible(false);
			adminView.getViewpetsAdminPanel().setVisible(false);
			adminView.getPanelHomeAdmin().setVisible(true);
		}
	}
}
