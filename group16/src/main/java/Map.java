import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import org.imgscalr.Scalr;

public class Map {
    private JPanel panel;
    private JTabbedPane tabs = new JTabbedPane();
    private String floorName;
    private Building building;
    private Building[] buildings = new Building[3];
    private Building currentBuilding;
    private String currentFloor;
    JComboBox<String> cb;
    FileReader fileReader;
    JScrollPane mapPanel;

    // Gets the JTabbedPane with the map in it
    
    public JTabbedPane getTabs() {
        return tabs;
    }

    public void setTabs(JTabbedPane tabs) {
        this.tabs = tabs;
    }
    
    // Creates the gray panel that the map and navigation buttons is in

    public Map() {
        panel = new JPanel();
        panel.setBounds(8, 25, 700, 568);
        panel.setLayout(null);
        
        // Loads all data from JSON files
        
        loadBuildingsData();
    }

    // If diffrent building is clicked then change image to that building
    
    ActionListener cbActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = ((JComboBox) e.getSource()).getSelectedIndex();
            String level = getBuilding().getLevels()[index].replaceAll("\\s+","").toLowerCase();
            System.out.println(level);
            currentFloor = level;
            JLabel picLabel = generatePicLabel(level);
            mapPanel = new JScrollPane(picLabel);
            

            tabs.setComponentAt(tabs.getSelectedIndex(), mapPanel);

            mapPanel.revalidate();
            mapPanel.repaint();
            tabs.revalidate();
            tabs.repaint();
        }
    };


    public void loadBuildingsData() {
        File dir = new File("./src/main/metadata/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
           
            // For each of the 3 JSON files get the data and set the info
            
            for (int i = 0; i < 3; i++) {
                
                    try {
                        
                        Gson gson = new Gson();
                        
                        // This is teh order that the JSON files are read so it pulls data in this order
                        
                        if (i == 0) {
                            
                            fileReader = new FileReader("./src/main/metadata/NaturalSciences.json");
                        
                        } else if (i == 1) {
                            
                            fileReader = new FileReader("./src/main/metadata/Middlesex.json");
                            
                        } else {
                            
                            fileReader = new FileReader("./src/main/metadata/AlumniHall.json");

                        }

                        // This gets the data from the JSON files then sets that to the building class since each JSON file
                        // represents a building
                        
                        building = gson.fromJson(fileReader, Building.class);
                        building.setId(i);
                        buildings[i] = building;
                        
                        
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    // Checks to see if a diffrent diffrent buidling has been selected to change
                    // the levels being shown
                    
                    tabs.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            int index = tabs.getSelectedIndex();
                            building = buildings[index];
                            currentBuilding = building;
                            System.out.println(building.getBuildingName());
                            if (cb != null) panel.remove(cb);
                            cb = new JComboBox<String>(building.getLevels());
                            cb.setBounds(315, 541, 95, 25);
                            panel.add(cb);
                            cb.addActionListener(cbActionListener);

                            panel.revalidate();
                            panel.repaint();

                        }
                    });

                    // Setting current floor, this is the floor that is first shown upon opening
                    
                    currentFloor = "Level 2";
                    
                    
                    // I used these to test adding and removing POIs to diffrent layers, use them if you want to test
                    // added and removing POIs to all buildings, check JSON files to see if it works
                    
                    
                    //building.getLayer("Accessibility").addPOI("OPAAAAAAAA", "Built-in", "Accessibility", 7, "This is OPAAAAA", 578, 75);
                    //building.getLayer("Accessibility").removePOI(0);
                    
                    
                    // Gets label for each buildng
                  
                    JLabel picLabel = generatePicLabel(getBuilding().getLevels()[0].replaceAll("\\s+","").toLowerCase());
                    
                    // Makes the panel that the map is in
                    
                    mapPanel = new JScrollPane(picLabel);

                    // Adds diffrent components to the panel
                    
                    tabs.addTab(building.getBuildingName(), mapPanel);
                    tabs.setPreferredSize(new Dimension(700, 550));
                    tabs.setBounds(0, 0, 700, 550);
                    panel.add(tabs);
                 
            }


            building = buildings[tabs.getSelectedIndex()];

            // Makes the comboBox and gives it the correct levels
            
            if (cb != null) panel.remove(cb);
            cb = new JComboBox<String>(building.getLevels());
            cb.setBounds(315, 541, 95, 25);
            
            cb.addActionListener(cbActionListener);
            panel.add(cb);
            cb.setMaximumSize(cb.getPreferredSize()); 
            
        } else {
            System.out.println("./src/main/metadata/ does not exist");
        }
    }
    
    // Creates labels

    JLabel generatePicLabel(String level) {
        JLabel picLabel = null;
        try {
            File file = new File("./src/main/images/" + building.getBuildingName().replaceAll("\\s+","") + "/" + level + ".jpg");
            BufferedImage myPicture = ImageIO.read(file);
            BufferedImage scaledImg = Scalr.resize(myPicture, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, 800, 400, Scalr.OP_ANTIALIAS);
            picLabel = new JLabel(new ImageIcon(scaledImg));
            picLabel.setPreferredSize(new Dimension(scaledImg.getWidth(), scaledImg.getHeight()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picLabel;
    }

    // Reutnrs building object
    
    public Building getBuilding() {
        return building;
    }
    
    // Returns desired building object from name of that building
    
    public Building getBuilding(String buildingName) {
        
        if ((buildingName.equalsIgnoreCase("NaturalSciences")) || (buildingName.equalsIgnoreCase("Natural Sciences"))) {
            
            return buildings[0];
        } else if (buildingName.equalsIgnoreCase("Middlesex")) {
            
            return buildings[1];
        } else{
            
            return buildings[2];
            
        }
        
        
        
    }
    
    

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public JPanel getPanel() {
        return panel;
    }
    
    // Set building that is currently being viewed
    
    public void setCurrentBuilding(Building currentBuilding){
        
        this.currentBuilding = currentBuilding;
        
    }
    
    // Get building that is currently being viewed
    
    public Building getCurrentBuilding(){
        
        return currentBuilding;
        
    }
    
    // Set floor that is currently being viewed
    
    public void setcurrentFloor(String currentFloor){
        
        this.currentFloor = currentFloor;
        
    }
    
    // Get floor that is currently being viewed
    
    public String getcurrentFloor(){
        
        return currentFloor;
        
    }
}
  