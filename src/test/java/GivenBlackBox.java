import main.java.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import main.java.BearWorkshop;

import static org.junit.Assert.*;

/***
 * This class provides a framework to implement black box tests for various
 * implementations of the BearWorkshop Class. The BearWorkshop is having a
 * blowout sale and is offering the following savings.
 */
@RunWith(Parameterized.class)
public class GivenBlackBox {
    private Class<BearWorkshop> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {
        this.classUnderTest = (Class<BearWorkshop>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {BearWorkshop1.class},
                {BearWorkshop2.class},
                {BearWorkshop3.class},
                {BearWorkshop4.class},
                {BearWorkshop5.class}

        };
        return Arrays.asList(classes);
    }

    private BearWorkshop createBearWorkshop(String name) throws Exception {
        Constructor<BearWorkshop> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }

    BearWorkshop oneBear;
    Double oneBearExpected;

    BearWorkshop threeBears;
    Double threeBearsExpected;

    BearWorkshop twoBears;
    Double twoBearsExpected;

    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
    }

    // sample test

    /**
     * Test examines a BearFactory with 1 simple bear in it. The bear costs $30
     * and there are no savings.
     */
    @Test
    public void oneBearNoSavings() {
    	// One Bear base stuffing, no saving expected
        
        BearWorkshop oneBear = null;
        try {
        	oneBear = createBearWorkshop("NY");
        } catch (Exception e) {
        }
        
        oneBear.addBear(new Bear(Stuffing.stuffing.BASE)); // $30 stuffing + $1 casing -- should be no savings at all
        oneBearExpected = 0.00; // no savings since no clothing
    	
        Double ans = oneBear.calculateSavings();
        assertEquals(oneBearExpected, ans);
    }


    // sample test
    @Test
    public void threeBearsSaveOnCheapest() {
    	 // Three Bears expected to not pay for cheapest one
    	BearWorkshop threeBears = null;
        try {
        	threeBears = createBearWorkshop("AZ");
        } catch (Exception e) {
        }
    	
        threeBears.addBear(new Bear(Stuffing.stuffing.BASE)); // this is the cheapest one
        threeBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        threeBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        threeBearsExpected = 31.00;

        Double ans = threeBears.calculateSavings();
        assertEquals(threeBearsExpected, ans);
    }

    // sample test
 
    @Test
    public void oneBearTest3clothings() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        
        Bear customBear = new Bear(Stuffing.stuffing.BASE); // $31
        bears.addBear(customBear);

	    customBear.clothing.add(new Clothing(4, "Hat")); //$35
	    customBear.clothing.add(new Clothing(4, "Sunglasses")); //$39
	    customBear.clothing.add(new Clothing(4, "Shoes")); // free
	    
        Double bearsExpected = 4.0; // one cloth item for free
        Double ans = bears.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    @Test
    public void testOfNoisesInABears_NoiseMakerCollection() {
    	
       Bear testbear = new Bear();
       NoiseMaker noise_expected = new NoiseMaker("shaun","Im shaun!",NoiseMaker.Location.RIGHT_HAND);

       testbear.addNoise(noise_expected);

       NoiseMaker actual = testbear.noisemakers.get(0);
        assertEquals(noise_expected, actual);
    }
    
    
    
//------------------------------------------------------------------------------------------------------
// Testing 4 bears in a cart
    
    
    @Test
    public void testA() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear2 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear3 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear4 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear5 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear6 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear7 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear8 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear9 = new Bear(Stuffing.stuffing.DOWN);//$41
    	
    	workshop.addBear(testbear1);
    	workshop.addBear(testbear2);
    	workshop.addBear(testbear3);
    	workshop.addBear(testbear4);
    	//workshop.addBear(testbear5);
    	//workshop.addBear(testbear6);
    	//workshop.addBear(testbear7);
    	//workshop.addBear(testbear8);
    	//workshop.addBear(testbear9);
    	

    	Double bearsExpected = 41.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
    
