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
 * so to fix this issue i added in one line of code one line#30 to collect the tax value.
 * and
 * one line of code on line#36 to add the tax cost to the cost retrieved from the bear in question.
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
}
