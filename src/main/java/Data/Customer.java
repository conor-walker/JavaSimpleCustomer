package Data;

public class Customer {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;

    public Customer(String emailAddress, String firstName, String lastName, String password){
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }

    public String getPassword(){
        return this.password;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }
}
