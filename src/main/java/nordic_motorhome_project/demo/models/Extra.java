package nordic_motorhome_project.demo.models;

public class Extra {

    private int extraId;
    private String item;
    private double price;

    public Extra(int extraId, String item, double price) {
        this.extraId = extraId;
        this.item = item;
        this.price = price;
    }

    public Extra() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getExtraId() {
        return extraId;
    }

    public void setExtraId(int extraId) {
        this.extraId = extraId;
    }
}
