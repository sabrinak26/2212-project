import javax.swing.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import com.google.gson.Gson;
import java.io.FileWriter;

public class Main extends JFrame {
    
    // Frame is main window that the application uses
    
    public static Main frame;
    
    // saved is for when the program needs to know if info is saved, hasnt been implemented yet so I just set it to true
    
    private static boolean saved;
    
    // Create help and about buttons
    
    private static JButton helpButton;
    private static JButton aboutButton;


    // admin access buttons
    private static JTextField userTextField;
    private static JTextField passwordTextField;
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
    
    private static void openMainFrame() {
        
        // Creates frame
        
        frame = new Main();

        // add POI button
//        frame.add(addNewPOIButton);



        Map map = new Map();
        
        
        
        saved = true;

        // Info about frame
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Group 16 - UWO GIS");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(49,39, 131));
        
        // Adds map panel
        
        frame.add(map.getPanel());
        
        // Adds help and about buttons
        
        frame.add(aboutButton);
        frame.add(helpButton);






        //layersPanel.setBounds(720, 260, 270, 400);
        
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
        
        //JCheckBox accCheckBox = new JCheckBox();
        map.getCheckBoxs()[0].setSelected(false);
        
        //JCheckBox classCheckBox = new JCheckBox();
        map.getCheckBoxs()[1].setSelected(false);
        
        //JCheckBox favCheckBox = new JCheckBox();
        map.getCheckBoxs()[2].setSelected(false);
        
        //JCheckBox labCheckBox = new JCheckBox();
        map.getCheckBoxs()[3].setSelected(false);
        
        //JCheckBox resCheckBox = new JCheckBox();
        map.getCheckBoxs()[4].setSelected(false);
        
        //JCheckBox userCheckBox = new JCheckBox();
        map.getCheckBoxs()[5].setSelected(false);
        
        //JCheckBox washCheckBox = new JCheckBox();
        map.getCheckBoxs()[6].setSelected(false);
        
        layerLayeredPane.add(map.getCheckBoxs()[0]);
        layerLayeredPane.add(map.getCheckBoxs()[1]);
        layerLayeredPane.add(map.getCheckBoxs()[2]);
        layerLayeredPane.add(map.getCheckBoxs()[3]);
        layerLayeredPane.add(map.getCheckBoxs()[4]);
        layerLayeredPane.add(map.getCheckBoxs()[5]);
        layerLayeredPane.add(map.getCheckBoxs()[6]);

        
        layersPanel.add(layerLayeredPane);
        
        map.getCheckBoxs()[0].setBounds(12, 25, 25, 25);
        map.getCheckBoxs()[1].setBounds(12, 80, 25, 25);
        map.getCheckBoxs()[2].setBounds(12, 135, 25, 25);
        map.getCheckBoxs()[3].setBounds(12, 190, 25, 25);
        map.getCheckBoxs()[4].setBounds(12, 240, 25, 25);
        map.getCheckBoxs()[5].setBounds(12, 295, 25, 25);
        map.getCheckBoxs()[6].setBounds(12, 350, 25, 25);
        
        
        frame.add(layersPanel);
        
        frame.setVisible(true);

        map.getCheckBoxs()[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (map.getCheckBoxs()[0].isSelected()) {
                    System.out.println("accCheckBox is checked");
                    map.addPOIsToMap(map.getCurrentBuilding().getLayer("Accessibility").getPOIs());
                    

                } else {
                    System.out.println("accCheckBox is unchecked");
                    map.removePOIsFromMap(map.getCurrentBuilding().getLayer("Accessibility").getPOIs());
                }
            }
        });
        
        map.getCheckBoxs()[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (map.getCheckBoxs()[1].isSelected()) {
                    System.out.println("classCheckBox is checked");
                    map.addPOIsToMap(map.getCurrentBuilding().getLayer("Classrooms").getPOIs());
                        
                } else {
                    System.out.println("classCheckBox is unchecked");
                    map.removePOIsFromMap(map.getCurrentBuilding().getLayer("Classrooms").getPOIs());
                }
            }
        });
        
        map.getCheckBoxs()[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (map.getCheckBoxs()[2].isSelected()) {
                    System.out.println("favCheckBox is checked");
                    map.addPOIsToMap(map.getCurrentBuilding().getLayer("Favourites").getPOIs());

                } else {
                    System.out.println("favCheckBox is unchecked");
                    map.removePOIsFromMap(map.getCurrentBuilding().getLayer("Favourites").getPOIs());
                    
                }
            }
        });
        
        map.getCheckBoxs()[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (map.getCheckBoxs()[3].isSelected()) {
                    System.out.println("labCheckBox is checked");
                    map.addPOIsToMap(map.getCurrentBuilding().getLayer("Labs").getPOIs());
                } else {
                    System.out.println("labCheckBox is unchecked");
                    map.removePOIsFromMap(map.getCurrentBuilding().getLayer("Labs").getPOIs());
                }
            }
        });
        
        map.getCheckBoxs()[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (map.getCheckBoxs()[4].isSelected()) {
                    System.out.println("resCheckBox is checked");
                    map.addPOIsToMap(map.getCurrentBuilding().getLayer("Restaurants").getPOIs());
                } else {
                    System.out.println("resCheckBox is unchecked");
                    map.removePOIsFromMap(map.getCurrentBuilding().getLayer("Restaurants").getPOIs());
                }
            }
        });
        
        map.getCheckBoxs()[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (map.getCheckBoxs()[5].isSelected()) {
                    System.out.println("userCheckBox is checked");

                    map.addPOIsToMap(map.getCurrentBuilding().getLayer("User defined POIs").getPOIs());

//                    map.addMarker();

                } else {
                    System.out.println("userCheckBox is unchecked");
                    map.removePOIsFromMap(map.getCurrentBuilding().getLayer("User defined POIs").getPOIs());
                }
            }
        });
        
        map.getCheckBoxs()[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (map.getCheckBoxs()[6].isSelected()) {
                    System.out.println("washCheckBox is checked");
                    map.addPOIsToMap(map.getCurrentBuilding().getLayer("Washrooms").getPOIs());
                } else {
                    System.out.println("washCheckBox is unchecked");
                    map.removePOIsFromMap(map.getCurrentBuilding().getLayer("Washrooms").getPOIs());
                }
            }
        });
        

        
        //map.getBuilding("Natural Sciences").getLayer("Accessibility").addPOI("one","Level 4", "Built-in", "Accessibility", 7, "This is One on level 2", 200, 200);
        //map.getBuilding("AlumniHall").getLayer("Classrooms").addPOI("two","Level 2", "Built-in", "Classrooms", 7, "This is Two", 100, 100);

