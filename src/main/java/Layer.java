/**
 *
 * @author ben
 */;
 
import java.util.Enumeration;
import java.util.Hashtable;

public class Layer {
    
    private String category;
    
    // POIs are stored in Hashtable
    
    private Hashtable<Integer, POI> pois;
    
    // Number of POIs in layer
    
    private int numPois;
    private int currKey = 0;
    boolean isSelected = false;
    
    // Create layer, might not need to construct more layers cause they are already all there
    
    public Layer(String category){
        
        this.category = category;
        numPois = 0;
        
    }
    
    // Add POI with no metadata to Hashtable using numPois as the key
    
    public void addPOI() {
    
        if (pois == null) {
            
            pois = new Hashtable<>();
            
        }
        
        pois.put(currKey, new POI(currKey));
        
        numPois++;
        currKey++;
    
    }
    
    // Add POI with metadata to Hashtable using numPois as the key
    
    public void addPOI(String poiName, String floor, String poiType, String poiCategory, int poiRoomNumber, String poiDescription, int poiX, int poiY) {
    
        if (pois == null) {
            
            pois = new Hashtable<>();
            
        }
        
    pois.put(currKey, new POI(poiName, floor, poiType, poiCategory, poiRoomNumber, poiDescription, poiX, poiY, currKey));
    
    numPois++;
    currKey++;
    
}
    
    // If Hashtable and key exists then it removes that POI from the Hashtable
    
    public void removePOI(int key) {
        
        if (pois != null && pois.get(key) != null) {
        
            pois.remove(key);
        
            numPois--;
        }
    }
    
    public String getCategory() {
        
        return category;
        
    }
    
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
    
    public boolean getIsSelected() {
        
        
        
        return isSelected;
        
    }
    
    public void setIsSelected(boolean isSelected) {
        
        this.isSelected = isSelected;
        
    }
    
}
