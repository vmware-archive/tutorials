package hello;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
	@Autowired
	private CustomerRepository repository;

    @RequestMapping(value="/")
    public String index(Map<String, Object> model) {
        String result = "";
        for (Customer customer : repository.findAll()) {
            result += customer.toHTMLTable();
        }
        model.put("customers", result);
        return "list";
    }

    @RequestMapping(value="/resetdata")
    public String resetdata() {
    	repository.deleteAll();
		// save a couple of customers as test data
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
        return "forward:/";
    }

    @RequestMapping(value="/new")
    public String newCustomer(@RequestParam("firstName") String firstName, 
        @RequestParam("lastName") String lastName, 
        @RequestParam(value="email", required=false) String email) {
        repository.save(new Customer(firstName, lastName, email));
        return "forward:/";
    }
}

