package nordic_motorhome_project.demo.models;

import java.sql.Date;

public class Rental {
    private int rentalId;
    private int cusomterId;
    private int motorhomeId;
    private Date pickupDate;
    private Date dropoffDate;

    public Rental(int rentalId, int cusomterId, int motorhomeId, Date pickupDate, Date dropoffDate) {
        this.rentalId = rentalId;
        this.cusomterId = cusomterId;
        this.motorhomeId = motorhomeId;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getCusomterId() {
        return cusomterId;
    }

    public void setCusomterId(int cusomterId) {
        this.cusomterId = cusomterId;
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

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
}
