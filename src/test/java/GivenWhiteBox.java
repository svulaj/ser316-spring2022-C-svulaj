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
    
    /**
     * This method tests node coverage --> Node 43 - 50.   -------> Fully covers all nodes.
     * This method passes with flying colors indicating that the clothing
     * 		clothing list traversal functionality work properly. 
     * 		It show uses four pieces of clothing, on of which is discounted
     * 		as described in the specification above the getCost() in BearWorkshop.java.
     * 
     * This test shows $30 being added to the cost of a single bear as opposed to $40
     * which is the total additional cost of all 4 pieces of clothing had they 
     * all been added to the bear.
     * 
     * NEW: This test is the same as the previous but now has edge coverage to 
     * 		test whether or not the if-condition for adding the noiseMaker
     * 		cost to the individual bears total cost. 
     * 
     * With the addition of this test node coverage of nodes 38-64 has been achieved.
     */
    
    @Test
    public void getCost_clothingTraversal_with_ifBranch() {
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
         
         NoiseMaker noise0 = new NoiseMaker();
         testbear0.noisemakers.add(noise0);
         
         Double ans = oneBear.getCost(testbear0);
         assertEquals(81.07, ans, 0.5);
    }
    
    
    /**
     * This test is for node coverage of method calculateTax.
     * 		Specifically nodes: 99-122
     * 
     * This test creates multiple bears all using different taxes
     * 		(different workShops from different states).
     * 		This includes edge coverage by covering each switch branch within
     * 		the method.
     */
    
    @Test
    public void calculateTax_nodeTest() {
        
    	BearWorkshop shop0 = new BearWorkshop("AZ");
    	Double ans = shop0.calculateTax();
        assertEquals(1.07, ans, 0.5);
    	
        
    	BearWorkshop shop1 = new BearWorkshop("NY");
    	Double ans1 = shop1.calculateTax();
        assertEquals(1.09, ans1, 0.5);
    	
    	
    	BearWorkshop shop2 = new BearWorkshop("VA");
    	Double ans2 = shop2.calculateTax();
        assertEquals(1.05, ans2, 0.5);
    	
    	
    	BearWorkshop shop3 = new BearWorkshop("DC");
    	Double ans3 = shop3.calculateTax();
        assertEquals(1.105, ans3, 0.5);
    	
    	
    	BearWorkshop shop4 = new BearWorkshop("CA");
    	Double ans4 = shop4.calculateTax();
        assertEquals(1.1, ans4, 0.5);
        
        
        BearWorkshop shop5 = new BearWorkshop("");
    	Double ans5 = shop5.calculateTax();
        assertEquals(1.05, ans5, 0.5);
        
    }
    
    
    
}
