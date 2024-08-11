package gui;

import javax.swing.*;
import java.awt.*;

public class FrameForGui extends JFrame {
    JButton button;
    JLabel label;

    FrameForGui() {
        label = new JLabel();

        label.setText("test text");
        label.setForeground(Color.black);
        label.setBounds(150,50, 150, 150);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(150, 300, 175, 50);
        button.addActionListener(e -> {
            label.setVisible(true);
        });
        button.setText("Exit button");
        button.setFocusable(false);
        button.setForeground(Color.green);
        button.setBackground(Color.darkGray);
        button.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }
}
