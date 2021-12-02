package co.edu.unbosque.model;

public class Phone {

	private int id;
	private int id_usuario;
	private String phone_number;
	private char state;

	public Phone() {

	}

	public Phone(String phone_number, char state) {

		this.phone_number = phone_number;
		this.state = state;
	}

	public Phone(String phone_number) {
		this.phone_number = phone_number;
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
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
