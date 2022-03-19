package main.java;

import java.util.*;

// This class provides functionality for a BearWorkshop class.
public class BearWorkshop implements BearWorkshopInterface {
    // Workshop has a collection of bears
    // Workshop has a customer
    private Customer customer;
    List<Bear> BearCart;

    /**
     * Default constructor for the Bear Workshop.
     */
    public BearWorkshop() {
        this("AZ");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * This is a parameterized constructor for a BearWorkshop.
     * 
     * @param state customer is in
     */
    public BearWorkshop(String state) {
        BearCart = new LinkedList<>();
        setCustomer(new Customer(state));
    }

    /**
     * This is a convenience method to calculate the cost of one bears in the
     * shopping cart for a customer in the BearFactory. It should take the accessory
     * discounts into account correctly.
     * 
     * @param bear to get cost of
     * @return double representation of bear cost TODO: Done.
     */

    @Override
    public double getCost(Bear bear) {
        Collections.sort(bear.clothing);
        int numFree = bear.clothing.size() / 3;
        ArrayList<Clothing> freeClothes = new ArrayList<>();

        for (int i = 0; i < bear.clothing.size(); i++) {
            Clothing clothes = bear.clothing.get(i);
            if (i < numFree) {
                freeClothes.add(clothes);
            } else {
                bear.price += clothes.price;
            }
        }

        for (NoiseMaker noise : bear.noisemakers) {
            bear.price += noise.price;
        }

        if (bear.ink != null) {
            bear.price += bear.ink.price;
        }

        bear.price += bear.stuff.price;
        bear.price += bear.casing.priceModifier;

        return bear.price;
    }

    // Function to get the raw cost of a bear without any discounts
    // TODO: Done.
    public double getRawCost(Bear bear) {
        // bear.price = 0;
        for (int i = 0; i < bear.clothing.size(); i++) {
            Clothing clothes = bear.clothing.get(i);
            bear.price += clothes.price;

        }

        for (NoiseMaker noise : bear.noisemakers) {
            bear.price += noise.price;
        }

        if (bear.ink != null) {
            bear.price += bear.ink.price;
        }

        bear.price += bear.stuff.price;
        bear.price += bear.casing.priceModifier;

        double bearPrice = bear.price;
        bear.price = 0;
        return bearPrice;
    }

    /**
     * Utility method to calculate tax for purchases by customers in different
     * states. You can assume these taxes are what we want, so they are not wrong.
     * 
     * @return
     */
    public double calculateTax() {
        double tax;
        switch (getCustomer().state) {
            case "AZ":
                tax = 1.07;
                break;
            case "NY":
                tax = 1.09;
                break;
            case "VA":
                tax = 1.05;
                break;
            case "DC":
                tax = 1.105;
                break;
            case "CA":
                tax = 1.1;
                break;
            default:
                tax = 1.05;
                break;
        }
        return tax;
    }

    /**
     * Utility method to add a bear to the BearFactory - so ti the shopping cart.
     * 
     * @param bear to add
     * @return true if successful, false otherwise TODO: Done.
     */
    @Override
    public boolean addBear(Bear bear) {
        this.BearCart.add(bear);
        return true;

    }

    // Simple means to remove a bear from the shopping cart
    @Override
    public boolean removeBear(Bear bear) {
        if (this.BearCart.remove(bear)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This is a function to allow customers to checkout their shopping cart It
     * should return the total cost of they purchase. TODO: Done.
     * 
     * @return
     */
    @Override
    public double checkout() {
        double tax = 0;

        // Checks age of customer(child) & customer(Parent)
        if (this.getCustomer().age <= 13) {
            if (this.getCustomer().getParent().age < 18) {
                System.out.println("Guardian is too young");
            }
            return -1;
        }

        // Accumulates cost of all bears in said customers cart.
        // Also, accumulates taxes on all bears within the cart.
        double cost = 0;
        double savings = 0;
        for (Bear bear : this.BearCart) {
            tax += this.calculateTax();
            cost += this.getRawCost(bear);
            // savings = this.calculateSavings();
        }

        // Grabs all savings of the bears from said customers cart.
        savings = this.calculateSavings();
        // subtracts the savings from the bears.
        cost = cost - savings;
        // adds tax to cost of the bears and returns the carts checkout value.
        return cost + tax;
    }
    // Collections.sort(this.bearCart.get(i).clothing);

    /**
     * This method returns the savings for advertised bundle savings. Specifically,
     * - Bears are Buy 2 bears, get a third one free. It is always the cheapest bear
     * that is free. The price here is meant when all discounts for a single bear
     * are applied
     * 
     * - It is 10% off the cost of a bear when a single bear has 10 or more
     * accessories (anything on a bear is an accessory) that the customer pays for
     * (so if clothes are free these do not count).
     * 
     * - Clothes are buy 2, get one free on each bear. Always the cheapest clothes
     * are free. So if a bear has 6 clothes, then the two cheapest ones will be free
     * and it would count as 4 accessories (see above).
     * 
     * - Inking on a specific bear is free if and only if the bear without discounts
     * applied to it costs more than $70.
     * 
     * TIP: the implemented savings method in the BearWorkshop1-5 do not use the
     * getCost method implemented in this base class. They implement their own
     * savings calculation All of them do however use the getRawCost method
     * implemented in this base class. EXAMPLE: You buy 3 bears, one bear has 3
     * clothing items, the other two have 4 clothing items. Non of them have
     * embroidery or noise makers and they have the same stuffing. Now, on each bear
     * one clothing item will be free, since buy 2 get 1 free on a bear. So for
     * costs we have the bear with stuffing. For one we pay only 2 clothing items,
     * for 2 we still pay for 3 clothing items. Since all clothing is the same price
     * the bear with only 2 paid clothing items is cheapest. So we will get that
     * bear for free. We will only have to pay for 2 bears, with 3 clothing items
     * each.
     * 
     * @return the savings if the customer would check with the current bears in the
     *         workshop out as double
     */
    public double calculateSavings() {
        double totalSavings = 0;
        int count = 0;
        int numOfClothes = 0;

        double embroiderySize = 0;
        double totalAccessories = 0;

        // calculate the 10% savings of bears that have more than 10 accessories
        double noiseMakerSize;
        // double clothingSize;
//==========================================================
//=============================================
        // calculates the savings of clothing
        // loops through bears
        for (int i = 0; i < this.BearCart.size(); i++) {
            // this is the variable that resets the savings of individual bear as each bear
            // is come across
            double indivSavings = 0.0;

            // test spot
            embroiderySize = 0;
            totalAccessories = 0;

            numOfClothes = 0;

            Collections.sort(this.BearCart.get(i).clothing);

            // loops through clothing list of each bear
            for (int j = 0; j < this.BearCart.get(i).clothing.size(); j++) {

                // prints all of the prices of all articles of clothing for a particular bear
                System.out.println(this.BearCart.get(i).clothing.get(j).price);

                totalAccessories++;

                // this counts how many groups of three there are in the clothing list for an
                // individual bear
                numOfClothes++;
                if (numOfClothes % 3 == 0) {
                    totalAccessories--;
                    count++;
                    int lastIdx = this.BearCart.get(i).clothing.size() - count;
                    // System.out.println("Last index: " + lastIdx);
                    indivSavings += this.BearCart.get(i).clothing.get(lastIdx).price;

                    // prints the price of the clothing that is going to be added to totalSavings
                    System.out.println("individual savings for a bear is = " + indivSavings);
                }
            }
            // adds the savings found to the total-saving calculations
            totalSavings += indivSavings;
            System.out.println("total savings = " + totalSavings);
            System.out.println("===========================================================");
            // Sets the cost of a bear with
            // this.BearCart.get(i).setPrice(this.getRawCost(BearCart.get(i)) -
            // indivSavings);
//==============================================
//=========================================================
            // Embroidery discount section

            // If a embroidery exists
            if (!this.BearCart.get(i).ink.embroidText.equals("")) {
                totalAccessories++;
            }

            if (this.getRawCost(BearCart.get(i)) > 70) {

                embroiderySize = this.BearCart.get(i).ink.embroidText.length();
                System.out.println("Embroidery length:" + embroiderySize);

                indivSavings += embroiderySize;
                System.out.println("individual savings for a bear is = " + indivSavings + "\n");

                // this.BearCart.get(i).setPrice(this.getRawCost(BearCart.get(i)) -
                // indivSavings);
                totalSavings += embroiderySize;
                // System.out.println("total savings = " + totalSavings);
                if (totalAccessories != 0) {
                    totalAccessories--;
                }
                // totalAccessories--;
            }

            // sets Embroidery size to zero after the embroidery cost has been added to the
            // total savings

            // This group should be after all the discount calculations (end of i for-loop)
            // embroiderySize = 0;
            // totalAccessories = 0;
            // count = 0;
            // numOfClothes = 0;

            // This is temporary, This should not be reset
            // totalSavings = 0;
            double currBearPrice = this.getRawCost(this.BearCart.get(i));
            this.BearCart.get(i).setPrice(this.getRawCost(BearCart.get(i)) - indivSavings);
            double currBearPricetwo = this.BearCart.get(i).price;
            System.out.println("===========================================================");

//====================================
//===================================================================
// calculate the 10% savings of bears that have more than 10 accessories
            // double noiseMakerSize;
            // double clothingSize;

            // clothingSize = this.BearCart.get(i).clothing.size();
            // totalAccessories += clothingSize;

            // NoisMakers
            noiseMakerSize = this.BearCart.get(i).noisemakers.size();
            totalAccessories += noiseMakerSize;

            // this.BearCart.get(i).setPrice(this.getRawCost(this.BearCart.get(i) -
            // checks to see if total accessories exceeds 10
            if (totalAccessories >= 10) {
                System.out.println("exceeds 10");
                // used for debugging
                currBearPrice = this.BearCart.get(i).price;
                double savingsOfaccessories = this.BearCart.get(i).price - (this.BearCart.get(i).price * 0.1);
                totalSavings += (this.BearCart.get(i).price * 0.1);
                System.out.println("Discounted bear price = " + savingsOfaccessories);

            }
            // totalAccessories = 0;
            // the end of the i loop
            embroiderySize = 0;
            totalAccessories = 0;
            count = 0;
            numOfClothes = 0;

        }
        System.out.println("===========================================================");

//=======================================================================================================	 

//buy 2 get one free section
        Collections.sort(this.BearCart);

        for (int i = 0; i < this.BearCart.size() / 3; i++) {

            // double iBearPrice = this.BearCart.get(i).price;
            totalSavings += this.BearCart.get(i).price;

        }
        System.out.println("total savings = " + totalSavings);

        return totalSavings;
    }

}