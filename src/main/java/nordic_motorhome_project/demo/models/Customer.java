package nordic_motorhome_project.demo.models;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String cpr;
    private String phoneNumber;
    private String driversLicence;

    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, String address, String cpr, String phoneNumber, String driversLicence) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cpr = cpr;
        this.phoneNumber = phoneNumber;
        this.driversLicence = driversLicence;
    }

    public Customer(String firstName, String lastName, String address, String cpr, String phoneNumber, String driversLicence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cpr = cpr;
        this.phoneNumber = phoneNumber;
        this.driversLicence = driversLicence;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDriversLicence() {
        return driversLicence;
    }

    public void setDriversLicence(String driversLicence) {
        this.driversLicence = driversLicence;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", customerId=" + customerId +
                ", cpr='" + cpr + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", driversLicence='" + driversLicence + '\'' +
                '}';
    }
}
