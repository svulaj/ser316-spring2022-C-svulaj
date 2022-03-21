package main.java;

import main.java.Stuffing.Stuffs;
import java.util.LinkedList;

public class Bear implements Comparable<Bear> {
    public Casing casing;
    public Stuffing stuff;
    public Embroidery ink;
    public LinkedList<NoiseMaker> noisemakers; // accessory
    public LinkedList<Clothing> clothing; // accessory
    public double price;
    // bear has a shell (requ)
    // bear has stuffing (req)
    // bear has a tattoo/emroider or not (opt)
    // bear has a noisemaker (opt)

    /**
     * Bear object constructor. This creates a basic bear with. 
     */
    public Bear() {
        this.casing = new Casing();
        this.stuff = new Stuffing(Stuffs.BASE);
        noisemakers = new LinkedList<>();
        clothing = new LinkedList<>();
        ink = new Embroidery("");
        price = 0;
    }
    /**
     * bear constructor with option for stuffing input.
     * 
     * @param stuff is the stuffing you put in the bear.
     */
    public Bear(Stuffs stuff) {
        this.casing = new Casing();
        this.stuff = new Stuffing(stuff);
        noisemakers = new LinkedList<>();
        clothing = new LinkedList<>();
        ink = new Embroidery("");
        price = 0;
    }

    public void setPrice(double incomingPrice) {
        this.price = incomingPrice;
    }

    /**
     * Description: adds a noisemaker.
     * @param noise Is the sound the noisemaker makes.
     * @return Returns true if the spot is not taken.
     */
    public boolean addNoise(NoiseMaker noise) {
        if (this.noisemakers.size() >= 5) {
            return false;
        } else {
            for (NoiseMaker noisemaker : noisemakers) {
                if (noise.spot == noisemaker.spot) {
                    return false;
                }
            }
            noisemakers.add(noise);
            return true;
        }
    }
    // Compare method now is able to do a proper price comparison
    @Override
    public int compareTo(Bear bear) {
        if (this.price < bear.price) {
            return 1;//Made change to double.compare instead of just compare
        } else if (Double.compare(this.price,bear.price) <= -1) {  
            return -1;
        } else {
            return 0;
        }
    }
    // Added a new equals method to override the java library equals method to fit our needs
    @Override
    public boolean equals(Object o) {
        return o == this;
    }
}