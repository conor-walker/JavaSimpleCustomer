package Data;

import java.util.ArrayList;
import java.util.List;

public class CustomersFromStub implements Customers {
    List<Customer> listOfCustomers = new ArrayList<>();

    public CustomersFromStub(){
        listOfCustomers.add(new Customer("test@test.com","Test","Data.Customer","test"));
    }

    public List<Customer> getAllCustomers(){
        return listOfCustomers;
    }

    private void register(){
            listOfCustomers.add(new Customer("1","2","3","4"));
    }
}
