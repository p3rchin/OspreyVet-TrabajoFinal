package co.edu.unbosque.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Username {

	private int id;
	private short typeuser_id;
	private String username;
	private String password;
	private String names;
	private String lastnames;
	private String num_cedula;
	private String age;
	private String address;
	private char state;

	public Username() {

	}

	public Username(short typeuser_id, String username, String password, String names, String lastnames,
			String num_cedula, String age, String address, char state) {

		this.typeuser_id = typeuser_id;
		this.username = username;
		this.password = password;
		this.names = names;
		this.lastnames = lastnames;
		this.num_cedula = num_cedula;
		this.age = age;
		this.address = address;
		this.state = state;
	}
	
	

	public Username(int id, short typeuser_id, String username, String password, String names, String lastnames,
			String num_cedula, String age, String address, char state) {
		super();
		this.id = id;
		this.typeuser_id = typeuser_id;
		this.username = username;
		this.password = password;
		this.names = names;
		this.lastnames = lastnames;
		this.num_cedula = num_cedula;
		this.age = age;
		this.address = address;
		this.state = state;
	}

	public Username(String username, String password, String names, String lastnames, String num_cedula, String age,
			String address) {

		this.username = username;
		this.password = password;
		this.names = names;
		this.lastnames = lastnames;
		this.num_cedula = num_cedula;
		this.age = age;
		this.address = address;
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

	public boolean onlyNumbers(String number) {
		for (int i = 0; i < number.length(); i++) {
			char aux = number.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean correctNumber(String phoneNumber) {
		if (phoneNumber.length() == 10) {
			return true;
		}
		return false;
	}

	public boolean correctPassword(String password) {
		if (password.length() < 8) {
			return false;
		}
		return true;
	}

	public boolean correctCedula(String cedulaNumber) {
		if (this.onlyNumbers(cedulaNumber)) {
			if (cedulaNumber.length() == 10) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	public boolean correctAge(String age) {
		int ageC = Integer.parseInt(age);
		if (ageC >= 18) {
			return true;
		}
		return false;
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

	public String encrypt(String password) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();

		for (byte b : hash) {
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
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
	 * @return the typeuser_id
	 */
	public short getTypeuser_id() {
		return typeuser_id;
	}

	/**
	 * @param typeuser_id the typeuser_id to set
	 */
	public void setTypeuser_id(short typeuser_id) {
		this.typeuser_id = typeuser_id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the names
	 */
	public String getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}

	/**
	 * @return the lastnames
	 */
	public String getLastnames() {
		return lastnames;
	}

	/**
	 * @param lastnames the lastnames to set
	 */
	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	/**
	 * @return the num_cedula
	 */
	public String getNum_cedula() {
		return num_cedula;
	}

	/**
	 * @param num_cedula the num_cedula to set
	 */
	public void setNum_cedula(String num_cedula) {
		this.num_cedula = num_cedula;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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