//        map.getBuilding("NaturalSciences").getLayer("Accessibility").addPOI("OPAAAAAAAA","Level 2", "Built-in", "Accessibility", 7, "This is OPAAAAA", 125, 125);
        //map.getBuilding("AlumniHall").getLayer("Accessibility").addPOI("OPAAAAAAAA","Level 2", "Built-in", "Accessibility", 7, "This is OPAAAAA", 125, 125);


        //map.getBuilding("AlumniHall").getLayer("Accessibility").removePOI(0);
        //map.getBuilding("Natural Sciences").getLayer("Classrooms").removePOI(3);
        //map.getBuilding("Natural Sciences").getLayer("Classrooms").removePOI(2);
        //map.getBuilding("Natural Sciences").getLayer("Classrooms").removePOI(1);
        //map.getBuilding("Natural Sciences").getLayer("Accessibility").removePOI(10);
        //map.getBuilding("Natural Sciences").getLayer("Accessibility").removePOI(11);

        
        // This is currently the line I am using to test putting POIs on the map
        
        //map.addMarker(75, 75, map.getBuilding("NaturalSciences").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
//        map.addMarker(175, 175, map.getBuilding("NaturalSciences").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
//        map.addMarker(250, 300, map.getBuilding("AlumniHall").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
//        map.addMarker(175, 175, map.getBuilding("AlumniHall").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
        
        
        //map.addPOIsToMap(map.getBuilding("NaturalSciences").getLayer("Accessibility").getPOIs());
        //map.addPOIsToMap(map.getBuilding("NaturalSciences").getLayer("Classrooms").getPOIs());
        
        // Checks if application is being closed
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                
                // If in the middle of task and info not saved then is will promt user if they really want to close
                // If you wnat to see this set saved to false
                // When they close the window it saves all current data to JSON file
                
                if (!saved) {
                
                    ImageIcon icon = new ImageIcon("./src/main/images/icons/WesternLogo.png");
                    Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(image);
                    int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Program", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
                    if (confirm == JOptionPane.YES_OPTION) {
                        
                        // Save info to JSONs
                        
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
                        
                        System.exit(0);
                    
                    }
                } else {
                
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

                    System.exit(0);

                }
            }
        });
        
            
        
    }

    private static void openAdminFrame() {
        System.out.println("inside admin frame");

        // Creates frame


        frame = new Main();

        // make the edit POI interface buttons

        poiNameField = new JTextField("Enter POI name");
        typeTextField = new JTextField("Enter POI type");
        descTextField = new JTextField("Enter POI description");
        roomNumTextField = new JTextField("Enter POI room number ");
        categoryTextField = new JTextField("Enter the category");
        submitPOIButton = new JButton("Submit");


        poiNameField.setBounds(100, 600, 100, 25);
        typeTextField.setBounds(250, 600, 100, 25);
        descTextField.setBounds(100, 630, 100, 25);
        roomNumTextField.setBounds(250, 630, 100, 25);
        categoryTextField.setBounds(400, 600, 100, 25);
        submitPOIButton.setBounds(350,630, 100, 25);

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

//        addNewPOIButton.setBounds( 200,600, 400,25 );






        // add POI button
        frame.add(addNewPOIButton);







        Map map = new Map(addNewPOIButton, poiNameField, typeTextField, descTextField, roomNumTextField, categoryTextField, submitPOIButton);



        saved = true;

        // Info about frame

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Group 16 - UWO GIS");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(49,39, 131));

        // Adds map panel

        frame.add(map.getPanel());

        // Adds help and about buttons

        frame.add(aboutButton);
        frame.add(helpButton);


        //layersPanel.setBounds(720, 260, 270, 400);

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

        JCheckBox accCheckBox = new JCheckBox();
        accCheckBox.setSelected(false);

        JCheckBox classCheckBox = new JCheckBox();
        classCheckBox.setSelected(false);

        JCheckBox favCheckBox = new JCheckBox();
        favCheckBox.setSelected(false);

        JCheckBox labCheckBox = new JCheckBox();
        labCheckBox.setSelected(false);

        JCheckBox resCheckBox = new JCheckBox();
        resCheckBox.setSelected(false);

        JCheckBox userCheckBox = new JCheckBox();
        userCheckBox.setSelected(false);

        JCheckBox washCheckBox = new JCheckBox();
        washCheckBox.setSelected(false);

        layerLayeredPane.add(accCheckBox);
        layerLayeredPane.add(classCheckBox);
        layerLayeredPane.add(favCheckBox);
        layerLayeredPane.add(labCheckBox);
        layerLayeredPane.add(resCheckBox);
        layerLayeredPane.add(userCheckBox);
        layerLayeredPane.add(washCheckBox);


        layersPanel.add(layerLayeredPane);

        accCheckBox.setBounds(12, 25, 25, 25);
        classCheckBox.setBounds(12, 80, 25, 25);
        favCheckBox.setBounds(12, 135, 25, 25);
        labCheckBox.setBounds(12, 190, 25, 25);
        resCheckBox.setBounds(12, 240, 25, 25);
        userCheckBox.setBounds(12, 295, 25, 25);
        washCheckBox.setBounds(12, 350, 25, 25);


        frame.add(layersPanel);

        frame.setVisible(true);

        accCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (accCheckBox.isSelected()) {
                    System.out.println("accCheckBox is checked");
                } else {
                    System.out.println("accCheckBox is unchecked");
                }
            }
        });

        classCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (classCheckBox.isSelected()) {
                    System.out.println("classCheckBox is checked");
                } else {
                    System.out.println("classCheckBox is unchecked");
                }
            }
        });

        favCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (favCheckBox.isSelected()) {
                    System.out.println("favCheckBox is checked");
                } else {
                    System.out.println("favCheckBox is unchecked");
                }
            }
        });

        labCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (labCheckBox.isSelected()) {
                    System.out.println("labCheckBox is checked");
                } else {
                    System.out.println("labCheckBox is unchecked");
                }
            }
        });

        resCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (resCheckBox.isSelected()) {
                    System.out.println("resCheckBox is checked");
                } else {
                    System.out.println("resCheckBox is unchecked");
                }
            }
        });

        userCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (userCheckBox.isSelected()) {
                    System.out.println("userCheckBox is checked");
//                    map.addMarker();
                } else {
                    System.out.println("userCheckBox is unchecked");
                }
            }
        });

        washCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (washCheckBox.isSelected()) {
                    System.out.println("washCheckBox is checked");
                } else {
                    System.out.println("washCheckBox is unchecked");
                }
            }
        });

