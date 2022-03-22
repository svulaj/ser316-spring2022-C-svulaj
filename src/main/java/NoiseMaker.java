package main.java;

public class NoiseMaker {
    public double price;
    //Never read/never used, removing from class
    //String label;
    //Never read/never used, removing from class
    //String recording;

    Location spot;

    public NoiseMaker() {
        this("Default Noise", "I wuv you", Location.CENTERBODY);
    }

    /**
     * Description: constructor that takes in said params.
     * @param label Is what's written on the bear.
     * @param recording Is what the bear says.
     * @param location Is the location where the recording is on the bear.
     */
    public NoiseMaker(String label, String recording, Location location) {
        //this.label = label;
        //this.recording = recording;
        this.spot = location;
        switch (location) {
            // you can assume that the price given here for the noisemakers is correct
            case CENTERBODY:
                this.price = 10;
                break;
            default:
                this.price = 5;
                break;
        }
    }

    public enum Location {
        RIGHT_HAND, LEFT_HAND, RIGHT_FOOT, LEFT_FOOT, CENTERBODY
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Location getSpot() {
        return spot;
    }

    public void setSpot(Location spot) {
        this.spot = spot;
    }
    
}
