package nordic_motorhome_project.demo.models;

public class Motorhome {

    private int motorhomeId;
    private String regNr;
    private String brand;
    private String model;
    private int seats;
    private int beds;
    private double price;

    public Motorhome() {
    }

    public Motorhome(int motorhomeId, String regNr, String brand, String model, int seats, int beds, double price) {
        this.motorhomeId = motorhomeId;
        this.regNr = regNr;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.beds = beds;
        this.price = price;
    }

    public Motorhome(String regNr, String brand, String model, int seats, int beds, double price) {
        this.regNr = regNr;
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.beds = beds;
        this.price = price;
    }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
