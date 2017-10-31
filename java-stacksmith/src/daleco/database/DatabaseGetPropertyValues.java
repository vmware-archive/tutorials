package daleco.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseGetPropertyValues {
	DatabaseConfig dbconfig = null;
	InputStream inputStream;
 
	public DatabaseConfig getPropValues() throws IOException {
		try {
			Properties prop = new Properties();
			String propFileName = "database.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			String host = prop.getProperty("host");
 
			dbconfig = new DatabaseConfig(user, password, host);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return dbconfig;
	}

}
