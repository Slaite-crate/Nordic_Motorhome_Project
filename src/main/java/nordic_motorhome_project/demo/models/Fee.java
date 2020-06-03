package nordic_motorhome_project.demo.models;


public class Fee { // Natali
    private int feeId;
    private String fee;
    private double price;

    public Fee (int feeId, String fee, double price){
        this.feeId = feeId;
        this.fee = fee;
        this.price = price;
    }

    public Fee (String fee, double price){
        this.fee = fee;
        this.price = price;
    }

    public Fee(){

    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
