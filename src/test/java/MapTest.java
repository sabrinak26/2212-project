/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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
public class MapTest {
    
    public MapTest() {
        
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
     * Test of getTabs method, of class Map.
     */
    @Test
    public void testGetTabs() {
        System.out.println("getTabs");
        Map instance = new Map();
        JTabbedPane expResult = null;
        JTabbedPane result = instance.getTabs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTabs method, of class Map.
     */
    @Test
    public void testSetTabs() {
        System.out.println("setTabs");
        JTabbedPane tabs = null;
        Map instance = new Map();
        instance.setTabs(tabs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadBuildingsData method, of class Map.
     */
    @Test
    public void testLoadBuildingsData() {
        System.out.println("loadBuildingsData");
        Map instance = new Map();
        instance.loadBuildingsData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateLayeredPane method, of class Map.
     */
    @Test
    public void testGenerateLayeredPane() {
        System.out.println("generateLayeredPane");
        String level = "";
        Map instance = new Map();
        JLayeredPane expResult = null;
        JLayeredPane result = instance.generateLayeredPane(level);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuilding method, of class Map.
     */
    @Test
    public void testGetBuilding_0args() {
        System.out.println("getBuilding");
        Map instance = new Map();
        Building expResult = null;
        Building result = instance.getBuilding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuilding method, of class Map.
     */
    @Test
    public void testGetBuilding_String() {
        System.out.println("getBuilding");
        String buildingName = "";
        Map instance = new Map();
        Building expResult = null;
        Building result = instance.getBuilding(buildingName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBuilding method, of class Map.
     */
    @Test
    public void testSetBuilding() {
        System.out.println("setBuilding");
        Building building = null;
        Map instance = new Map();
        instance.setBuilding(building);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFloorName method, of class Map.
     */
    @Test
    public void testGetFloorName() {
        System.out.println("getFloorName");
        Map instance = new Map();
        instance.setFloorName("Level 3");
        String expResult = "Level 3";
        String result = instance.getFloorName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFloorName method, of class Map.
     */
    @Test
    public void testSetFloorName() {
        System.out.println("setFloorName");
        String floorName = "Level 5";
        Map instance = new Map();
        instance.setFloorName(floorName);
        String result = instance.getFloorName();
        assertEquals(floorName, result);
    }

    /**
     * Test of getPanel method, of class Map.
     */
    @Test
    public void testGetPanel() {
        System.out.println("getPanel");
        Map instance = new Map();
        JPanel expResult = null;
        JPanel result = instance.getPanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentBuilding method, of class Map.
     */
    @Test
    public void testSetCurrentBuilding() {
        System.out.println("setCurrentBuilding");
        Building currentBuilding = null;
        Map instance = new Map();
        instance.setCurrentBuilding(currentBuilding);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentBuilding method, of class Map.
     */
    @Test
    public void testGetCurrentBuilding() {
        System.out.println("getCurrentBuilding");
        Map instance = new Map();
        Building expResult = null;
        Building result = instance.getCurrentBuilding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setcurrentFloor method, of class Map.
     */
    @Test
    public void testSetcurrentFloor() {
        System.out.println("setcurrentFloor");
        String currentFloor = "";
        Map instance = new Map();
        instance.setcurrentFloor(currentFloor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getcurrentFloor method, of class Map.
     */
    @Test
    public void testGetcurrentFloor() {
        System.out.println("getcurrentFloor");
        Map instance = new Map();
        String expResult = "";
        String result = instance.getcurrentFloor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPOIToMap method, of class Map.
     */
    @Test
    public void testAddPOIToMap() {
        System.out.println("addPOIToMap");
        POI poi = null;
        Map instance = new Map();
        instance.addPOIToMap(poi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPOIsToMap method, of class Map.
     */
    @Test
    public void testAddPOIsToMap() {
        System.out.println("addPOIsToMap");
        POI[] pois = null;
        Map instance = new Map();
        instance.addPOIsToMap(pois);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPOI method, of class Map.
     */
    @Test
    public void testAddPOI() {
        System.out.println("addPOI");
        int x = 0;
        int y = 0;
        Map instance = new Map();
        instance.addPOI(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMarker method, of class Map.
     */
    @Test
    public void testAddMarker() {
        System.out.println("addMarker");
        int x = 0;
        int y = 0;
        String building = "";
        String level = "";
        Map instance = new Map();
        instance.addMarker(x, y, building, level);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLayeredPane method, of class Map.
     */
    @Test
    public void testGetLayeredPane() {
        System.out.println("getLayeredPane");
        String building = "";
        String level = "";
        Map instance = new Map();
        JLayeredPane expResult = null;
        JLayeredPane result = instance.getLayeredPane(building, level);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLayeredPane method, of class Map.
     */
    @Test
    public void testAddLayeredPane() {
        System.out.println("addLayeredPane");
        String building = "";
        String level = "";
        JLayeredPane pane = null;
        Map instance = new Map();
        instance.addLayeredPane(building, level, pane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
