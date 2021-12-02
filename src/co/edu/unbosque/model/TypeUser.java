package co.edu.unbosque.model;

public class TypeUser {

	private int id;
	private String name;
	private char state;

	public TypeUser() {

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