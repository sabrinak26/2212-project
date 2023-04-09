/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sabrina
 */
public class LayerTest {
    
    public LayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("setUpClass()");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("tearDownClass()");
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("tearDown()");
    }

    /**
     * Test of addPOI method, of class Layer.
     */
    @Test
    public void testAddPOI_0args() {
        System.out.println("addPOI");
        String category = "Classroom";
        Layer instance = new Layer(category);
        instance.addPOI();
        int expResult = 1;
        int result = instance.getPOIs().length;
        assertEquals(expResult, result);

    }

    /**
     * Test of addPOI method, of class Layer.
     */
    @Test
    public void testAddPOI_8args() {
        System.out.println("addPOI");
        String poiName = "POI";
        String floor = "Level 2";
        String poiType = "User";
        String poiCategory = "Classroom";
        String poiRoomNumber = "1";
        String poiDescription = "This is a test POI";
        int poiX = 1;
        int poiY = 1;
        String category = "Classroom";
        Layer instance = new Layer (category);
        instance.addPOI(poiName, floor, poiType, poiCategory, poiRoomNumber, poiDescription, poiX, poiY);
        int expResult = 1;
        int result = instance.getPOIs().length;
        assertEquals(expResult, result);
    }

    /**
     * Test of removePOI method, of class Layer.
     */
    @Test
    public void testRemovePOI() {
        System.out.println("removePOI");
        int key = 1;
        String category = "Classroom";
        Layer instance = new Layer (category);
        POI poi = new POI("POI", "Level 2", "User", "Classroom", "4", "This is a test POI", 1, 1,1);
        instance.removePOI(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class Layer.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        String category = "Labs";
        Layer instance = new Layer(category);
        String expResult = "Labs";
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPOIs method, of class Layer.
     */
    @Test
    public void testGetPOIs() {
        System.out.println("getPOIs");
        String category = "Labs";
        Layer instance = new Layer(category);
        instance.addPOI("POI", "2", "User", "Labs", "2", "a POI", 0, 0);
        POI testPOI = new POI("POI", "2", "User", "Labs", "2", "a POI", 0, 0,1);
        POI[] expResult = {testPOI};
        POI[] result = instance.getPOIs();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getIsSelected method, of class Layer.
     */
    @Test
    public void testGetIsSelected() {
        System.out.println("getIsSelected");
        String category = "Labs";
        Layer instance = new Layer(category);
        instance.setIsSelected(true);
        boolean expResult = true;
        boolean result = instance.getIsSelected();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsSelected method, of class Layer.
     */
    @Test
    public void testSetIsSelected() {
        System.out.println("setIsSelected");
        boolean isSelected = false;
        String category = "Classroom";
        Layer instance = new Layer(category);
        instance.setIsSelected(isSelected);
        boolean result = instance.getIsSelected();
        assertEquals(isSelected, result);
    }

    /**
     * Test of getPOINames method, of class Layer.
     */
    @Test
    public void testGetPOINames() {
        System.out.println("getPOINames");
        Layer instance = null;
        String[] expResult = null;
        String[] result = instance.getPOINames();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

