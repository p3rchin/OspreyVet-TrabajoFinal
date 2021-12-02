package co.edu.unbosque.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.TableModel;

public class PetDAO {

	private Conection connectionDB;

	public PetDAO() {

		connectionDB = new Conection();
	}

	public boolean add(Pet pet) {
		boolean verificar = false;
		connectionDB.DBConection();
		try {

			Statement smt = connectionDB.getConnection().createStatement();
			smt.executeUpdate(
					"INSERT INTO mascota (id_usuario, nombre, id_especie, id_raza, id_color, anio_nacimiento, estado) VALUES("
							+ pet.getId_user() + ", '" + pet.getName() + "', "
							+ "(SELECT id FROM especie WHERE nombre = '" + pet.getName_specie() + "')" + ", "
							+ "(SELECT id FROM raza WHERE nombre = '" + pet.getName_race() + "')" + ", "
							+ pet.getId_color() + ", '" + pet.getDate_bird() + "', 'A')");
			verificar = true;
			smt.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public boolean edit(Pet pet) {
		boolean verificar = false;
		connectionDB.DBConection();
		try {

			Statement smt = connectionDB.getConnection().createStatement();
			smt.executeUpdate("UPDATE mascota SET nombre = '" + pet.getName() + "', id_especie = " + pet.getId_specie()
					+ ", id_raza = " + "(SELECT id FROM raza WHERE nombre = '" + pet.getName_race() + "')"
					+ ", id_color = " + pet.getId_color() + ", anio_nacimiento = '" + pet.getDate_bird()
					+ "', estado = 'A' WHERE id_usuario = " + pet.getId_user() + " and id = " + pet.getId());
			verificar = true;
			smt.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public boolean delete(Pet pet) {
		boolean verificar = false;
		connectionDB.DBConection();
		try {

			Statement smt = connectionDB.getConnection().createStatement();
			smt.executeUpdate("UPDATE mascota SET nombre = '" + pet.getName() + "', id_especie = " + pet.getId_specie()
					+ ", id_raza = " + "(SELECT id FROM raza WHERE nombre = '" + pet.getName_race() + "')"
					+ ", id_color = " + pet.getId_color() + ", anio_nacimiento = '" + pet.getDate_bird()
					+ "', estado = 'I' WHERE id_usuario = " + pet.getId_user() + " and id = " + pet.getId());
			verificar = true;
			smt.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

	public ArrayList<Pet> filterPet(int id_usuario, String parameter, String toSearch) {
		ArrayList<Pet> arrayPet = new ArrayList<Pet>();
		connectionDB.DBConection();
		PreparedStatement query;
		ResultSet res;
		try {
			if (parameter.equals("ID")) {
				query = connectionDB.getConnection().prepareStatement(
						"select a.id, a.nombre, b.nombre as nombre_especie, c.nombre as nombre_raza, d.nombre as nombre_color, a.anio_nacimiento from mascota a, especie b, raza c, color d, usuario e where a.id_especie = b.id and a.id_raza = c.id and a.id_color = d.id and e.id = a.id_usuario and a.id = "
								+ toSearch + " ORDER BY id");
				res = query.executeQuery();
				while (res.next()) {
					Pet pet = new Pet();
					pet.setId(res.getInt("id"));
					pet.setName(res.getString("nombre"));
					pet.setName_specie(res.getString("nombre_especie"));
					pet.setName_race(res.getString("nombre_raza"));
					pet.setName_color(res.getString("nombre_color"));
					pet.setDate_bird(res.getDate("anio_nacimiento"));
					arrayPet.add(pet);
				}
				res.close();
				query.close();

			} else if (parameter.equals("Nombre")) {

				query = connectionDB.getConnection().prepareStatement(
						"select a.id, a.nombre as nombre_mascota, b.nombre as nombre_especie, c.nombre as nombre_raza, d.nombre as nombre_color, a.anio_nacimiento from mascota a, especie b, raza c, color d, usuario e where a.id_especie = b.id and a.id_raza = c.id and a.id_color = d.id and e.id = a.id_usuario and a.nombre = '"
								+ toSearch + "' and id_usuario = " + id_usuario + " ORDER BY id");
				res = query.executeQuery();
				while (res.next()) {
					Pet pet = new Pet();
					pet.setId(res.getInt("id"));
					pet.setName(res.getString("nombre_mascota"));
					pet.setName_specie(res.getString("nombre_especie"));
					pet.setName_race(res.getString("nombre_raza"));
					pet.setName_color(res.getString("nombre_color"));
					pet.setDate_bird(res.getDate("anio_nacimiento"));
					arrayPet.add(pet);
				}
				res.close();
				query.close();
			} else if (parameter.equals("Especie")) {
				query = connectionDB.getConnection().prepareStatement(
						"select a.id, a.nombre as nombre_mascota, b.nombre as nombre_especie, c.nombre as nombre_raza, d.nombre as nombre_color, a.anio_nacimiento from mascota a, especie b, raza c, color d, usuario e where a.id_especie = b.id and a.id_raza = c.id and a.id_color = d.id and e.id = a.id_usuario and b.nombre = '"
								+ toSearch + "' and id_usuario = " + id_usuario + " ORDER BY id");
				res = query.executeQuery();
				while (res.next()) {
					Pet pet = new Pet();
					pet.setId(res.getInt("id"));
					pet.setName(res.getString("nombre_mascota"));
					pet.setName_specie(res.getString("nombre_especie"));
					pet.setName_race(res.getString("nombre_raza"));
					pet.setName_color(res.getString("nombre_color"));
					pet.setDate_bird(res.getDate("anio_nacimiento"));
					arrayPet.add(pet);
				}
				res.close();
				query.close();
			} else if (parameter.equals("Raza")) {
				query = connectionDB.getConnection().prepareStatement(
						"select a.id, a.nombre as nombre_mascota, b.nombre as nombre_especie, c.nombre as nombre_raza, d.nombre as nombre_color, a.anio_nacimiento from mascota a, especie b, raza c, color d, usuario e where a.id_especie = b.id and a.id_raza = c.id and a.id_color = d.id and e.id = a.id_usuario and c.nombre = '"
								+ toSearch + "' and id_usuario = " + id_usuario + " ORDER BY id");
				res = query.executeQuery();
				while (res.next()) {
					Pet pet = new Pet();
					pet.setId(res.getInt("id"));
					pet.setName(res.getString("nombre_mascota"));
					pet.setName_specie(res.getString("nombre_especie"));
					pet.setName_race(res.getString("nombre_raza"));
					pet.setName_color(res.getString("nombre_color"));
					pet.setDate_bird(res.getDate("anio_nacimiento"));
					arrayPet.add(pet);
				}
				res.close();
				query.close();
			} else if (parameter.equals("Color")) {
				query = connectionDB.getConnection().prepareStatement(
						"select a.id, a.nombre as nombre_mascota, b.nombre as nombre_especie, c.nombre as nombre_raza, d.nombre as nombre_color, a.anio_nacimiento from mascota a, especie b, raza c, color d, usuario e where a.id_especie = b.id and a.id_raza = c.id and a.id_color = d.id and e.id = a.id_usuario and d.nombre = '"
								+ toSearch + "' and id_usuario = " + id_usuario + " ORDER BY id");
				res = query.executeQuery();
				while (res.next()) {
					Pet pet = new Pet();
					pet.setId(res.getInt("id"));
					pet.setName(res.getString("nombre_mascota"));
					pet.setName_specie(res.getString("nombre_especie"));
					pet.setName_race(res.getString("nombre_raza"));
					pet.setName_color(res.getString("nombre_color"));
					pet.setDate_bird(res.getDate("anio_nacimiento"));
					arrayPet.add(pet);
				}
				res.close();
				query.close();
			} else if (parameter.equals("Año de nacimiento")) {
				System.out.println(
						"select a.id, a.nombre as nombre_mascota, b.nombre as nombre_especie, c.nombre as nombre_raza, d.nombre as nombre_color, a.anio_nacimiento from mascota a, especie b, raza c, color d, usuario e where a.id_especie = b.id and a.id_raza = c.id and a.id_color = d.id and e.id = a.id_usuario and d.nombre = '"
								+ toSearch + "' and id_usuario = " + id_usuario + " ORDER BY id");
				query = connectionDB.getConnection().prepareStatement(
						"select a.id, a.nombre as nombre_mascota, b.nombre as nombre_especie, c.nombre as nombre_raza, d.nombre as nombre_color, a.anio_nacimiento as anio_nacimiento from mascota a, especie b, raza c, color d, usuario e where a.id_especie = b.id and a.id_raza = c.id and a.id_color = d.id and e.id = a.id_usuario and a.anio_nacimiento = '"
								+ toSearch + "' and id_usuario = " + id_usuario + " ORDER BY id");
				res = query.executeQuery();
				while (res.next()) {
					Pet pet = new Pet();
					pet.setId(res.getInt("id"));
					pet.setName(res.getString("nombre_mascota"));
					pet.setName_specie(res.getString("nombre_especie"));
					pet.setName_race(res.getString("nombre_raza"));
					pet.setName_color(res.getString("nombre_color"));
					pet.setDate_bird(res.getDate("anio_nacimiento"));
					arrayPet.add(pet);
				}
				res.close();
				query.close();
			}

			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPet;

	}

	public ArrayList<Pet> infoPet(int id_usuario) {
		ArrayList<Pet> arrayPets = new ArrayList<Pet>();
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection().prepareStatement(
					"SELECT * FROM mascota WHERE id_usuario =" + id_usuario + " and estado = 'A' ORDER BY id");
			ResultSet res = query.executeQuery();
			while (res.next()) {
				Pet pet = new Pet();
				pet.setId(res.getInt("id"));
				pet.setName(res.getString("nombre"));
				int id_specie = res.getInt("id_especie");
				PreparedStatement query2 = connectionDB.getConnection()
						.prepareStatement("SELECT nombre FROM especie WHERE id = " + id_specie + " and estado = 'A'");
				ResultSet res2 = query2.executeQuery();
				while (res2.next()) {
					pet.setName_specie(res2.getString("nombre"));
				}
				int id_race = res.getInt("id_raza");
				PreparedStatement query3 = connectionDB.getConnection()
						.prepareStatement("SELECT nombre FROM raza WHERE id = " + id_race + "and id_especie = "
								+ id_specie + " and estado = 'A'");
				ResultSet res3 = query3.executeQuery();
				while (res3.next()) {
					pet.setName_race(res3.getString("nombre"));
				}

				int id_color = res.getInt("id_color");
				PreparedStatement query4 = connectionDB.getConnection()
						.prepareStatement("SELECT nombre FROM color WHERE id = " + id_color + " and estado = 'A'");
				ResultSet res4 = query4.executeQuery();
				if (res4.next()) {
					pet.setName_color(res4.getString("nombre"));
				}
				pet.setDate_bird(res.getDate("anio_nacimiento"));
				arrayPets.add(pet);

				res2.close();
				query2.close();
				res2.close();
				query2.close();
				res2.close();
				query2.close();
			}
			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPets;

	}

	public ArrayList<String> speciesComboBox() {
		ArrayList<String> petSpecies = new ArrayList<String>();
		try {
			connectionDB.DBConection();
			PreparedStatement pst = connectionDB.getConnection().prepareStatement("SELECT nombre FROM especie");
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				petSpecies.add(res.getString("nombre"));
			}

			res.close();
			connectionDB.DBClose();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return petSpecies;

	}

	public ArrayList<String> raceComboBox(int id_especie) {
		ArrayList<String> petRaces = new ArrayList<String>();
		petRaces.clear();
		try {
			connectionDB.DBConection();
			PreparedStatement pst = connectionDB.getConnection()
					.prepareStatement("SELECT nombre FROM raza WHERE id_especie = " + id_especie);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				petRaces.add(res.getString("nombre"));
			}

			res.close();
			connectionDB.DBClose();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return petRaces;

	}

	public ArrayList<String> colorComboBox() {
		ArrayList<String> petColors = new ArrayList<String>();
		petColors.clear();
		try {
			connectionDB.DBConection();
			PreparedStatement pst = connectionDB.getConnection().prepareStatement("SELECT nombre FROM color");
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				petColors.add(res.getString("nombre"));
			}

			res.close();
			connectionDB.DBClose();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return petColors;

	}

	public ArrayList<Pet> infoPetsUsers() {
		ArrayList<Pet> arrayPets = new ArrayList<Pet>();
		connectionDB.DBConection();
		try {
			PreparedStatement query = connectionDB.getConnection().prepareStatement(
					"select a.id, a.nombre as nombre_mascota, b.nombre as nombre_especie, c.nombre as nombre_raza, d.nombre as nombre_color, a.anio_nacimiento, a.id_usuario, e.nombre_usuario from mascota a, especie b, raza c, color d, usuario e where a.id_especie = b.id and a.id_raza = c.id and a.id_color = d.id and e.id = a.id_usuario and a.estado = 'A' ORDER BY id");
			ResultSet res = query.executeQuery();
			while (res.next()) {
				Pet pet = new Pet();
				pet.setId(res.getInt("id"));
				pet.setId_user(res.getInt("id_usuario"));
				pet.setName(res.getString("nombre_mascota"));
				pet.setName_specie(res.getString("nombre_especie"));
				pet.setName_race(res.getString("nombre_raza"));
				pet.setName_color(res.getString("nombre_color"));
				pet.setDate_bird(res.getDate("anio_nacimiento"));
				pet.setName_user(res.getString("nombre_usuario"));

				arrayPets.add(pet);

			}

			res.close();
			query.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPets;

	}

	public boolean deleteFromAdmin(Pet pet) {
		boolean verificar = false;
		connectionDB.DBConection();
		try {

			Statement smt = connectionDB.getConnection().createStatement();
			smt.executeUpdate("UPDATE mascota SET nombre = '" + pet.getName() + "', id_especie = "
					+ "(SELECT id FROM especie WHERE nombre = '" + pet.getName_specie() + "')" + ", id_raza = "
					+ "(SELECT id FROM raza WHERE nombre = '" + pet.getName_race() + "')" + ", id_color = "
					+ "(SELECT id FROM color WHERE nombre = '" + pet.getName_color() + "')" + ", anio_nacimiento = '"
					+ pet.getDate_bird() + "', estado = 'I' WHERE id_usuario = " + pet.getId_user() + " and id = "
					+ pet.getId());
			verificar = true;
			smt.close();
			connectionDB.DBClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}

}
