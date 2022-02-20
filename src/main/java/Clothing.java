package main.java;

/**
Class: Clothing

Description: This class is designed to be able to hold the information associated
			 with clothing articles for the bears customers with to add.
			 main features are: creating clothing & comparing clothing.
*/

public class Clothing implements Comparable<Clothing> {
    public double price;
    public String Description;

    //  you can assume that the price of $4 per clothing item is correct
    public Clothing() {
        this(4.00, "Generic Offtrack Separate");

    }

    public Clothing(double price, String descr) {
        this.price = price;
        this.Description = descr;
    }

    public int compareTo(Clothing clothes) {
        if (clothes.price > this.price) {
            return 1;
        } else if (clothes.price < this.price) {
            return -1;
        } else {
            return 0;
        }
    }
}
