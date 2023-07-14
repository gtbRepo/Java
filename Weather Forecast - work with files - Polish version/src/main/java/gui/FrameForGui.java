package gui;

import javax.swing.*;
import java.awt.*;

//import javax.swing.ImageIcon; //do zmiany ikony
public class FrameForGui extends JFrame
{
    JButton button;
    public FrameForGui() {
        this.setTitle("Weather Forecast");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //    frame.setResizable(false);
        this.setMinimumSize(new Dimension(600, 600));
        this.setSize(800, 600);
        this.setVisible(true);

        // ImageIcon image = new ImageIcon(""); // w cudzysłowie nazwa nowej ikony
        // frame.setIconImage(image.getImage());
        // frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.getContentPane().setBackground(new Color(255, 255, 255)); //na razie biały

        //TODO Kod poniżej prawdopodobnie powinien być w Gui
        JLabel infoText = new JLabel("Program wyłącza tylko przeznaczony do tego przycisk."
                + "/nPo wciśnięciu przycisku X w prawym górnym rogu aplikacja dalej będzie działać"
                + "/nw tle. Do zakończenia działania programu potrzebne jest wtedy wprowadzenie do konsoli"
                + "/ndowolnego znaku różnego od liczb od 1 do 4.");
        infoText.setBounds(50,200,200,200);
        this.add(infoText);
        button = new JButton();
        button.setBounds(200,350,350,50);
        button.addActionListener(e -> System.exit(0));
        button.setText("Tymczasowa funkcja -> zamykanie aplikacji");
        this.add(button);
    }
}
