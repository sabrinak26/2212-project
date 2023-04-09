import javax.swing.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import javax.swing.JFrame;

public class Main extends JFrame {

    // Frame is main window that the application uses

    public static Main frame;

    // saved is for when the program needs to know if info is saved, hasnt been
    // implemented yet so I just set it to true

    private static boolean saved;

    // Create help and about buttons

    private static JButton helpButton;
    private static JButton aboutButton;

    // admin access buttons
    private static JTextField userNameTextField;
    private static JPasswordField passwordTextField;
    private static JButton enterCredsButton;

    // Main application window

    // add new POI button
    private static JButton addNewPOIButton;
    private static JTextField poiNameField;
    private static JTextField roomNumTextField;
    private static JTextField descTextField;
    private static JTextField typeTextField;
    private static JTextField categoryTextField;
    private static JButton submitPOIButton;

    // searchPOI fields
    private static JComboBox searchPOIDropDown;
    private static JButton findPOIOnMapButton;

    private static JLabel poiTitle;
    private static JLabel poiRoom;
    private static JLabel poiDes;
    
    // POI HashMap
    private static HashMap POIHashMap;
    private static HashMap BuildingPOIHashMap;
    private static HashMap RoomNumPOIHashMap;
    private static HashMap DescHashMap;

    private static Map map;


    private static void saveJSON() {
        if (map == null) return;
        Gson natSciGson = new Gson();

        try (FileWriter writer = new FileWriter("./src/main/metadata/NaturalSciences.json")) {

            natSciGson.toJson(map.getBuilding("NaturalSciences"), writer);

        } catch (IOException c) {
            c.printStackTrace();
        }

        Gson midSciGson = new Gson();

        try (FileWriter writer = new FileWriter("./src/main/metadata/Middlesex.json")) {

            midSciGson.toJson(map.getBuilding("Middlesex"), writer);

        } catch (IOException c) {
            c.printStackTrace();
        }

        Gson AlumGson = new Gson();

        try (FileWriter writer = new FileWriter("./src/main/metadata/AlumniHall.json")) {

            AlumGson.toJson(map.getBuilding("AlumniHall"), writer);

        } catch (IOException c) {
            c.printStackTrace();
        }
    }

