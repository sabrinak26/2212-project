package Group16;

import javax.swing.*;

public class Main extends JFrame{

    private JPanel panel;

    public static void main(String[] args) {
        System.out.println("Hello World");

        Main test = new Main();
        test.setContentPane(test.panel);
        test.setTitle("Hello World");
        test.setSize(300, 400);
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
