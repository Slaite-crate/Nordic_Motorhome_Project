package nordic_motorhome_project.demo.models;

import java.sql.Date;

public class Rental {
    private int rental_id;
    private int cusomter_id;
    private int motorhome_id;
    private Date pickup_date;
    private Date dropoff_date;

    public Rental(int rental_id, int cusomter_id, int motorhome_id, Date pickup_date, Date dropoff_date) {
        this.rental_id = rental_id;
        this.cusomter_id = cusomter_id;
        this.motorhome_id = motorhome_id;
        this.pickup_date = pickup_date;
        this.dropoff_date = dropoff_date;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public int getCusomter_id() {
        return cusomter_id;
    }

    public void setCusomter_id(int cusomter_id) {
        this.cusomter_id = cusomter_id;
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public Date getDropoff_date() {
        return dropoff_date;
    }

    public void setDropoff_date(Date dropoff_date) {
        this.dropoff_date = dropoff_date;
    }
}