//        map.getBuilding("NaturalSciences").getLayer("Accessibility").addPOI("OPAAAAAAAA","Level 2", "Built-in", "Accessibility", 7, "This is OPAAAAA", 125, 125);
        //map.getBuilding("AlumniHall").getLayer("Accessibility").addPOI("OPAAAAAAAA","Level 2", "Built-in", "Accessibility", 7, "This is OPAAAAA", 125, 125);

        map.getBuilding("NaturalSciences").getLayer("").removePOI(0);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(1);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(2);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(3);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(4);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(5);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(6);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(7);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(8);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(9);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(10);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(11);
        map.getBuilding("NaturalSciences").getLayer("Classrooms").removePOI(12);

        // This is currently the line I am using to test putting POIs on the map

        //map.addMarker(75, 75, map.getBuilding("NaturalSciences").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
//        map.addMarker(175, 175, map.getBuilding("NaturalSciences").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
//        map.addMarker(250, 300, map.getBuilding("AlumniHall").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
//        map.addMarker(175, 175, map.getBuilding("AlumniHall").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&


        //map.addPOIsToMap(map.getBuilding("NaturalSciences").getLayer("Accessibility").getPOIs());

        // Checks if application is being closed

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                // If in the middle of task and info not saved then is will promt user if they really want to close
                // If you wnat to see this set saved to false
                // When they close the window it saves all current data to JSON file

                if (!saved) {

                    ImageIcon icon = new ImageIcon("./src/main/images/icons/WesternLogo.png");
                    Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(image);
                    int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Program", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
                    if (confirm == JOptionPane.YES_OPTION) {

                        // Save info to JSONs

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

                        System.exit(0);

                    }
                } else {

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
        startFrame.getContentPane().setBackground(new Color(49,39, 131));
        startFrame.setVisible(true);

        // Creates and adds Help and About buttons
        
        helpButton = new JButton();
        aboutButton = new JButton();
        addNewPOIButton = new JButton();
        enterCredsButton = new JButton();

        // add admin access fields
        userTextField = new JTextField("enter username");
        passwordTextField = new JTextField("enter password");



        helpButton.setText("Help");
        aboutButton.setText("About");
        addNewPOIButton.setText("Add New POI");
        enterCredsButton.setText("Enter");
        
        aboutButton.setBounds(0, 0, 75, 25);
        helpButton.setBounds(67, 0, 75, 25);
        addNewPOIButton.setBounds( 200,600, 400,25 );

//        enterCredsButton.setText("Enter");

        userTextField.setBounds(150, 450, 300,25);
        passwordTextField.setBounds(450, 450, 300,25);
        enterCredsButton.setBounds(400, 485, 100,25);



        
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

//        addNewPOIButton.addActionListener( e ->
//        {
//            addNewPOIButton.setText("Select where you want to add your point");
//
//
//        });

        enterCredsButton.addActionListener( e ->{
            System.out.println("go to admin page");
            openAdminFrame();

        });
        
        
        
        // Add a start button to the start screen
        
        JButton startButton = new JButton("Start");
        startButton.setBounds(800, 550, 150, 75);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the main frame when the start button is clicked
                startFrame.dispose();
                openMainFrame();
            }
        });
        
        startFrame.add(startButton);
        startFrame.add(aboutButton);
        startFrame.add(helpButton);

        startFrame.add(userTextField);
        startFrame.add(passwordTextField);
        startFrame.add(enterCredsButton);
//        startFrame.add(addNewPOIButton);
       

        startButton.setVisible(true);
        aboutButton.setVisible(true);
        helpButton.setVisible(true);

        userTextField.setVisible(true);
        passwordTextField.setVisible(true);
        enterCredsButton.setVisible(true);
//        addNewPOIButton.setVisible(true);
        startFrame.setVisible(true);
    }
    
}
    
    