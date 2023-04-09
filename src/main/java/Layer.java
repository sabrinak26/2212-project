import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author ben
 */
public class Layer {
    
    private String category;
    
    // POIs are stored in Hashtable
    
    private Hashtable<Integer, POI> pois;
    
    // Number of POIs in layer
    
    private int numPois;
    private int currKey = 0;
    boolean isSelected = false;
        
    /**
     *
     * @param category
     */
    public Layer(String category){
        
        this.category = category;
        numPois = 0;
        
    }
    
    // Add POI with no metadata to Hashtable using numPois as the key

    /**
     *
     */
    
    public void addPOI() {
        
        if (pois == null) {
            
            pois = new Hashtable<>();
            
        }
        
        pois.put(currKey, new POI(currKey));
        
        numPois++;
        currKey++;
    
    }
    
    // Add POI with metadata to Hashtable using numPois as the key

    /**
     *
     * @param poiName
     * @param floor
     * @param poiType
     * @param poiCategory
     * @param poiRoomNumber
     * @param poiDescription
     * @param poiX
     * @param poiY
     */
    
    public void addPOI(String poiName, String floor, String poiType, String poiCategory, String poiRoomNumber, String poiDescription, int poiX, int poiY) {
    
        if (pois == null) {
            
            pois = new Hashtable<>();
            
        }
        
        pois.put(currKey, new POI(poiName, floor, poiType, poiCategory, poiRoomNumber, poiDescription, poiX, poiY, currKey));

        numPois++;
        currKey++;
    
    }
    
    // If Hashtable and key exists then it removes that POI from the Hashtable

    /**
     *
     * @param key
     */
    
    public void removePOI(int key) {
        
        if (pois != null && pois.get(key) != null) {
        
            pois.remove(key);
        
            numPois--;
        }
    }
    
    /**
     *
     * @return
     */
    public String getCategory() {
        
        return category;
        
    }
    
    /**
     *
     * @return
     */
    public POI[] getPOIs() {
        
        if (pois == null) {
            
            pois = new Hashtable<>();
            
        }
        
        POI[] poiArray = new POI[pois.size()];
        int index = 0;
        
        for (POI value : pois.values()) {
        
            poiArray[index] = value;
            index++;
        
        }
        return poiArray;
    }

    /**
     *
     * @return
     */
    public String[] getPOINames() {
        if (pois == null) {

            pois = new Hashtable<>();

        }

        String[] poiNameArray = new String[pois.size()];
        int index = 0;

        for (POI value : pois.values()) {

            poiNameArray[index] = value.getName();
            index++;

        }
        return poiNameArray;
    }

    /**
     *
     * @return
     */
    public String[] getPOIInformation() {
        if (pois == null) {

            pois = new Hashtable<>();

        }

        String[] poiInfoArray = new String[pois.size()*3];
        int index = 0;

        for (POI value : pois.values()) {

            poiInfoArray[index] = value.getName();
            poiInfoArray[index+1] = String.valueOf(value.getRoomNumber());
            poiInfoArray[index+2] = value.getDescription();
            index+=3;

        }
        return poiInfoArray;
    }
    
    /**
     *
     * @return
     */
    public boolean getIsSelected() {
        
        
        
        return isSelected;
        
    }
    
    /**
     *
     * @param isSelected
     */
    public void setIsSelected(boolean isSelected) {
        
        this.isSelected = isSelected;
        
    }
    
}
