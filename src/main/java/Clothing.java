package main.java;

public class Clothing implements Comparable<Clothing> {
    public double price;
    //changed to lowercase
    // never used, never read, useless so we remove it
//    public String description;

    // you can assume that the price of $4 per clothing item is correct
    public Clothing() {
        this(4.00, "Generic Offtrack Separate");

    }

    public Clothing(double price, String descr) {
        this.price = price;
        //Useless field. Never read.
//        this.description = descr;
    }

    public int compareTo(Clothing clothes) {
        if (clothes.price > this.price) {
            return 1;//Made change to double.compare instead of just compare
        } else if (Double.compare(clothes.price, this.price) <= -1) {  
            return -1;
        } else {
            return 0;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        return o == this;
    }
    
    public double getPrice() {
        return this.price;
    }
}
