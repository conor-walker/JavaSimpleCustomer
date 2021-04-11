import java.util.ArrayList;
import java.util.List;

public class CustomersFromStub implements Customers {
    List<Customer> listOfCustomers = new ArrayList<>();

    public CustomersFromStub(){
        listOfCustomers.add(new Customer("test@test.com","Test","Customer","test"));
    }
    public List<Customer> getAllCustomers(){
        return listOfCustomers;
    }

    private void addToList(List<String[]> customerList){
        for(String[] customer : customerList){
            listOfCustomers.add(arrayToCustomer(customer));
        }
    }

    private Customer arrayToCustomer(String[] customerInfo){
        return new Customer(customerInfo[0],customerInfo[1],customerInfo[2],customerInfo[3]);
    }
}
