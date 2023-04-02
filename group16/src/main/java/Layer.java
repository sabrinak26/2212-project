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
        
        pois.put(numPois, new POI(numPois));
        
        numPois++;
    
    }
    
    // Add POI with metadata to Hashtable using numPois as the key
    
    public void addPOI(String poiName, String poiType, String poiCategory, int poiRoomNumber, String poiDescription, int poiX, int poiY) {
    
        if (pois == null) {
            
            pois = new Hashtable<>();
            
        }
        
    pois.put(numPois, new POI(poiName, poiType, poiCategory, poiRoomNumber, poiDescription, poiX, poiY, numPois));
    
    numPois++;
    
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
    
}
