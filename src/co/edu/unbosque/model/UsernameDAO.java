package co.edu.unbosque.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsernameDAO {

	private Conection connectionDB;
	private PhoneDAO phoneDAO;

	public UsernameDAO() {

		connectionDB = new Conection();

	}

	public boolean register(Username user, Phone phone) {
		boolean reg = true;
		String userVa = "";
		try {
			connectionDB.DBConection();

			PreparedStatement query1 = connectionDB.getConnection()

					.prepareStatement(
							"SELECT nombre_usuario FROM usuario WHERE nombre_usuario ='" + user.getUsername() + "'");
			ResultSet res1 = query1.executeQuery();
			if (res1.next()) {
				userVa = res1.getString("nombre_usuario");
			}
			if (userVa.equals(user.getUsername())) {
				reg = false;

			} else {

				Statement stmt = connectionDB.getConnection().createStatement();
				stmt.executeUpdate(
						"INSERT INTO usuario (id_tipo, nombre_usuario, contrasenia, nombres, apellidos, numero_cedula, edad, direccion, estado) VALUES("
								+ user.getTypeuser_id() + ",'" + user.getUsername() + "','" + user.getPassword() + "','"
								+ user.getNames() + "','" + user.getLastnames() + "','" + user.getNum_cedula() + "','"
								+ user.getAge() + "','" + user.getAddress() + "','" + user.getState() + "')");
				reg = true;
				PreparedStatement query2 = connectionDB.getConnection()
						.prepareStatement("SELECT id FROM usuario WHERE nombre_usuario ='" + user.getUsername() + "'");
				ResultSet res2 = query2.executeQuery();

				if (res2.next()) {
					stmt.executeUpdate("INSERT INTO telefono (id_usuario, numero_telefono, estado) VALUES ("
							+ res2.getInt("id") + ",'" + phone.getPhone_number() + "','" + phone.getState() + "')");
				}
				res2.close();
				query2.close();

				stmt.close();

			}

			res1.close();
			query1.close();

			connectionDB.DBClose();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return reg;
	}

	public String[] login(String user, String password) {
		String[] returnLogin = new String[4];
		returnLogin[0] = "false";
		String userC = "";
		String passwordC = "";
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection()

					.prepareStatement("SELECT nombre_usuario, contrasenia FROM usuario WHERE nombre_usuario ='" + user
							+ "' and contrasenia = '" + password + "'");
			ResultSet res = query.executeQuery();
			if (res.next()) {
				userC = res.getString("nombre_usuario");
				passwordC = res.getString("contrasenia");

			}
			if (userC.equals(user) || passwordC.equals(password)) {
				returnLogin[0] = "true";
				PreparedStatement query2 = connectionDB.getConnection().prepareStatement(
						"SELECT id_tipo, nombres, apellidos FROM usuario WHERE nombre_usuario ='" + user + "'");
				ResultSet res2 = query2.executeQuery();

				if (res2.next()) {
					returnLogin[1] = res2.getString("id_tipo");
					returnLogin[2] = res2.getString("nombres");
					returnLogin[3] = res2.getString("apellidos");
				}
				res2.close();
				query2.close();
			}

			res.close();
			query.close();
			connectionDB.DBClose();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnLogin;

	}

	public ArrayList<Object> infoUser(String username) {
		ArrayList<Object> returnInfoUser = new ArrayList<Object>();
		Username returnUsername = new Username();
		Phone returnPhone = new Phone();
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario ='" + username + "'");
			ResultSet res = query.executeQuery();
			if (res.next()) {

				String id = res.getString("id");
				returnUsername.setUsername(res.getString("nombre_usuario"));
				returnUsername.setPassword(res.getString("contrasenia"));
				returnUsername.setNames(res.getString("nombres"));
				returnUsername.setLastnames(res.getString("apellidos"));
				returnUsername.setNum_cedula(res.getString("numero_cedula"));
				returnUsername.setAge(res.getString("edad"));
				returnUsername.setAddress(res.getString("direccion"));
				PreparedStatement query2 = connectionDB.getConnection()
						.prepareStatement("SELECT numero_telefono, estado FROM telefono WHERE id_usuario = " + id);
				ResultSet res2 = query2.executeQuery();
				if (res2.next()) {
					returnPhone.setPhone_number(res2.getString("numero_telefono"));
					returnPhone.setState(res2.getString("estado").charAt(0));
				}

			}
			returnInfoUser.add(returnUsername);
			returnInfoUser.add(returnPhone);

			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnInfoUser;
	}

	public boolean edit(String username, Username usernameToEdit, Phone phoneToEdit) {
		boolean verificar = false;
		String id = "";
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario ='" + username + "'");
			ResultSet res = query.executeQuery();
			if (res.next()) {
				id = res.getString("id");
				Statement smt = connectionDB.getConnection().createStatement();
				smt.executeUpdate("UPDATE usuario SET " + "nombre_usuario" + " = '" + usernameToEdit.getUsername()
						+ "', " + "contrasenia" + " = '" + usernameToEdit.getPassword() + "', " + "nombres" + " = '"
						+ usernameToEdit.getNames() + "', " + "apellidos" + " = '" + usernameToEdit.getLastnames()
						+ "', " + "numero_cedula" + " = '" + usernameToEdit.getNum_cedula() + "', " + "edad" + " = '"
						+ usernameToEdit.getAge() + "', " + "direccion" + " = '" + usernameToEdit.getAddress()
						+ "' WHERE id = " + id);
				Statement smt2 = connectionDB.getConnection().createStatement();
				smt2.executeUpdate("UPDATE telefono SET " + "numero_telefono" + " = '" + phoneToEdit.getPhone_number()
						+ "' WHERE id_usuario = " + id);
				verificar = true;
				smt.close();
				smt2.close();
			}
			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public boolean editUser(String username, Username usernameToEdit) {
		boolean verificar = false;
		String id = "";
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario ='" + username + "'");
			ResultSet res = query.executeQuery();
			if (res.next()) {
				id = res.getString("id");
				Statement smt = connectionDB.getConnection().createStatement();
				smt.executeUpdate("UPDATE usuario SET " + "nombre_usuario" + " = '" + usernameToEdit.getUsername()
						+ "', " + "contrasenia" + " = '" + usernameToEdit.getPassword() + "', " + "nombres" + " = '"
						+ usernameToEdit.getNames() + "', " + "apellidos" + " = '" + usernameToEdit.getLastnames()
						+ "', " + "numero_cedula" + " = '" + usernameToEdit.getNum_cedula() + "', " + "edad" + " = '"
						+ usernameToEdit.getAge() + "', " + "direccion" + " = '" + usernameToEdit.getAddress()
						+ "' WHERE id = " + id);
				verificar = true;
				smt.close();
			}
			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public boolean deleteUser(String username, Username usernameToEdit) {
		boolean verificar = false;
		String id = "";
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario ='" + username + "'");
			ResultSet res = query.executeQuery();
			if (res.next()) {
				id = res.getString("id");
				Statement smt = connectionDB.getConnection().createStatement();
				smt.executeUpdate("UPDATE usuario SET " + "estado" + " = 'I' WHERE id = " + id);
				verificar = true;
				smt.close();
			}
			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public ArrayList<Username> infoUsers() {
		ArrayList<Username> arrayUsers = new ArrayList<Username>();
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE estado = 'A' ORDER BY id, id_tipo");
			ResultSet res = query.executeQuery();
			while (res.next()) {
				Username username = new Username();
				username.setId(res.getInt("id"));
				username.setTypeuser_id(res.getShort("id_tipo"));
				username.setUsername(res.getString("nombre_usuario"));
				username.setPassword(res.getString("contrasenia"));
				username.setNames(res.getString("nombres"));
				username.setLastnames(res.getString("apellidos"));
				username.setNum_cedula(res.getString("numero_cedula"));
				username.setAge(res.getString("edad"));
				username.setAddress(res.getString("direccion"));
				arrayUsers.add(username);
			}

			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayUsers;

	}

	public int returnIDUser(String username) {
		int id = 0;
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario ='" + username + "'");
			ResultSet res = query.executeQuery();
			while (res.next()) {
				id = res.getInt("id");
			}
			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int returnIDTypeUser(String username) {
		int id = 0;
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection()
					.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario ='" + username + "'");
			ResultSet res = query.executeQuery();
			while (res.next()) {
				id = res.getInt("id_tipo");
			}
			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
