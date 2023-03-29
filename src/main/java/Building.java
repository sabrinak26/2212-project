public class Building {
    private String buildingName;
    private String[] levels;

    private String[] levelNames;
    private int id;


    public String[] getLevelNames() {
        return levelNames;
    }

    public void setLevelNames(String[] levelNames) {
        this.levelNames = levelNames;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String[] getLevels() {
        return levels;
    }

    public void setLevels(String[] levels) {
        this.levels = levels;
    }
}