    private static void generateCheckboxActionListeners() {
        String[] layers = {"Accessibility", "Classrooms", "Favourites", "Labs", "Restaurants", "User defined POIs" ,"Washrooms"};
        for (int i = 0; i< map.getCheckBoxs().length; i++) {
            int finalI = i;
            map.getCheckBoxs()[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JCheckBox currCheckBox = ((JCheckBox) e.getSource());
                    if (currCheckBox.isSelected()) {
                        map.addPOIsToMap(map.getCurrentBuilding().getLayer(layers[finalI]).getPOIs());
                        map.updateJustMenu();

                    } else {
                        map.removePOIsFromMap(map.getCurrentBuilding().getLayer(layers[finalI]).getPOIs());

                    }
                }
            });
        }
    }

    private static void setPlaceholder(JTextField textField, String text, boolean isPassword) {
        textField.setText(text);
        textField.setForeground(Color.GRAY);
        if (isPassword) passwordTextField.setEchoChar((char) 0);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(text)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                    if (isPassword) passwordTextField.setEchoChar('*');

                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(text);
                    if (isPassword) passwordTextField.setEchoChar((char) 0);
                }
            }
        });
    }


    private static void generateSearchField() {
        String[] poiList = new String[] {};
        for (int i = 0; i < map.getBuildings().length; i++) {
            Building curr = map.getBuildings()[i];
            String[] accPoi = curr.getLayer("Accessibility").getPOIInformation();
            String[] classPoi = curr.getLayer("Classrooms").getPOIInformation();
            String[] favPoi = curr.getLayer("Favourites").getPOIInformation();
            String[] labPoi = curr.getLayer("Labs").getPOIInformation();
            String[] restaurantPoi = curr.getLayer("Restaurants").getPOIInformation();
            String[] userDefPoi = curr.getLayer("User defined POIs").getPOIInformation();
            String[] washroomPoi = curr.getLayer("Washrooms").getPOIInformation();

            String[] tempArr = new String[poiList.length + accPoi.length + classPoi.length + favPoi.length
                    + labPoi.length + restaurantPoi.length + userDefPoi.length + washroomPoi.length];
            System.arraycopy(poiList, 0, tempArr, 0, poiList.length);
            System.arraycopy(accPoi, 0, tempArr, poiList.length, accPoi.length);
            System.arraycopy(classPoi, 0, tempArr, poiList.length + accPoi.length, classPoi.length);
            System.arraycopy(favPoi, 0, tempArr, poiList.length + accPoi.length + classPoi.length, favPoi.length);
            System.arraycopy(labPoi, 0, tempArr, poiList.length + accPoi.length + classPoi.length + favPoi.length,
                    labPoi.length);
            System.arraycopy(restaurantPoi, 0, tempArr,
                    poiList.length + accPoi.length + classPoi.length + favPoi.length + labPoi.length,
                    restaurantPoi.length);
            System.arraycopy(userDefPoi, 0, tempArr, poiList.length + accPoi.length + classPoi.length + favPoi.length
                    + labPoi.length + restaurantPoi.length, userDefPoi.length);
            System.arraycopy(washroomPoi, 0, tempArr, poiList.length + accPoi.length + classPoi.length + favPoi.length
                    + labPoi.length + restaurantPoi.length + userDefPoi.length, washroomPoi.length);
            poiList = tempArr;

        }

        searchPOIDropDown = new JComboBox(poiList);
        searchPOIDropDown.setBounds(730, 120, 250, 20);
        AutoComplete.enable(searchPOIDropDown); 

        findPOIOnMapButton = new JButton("find poi");
        findPOIOnMapButton.setBounds(730, 200, 100, 20);
        findPOIOnMapButton.addActionListener(e -> {
            System.out.println("The selected POI to search is: "
                    + searchPOIDropDown.getItemAt(searchPOIDropDown.getSelectedIndex()));
            String toSearchFor = (String) searchPOIDropDown.getItemAt(searchPOIDropDown.getSelectedIndex());

            POI searchedPOI = (POI) POIHashMap.get(toSearchFor);

            if (searchedPOI != null) {

                System.out.println("selecting marker");
                map.selectMarker(searchedPOI.getX(), searchedPOI.getY(),
                        ((Building) BuildingPOIHashMap.get(searchedPOI.getName())).getBuildingName(),
                        searchedPOI.getfloor());
                map.addPoIToMapLevel(searchedPOI,
                        (String) ((Building) BuildingPOIHashMap.get(searchedPOI.getName())).getBuildingName());
            } else {
                searchedPOI = (POI) DescHashMap.get(toSearchFor);

                if (searchedPOI != null) {
                    System.out.println("selecting marker");
                    map.addPoIToMapLevel(searchedPOI,
                            (String) ((Building) BuildingPOIHashMap.get(searchedPOI.getName())).getBuildingName());
                    map.selectMarker(searchedPOI.getX(), searchedPOI.getY(),
                            ((Building) BuildingPOIHashMap.get(searchedPOI.getName())).getBuildingName(),
                            searchedPOI.getfloor());
                } else {
                    searchedPOI = (POI) RoomNumPOIHashMap.get(toSearchFor);
                    if (searchedPOI != null) {
                        System.out.println("selecting marker");
                        map.selectMarker(searchedPOI.getX(), searchedPOI.getY(),
                                ((Building) BuildingPOIHashMap.get(searchedPOI.getName())).getBuildingName(),
                                searchedPOI.getfloor());
                        map.addPoIToMapLevel(searchedPOI,
                                (String) ((Building) BuildingPOIHashMap.get(searchedPOI.getName())).getBuildingName());
                    }

                }

            }
        });

        frame.add(searchPOIDropDown);
        frame.add(findPOIOnMapButton);
    }


    private static void loginActionListener(JFrame frame, JButton enterCredsButton) {
        enterCredsButton.addActionListener(e -> {
            // System.out.println("go to admin page");

            boolean passwordWorks = true;
            char[] enteredPassword = passwordTextField.getPassword();
            char[] validPassword = new char[] { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };

            if (validPassword.length != enteredPassword.length) {
                passwordWorks = false;
            } else {
                for (int i = 0; i < enteredPassword.length; i++) {
                    if (enteredPassword[i] != validPassword[i]) {
                        passwordWorks = false;
                    }
                }
            }

            if (userNameTextField.getText().equalsIgnoreCase("Admin") && passwordWorks) {
                if (frame != null) frame.dispose();
                openAdminFrame();
            } else {
                System.out.println("incorrect password");
                passwordTextField.setEchoChar((char) 0);
                passwordTextField.setText("Incorrect Password Entered");
            }

        });
    }


    private static void logoutActionListener(JFrame frame, JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the main frame when the start button is clicked
                saveJSON();
                if(frame != null) frame.dispose();
                openMainFrame();
            }
        });
    }

    private static void openMainFrame() {

        // Creates frame
        frame = new Main();


        // Info about frame
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Group 16 - UWO GIS");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(49, 39, 131));

        map = new Map();
        POIHashMap = new HashMap();
        BuildingPOIHashMap = new HashMap();
        DescHashMap = new HashMap();
        RoomNumPOIHashMap = new HashMap();
        Building[] buildingList = map.getBuildings();

        saved = true;

        // Populates Hashmaps for each of the metadata
        for (int i = 0; i < buildingList.length; i++) {
            Layer[] curr_building_layer = buildingList[i].getLayers();

            for (int j = 0; j < curr_building_layer.length; j++) {
                POI[] poiList = curr_building_layer[j].getPOIs();

                for (int k = 0; k < poiList.length; k++) {
                    String curr_poi_name = poiList[k].getName();

                    if (!POIHashMap.containsKey(curr_poi_name)) {
                        POIHashMap.put(curr_poi_name, poiList[k]);
                        BuildingPOIHashMap.put(curr_poi_name, buildingList[i]);
                        RoomNumPOIHashMap.put(poiList[k].getRoomNumber() + "", poiList[k]);
                        DescHashMap.put(poiList[k].getDescription(), poiList[k]);
                    }
                }
            }
        }
        
        map.addFaves();

        // sets weather parameters/
        // LIMITED REQUESTS - uncomment only when feature needed
        /*
         * try {
         * map.getWeather();
         * } catch (IOException ex) {
         * Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         * } catch (InterruptedException ex) {
         * Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         * }
         */

        generateSearchField();

        // Adds map panel
        frame.add(map.getPanel());

        // Adds help and about buttons

        frame.add(aboutButton);
        frame.add(helpButton);

        // add admin access fields
        userNameTextField = new JTextField("Username");
        passwordTextField = new JPasswordField();
        enterCredsButton = new JButton("Enter");



        setPlaceholder(userNameTextField, "Username", false);
        setPlaceholder(passwordTextField, "Password", true);
        loginActionListener(frame, enterCredsButton);

        userNameTextField.setBounds(142, 0, 100, 25);
        passwordTextField.setBounds(242, 0, 100, 25);
        enterCredsButton.setBounds(342, 0, 75, 25);
        frame.add(userNameTextField);
        frame.add(passwordTextField);
        frame.add(enterCredsButton);

        // generates icon from url provided by Open Weather Map
        URL url = null;
        try {
            url = new URL("https://openweathermap.org/img/wn/" + map.getIcon() + "@2x.png");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // gen image label
        ImageIcon weatherImg = new ImageIcon(url);
        JLabel weatherLabel = new JLabel();
        weatherLabel.setIcon(weatherImg);
        weatherLabel.setBounds(0, 0, weatherImg.getIconWidth(), weatherImg.getIconHeight());

        // set text label for temp
        JLabel weatherText = new JLabel();
        weatherText.setText(String.format("%.1f\u00B0C", map.getTemp()));
        weatherText.setForeground(Color.white);
        weatherText.setBounds(0, -25, weatherImg.getIconWidth(), weatherImg.getIconHeight());

        // create pane to add weather to
        JLayeredPane weatherLayeredPane = new JLayeredPane();
        weatherLayeredPane.setBounds(weatherLabel.getBounds());
        weatherLayeredPane.add(weatherLabel, JLayeredPane.DEFAULT_LAYER);
        weatherLayeredPane.add(weatherText, JLayeredPane.CENTER_ALIGNMENT);

        // create transparent panel to display
        JPanel weatherPanel = new JPanel();
        weatherPanel.setLayout(null);
        weatherPanel.setBounds(860, 0, weatherImg.getIconWidth() + 10, weatherImg.getIconHeight() + 40);
        weatherPanel.setOpaque(false);

        weatherPanel.add(weatherLayeredPane);

        // layersPanel.setBounds(720, 260, 270, 400);

        ImageIcon layersImage = new ImageIcon("./src/main/images/icons/layers.png");
        JLabel layersLabel = new JLabel();
        //layersLabel.setIcon(layersImage);
        //layersLabel.setBounds(0, 0, layersImage.getIconWidth(), layersImage.getIconHeight());
        layersLabel.setBounds(0, 0, layersImage.getIconWidth()/5, layersImage.getIconHeight());

        JLayeredPane layerLayeredPane = new JLayeredPane();
        layerLayeredPane.setBounds(0, 0, layersImage.getIconWidth()/5, layersImage.getIconHeight());
        layerLayeredPane.add(layersLabel, JLayeredPane.DEFAULT_LAYER);

        JPanel layersPanel = new JPanel();
        layersPanel.setLayout(null); // set the layout to null to use setBounds
        layersPanel.setBounds(720, 260, layersImage.getIconWidth()/5, layersImage.getIconHeight());
        
        
        for (int i = 0; i < map.getCheckBoxs().length; i++) {
            map.getCheckBoxs()[i].setSelected(true);
            map.getCheckBoxs()[i].setBounds(12, 25+(55*i), 25, 25);
            layerLayeredPane.add(map.getCheckBoxs()[i]);
        }

        layersPanel.add(layerLayeredPane);

        frame.add(layersPanel);
        frame.add(weatherPanel);

        JPanel poiInfo = new JPanel();
        poiInfo.setLayout(null);
        poiInfo.setBounds(28, 600, 660, 65);
        poiInfo.setOpaque(true);

        JLayeredPane poiLayeredPane = new JLayeredPane();
        poiLayeredPane.setSize(poiInfo.getSize());

        JLabel label = new JLabel("Selected POI:");
        label.setBounds(5, 0, 100, 30);
        poiLayeredPane.add(label, JLayeredPane.DEFAULT_LAYER);

        JLabel poiName = new JLabel("POI name:");
        poiName.setBounds(200, 0, 80, 30);
        poiLayeredPane.add(poiName, JLayeredPane.DEFAULT_LAYER);

        JLabel poiRoomNumber = new JLabel("POI Room Number:");
        poiRoomNumber.setBounds(400, 0, 120, 30);
        poiLayeredPane.add(poiRoomNumber, JLayeredPane.DEFAULT_LAYER);

        JLabel poiDescription = new JLabel("POI Description:");
        poiDescription.setBounds(200, 30, 110, 30);
        poiLayeredPane.add(poiDescription, JLayeredPane.DEFAULT_LAYER);

        poiTitle = new JLabel("");
        poiRoom = new JLabel("");
        poiDes = new JLabel("");

        poiTitle.setBounds(267, 0, 200, 30);
        poiLayeredPane.add(poiTitle, JLayeredPane.DEFAULT_LAYER);
        poiRoom.setBounds(523, 0, 120, 30);
        poiLayeredPane.add(poiRoom, JLayeredPane.DEFAULT_LAYER);
        poiDes.setBounds(305, 30, 300, 30);
        poiLayeredPane.add(poiDes, JLayeredPane.DEFAULT_LAYER);


        JLabel favLab = new JLabel("Favourite");
        favLab.setBounds(10,30,150,30);
        poiLayeredPane.add(favLab, JLayeredPane.MODAL_LAYER);
        
        JButton favourite = new JButton();
        favourite.setBounds(75,30,25,25);
        favourite.setText("+");
        favourite.setBorder(BorderFactory.createEmptyBorder());
        favourite.setFocusable(false);
        favourite.setVisible(false);
        
        poiLayeredPane.add(favourite, JLayeredPane.MODAL_LAYER);
         
        poiInfo.add(poiLayeredPane);        
        poiRoom.addPropertyChangeListener("text", e -> {
            
            if (!poiTitle.getText().equals("")){
                favourite.setVisible(true);
                POI poi = ((POI) RoomNumPOIHashMap.get(poiRoom.getText()));
                if (poi.isFavourite()){
                    favourite.setText("-");
                }
                else {
                    favourite.setText("+");
                }
            } else favourite.setVisible(false);
        });
        
        //for some reason needs to be RoomNum..
        favourite.addActionListener(e -> {
            POI poi = (POI) RoomNumPOIHashMap.get(poiRoom.getText());
            if (poi==null) return;
            if (favourite.getText().equals("+")){
                poi.setFavourite(true);
                favourite.setText("-");
            }
            else {
                poi.setFavourite(false);
                favourite.setText("+");
            }
                    
            map.updateMenu();
        });
        
        
        
        
        frame.add(poiInfo);
        frame.add(map.getMenuPanel());
        
        frame.setVisible(true);
        
        
        map.updateMenu();
        
        generateCheckboxActionListeners();
        
        map.addAllPois();
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                // If in the middle of task and info not saved then is will promt user if they
                // really want to close
                // If you wnat to see this set saved to false
                // When they close the window it saves all current data to JSON file

                if (!saved) {

                    ImageIcon icon = new ImageIcon("./src/main/images/icons/WesternLogo.png");
                    Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(image);
                    int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Program",
                            JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
                    if (confirm == JOptionPane.YES_OPTION) {

                        // Save info to JSONs

                        saveJSON();
                        System.exit(0);

                    }
                } else {
                    saveJSON();
                    System.exit(0);

                }
            }
        });

    }

    private static void openAdminFrame() {
        System.out.println("inside admin frame");

        // Creates frame
        frame = new Main();

        // Info about frame
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Group 16 - UWO GIS");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(49, 39, 131));

        // make the edit POI interface buttons

        poiNameField = new JTextField("Enter POI name");
        typeTextField = new JTextField("Enter POI type");
        descTextField = new JTextField("Enter POI description");
        roomNumTextField = new JTextField("Enter POI room number ");
        categoryTextField = new JTextField("Enter the category");
        submitPOIButton = new JButton("Submit");

        setPlaceholder(poiNameField, "Enter POI name", false);
        setPlaceholder(typeTextField, "Enter POI type", false);
        setPlaceholder(descTextField, "Enter POI description", false);
        setPlaceholder(roomNumTextField, "Enter POI room number", false);
        setPlaceholder(categoryTextField, "Enter the category", false);

        poiNameField.setBounds(20, 600, 150, 25);
        typeTextField.setBounds(220, 600, 150, 25);
        descTextField.setBounds(20, 630, 150, 25);
        roomNumTextField.setBounds(220, 630, 150, 25);
        categoryTextField.setBounds(420, 600, 150, 25);
        submitPOIButton.setBounds(420, 630, 150, 25);

        frame.add(poiNameField);
        frame.add(typeTextField);
        frame.add(descTextField);
        frame.add(roomNumTextField);
        frame.add(categoryTextField);
        frame.add(submitPOIButton);

        poiNameField.setVisible(false);
        typeTextField.setVisible(false);
        descTextField.setVisible(false);
        roomNumTextField.setVisible(false);
        categoryTextField.setVisible(false);
        submitPOIButton.setVisible(false);

        // addNewPOIButton.setBounds( 200,600, 400,25 );

        // add POI button
        frame.add(addNewPOIButton);

        map = new Map(addNewPOIButton, poiNameField, typeTextField, descTextField, roomNumTextField,
                categoryTextField, submitPOIButton);

        saved = true;


        // Adds map panel

        frame.add(map.getPanel());

        // Adds help and about buttons

        frame.add(aboutButton);
        frame.add(helpButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(142, 0, 75, 25);
        logoutActionListener(frame, logoutButton);
        frame.add(logoutButton);


        ImageIcon layersImage = new ImageIcon("./src/main/images/icons/layers.png");
        JLabel layersLabel = new JLabel();
        layersLabel.setIcon(layersImage);
        layersLabel.setBounds(0, 0, layersImage.getIconWidth(), layersImage.getIconHeight());

        JLayeredPane layerLayeredPane = new JLayeredPane();
        layerLayeredPane.setBounds(0, 0, layersImage.getIconWidth(), layersImage.getIconHeight());
        layerLayeredPane.add(layersLabel, JLayeredPane.DEFAULT_LAYER);

        JPanel layersPanel = new JPanel();
        layersPanel.setLayout(null); // set the layout to null to use setBounds
        layersPanel.setBounds(720, 260, layersImage.getIconWidth(), layersImage.getIconHeight());


        for (int i = 0; i < map.getCheckBoxs().length; i++) {
            map.getCheckBoxs()[i].setSelected(false);
            map.getCheckBoxs()[i].setBounds(12, 25+(55*i), 25, 25);
            layerLayeredPane.add(map.getCheckBoxs()[i]);
        }

        layersPanel.add(layerLayeredPane);
        frame.add(layersPanel);

        frame.setVisible(true);


        generateCheckboxActionListeners();


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                // If in the middle of task and info not saved then is will promt user if they
                // really want to close
                // If you wnat to see this set saved to false
                // When they close the window it saves all current data to JSON file

                if (!saved) {

                    ImageIcon icon = new ImageIcon("./src/main/images/icons/WesternLogo.png");
                    Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(image);
                    int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Program",
                            JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
                    if (confirm == JOptionPane.YES_OPTION) {

                        // Save info to JSONs

                        saveJSON();

                        System.exit(0);

                    }
                } else {

                    saveJSON();

                    System.exit(0);

                }
            }
        });
    }

    // Main method
    public static void main(String[] args) {

        // Create the start screen

        JFrame startFrame = new JFrame();
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLayout(null);
        startFrame.setSize(1000, 700);
        startFrame.setTitle("Group 16 - UWO GIS - Start Page");
        startFrame.setResizable(false);
        startFrame.setLocationRelativeTo(null);
        startFrame.getContentPane().setBackground(new Color(49, 39, 131));
        startFrame.setVisible(true);

        // Creates and adds Help and About buttons

        helpButton = new JButton();
        aboutButton = new JButton();
        addNewPOIButton = new JButton();
        enterCredsButton = new JButton();

        // add admin access fields
        userNameTextField = new JTextField();
        passwordTextField = new JPasswordField();

        setPlaceholder(userNameTextField, "Enter Username", false);
        setPlaceholder(passwordTextField, "Enter Password", true);

        helpButton.setText("Help");
        aboutButton.setText("About");
        addNewPOIButton.setText("Add New POI");
        enterCredsButton.setText("Enter");

        aboutButton.setBounds(0, 0, 75, 25);
        helpButton.setBounds(67, 0, 75, 25);
        addNewPOIButton.setBounds(200, 600, 400, 25);


        userNameTextField.setBounds(150, 450, 300, 25);
        passwordTextField.setBounds(450, 450, 300, 25);
        enterCredsButton.setBounds(400, 485, 100, 25);

        // Check if buttons are correct then opens correct files
        helpButton.addActionListener(e -> {
            try {
                File helpFile = new File("./src/main/PDFs/Help.pdf");
                Desktop.getDesktop().open(helpFile);
            } catch (IOException ex) {
                System.out.print("File does not exist");
            }
        });

        aboutButton.addActionListener(e -> {
            try {
                File aboutFile = new File("./src/main/PDFs/About.pdf");
                Desktop.getDesktop().open(aboutFile);
            } catch (IOException ex) {
                System.out.print("File does not exist");
            }
        });

        loginActionListener(startFrame, enterCredsButton);

        // Add a start button to the start screen

        JButton startButton = new JButton("Start");
        startButton.setBounds(800, 550, 150, 75);
        logoutActionListener(startFrame, startButton);

        startFrame.add(startButton);
        startFrame.add(aboutButton);
        startFrame.add(helpButton);

        startFrame.add(userNameTextField);
        startFrame.add(passwordTextField);
        startFrame.add(enterCredsButton);

        startButton.setVisible(true);
        aboutButton.setVisible(true);
        helpButton.setVisible(true);

        userNameTextField.setVisible(true);
        passwordTextField.setVisible(true);
        enterCredsButton.setVisible(true);
        startFrame.setVisible(true);

        userNameTextField.revalidate();
        userNameTextField.repaint();
        passwordTextField.revalidate();
        passwordTextField.repaint();
        startFrame.revalidate();
        startFrame.repaint();

    }

    public void setPoiInfo(String poiTitle, String poiRoom, String poiDes) {

        this.poiTitle.setText(poiTitle);
        this.poiRoom.setText(poiRoom);
        this.poiDes.setText(poiDes);

        this.poiTitle.revalidate();
        this.poiTitle.repaint();
        this.poiRoom.revalidate();
        this.poiRoom.repaint();
        this.poiDes.revalidate();
        this.poiDes.repaint();
    }
}
