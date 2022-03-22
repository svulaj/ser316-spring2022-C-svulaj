package main.java;

public class Stuffing {
    // changed stuffing to Stuffs
    public enum Stuffs {
        BASE, DOWN, FOAM
    }
//    Never used, never read. Removing
//    Stuffs polyStuffing;
    int price;

    /**
     * Description: constructor for stuffing.
     * @param interiorStuffing Is what the stuffing material is.
     */
    public Stuffing(Stuffs interiorStuffing) {

        switch (interiorStuffing) {
            case BASE:
                //this.polyStuffing = Stuffs.BASE;
                this.price = 30;
                break;
            case DOWN:
                //this.polyStuffing = Stuffs.DOWN;
                this.price = 40;
                break;
            case FOAM:
                //this.polyStuffing = Stuffs.FOAM;
                this.price = 50;
                break;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
