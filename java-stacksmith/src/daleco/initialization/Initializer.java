package daleco.initialization;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daleco.database.DaleCoDatabase;

/**
 * Servlet implementation class Initializer
 */
@WebServlet(description = "Initializes the database and other necessary set up", urlPatterns = { "/Initializer" })
public class Initializer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Initializer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init( ) {
    		System.out.println("First run, checking for database ...");
    		try {

			
			DaleCoDatabase db = new DaleCoDatabase();
			
			
			if(db.dbExsits()) {
				System.out.println("Daleco database exists, continuing with initialization.");
			}
			else {
				System.out.println("Daleco database not found, creating ...");
				db.create();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    }
    

}