//------------------------------------------------------------------------------------------------------    
    
    @Test
    public void testB() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear2 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear3 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear4 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear5 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear6 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear7 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear8 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear9 = new Bear(Stuffing.stuffing.DOWN);//$41
    	
    	workshop.addBear(testbear1);
    	workshop.addBear(testbear2);
    	workshop.addBear(testbear3);
    	workshop.addBear(testbear4);
    	workshop.addBear(testbear5);
    	workshop.addBear(testbear6);
    	workshop.addBear(testbear7);
    	//workshop.addBear(testbear8);
    	//workshop.addBear(testbear9);
    	

    	Double bearsExpected = 82.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
  //------------------------------------------------------------------------------------------------------    
    
    
    @Test
    public void testC() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear2 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear3 = new Bear(Stuffing.stuffing.DOWN);//$41 -
    	Bear testbear4 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear5 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear6 = new Bear(Stuffing.stuffing.DOWN);//$41 -
    	Bear testbear7 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear8 = new Bear(Stuffing.stuffing.DOWN);//$41
    	Bear testbear9 = new Bear(Stuffing.stuffing.DOWN);//$41 -
    	Bear testbear10 = new Bear(Stuffing.stuffing.DOWN);//$41
    	
    	
    	workshop.addBear(testbear1);
    	workshop.addBear(testbear2);
    	workshop.addBear(testbear3);
    	workshop.addBear(testbear4);
    	workshop.addBear(testbear5);
    	workshop.addBear(testbear6);
    	workshop.addBear(testbear7);
    	workshop.addBear(testbear8);
    	workshop.addBear(testbear9);
    	workshop.addBear(testbear10);
    	

    	Double bearsExpected = 123.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
    
  //------------------------------------------------------------------------------------------------------
    
    @Test
    public void testD() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear2 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear3 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear4 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear5 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear6 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear7 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear8 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear9 = new Bear(Stuffing.stuffing.DOWN);//$41
    	workshop.addBear(testbear1);
    	//workshop.addBear(testbear2);
    	//workshop.addBear(testbear3);
    	//workshop.addBear(testbear4);
    	//workshop.addBear(testbear5);
    	//workshop.addBear(testbear6);
    	//workshop.addBear(testbear7);
    	//workshop.addBear(testbear8);
    	//workshop.addBear(testbear9);
    	
    	
    	Clothing cloth0 = new Clothing(6,"shirt");
    	Clothing cloth1 = new Clothing(4,"pants");
    	Clothing cloth2 = new Clothing(2,"hat");
    	//Clothing cloth3 = new Clothing(9,"right shoe");
    	//Clothing cloth4 = new Clothing(8,"right shoe");
    	//Clothing cloth5 = new Clothing(10,"right shoe");
    	
    	testbear1.clothing.add(cloth0);
    	testbear1.clothing.add(cloth1);
    	testbear1.clothing.add(cloth2);
    	//testbear4.clothing.add(cloth3);
    	//testbear5.clothing.add(cloth4);
    	//testbear6.clothing.add(cloth5);
    	
    	

    	Double bearsExpected = 2.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
  
    
//------------------------------------------------------------------------------------------------------    
   

    @Test
    public void testE() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear2 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear3 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear4 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear5 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear6 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear7 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear8 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear9 = new Bear(Stuffing.stuffing.DOWN);//$41
    	workshop.addBear(testbear1);
    	//workshop.addBear(testbear2);
    	//workshop.addBear(testbear3);
    	//workshop.addBear(testbear4);
    	//workshop.addBear(testbear5);
    	//workshop.addBear(testbear6);
    	//workshop.addBear(testbear7);
    	//workshop.addBear(testbear8);
    	//workshop.addBear(testbear9);
    	
    	
    	Clothing cloth0 = new Clothing(5,"shirt");
    	Clothing cloth1 = new Clothing(5,"pants");
    	Clothing cloth2 = new Clothing(5,"hat");
    	Clothing cloth3 = new Clothing(5,"right shoe");
    	Clothing cloth4 = new Clothing(5,"right shoe");
    	Clothing cloth5 = new Clothing(5,"right shoe");
    	//value of bear with all accessories = $71
    	
    	
    	testbear1.clothing.add(cloth0);
    	testbear1.clothing.add(cloth1);
    	testbear1.clothing.add(cloth2);
    	testbear1.clothing.add(cloth3);
    	testbear1.clothing.add(cloth4);
    	testbear1.clothing.add(cloth5);
    	
    	

    	Double bearsExpected = 10.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
  //------------------------------------------------------------------------------------------------------   
    
    
    @Test
    public void testF() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear2 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear3 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear4 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear5 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear6 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear7 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear8 = new Bear(Stuffing.stuffing.DOWN);//$41
    	//Bear testbear9 = new Bear(Stuffing.stuffing.DOWN);//$41
    	workshop.addBear(testbear1);
    	//workshop.addBear(testbear2);
    	//workshop.addBear(testbear3);
    	//workshop.addBear(testbear4);
    	//workshop.addBear(testbear5);
    	//workshop.addBear(testbear6);
    	//workshop.addBear(testbear7);
    	//workshop.addBear(testbear8);
    	//workshop.addBear(testbear9);
    	
    	
    	Clothing cloth0 = new Clothing(5,"shirt");
    	Clothing cloth1 = new Clothing(5,"pants");
    	Clothing cloth2 = new Clothing(5,"hat");
    	Clothing cloth3 = new Clothing(5,"right shoe");
    	Clothing cloth4 = new Clothing(5,"right shoe");
    	Clothing cloth5 = new Clothing(5,"right shoe");
    	Clothing cloth6 = new Clothing(5,"right shoe");
    	Clothing cloth7 = new Clothing(5,"right shoe");
    	Clothing cloth8 = new Clothing(5,"right shoe");
    	//value of bear with all accessories = $86
    	
    	
    	testbear1.clothing.add(cloth0);
    	testbear1.clothing.add(cloth1);
    	testbear1.clothing.add(cloth2);
    	testbear1.clothing.add(cloth3);
    	testbear1.clothing.add(cloth4);
    	testbear1.clothing.add(cloth5);
    	
    	

    	Double bearsExpected = 10.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
