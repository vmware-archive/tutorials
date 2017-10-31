package daleco.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.io.*;

public class DaleCoDatabase {
	private Connection connection = null;

	public Connection getConnection() {
		return this.connection;
	}
	
	public DaleCoDatabase() throws Exception {
		try {
			DatabaseConfig dbconfig = null;

			DatabaseGetPropertyValues dbpropvalues = new DatabaseGetPropertyValues();
	
			dbconfig =dbpropvalues.getPropValues();
			System.out.println("User: " + dbconfig.GetUser());
			System.out.println("Password: " + dbconfig.GetPassword());
			System.out.println("Host: " + dbconfig.GetHost());
			
			System.out.println("Initializing database driver ...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to Database");
			String constring = "jdbc:mysql://" + dbconfig.GetHost() + "/?user=" + dbconfig.GetUser() + "&password=" + dbconfig.GetPassword();
			System.out.println("Connection String:" + constring);
			connection = DriverManager.getConnection(constring);
            if(connection != null) {
            		System.out.println("Database Connected");
            }
            else {
            		System.out.println("Database NOT Connected");
            }
            
		} catch (Exception e) {
			throw(e);
		}
	}
	
	public void create() throws Exception {
		PreparedStatement statement = null;
		try {
			System.out.println("Creating Database");
			statement = this.connection
                    .prepareStatement("CREATE DATABASE inventory;");
			statement.execute();
			
			
			System.out.println("Creating table: Products");
			statement.close();
			statement = connection.prepareStatement("CREATE TABLE inventory.products (product_id int not NULL primary key, description CHAR (200), image_name CHAR(200));");
			statement.execute();
			statement.close();
			
			System.out.println("Loading data");
			try {
	            InputStream is = getClass().getClassLoader().getResourceAsStream("products.csv");
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	            String line = null;
	            
	            Statement batchStatment = connection.createStatement();
	            while((line = bufferedReader.readLine()) != null) {
	                String[] d = line.split(",");
	                String sql = "INSERT INTO inventory.products VALUES('" + d[0] + "','" + d[1] + "','" + d[2] + "')";
	                System.out.println("Adding: " + sql);
	                batchStatment.addBatch(sql);
	            } 
	            
	            bufferedReader.close(); //TODO: Move this to a finally block
	            
	            batchStatment.executeBatch();
	            batchStatment.close();
	            
			} catch(FileNotFoundException e) {
				System.out.println("Data file not found");
				e.printStackTrace();
			}catch(IOException e) {
	            e.printStackTrace();
	        }
			
		} catch (Exception e) {
			throw(e);
		} 
		finally {
			if (statement != null) {
                statement.close();
            }
		}
	}
	
	public boolean dbExsits(){
	    try{

	        ResultSet resultSet = connection.getMetaData().getCatalogs();

	        while (resultSet.next()) {
	          String databaseName = resultSet.getString(1);
	            if(databaseName.equals("inventory")){
	                return true;
	            }
	        }
	        resultSet.close();
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }

	    return false;
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
