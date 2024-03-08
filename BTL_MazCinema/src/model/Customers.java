package model;

public class Customers {
    private String customerId;
    private Accounts accounts;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    public Customers() {
        accounts = new Accounts();
    }

    public Customers(String customerId, Accounts accounts, String firstName, String lastName, String email, String address) {
        accounts = new Accounts();
        this.customerId = customerId;
        this.accounts = accounts;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
