package nordic_motorhome_project.demo.models;

import java.sql.Date;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String phoneNumber;
    private String driversLicense;
    private String country;
    private String zipCode;
    private String city;
    private String street;

    public Customer(String firstName, String lastName, Date birthDate, String phoneNumber, String driversLicense, String country, String zipCode, String city, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.driversLicense = driversLicense;
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
    }

    public Customer(int customerId, String firstName, String lastName, Date birthDate, String phoneNumber, String driversLicense, String country, String zipCode, String city, String street) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.driversLicense = driversLicense;
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
    }

    public Customer(){

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
