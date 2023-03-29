import javax.swing.*;



public class Main extends JFrame {
    public static Building[] buildings = new Building[3];
    public static Main frame;

    Main() {
        setTitle("Buildings");

    }

//    public static void navigate(JPanel panel) {
//        frame.getContentPane().removeAll();
//        frame.setContentPane(panel);
//        frame.revalidate();
//        frame.repaint();
//    }


    public static void main(String[] args) {
        frame = new Main();

        Map map = new Map();
//        map.getTabs().setBounds(0, 0, 100, 100);
        frame.add(map.getPanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 700);
        frame.setVisible(true);


    }
}