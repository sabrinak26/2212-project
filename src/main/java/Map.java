import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.imgscalr.Scalr;
import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.awt.event.*;


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
    private Hashtable<String, JLayeredPane> layeredPanes;
    JCheckBox accCheckBox = new JCheckBox();
    JCheckBox classCheckBox = new JCheckBox();
    JCheckBox favCheckBox = new JCheckBox();
    JCheckBox labCheckBox = new JCheckBox(); 
    JCheckBox resCheckBox = new JCheckBox();  
    JCheckBox userCheckBox = new JCheckBox();
    JCheckBox washCheckBox = new JCheckBox();

    private JButton addNewPOIButton;
    private JTextField poiNameField;
    private JTextField roomNumTextField;
    private JTextField descTextField;
    private JTextField typeTextField;
    private JTextField categoryTextField;
    private JButton submitPOIButton;
    
    private JPopupMenu popup = new JPopupMenu();
    DefaultListModel<String> names = new DefaultListModel<>();
    HashMap<String, POI> map = new HashMap<String, POI>();

            
    JLabel poiName;
    JLabel poiRoom;
    JLabel poiDes;
    
    private String icon = "04d";
    private float temp = 12;    

    public JTabbedPane getTabs() {      
        return tabs;
    }

    public void setTabs(JTabbedPane tabs) {
        this.tabs = tabs;
    }

    public Map() {
        panel = new JPanel();
        panel.setBounds(8, 25, 700, 568);
        panel.setLayout(null);

        
        loadBuildingsData();

    }

    ActionListener cbActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = ((JComboBox) e.getSource()).getSelectedIndex();
            String level = getBuilding().getLevels()[index].replaceAll("\\s+","").toLowerCase();
            accCheckBox.setSelected(false);
            classCheckBox.setSelected(false);
            favCheckBox.setSelected(false); 
            labCheckBox.setSelected(false);       
            resCheckBox.setSelected(false); 
            userCheckBox.setSelected(false);
            washCheckBox.setSelected(false);
            
            if (currentBuilding != null && currentFloor != null) {
                            
                removePOIsFromMap(getCurrentBuilding().getLayer("Accessibility").getPOIs());
                removePOIsFromMap(getCurrentBuilding().getLayer("Classrooms").getPOIs());
                removePOIsFromMap(getCurrentBuilding().getLayer("Favourites").getPOIs());
                removePOIsFromMap(getCurrentBuilding().getLayer("Labs").getPOIs());
                removePOIsFromMap(getCurrentBuilding().getLayer("Restaurants").getPOIs());
                removePOIsFromMap(getCurrentBuilding().getLayer("User defined POIs").getPOIs());
                removePOIsFromMap(getCurrentBuilding().getLayer("Washrooms").getPOIs());
                
                names.removeAllElements();
                popup.removeAll();
           
            }
            
            System.out.println(level);
            currentFloor = level;
            System.out.println("THIS IS 1");
            JLayeredPane layeredPane = generateLayeredPane(level);
            mapPanel = new JScrollPane(layeredPane);
            

            tabs.setComponentAt(tabs.getSelectedIndex(), mapPanel);

            mapPanel.revalidate();
            mapPanel.repaint();
            tabs.revalidate();
            tabs.repaint();
        }
    };

    public Map( JButton addNewPOIButton, JTextField poiNameField, JTextField typeTextField, JTextField descTextField, JTextField roomNumTextField, JTextField categoryTextField, JButton submitPOIButton ) {
        panel = new JPanel();
        panel.setBounds(8, 25, 700, 568);
        panel.setLayout(null);


        this.addNewPOIButton = addNewPOIButton;
        this.poiNameField = poiNameField;
        this.roomNumTextField = roomNumTextField;
        this.typeTextField = typeTextField;
        this.descTextField = descTextField;
        this.categoryTextField = categoryTextField;
        this.submitPOIButton = submitPOIButton;
        
        

        loadBuildingsData();

        cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = ((JComboBox) e.getSource()).getSelectedIndex();
                String level = getBuilding().getLevels()[index].replaceAll("\\s+","").toLowerCase();
                
                accCheckBox.setSelected(false);
                classCheckBox.setSelected(false);
                favCheckBox.setSelected(false); 
                labCheckBox.setSelected(false);       
                resCheckBox.setSelected(false); 
                userCheckBox.setSelected(false);
                washCheckBox.setSelected(false);

                if (currentBuilding != null && currentFloor != null) {

                    removePOIsFromMap(getCurrentBuilding().getLayer("Accessibility").getPOIs());
                    removePOIsFromMap(getCurrentBuilding().getLayer("Classrooms").getPOIs());
                    removePOIsFromMap(getCurrentBuilding().getLayer("Favourites").getPOIs());
                    removePOIsFromMap(getCurrentBuilding().getLayer("Labs").getPOIs());
                    removePOIsFromMap(getCurrentBuilding().getLayer("Restaurants").getPOIs());
                    removePOIsFromMap(getCurrentBuilding().getLayer("User defined POIs").getPOIs());
                    removePOIsFromMap(getCurrentBuilding().getLayer("Washrooms").getPOIs());

                    names.removeAllElements();
                    popup.removeAll();
                }
                
                System.out.println(level);
                currentFloor = level;
                System.out.println("THIS IS 1");
                JLayeredPane layeredPane = generateLayeredPane(level);
                mapPanel = new JScrollPane(layeredPane);



                tabs.setComponentAt(tabs.getSelectedIndex(), mapPanel);

                mapPanel.revalidate();
                mapPanel.repaint();
                tabs.revalidate();
                tabs.repaint();

            }
        };

    }
    public void loadBuildingsData() {
        File dir = new File("./src/main/metadata/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {

            
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

                        building = gson.fromJson(fileReader, Building.class);
                        building.setId(i);
                        buildings[i] = building;
                        
                        
                        setCurrentBuilding(building);
                        
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    tabs.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            int index = tabs.getSelectedIndex();
                            accCheckBox.setSelected(false);
                            classCheckBox.setSelected(false);
                            favCheckBox.setSelected(false); 
                            labCheckBox.setSelected(false);       
                            resCheckBox.setSelected(false); 
                            userCheckBox.setSelected(false);
                            washCheckBox.setSelected(false);
                            
                            if (currentBuilding != null && currentFloor != null) {
                            
                                removePOIsFromMap(getCurrentBuilding().getLayer("Accessibility").getPOIs());
                                removePOIsFromMap(getCurrentBuilding().getLayer("Classrooms").getPOIs());
                                removePOIsFromMap(getCurrentBuilding().getLayer("Favourites").getPOIs());
                                removePOIsFromMap(getCurrentBuilding().getLayer("Labs").getPOIs());
                                removePOIsFromMap(getCurrentBuilding().getLayer("Restaurants").getPOIs());
                                removePOIsFromMap(getCurrentBuilding().getLayer("User defined POIs").getPOIs());
                                removePOIsFromMap(getCurrentBuilding().getLayer("Washrooms").getPOIs());
                                names.removeAllElements();
                                popup.removeAll();
                        
                            }
                                
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

                    
                    // Gets label for each buildng
                    System.out.println("THIS IS 2");
                    JLayeredPane layeredPane = generateLayeredPane(getBuilding().getLevels()[0].replaceAll("\\s+","").toLowerCase());
                    

                    JScrollPane mapPanel = new JScrollPane(layeredPane);



                    if ( addNewPOIButton != null ) {
                        addNewPOIButton.addActionListener(f ->
                        {
                            addNewPOIButton.setText("Select where you want to add your POI and click");
                            layeredPane.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    int x = e.getX()-9;
                                    int y = e.getY()-28;

                                    addMarker(x, y, currentBuilding.getBuildingName(),  currentFloor);

                                    System.out.println(x + "," + y);//these co-ords are relative to the component
                                    addNewPOIButton.setVisible(false);

                                    poiNameField.setVisible(true);
                                    poiNameField.addFocusListener(new FocusListener() {
                                        @Override
                                        public void focusGained(FocusEvent e) {
                                            if (poiNameField.getText().equals("Enter POI Name")) {
                                                poiNameField.setText("");
                                                poiNameField.setForeground(Color.BLACK);
                                            }
                                        }
                                        @Override
                                        public void focusLost(FocusEvent e) {
                                            if (poiNameField.getText().isEmpty()) {
                                                poiNameField.setForeground(Color.GRAY);
                                                poiNameField.setText("Enter POI Name");
                                            }
                                        }
                                    });



                                    typeTextField.setVisible(true);


                                    descTextField.setVisible(true);


                                    roomNumTextField.setVisible(true);


                                    categoryTextField.setVisible(true);


                                    submitPOIButton.setVisible(true);

                                    submitPOIButton.addActionListener( g -> {
                                        submitPOIButton.setVisible(false);
                                        String name = poiNameField.getText();
                                        String type = typeTextField.getText();
                                        String desc = descTextField.getText();
                                        int roomNum = Integer.parseInt(roomNumTextField.getText());
                                        String category = categoryTextField.getText();
                                        System.out.println("name: "+poiNameField.getText() + " type: "+typeTextField.getText() +" desc: "+descTextField.getText() + " room #: "+roomNumTextField.getText() + " category: " + categoryTextField.getText());

                                        currentBuilding.getLayer( categoryTextField.getText() ).addPOI(name, currentFloor, type, category, roomNum, desc, x, y);

                                        poiNameField.setVisible(false);
                                        typeTextField.setVisible(false);
                                        descTextField.setVisible(false);
                                        roomNumTextField.setVisible(false);
                                        categoryTextField.setVisible(false);

                                        addNewPOIButton.setVisible(true);

                                    } );

                                }

                                @Override
                                public void mousePressed(MouseEvent e) {

                                }

                                @Override
                                public void mouseReleased(MouseEvent e) {

                                }

                                @Override
                                public void mouseEntered(MouseEvent e) {

                                }

                                @Override
                                public void mouseExited(MouseEvent e) {

                                }
                            });


                        });
                    }

                    
                    tabs.addTab(building.getBuildingName(), mapPanel);
                    tabs.setPreferredSize(new Dimension(700, 550));
                    tabs.setBounds(0, 0, 700, 550);
                    panel.add(tabs);
                 
            }


            currentFloor = "Level 2";
            
            setCurrentBuilding(getBuilding("NaturalSciences"));

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
        System.out.println("THIS IS 3");

    }

    // Creates labels

    JLayeredPane generateLayeredPane(String level) {
        System.out.println("./src/main/images/" + currentBuilding.getBuildingName().replaceAll("\\s+","") + "/" + level + ".jpg" + "AHHHHHH");
        JLabel picLabel = null;
        JLayeredPane layeredPane = null;
        try {
            File file = new File("./src/main/images/" + currentBuilding.getBuildingName().replaceAll("\\s+","") + "/" + level + ".jpg");

            BufferedImage myPicture = ImageIO.read(file);
            BufferedImage scaledImg = Scalr.resize(myPicture, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, 800, 400, Scalr.OP_ANTIALIAS);
            picLabel = new JLabel(new ImageIcon(scaledImg));
            picLabel.setPreferredSize(new Dimension(scaledImg.getWidth(), scaledImg.getHeight()));

            
            picLabel.setPreferredSize(new Dimension(picLabel.getIcon().getIconWidth(), picLabel.getIcon().getIconHeight()));
                    
                    
            layeredPane = new JLayeredPane();
            layeredPane.setPreferredSize(picLabel.getPreferredSize());

            layeredPane.add(picLabel, JLayeredPane.DEFAULT_LAYER);
            picLabel.setBounds(0, 0, picLabel.getPreferredSize().width, picLabel.getPreferredSize().height);
 
            // Layered pane is here
            layeredPane.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int x = e.getX()-9;
                    int y = e.getY()-28;

                    addMarker(x, y, currentBuilding.getBuildingName(),  currentFloor);

                    System.out.println(x + "," + y);//these co-ords are relative to the component
                    addNewPOIButton.setVisible(false);
                    poiNameField.setVisible(true);
                    typeTextField.setVisible(true);
                    descTextField.setVisible(true);
                    roomNumTextField.setVisible(true);
                    submitPOIButton.setVisible(true);
                    categoryTextField.setVisible(true);

                    submitPOIButton.addActionListener( g -> {
                        String name = poiNameField.getText();
                        String type = typeTextField.getText();
                        String desc = descTextField.getText();
                        int roomNum = Integer.parseInt(roomNumTextField.getText());
                        String category = categoryTextField.getText();
                        System.out.println("name: "+poiNameField.getText() + " type: "+typeTextField.getText() +" desc: "+descTextField.getText() + " room #: "+roomNumTextField.getText() + " category: " + categoryTextField.getText());

                        currentBuilding.getLayer( categoryTextField.getText() ).addPOI(name, currentFloor, type, category, roomNum, desc, x, y);

                    } );

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });


            addLayeredPane(currentBuilding.getBuildingName(), level, layeredPane);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return layeredPane;
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
    
    public void addPOIToMap(POI poi) {
        
        addMarker(poi.getX(),poi.getY(), currentBuilding.getBuildingName(), poi.getfloor(), poi);
        
    }
    
    public void addPOIsToMap(POI[] pois) {
        System.out.println("AHHHH");
        for (int i = 0; i < pois.length; i++) {
        
            POI poi = pois[i];
            System.out.println(poi.getName());
            System.out.println("I'm before");
            System.out.println("I'm before");
            System.out.println(currentFloor);
            System.out.println(poi.getfloor());
            System.out.println(poi.getfloor());
            if (poi.getfloor().replaceAll("\\s+","").toLowerCase().equalsIgnoreCase(currentFloor.replaceAll("\\s+","").toLowerCase())) {
                System.out.println("I THE ONE THAT YOU WANT");
                addMarker(poi.getX(), poi.getY(), currentBuilding.getBuildingName().replaceAll("\\s+","").toLowerCase(), poi.getfloor().replaceAll("\\s+","").toLowerCase(), poi);
            
            }
         
        }
    }
        
    public void removePOIsFromMap(POI[] pois) {
        System.out.println("AHHHH: The Squeekqual");
        for (int i = 0; i < pois.length; i++) {
            
            POI poi = pois[i];
            System.out.println(poi.getName());
            
            if (poi.getfloor().replaceAll("\\s+","").toLowerCase().equalsIgnoreCase(currentFloor.replaceAll("\\s+","").toLowerCase())) {
            System.out.println("I THE ONE THAT YOU WANT");
            removeMarker(poi.getX(),poi.getY(), currentBuilding.getBuildingName().replaceAll("\\s+","").toLowerCase(), poi.getfloor().replaceAll("\\s+","").toLowerCase());
    
            }
    }
        
        
    }
    
    public void addPOI(int x, int y) {
        
      
    }
    
    public void addMarker(int x, int y, String building, String level, POI poi) {
       System.out.print("TESTINGHEH");
        
       
        JLabel marker = new JLabel();
        marker.setIcon(new ImageIcon("./src/main/images/icons/POI.png")); // replace with path to your blue dot image
        
        marker.setPreferredSize(new Dimension(18, 28)); // set the size of the dot
        marker.setBackground(Color.GREEN);
        marker.setFocusable(true);
        marker.setOpaque(false);

        // Get the correct JLayeredPane based on the building and level strings
        JLayeredPane pane = getLayeredPane(building, level);

        // Add the blue dot to the correct JLayeredPane at the given coordinates
        pane.add(marker, JLayeredPane.PALETTE_LAYER); // add to the lowest layer
        marker.setBounds(x, y, marker.getPreferredSize().width, marker.getPreferredSize().height);
        pane.moveToFront(marker);

        // Refresh the JLayeredPane to show the added dot
        

        marker.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            System.out.println("PRITNINGGGGGGGG" + x + building);
            marker.requestFocusInWindow();
            marker.setBackground(Color.GREEN);
            marker.setOpaque(true);
            
            //pane.revalidate();
            //pane.repaint();
            }
        });
        
        marker.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                System.out.println("Label focused");
                
                Main main = new Main();

                String roomNum = String.valueOf(poi.getRoomNumber());

                main.setPoiInfo(poi.getName(), roomNum, poi.getDescription());
                
                marker.setBackground(Color.GREEN);
                marker.setOpaque(true);
                
                pane.revalidate();
                pane.repaint();
            }
            
            public void focusLost(FocusEvent e) {
                
                Main main = new Main();
                
                main.setPoiInfo("", "", "");
                
                System.out.println("Label focus lost");
                marker.setBackground(Color.WHITE);
                marker.setOpaque(false);
                pane.revalidate();
                pane.repaint();
            }
        });
        
        pane.addMouseListener(new MouseAdapter() {
                @Override
                    public void mouseClicked(MouseEvent e) {
                    
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
                }
            });
        
       
        pane.revalidate();
        pane.repaint();
        this.panel.repaint();
        this.panel.revalidate();
        System.out.println("DID IT REPAINT?");

    }
    
    public void addMarker(int x, int y, String building, String level) {
       System.out.print("TESTINGHEH");
       
        JLabel marker = new JLabel();
        marker.setIcon(new ImageIcon("./src/main/images/icons/POI.png")); // replace with path to your blue dot image
        
        marker.setPreferredSize(new Dimension(18, 28)); // set the size of the dot
        marker.setBackground(Color.GREEN);
        marker.setFocusable(true);
        marker.setOpaque(false);

        // Get the correct JLayeredPane based on the building and level strings
        JLayeredPane pane = getLayeredPane(building, level);

        // Add the blue dot to the correct JLayeredPane at the given coordinates
        pane.add(marker, JLayeredPane.PALETTE_LAYER); // add to the lowest layer
        marker.setBounds(x, y, marker.getPreferredSize().width, marker.getPreferredSize().height);
        pane.moveToFront(marker);

        // Refresh the JLayeredPane to show the added dot
        

        marker.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            System.out.println("PRITNINGGGGGGGG" + x + building);
            marker.requestFocusInWindow();
            marker.setBackground(Color.GREEN);
            marker.setOpaque(true);
            
            //pane.revalidate();
            //pane.repaint();
            }
        });
       
        marker.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                System.out.println("Label focused");
                marker.setBackground(Color.GREEN);
                marker.setOpaque(true);
                
                pane.revalidate();
                pane.repaint();
            }
            
            public void focusLost(FocusEvent e) {
                System.out.println("Label focus lost");
                marker.setBackground(Color.WHITE);
                marker.setOpaque(false);
                pane.revalidate();
                pane.repaint();
            }
        });
        
        pane.addMouseListener(new MouseAdapter() {
                @Override
                    public void mouseClicked(MouseEvent e) {
                    
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
                }
            });
        
       
        pane.revalidate();
        pane.repaint();
        this.panel.repaint();
        this.panel.revalidate();
        System.out.println("DID IT REPAINT?");

    }
    
    
    public void selectMarker(int x, int y, String building, String level){
        
        JLayeredPane pane = getLayeredPane(building, level);
        Component[] components = pane.getComponents();
        
        
        for (Component component : components) {
            if (component instanceof JComponent)
                ((JComponent) component).scrollRectToVisible(new Rectangle(x-100,y-100,1,1));
            if (component instanceof JLabel) {
                JLabel marker = (JLabel) component;
                if (marker.getX() == x && marker.getY() == y) {
                    marker.grabFocus();
                }
            }
        }
    }
    
    
    public void removeMarker(int x, int y, String building, String level) {
        
       JLayeredPane pane = getLayeredPane(building, level);
        Component[] components = pane.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel marker = (JLabel) component;
                if (marker.getX() == x && marker.getY() == y) {
                    pane.remove(marker);
                    pane.revalidate();
                    pane.repaint();
                    this.panel.repaint();
                    this.panel.revalidate();
                    
                }
            }
        }

    }
    
    public JLayeredPane getLayeredPane(String building, String level) {
        
        level = level.replaceAll("\\s+","").toLowerCase();
        building = building.replaceAll("\\s+","").toLowerCase();
        String key = level + building;
        
        return layeredPanes.get(key);
        
    }

    public void addLayeredPane(String building, String level, JLayeredPane pane) {
        System.out.println("ADDED A LAYERED PANE");
        level = level.replaceAll("\\s+","").toLowerCase();
        building = building.replaceAll("\\s+","").toLowerCase();
        String key = level + building;
        
        if (layeredPanes == null) {
            
            layeredPanes = new Hashtable<>();
            
        }
        
        layeredPanes.put(key, pane);

    }

    public Building[] getBuildings() {
        return this.buildings;
    }
    
    public JCheckBox[] getCheckBoxs() {
        
        JCheckBox[] boxs = {accCheckBox, classCheckBox, favCheckBox, labCheckBox, resCheckBox, userCheckBox, washCheckBox};
        
        return boxs;
        
    }
    
    //Utilizes Open Weather API to find current weather
    public void getWeather() throws IOException, InterruptedException{
        
        //https request code from https://github.com/mjg123/java-http-clients/blob/master/src/main/java/com/twilio/JavaHttpClientDemo.java
        
        HttpClient client = HttpClient.newHttpClient();
        
        //generates the actual request. "appid={}"is the api key, replace if needed.
        HttpRequest request = HttpRequest.newBuilder(
            URI.create("https://api.openweathermap.org/data/2.5/weather?lat=42.984924&lon=-81.245277&appid=7289416298553ad8aa7670c1ef8455d3"))
            .header("accept", "application/json")
            .build();
        
        //actually does the api things
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        //for some reason it cant return a json from a json type response,,, so we parse it instead
        JsonObject weather = new Gson().fromJson(response.body(), JsonObject.class);
        
        
        //System.out.println(response.body());
        
        //search through json for the icon and tempurature 
        icon = weather.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();  //icon in format "xxc" for unique icon codes
        temp = weather.getAsJsonObject("main").get("temp").getAsFloat() - 273.15f; //for some reason it gives kelvin
        
        //System.out.println(forecast);
        //System.out.println(temp);
    }
    
    //getters
    public String getIcon(){
        return this.icon;
    }
    
    public float getTemp(){
        return this.temp;
    }

    //generates a popup for Main to use
    //code modified from https://stackoverflow.com/questions/19064358/how-to-create-a-popup-jpanel-in-a-jframe
    public JPopupMenu makePopup(String category){
        
        //finds selected layer and poi's within it
        Layer layer = currentBuilding.getLayer(category);
        
        POI pois[] = layer.getPOIs();
        
        
        //add all names on current floor
       
        
        for (int i=0; i<pois.length; i++){
            if (pois[i].getfloor().equals(currentFloor) || pois[i].getfloor().replaceAll("\\s+","").toLowerCase().equals(currentFloor))
                if (!names.contains(pois[i].getName())){
                    names.addElement(pois[i].getName());
                    map.put(pois[i].getName(), pois[i]); //possible bug for duplicate names
                }
        }  
        
        //make list :)
        JList JPois = new JList(names);
        
        JPois.addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                POI poi = map.get(JPois.getSelectedValue());
                
                selectMarker(poi.getX(), poi.getY(), currentBuilding.getBuildingName(), poi.getfloor());
            }
        });
            
        popup = new JPopupMenu();
        
        //tbh this just looked pretty
        popup.setLayout(new BorderLayout());
        
        
        popup.add(new JScrollPane(JPois));
        
        //ensure popup doesnt get too big
        int size = names.getSize();
        int height = size<10? size*23-size+5 : 250;
        popup.setPopupSize(100, height);
        
        
        //rutilize the main frame rather than dealing with JFrame.getframes()
        return popup;
    
        }
    
    public void removeFromPopup(String category){
        //finds selected layer and poi's within it
        Layer layer = currentBuilding.getLayer(category);
        POI pois[] = layer.getPOIs();
        
        //int ind;
        for (int i=0; i<names.getSize(); i++){
            //ind = names.indexOf(pois[i].getName());
            names.removeElement(pois[i].getName());
            //popup.remove(ind);
       
        }
        
    }
}

  
