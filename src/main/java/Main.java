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
    
    // Main application window
    
    private static void openMainFrame() {
        
        // Creates frame
        
        frame = new Main();
     
        Map map = new Map();
        
        //JPanel layersPanel = new JPanel();
        
        
        
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
        
        //map.getBuilding("NaturalSciences").getLayer("Accessibility").addPOI("OPAAAAAAAA","Level 2", "Built-in", "Accessibility", 7, "This is OPAAAAA", 125, 125);
        //map.getBuilding("AlumniHall").getLayer("Accessibility").addPOI("OPAAAAAAAA","Level 2", "Built-in", "Accessibility", 7, "This is OPAAAAA", 125, 125);

        //map.getBuilding("AlumniHall").getLayer("Accessibility").removePOI(0);
        
        // This is currently the line I am using to test putting POIs on the map
        
        //map.addMarker(75, 75, map.getBuilding("NaturalSciences").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
        //map.addMarker(175, 175, map.getBuilding("NaturalSciences").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
        //map.addMarker(75, 75, map.getBuilding("AlumniHall").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
        //map.addMarker(175, 175, map.getBuilding("AlumniHall").getBuildingName(), "level2"); // TYFUGIH*OUTCFYGI(&F*^&T(G*HYRDT*(&DRT&F^*G&T^R&
        
        
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
        
        helpButton.setText("Help");
        aboutButton.setText("About");
        
        aboutButton.setBounds(0, 0, 75, 25);
        helpButton.setBounds(67, 0, 75, 25);
        
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
       

        startButton.setVisible(true);
        aboutButton.setVisible(true);
        helpButton.setVisible(true);
        startFrame.setVisible(true);
    }
}