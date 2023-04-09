
/**
 *
 * @author ben
 */
public class POI {
    
    //private Layer layer;
    //private Map map;
    private String type;
    private String category;
    private String name;
    private String roomNumber;
    private String description;
    private boolean favourite;
    private int x_coordinate;
    private int y_coordinate;
    private int key;
    private String floor;
    
    // Create POI with no metadata

    /**
     *
     * @param key
     */
    
    public POI(int key) {
        
        this.key = key;
        
    }
    
    // Create POI with metadata

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
     * @param key
     */
    
    public POI(String poiName, String floor, String poiType, String poiCategory, String poiRoomNumber, String poiDescription, int poiX, int poiY, int key) {
        
        this.type = poiType;
        this.category = poiCategory;
        this.name = poiName;
        this.floor = floor;
        this.roomNumber = poiRoomNumber;
        this.description = poiDescription;
        this.favourite = false;
        this.x_coordinate = poiX;
        this.y_coordinate = poiY;
        this.key = key;
    }
    
    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
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
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     *
     * @param roomNumber
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public boolean isFavourite() {
        return favourite;
    }

    /**
     *
     * @param favourite
     */
    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x_coordinate;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x_coordinate = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y_coordinate;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y_coordinate = y;
    }
    
    /**
     *
     * @return
     */
    public int getKey() {
        return key;
    }
   
    /**
     *
     * @param key
     */
    public void setKey(int key) {
        this.key = key;
    }
    
    /**
     *
     * @return
     */
    public String getfloor() {
        return floor;
    }

    /**
     *
     * @param floor
     */
    public void setfloor(String floor) {
        this.floor = floor;
    }
    
}

