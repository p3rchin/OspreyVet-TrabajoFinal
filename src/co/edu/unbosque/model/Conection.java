package co.edu.unbosque.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
	String login = "postgres";
	String password = "12613505Mora";
	String url = "jdbc:postgresql://localhost:5432/ospreyvetlocal";
	private Connection connection;

	public Conection() {

	}

	public void DBConection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, login, password);

			if (connection != null) {
				System.out.println("Connection established");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void DBClose() {
		try {
			connection.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	

}