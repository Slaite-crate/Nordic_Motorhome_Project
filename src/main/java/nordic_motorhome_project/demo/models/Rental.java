package nordic_motorhome_project.demo.models;

import java.sql.Date;

public class Rental {
    private int rentalId;
    private String regNr;
    private String brand;
    private String model;
    private Date pickupDate;
    private Date dropoffDate;

    public Rental(int rentalId, String regNr, String brand, String model, Date pickupDate, Date dropoffDate) {
        this.rentalId = rentalId;
        this.regNr = regNr;
        this.brand = brand;
        this.model = model;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
}
