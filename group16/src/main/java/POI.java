/**
 *
 * @author ben
 */

import com.google.gson.Gson;

public class POI {
    
    //private Layer layer;
    //private Map map;
    private String type;
    private String category;
    private String name;
    private int roomNumber;
    private String description;
    private boolean favourite;
    private int x_coordinate;
    private int y_coordinate;
    private int key;
    
    // Create POI with no metadata
    
    public POI(int key) {
        
        this.key = key;
        
    }
    
    // Create POI with metadata
    
    public POI(String poiName, String poiType, String poiCategory, int poiRoomNumber, String poiDescription, int poiX, int poiY, int key) {
        
        this.type = poiType;
        this.category = poiCategory;
        this.name = poiName;
        this.roomNumber = poiRoomNumber;
        this.description = poiDescription;
        this.favourite = false;
        this.x_coordinate = poiX;
        this.y_coordinate = poiY;
        this.key = key;
    }
    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public int getX() {
        return x_coordinate;
    }

    public void setX(int x) {
        this.x_coordinate = x;
    }

    public int getY() {
        return y_coordinate;
    }

    public void setY(int y) {
        this.y_coordinate = y;
    }
    
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    
}