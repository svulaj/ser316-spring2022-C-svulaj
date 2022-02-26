import main.java.*;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import main.java.BearWorkshop;


public class GivenWhiteBox {
    BearWorkshop oneBear;

    @Before
    public void setUp() throws Exception {
    }

/**
 * The change that needed to happen here was that the tax was not being applied
 * so to fix this issue i added in one line of code one line#32 to collect the tax value.
 * and
 * one line of code on line#36 to add the tax cost to the cost retrieved from the bear in question.
 * 
 * ---> Default test given with slight modification
 * ---> Testing getCost().
 * 
 */
    
    @Test
    public void checkoutOneBear() {
        // One Student
        oneBear = new BearWorkshop("AZ");
        Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
        
        double taxCost = oneBear.calculateTax(); //New Line of code
        
        Double ans = oneBear.getCost(testbear1); 
        
        ans += taxCost; //New Line of code
        
        assertEquals(42.07, ans, 0.5);
    }
    
    
    /**
     * This method tests node coverage --> Node 43 - 50.
     * This method passes with flying colors indicating that the clothing
     * 		clothing list traversal functionality work properly. 
     * 		It show uses four pieces of clothing, on of which is discounted
     * 		as described in the specification above the getCost() in BearWorkshop.java.
     * 
     * This test shows $30 being added to the cost of a single bear as opposed to $40
     * which is the total additional cost of all 4 pieces of clothing had they 
     * all been added to the bear.
     */
    		
    @Test
    public void getCost_clothingTraversal() {
        // One Student
        oneBear = new BearWorkshop("AZ");
        Bear testbear0 = new Bear(Stuffing.stuffing.DOWN);//$41

        oneBear.addBear(testbear0);

         Clothing cloth0 = new Clothing(10,"show r");
         Clothing cloth1 = new Clothing(10,"show r");
         Clothing cloth2 = new Clothing(10,"show r");
         Clothing cloth3 = new Clothing(10,"show r");
         
         testbear0.clothing.add(cloth0);
         testbear0.clothing.add(cloth1);
         testbear0.clothing.add(cloth2);
         testbear0.clothing.add(cloth3);
         
         Double ans = oneBear.getCost(testbear0);
         assertEquals(71.07, ans, 0.5);
    }
    
    
    
}
