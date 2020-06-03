package nordic_motorhome_project.demo.models;

import java.sql.Date;

public class Rental { //Pelle
    private int rentalId;
    private int customerId;
    private int motorhomeId;
    private Date pickupDate;
    private Date dropoffDate;

    public Rental() {
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
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

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", customerId=" + customerId +
                ", motorhomeId=" + motorhomeId +
                ", pickupDate=" + pickupDate +
                ", dropoffDate=" + dropoffDate +
                '}';
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
}
