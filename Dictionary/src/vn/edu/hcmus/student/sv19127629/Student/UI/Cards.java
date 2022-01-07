package vn.edu.hcmus.student.sv19127629.Student.UI;

import javax.swing.*;
import java.awt.*;

public class Cards {
    private static  CardLayout cardLayout;
    public static JPanel cards;

    static{
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        JLabel defaultLable = new JLabel("default");
        cards.add(defaultLable, "default");

        JPanel searchByName = new SearchByNameUI().getUI();
        cards.add(searchByName,"searchByName");

        JPanel searchByDefinition = new SearchByDefinitionUI().getUI();
        cards.add(searchByDefinition,"searchByDefinition");

        JPanel history = new HistoryUI().getUI();
        cards.add(history,"history");

    }

    public static void show(String name){
        cardLayout.show(cards,name);
    }
}
