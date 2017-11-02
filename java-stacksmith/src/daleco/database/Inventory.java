package daleco.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Inventory {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inventory() {
    		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public List<DalecoItem> getAllItems() {
		List<DalecoItem> items = new ArrayList<DalecoItem>();
		try {
			DaleCoDatabase db = new DaleCoDatabase();
			Connection connection = db.getConnection();
			connection.setCatalog("inventory");
			
			PreparedStatement statement = connection.prepareStatement("SELECT product_id, description, image_name from inventory.products;");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				DalecoItem i = new DalecoItem();
				i.setDescription(rs.getString("description"));
				i.setId(rs.getInt("product_id"));
				i.setImageName(rs.getString("image_name"));
				items.add(i);
			}
			
			for(int i = 0 ; i < items.size(); ++i) {
				System.out.println(items.get(i));
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
    }
    


}
