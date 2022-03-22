package main.java;

public class Casing {
    double priceModifier;
    //removal of description variable, is never read
    //String description;

    public Casing() {
        this(1.00, "Default outer shell");
    }

    public Casing(double price, String descr) {
        this.priceModifier = price;
        //this.description = descr;
    }
    
    public double getPriceModifier() {
        return priceModifier;
    }
    public void setPriceModifier(double x) {
        priceModifier = x;
    }
}
