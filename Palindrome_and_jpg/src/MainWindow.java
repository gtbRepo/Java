import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle("Palindrom_and_jpg");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int whereInWidth = 100;
        int whereInHigh = 50;
        setLocation(whereInWidth, whereInHigh);
        JPanel panelBackground = new BackgroundPanel();
        getContentPane().add(panelBackground);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}