import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    public BackgroundPanel(){
        final int howHighPanel = 800;
        final int howWidthPanel = 1200;
        final Dimension panelSize = new Dimension(howWidthPanel,howHighPanel);
        setPreferredSize(panelSize);
        setBackground(Color.white);

        JPanel palindromePanel = new JPanel();
        palindromePanel.setBackground(Color.yellow);
        palindromePanel.setPreferredSize(new Dimension(howWidthPanel,howHighPanel/7));
        add(palindromePanel);
        JLabel labelUpper = new JLabel("Polski Palindrom: ");
        JLabel labelDown = new JLabel("A to kanapa pana Kota");
        palindromePanel.add(labelUpper);
        palindromePanel.add(labelDown);

        JPanel jpgPanel = new JPanel();
        jpgPanel.setBackground(Color.lightGray);
        jpgPanel.setPreferredSize(new Dimension(howWidthPanel,howHighPanel));
        add(jpgPanel);

        ImageIcon jpgPicture = new ImageIcon(
                "C:\\Users\\HP\\Desktop\\Cwiczenia_z_programowania\\Programy wysłane na GIT-a\\Java\\DemoSkillsInJava\\Palindrome_and_jpg\\Palindrome_and_jpg\\How_long_have_you_been_fixing_this_bug.PNG");
        JLabel jpgLabel = new JLabel(
                "Oto jpg, a nie to jednak jest plik .png :)", jpgPicture, SwingConstants.CENTER);
        jpgLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        jpgLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        jpgPanel.add(jpgLabel);
    }
}
