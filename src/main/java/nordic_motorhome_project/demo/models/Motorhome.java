package nordic_motorhome_project.demo.models;

public class Motorhome {

    private int id;
    private String regNr;
    private String brand;
    private String model;
    private double price;


    public Motorhome(int id, String regNr, String brand, String model, double price) {
        this.id = id;
        this.regNr = regNr;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Motorhome(String regNr, String brand, String model, double price) {
        this.regNr = regNr;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Motorhome() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Motorhome{" +
                "id=" + id +
                ", regNr='" + regNr + '\'' +
                ", brand='" + brand + '\'' +
                ", model=" + model +
                ", price='" + price + '\'' +
                '}';
    }
}
