package co.edu.unbosque.model;

import java.util.Date;

public class Pet {

	private int id;
	private int id_user;
	private String name;
	private int id_specie;
	private String name_specie;
	private int id_race;
	private String name_race;
	private int id_color;
	private String name_color;
	private Date date_bird;
	private char state;
	private String name_user;

	public Pet() {

	}

	public Pet(int id_user, String name, int id_specie, int id_race, int id_color, Date date_bird) {
		this.id_user = id_user;
		this.name = name;
		this.id_specie = id_specie;
		this.id_race = id_race;
		this.id_color = id_color;
		this.date_bird = date_bird;
	}

	public Pet(int id_user, String name, String name_specie, String name_race, String name_color, Date date_bird) {
		this.id_user = id_user;
		this.name = name;
		this.name_specie = name_specie;
		this.name_race = name_race;
		this.name_color = name_color;
		this.date_bird = date_bird;
	}

	public Pet(int id_user, String name, String name_specie, String name_race, int id_color, Date date_bird) {
		this.id_user = id_user;
		this.name = name;
		this.name_specie = name_specie;
		this.name_race = name_race;
		this.id_color = id_color;
		this.date_bird = date_bird;
	}
	
	
	public Pet(int id_user, String name, String name_specie, String name_race, int id_color, Date date_bird, String name_user) {
		this.id_user = id_user;
		this.name = name;
		this.name_specie = name_specie;
		this.name_race = name_race;
		this.id_color = id_color;
		this.date_bird = date_bird;
		this.name_user = name_user;
	}

	public Pet(int id, int id_user, String name, int id_specie, String name_race, int id_color, Date date_bird) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.name = name;
		this.id_specie = id_specie;
		this.name_race = name_race;
		this.id_color = id_color;
		this.date_bird = date_bird;
	}

	public boolean onlyLettersAndNumbers(String chair) {
		for (int i = 0; i < chair.length(); i++) {
			char aux = chair.charAt(i);
			if (aux == '@' || aux == '#' || aux == '%' || aux == 'º' || aux == '|' || aux == '!' || aux == '"'
					|| aux == '·' || aux == '$' || aux == '&' || aux == '/' || aux == '(' || aux == ')' || aux == '='
					|| aux == '?' || aux == '¿' || aux == '¡' || aux == '`' || aux == '^' || aux == '[' || aux == '+'
					|| aux == '*' || aux == ']' || aux == '´' || aux == '{' || aux == 'ç' || aux == '}' || aux == ','
					|| aux == '-' || aux == '>' || aux == '<') {
				return false;
			}
		}
		return true;
	}

	public boolean onlyLetters(String chair) {
		for (int i = 0; i < chair.length(); i++) {
			char auxiliar = chair.charAt(i);
			if (auxiliar == '0' || auxiliar == '1' || auxiliar == '2' || auxiliar == '3' || auxiliar == '4'
					|| auxiliar == '5' || auxiliar == '6' || auxiliar == '7' || auxiliar == '8' || auxiliar == '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return the name_user
	 */
	public String getName_user() {
		return name_user;
	}

	/**
	 * @param name_user the name_user to set
	 */
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	/**
	 * @return the name_specie
	 */
	public String getName_specie() {
		return name_specie;
	}

	/**
	 * @param name_specie the name_specie to set
	 */
	public void setName_specie(String name_specie) {
		this.name_specie = name_specie;
	}

	/**
	 * @return the name_race
	 */
	public String getName_race() {
		return name_race;
	}

	/**
	 * @param name_race the name_race to set
	 */
	public void setName_race(String name_race) {
		this.name_race = name_race;
	}

	/**
	 * @return the name_color
	 */
	public String getName_color() {
		return name_color;
	}

	/**
	 * @param name_color the name_color to set
	 */
	public void setName_color(String name_color) {
		this.name_color = name_color;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id_user
	 */
	public int getId_user() {
		return id_user;
	}

	/**
	 * @param id_user the id_user to set
	 */
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id_space
	 */
	public int getId_specie() {
		return id_specie;
	}

	/**
	 * @param id_specie the id_specie to set
	 */
	public void setId_specie(int id_specie) {
		this.id_specie = id_specie;
	}

	/**
	 * @return the id_race
	 */
	public int getId_race() {
		return id_race;
	}

	/**
	 * @param id_race the id_race to set
	 */
	public void setId_race(int id_race) {
		this.id_race = id_race;
	}

	/**
	 * @return the id_color
	 */
	public int getId_color() {
		return id_color;
	}

	/**
	 * @param id_color the id_color to set
	 */
	public void setId_color(int id_color) {
		this.id_color = id_color;
	}

	/**
	 * @return the date_bird
	 */
	public Date getDate_bird() {
		return date_bird;
	}

	/**
	 * @param date_bird the date_bird to set
	 */
	public void setDate_bird(Date date_bird) {
		this.date_bird = date_bird;
	}

	/**
	 * @return the state
	 */
	public char getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(char state) {
		this.state = state;
	}

}