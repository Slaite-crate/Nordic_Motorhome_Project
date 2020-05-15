package nordic_motorhome_project.demo.models;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String cpr;
    private String phoneNumber;
    private String driversLicense;

    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, String address, String cpr, String phoneNumber, String driversLicense) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cpr = cpr;
        this.phoneNumber = phoneNumber;
        this.driversLicense = driversLicense;
    }

    public Customer(String firstName, String lastName, String address, String cpr, String phoneNumber, String driversLicense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cpr = cpr;
        this.phoneNumber = phoneNumber;
        this.driversLicense = driversLicense;
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

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
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
                ", driversLicence='" + driversLicense + '\'' +
                '}';
    }
}
