package main.java;

import main.java.Stuffing.Stuffs;

public class Main {

    /**
     * Description: the main system of the bear store.
     * @param args Is what the customer could potentially input in the future.
     */
    public static void main(String[] args) {
        // Fill me in!

        Bear bear1 = new Bear(Stuffs.FOAM);
        Bear bear2 = new Bear(Stuffs.BASE);
        Bear bear3 = new Bear(Stuffs.DOWN);

        BearWorkshop workshop = new BearWorkshop("AZ");
        workshop.addBear(bear2);
        workshop.addBear(bear3);
        workshop.addBear(bear1);

        System.out.println(bear1.price);

        System.out.println(workshop.getCost(bear2));
        System.out.println(bear2.price);

        System.out.println(workshop.getCost(bear3));
        System.out.println(bear3.price);

        bear1.clothing.add(new Clothing());

        System.out.println("Bear with NO clothing object");
        System.out.println(bear1.price);

        System.out.println("Bear with one clothing object");
        System.out.println(workshop.getRawCost(bear1));

        bear1.clothing.add(new Clothing(5, "Cool sunglasses"));
        System.out.println("Bear with two clothing object");
        System.out.println(workshop.getRawCost(bear1));
    }
}
