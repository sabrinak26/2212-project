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
 * @author Sabrina
 */
public class POITest {
    
    public POITest() {
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
     * Test of getType method, of class POI.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a POI", 0, 0,1);
        String expResult = "User";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class POI.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "User";
        POI instance = new POI("POI", "2", null, "Labs", 2, "a POI", 0, 0,1);
        instance.setType(type);
        String result = instance.getType();
        assertEquals(type, result);
    }

    /**
     * Test of getCategory method, of class POI.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        POI instance = new POI("POI", "2", null, "Labs", 2, "a POI", 0, 0,1);
        String expResult = "Labs";
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategory method, of class POI.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "Labs";
        POI instance = new POI("POI", "2", "User", null, 2, "a POI", 0, 0,1);;
        instance.setCategory(category);
        String result = instance.getCategory();
        assertEquals(category, result);
    }

    /**
     * Test of getName method, of class POI.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a POI", 0, 0,1);
        String expResult = "POI";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class POI.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "POIname";
        POI instance = new POI(null, "2", "User", "Labs", 2, "a POI", 0, 0,1);
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }

    /**
     * Test of getRoomNumber method, of class POI.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a POI", 0, 0,1);
        int expResult = 2;
        int result = instance.getRoomNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoomNumber method, of class POI.
     */
    @Test
    public void testSetRoomNumber() {
        System.out.println("setRoomNumber");
        int roomNumber = 3;
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a POI", 0, 0,1);
        instance.setRoomNumber(roomNumber);
        int result = instance.getRoomNumber();
        assertEquals(roomNumber, result);
    }

    /**
     * Test of getDescription method, of class POI.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 0, 0,1);
        String expResult = "a test POI";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class POI.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "a new description for the test POI";
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 0, 0,1);
        instance.setDescription(description);
        String result = instance.getDescription();
        assertEquals(description, result);
    }

    /**
     * Test of isFavourite method, of class POI.
     */
    @Test
    public void testIsFavourite() {
        System.out.println("isFavourite");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 0, 0,1);
        boolean expResult = false;
        boolean result = instance.isFavourite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFavourite method, of class POI.
     */
    @Test
    public void testSetFavourite() {
        System.out.println("setFavourite");
        boolean favourite = true;
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 0, 0,1);
        instance.setFavourite(favourite);
        boolean result = instance.isFavourite();
        assertEquals(favourite, result);
    }

    /**
     * Test of getX method, of class POI.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 1, 0,1);
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class POI.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 5;
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 0, 0,1);
        instance.setX(x);
        int result = instance.getX();
        assertEquals(x, result);
    }

    /**
     * Test of getY method, of class POI.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 1, 6,1);
        int expResult = 6;
        int result = instance.getY();
        assertEquals(expResult, result);

    }

    /**
     * Test of setY method, of class POI.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 7;
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 1, 0,1);
        instance.setY(y);
        int result = instance.getY();
        assertEquals(y, result);
    }

    /**
     * Test of getKey method, of class POI.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 1, 0,1);
        int expResult = 1;
        int result = instance.getKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKey method, of class POI.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        int key = 5;
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 1, 0,1);
        instance.setKey(key);
        int result = instance.getKey();
        assertEquals(key, result);
    }

    /**
     * Test of getfloor method, of class POI.
     */
    @Test
    public void testGetfloor() {
        System.out.println("getfloor");
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 1, 0,1);
        String expResult = "2";
        String result = instance.getfloor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setfloor method, of class POI.
     */
    @Test
    public void testSetfloor() {
        System.out.println("setfloor");
        String floor = "3";
        POI instance = new POI("POI", "2", "User", "Labs", 2, "a test POI", 1, 0,1);
        instance.setfloor(floor);
        String result = instance.getfloor();
        assertEquals(floor, result);
    }
    
}
