import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.*;

/**
 *
 * @author ben
 */
public class Building {
    private String buildingName;
    private String[] levels;

    private String[] levelNames;
    private Layer[] layers;
    private int id;
    //private Hashtable<String, JLayeredPane> layeredPanes;

    /**
     *
     * @return
     */
    public String[] getLevelNames() {
        return levelNames;
    }

    /**
     *
     * @param levelNames
     */
    public void setLevelNames(String[] levelNames) {
        this.levelNames = levelNames;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     *
     * @param buildingName
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     *
     * @return
     */
    public String[] getLevels() {
        return levels;
    }

    /**
     *
     * @param levels
     */
    public void setLevels(String[] levels) {
        this.levels = levels;
    }
    
    // Gets the desired layer object in the building from string

    /**
     *
     * @param category
     * @return
     */
    
    public Layer getLayer(String category) {
        
        if (category.equalsIgnoreCase("Accessibility")) {
            return layers[0];
        } else if (category.equalsIgnoreCase("Classrooms")) {
            return layers[1];
        } else if (category.equalsIgnoreCase("Favourites")) {
            return layers[2];
        } else if (category.equalsIgnoreCase("Labs")) {
            return layers[3];
        } else if (category.equalsIgnoreCase("Restaurants")) {
            return layers[4];
        } else if (category.equalsIgnoreCase("User defined POIs")) {
            return layers[5];
        } else {
            return layers[6];
        }
       
    }

    /**
     *
     * @return
     */
    public Layer[] getLayers () {
        return this.layers;
    }

    // Used this to create the layers, they are all in the JSON files now so might not need this method

    /**
     *
     */
    
    public void setLayers() {
        
        this.layers = new Layer[] {
        new Layer("Accessibility"), 
        new Layer("Classrooms"), 
        new Layer("Favourites"),
        new Layer("Labs"), 
        new Layer("Restaurants"), 
        new Layer("User defined POIs"), 
        new Layer("Washrooms")
        };
    }
    /*
    public JLayeredPane getLayeredPane(String level) {
        
        return layeredPanes.get(level);
        
    }

    public void addLayeredPane(String level, JLayeredPane pane) {
        
        level = level.replaceAll("\\s+","").toLowerCase();
        
        if (layeredPanes == null) {
            
            layeredPanes = new Hashtable<>();
            
        }
        
        layeredPanes.put(level, pane);

    }
*/
}
