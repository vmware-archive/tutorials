package hello;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@javax.persistence.Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    public String firstName;
    public String lastName;
    public String email;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, "");
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%i, firstName='%s', lastName='%s', email='%s']",
                id, firstName, lastName, email);
    }
    
    public String toHTMLTable() {
        return String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", firstName, lastName, email, id);
    }
}

