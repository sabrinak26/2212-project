/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.HashMap;
import javax.swing.JCheckBox;
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


    // /**
    //  * Test of getBuilding method, of class Map.
    //  */
    // @Test
    // public void testGetBuilding_0args() {
    //     System.out.println("getBuilding");
    //     Map instance = new Map();
    //     Building expResult = null;
    //     Building result = instance.getBuilding();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getBuilding method, of class Map.
    //  */
    // @Test
    // public void testGetBuilding_String() {
    //     System.out.println("getBuilding");
    //     String buildingName = "";
    //     Map instance = new Map();
    //     Building expResult = null;
    //     Building result = instance.getBuilding(buildingName);
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setBuilding method, of class Map.
    //  */
    // @Test
    // public void testSetBuilding() {
    //     System.out.println("setBuilding");
    //     Building building = null;
    //     Map instance = new Map();
    //     instance.setBuilding(building);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }

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
     * Test of addPoIToMapLevel method, of class Map.
     */
    @Test
    public void testAddPoIToMapLevel() {
        System.out.println("addPoIToMapLevel");
        POI poi = null;
        String buildingName = "";
        Map instance = new Map();
        instance.addPoIToMapLevel(poi, buildingName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAllPois method, of class Map.
     */
    @Test
    public void testAddAllPois() {
        System.out.println("addAllPois");
        Map instance = new Map();
        instance.addAllPois();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePOIsFromMap method, of class Map.
     */
    @Test
    public void testRemovePOIsFromMap() {
        System.out.println("removePOIsFromMap");
        POI[] pois = null;
        Map instance = new Map();
        instance.removePOIsFromMap(pois);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMarker method, of class Map.
     */
    @Test
    public void testAddMarker_6args() {
        System.out.println("addMarker");
        int x = 0;
        int y = 0;
        String building = "";
        String level = "";
        POI poi = null;
        boolean disappear = false;
        Map instance = new Map();
        instance.addMarker(x, y, building, level, poi, disappear);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMarker method, of class Map.
     */
    @Test
    public void testAddMarker_4args() {
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
     * Test of selectMarker method, of class Map.
     */
    @Test
    public void testSelectMarker() {
        System.out.println("selectMarker");
        int x = 0;
        int y = 0;
        String building = "";
        String level = "";
        Map instance = new Map();
        instance.selectMarker(x, y, building, level);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMarker method, of class Map.
     */
    @Test
    public void testRemoveMarker() {
        System.out.println("removeMarker");
        int x = 0;
        int y = 0;
        String building = "";
        String level = "";
        Map instance = new Map();
        instance.removeMarker(x, y, building, level);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuildings method, of class Map.
     */
    @Test
    public void testGetBuildings() {
        System.out.println("getBuildings");
        Map instance = new Map();
        Building[] expResult = null;
        Building[] result = instance.getBuildings();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of getWeather method, of class Map.
     */
    @Test
    public void testGetWeather() throws Exception {
        System.out.println("getWeather");
        Map instance = new Map();
        instance.getWeather();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIcon method, of class Map.
     */
    @Test
    public void testGetIcon() {
        System.out.println("getIcon");
        Map instance = new Map();
        String expResult = "";
        String result = instance.getIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTemp method, of class Map.
     */
    @Test
    public void testGetTemp() {
        System.out.println("getTemp");
        Map instance = new Map();
        float expResult = 0.0F;
        float result = instance.getTemp();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMenu method, of class Map.
     */
    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        Map instance = new Map();
        instance.createMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNames method, of class Map.
     */
    @Test
    public void testAddNames() {
        System.out.println("addNames");
        String category = "";
        Map instance = new Map();
        instance.addNames(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFaves method, of class Map.
     */
    @Test
    public void testAddFaves() {
        System.out.println("addFaves");
        Map instance = new Map();
        instance.addFaves();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of updateMenu method, of class Map.
     */
    @Test
    public void testUpdateMenu() {
        System.out.println("updateMenu");
        Map instance = new Map();
        instance.updateMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateJustMenu method, of class Map.
     */
    @Test
    public void testUpdateJustMenu() {
        System.out.println("updateJustMenu");
        Map instance = new Map();
        instance.updateJustMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPOIHashMap method, of class Map.
     */
    @Test
    public void testGetPOIHashMap() {
        System.out.println("getPOIHashMap");
        Map instance = new Map();
        HashMap expResult = null;
        HashMap result = instance.getPOIHashMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

