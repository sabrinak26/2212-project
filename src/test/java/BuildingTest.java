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
 * @author Sabrina Ke
 */
public class BuildingTest {
    
    public BuildingTest() {
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
     * Test of getLevelNames method, of class Building.
     */
    @Test
    public void testGetLevelNames() {
        System.out.println("getLevelNames");
        Building instance = new Building();
        String[] levelNames = {"Level 2"};
        instance.setLevelNames(levelNames);
        String[] expResult = {"Level 2"};
        String[] result = instance.getLevelNames();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setLevelNames method, of class Building.
     */
    @Test
    public void testSetLevelNames() {
        System.out.println("setLevelNames");
        String[] levelNames = {"Level 2"};
        Building instance = new Building();
        instance.setLevelNames(levelNames);
        String[] result = instance.getLevelNames();
        assertEquals(levelNames, result);
    }

    /**
     * Test of getId method, of class Building.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Building instance = new Building();
        instance.setId(3);
        int expResult = 3;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Building.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 3;
        Building instance = new Building();
        instance.setId(id);
        int result = instance.getId();
        assertEquals(id, result);;
    }

    /**
     * Test of getBuildingName method, of class Building.
     */
    @Test
    public void testGetBuildingName() {
        System.out.println("getBuildingName");
        Building instance = new Building();
        instance.setBuildingName("Middlesex College");
        String expResult = "Middlesex College";
        String result = instance.getBuildingName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBuildingName method, of class Building.
     */
    @Test
    public void testSetBuildingName() {
        System.out.println("setBuildingName");
        String buildingName = "Alumni Hall";
        Building instance = new Building();
        instance.setBuildingName(buildingName);
        String result = instance.getBuildingName();
        assertEquals(buildingName, result);
    }

    /**
     * Test of getLevels method, of class Building.
     */
    @Test
    public void testGetLevels() {
        System.out.println("getLevels");
        Building instance = new Building();
        String[] levels = {"3"};
        instance.setLevels(levels);
        String[] expResult = {"3"};
        String[] result = instance.getLevels();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setLevels method, of class Building.
     */
    @Test
    public void testSetLevels() {
        System.out.println("setLevels");
        String[] levels = {"3"};
        Building instance = new Building();
        instance.setLevels(levels);
        String[] result = instance.getLevels();
        assertEquals(levels, result);
    }

    /**
     * Test of getLayer method, of class Building.
     */
    @Test
    public void testGetLayer() {
        System.out.println("getLayer");
        String category = "Classroom";
        Building instance = new Building();
        instance.setLayers();
        Layer expResult = null;
        Layer result = instance.getLayer(category);
        assertEquals(expResult, result);
    }

    /**
     * Test of setLayers method, of class Building.
     */
    @Test
    public void testSetLayers() {
        System.out.println("setLayers");
        Layer[] layers = {new Layer("Classroom")};
        Building instance = new Building();
        instance.setLayers();
        Layer result = instance.getLayer("Classroom");
        assertEquals(layers, result);
    }
    
}
