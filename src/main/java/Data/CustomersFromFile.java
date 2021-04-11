package Data;

import Engine.ReadDelimitedFile;

import java.util.ArrayList;
import java.util.List;

public class CustomersFromFile implements Customers {
    List<Customer> listOfCustomers = new ArrayList<>();

    public List<Customer> getAllCustomers(){
        ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
        List<String[]> fileData = readDelimitedFile.getFileData("customer.csv");
        addToList(fileData);
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
