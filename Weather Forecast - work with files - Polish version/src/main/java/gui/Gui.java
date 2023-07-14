package gui;

import javax.swing.*;
import java.awt.*;

public class Gui
{
    public Gui()
    {
        JFrame frame = new FrameForGui();
        JLabel label = new JLabel();
        label.setText("<html><b><h2>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Weather Forecast</b></h2><br>"
                + "<b>&emsp;GTB presents simple and temporary graphic user interface."
                + "&emsp;Below there is a desciption in Polish about this app.<br><br>"
                + "<b>&emsp;Pragnę przedstawić aplikację do prezentowania prognozy pogody.<br>"
                + "&emsp;Pierwszym komponentem wykorzystanym w programie jest web scraper, "
                + "którego celem jest pobranie zarówno obecnych danych <br>&emsp;pogodowych "
                + "jak również krótko- i długoterminowej prognozy dla miasta Kraków.<br>"
                + "&emsp;Dane zostały pobrane z portalu pogoda.interia.pl</b><br>"
                + "<br><br><br>&emsp;Aby zamknąć aplikację należy wpisać w konsoli dowolny znak z poza zakresu 1-4 "
                + "lub wcisnąć guzik.</html>");
        
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0,0,0));
        label.setFont(new Font("Ariel",Font.PLAIN, 12));
        label.setBackground(Color.GRAY);
        label.setOpaque(true); // wyswietli kolor tła
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);
    }
}
