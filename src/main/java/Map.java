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
    JComboBox<String> cb;

    JScrollPane mapPanel;

    public JTabbedPane getTabs() {
        return tabs;
    }

    public void setTabs(JTabbedPane tabs) {
        this.tabs = tabs;
    }

    public Map() {
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        loadBuildingsData();
    }

    ActionListener cbActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = ((JComboBox) e.getSource()).getSelectedIndex();
            String level = getBuilding().getLevels()[index].replaceAll("\\s+","").toLowerCase();
            System.out.println(level);
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
            int i =0;
            for (File child : directoryListing) {
                File jsonFile = new File(child.toURI());
                if (jsonFile.exists()) {
                    try {
                        FileReader fileReader = new FileReader(jsonFile);
                        Gson gson = new Gson();


                        building = gson.fromJson(fileReader, Building.class);
                        building.setId(i);
                        buildings[i] = building;
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    tabs.addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            int index = tabs.getSelectedIndex();
                            building = buildings[index];
                            if (cb != null) panel.remove(cb);
                            cb = new JComboBox<String>(building.getLevels());
                            panel.add(cb);
                            cb.addActionListener(cbActionListener);

                            panel.revalidate();
                            panel.repaint();

                        }
                    });


                    JLabel picLabel = generatePicLabel(getBuilding().getLevels()[0].replaceAll("\\s+","").toLowerCase());
                    mapPanel = new JScrollPane(picLabel);
                    tabs.addTab(building.getBuildingName(), mapPanel);
                    tabs.setPreferredSize(new Dimension(500, 400));
                    panel.add(tabs);

                    i++;
                } else {
                    System.out.println("Json file doesn't Exist");
                }
            }


            building = buildings[tabs.getSelectedIndex()];

            if (cb != null) panel.remove(cb);
            cb = new JComboBox<String>(building.getLevels());

            cb.addActionListener(cbActionListener);
            panel.add(cb);
            cb.setMaximumSize(cb.getPreferredSize()); // added code
            cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        } else {
            System.out.println("./src/main/metadata/ does not exist");
        }
    }

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

    public Building getBuilding() {
        return building;
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
}
