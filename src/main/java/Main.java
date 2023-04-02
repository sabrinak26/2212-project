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
        frame.setVisible(true);
        
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