package daleco.database;

public class DatabaseConfig {
	private String user = "";
	private String password = "";
	private String host = "";

	public DatabaseConfig(String user, String password, String host) {
		this.user = user;
		this.password = password;
		this.host = host;
	}
	


	public String GetHost() {
		return this.host;
	}
	public String GetUser() {
		return this.user;
	}
	
	public String GetPassword() {
		return this.password;
	}
	
}