//------------------------------------------------------------------------------------------------------
    
    @Test
    public void testG() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	
    	
    	workshop.addBear(testbear1);
    	
    	
    	
    	Double bearsExpected = 0.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
  //------------------------------------------------------------------------------------------------------
    
    
    
    @Test
    public void testH() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	
    	
    	workshop.addBear(testbear1);
    	
    	
    	
    	
    	NoiseMaker noise0 = new NoiseMaker();
    	NoiseMaker noise1 = new NoiseMaker();
    	NoiseMaker noise2 = new NoiseMaker();
    	NoiseMaker noise3 = new NoiseMaker();
    	NoiseMaker noise4 = new NoiseMaker();
    
    	
    	
    	testbear1.noisemakers.add(noise0);
    	testbear1.noisemakers.add(noise1);
    	testbear1.noisemakers.add(noise2);
    	testbear1.noisemakers.add(noise3);
    	testbear1.noisemakers.add(noise4);
    	
    	
    	
    	Double bearsExpected = 0.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
  //------------------------------------------------------------------------------------------------------    
    
    @Test
    public void testI() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	
    	
    	workshop.addBear(testbear1);
    	
    	
    	
    	
    	NoiseMaker noise0 = new NoiseMaker();
    	NoiseMaker noise1 = new NoiseMaker();
    	NoiseMaker noise2 = new NoiseMaker();
    	NoiseMaker noise3 = new NoiseMaker();
    	NoiseMaker noise4 = new NoiseMaker();
    	NoiseMaker noise5 = new NoiseMaker();
    	NoiseMaker noise6 = new NoiseMaker();
    	NoiseMaker noise7 = new NoiseMaker();
    	
    	
    	
    	testbear1.noisemakers.add(noise0);
    	testbear1.noisemakers.add(noise1);
    	testbear1.noisemakers.add(noise2);
    	testbear1.noisemakers.add(noise3);
    	testbear1.noisemakers.add(noise4);
    	testbear1.noisemakers.add(noise5);
    	testbear1.noisemakers.add(noise6);
    	testbear1.noisemakers.add(noise7);
    	
    	
    	
    	
    	Double bearsExpected = 0.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
  //------------------------------------------------------------------------------------------------------
    
    
    
    @Test
    public void testJ() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	
    	
    	workshop.addBear(testbear1);
    	
    	
    	
    	
    	NoiseMaker noise0 = new NoiseMaker();
    	NoiseMaker noise1 = new NoiseMaker();
    	NoiseMaker noise2 = new NoiseMaker();
    	NoiseMaker noise3 = new NoiseMaker();
    	NoiseMaker noise4 = new NoiseMaker();
    	NoiseMaker noise5 = new NoiseMaker();
    	NoiseMaker noise6 = new NoiseMaker();
    	NoiseMaker noise7 = new NoiseMaker();
    	NoiseMaker noise8 = new NoiseMaker();
    	NoiseMaker noise9 = new NoiseMaker();
    	
    	
    	
    	testbear1.noisemakers.add(noise0);
    	testbear1.noisemakers.add(noise1);
    	testbear1.noisemakers.add(noise2);
    	testbear1.noisemakers.add(noise3);
    	testbear1.noisemakers.add(noise4);
    	testbear1.noisemakers.add(noise5);
    	testbear1.noisemakers.add(noise6);
    	testbear1.noisemakers.add(noise7);
    	testbear1.noisemakers.add(noise8);
    	testbear1.noisemakers.add(noise9);
    	
    	
    	
    	Double bearsExpected = 41.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
    
    
    @Test
    public void testK() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	workshop.addBear(testbear1);
    	
    	testbear1.price = 71;
    	
    	
    	
    	Embroidery word1 = new Embroidery("Shaun");
    	testbear1.ink = word1;
    	

    	Double bearsExpected = 5.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
    
    
    @Test
    public void testL() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	workshop.addBear(testbear1);
    	
    	testbear1.price = 65;
    	
    	
    	
    	Embroidery word1 = new Embroidery("Shaun");
    	testbear1.ink = word1;
    	

    	Double bearsExpected = 5.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
    
    
    @Test
    public void testM() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	workshop.addBear(testbear1);
    	
    	Clothing cloth0 = new Clothing(20,"R shoe");
    	Clothing cloth1 = new Clothing(9,"L shoe");

    	testbear1.clothing.add(cloth0);
    	testbear1.clothing.add(cloth1);
    	
    	
    	Embroidery word1 = new Embroidery("Shaun");
    	testbear1.ink = word1;
    	

    	Double bearsExpected = 5.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
    @Test
    public void testO() {
    	BearWorkshop workshop = null;
        try {
        	workshop = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        
    	Bear testbear1 = new Bear(Stuffing.stuffing.DOWN);//$41
    	workshop.addBear(testbear1);
    	
    	Clothing cloth0 = new Clothing(4,"R shoe");
    	Clothing cloth1 = new Clothing(6,"L shoe");

    	testbear1.clothing.add(cloth0);
    	testbear1.clothing.add(cloth1);
    	
    	
    	Embroidery word1 = new Embroidery("Shaun");
    	testbear1.ink = word1;
    	

    	Double bearsExpected = 0.0; 
        Double ans = workshop.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    
    //done
}


























