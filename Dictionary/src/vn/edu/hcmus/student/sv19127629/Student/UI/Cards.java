package vn.edu.hcmus.student.sv19127629.Student.UI;

import javax.swing.*;
import java.awt.*;

public class Cards {
    private static  CardLayout cardLayout;
    public static JPanel cards;
    private static JTextPane textPane =null;
    static{
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        JLabel defaultLable = new JLabel("default");
        cards.add(defaultLable, "default");

        JLabel successLable = new JLabel("Success!");
        cards.add(successLable, "success");

        textPane = new JTextPane();
        cards.add(textPane, "message");

        JPanel searchByName = new SearchByNameUI().getUI();
        cards.add(searchByName,"searchByName");

        JPanel searchByDefinition = new SearchByDefinitionUI().getUI();
        cards.add(searchByDefinition,"searchByDefinition");

        JPanel history = new HistoryUI().getUI();
        cards.add(history,"history");

        JPanel addNewSlang = new AddNewSlangUI().getUI();
        cards.add(addNewSlang,"addNewSlang");

        JPanel editSlang = new EditSlangUI().getUI();
        cards.add(editSlang,"editSlang");

        JPanel deleteSlang = new DeleteSlangUI().getUI();
        cards.add(deleteSlang,"deleteSlang");

        JPanel game1 = new Game1UI().getUI();
        cards.add(game1,"game1");

    }

    public static void show(String name){
        cardLayout.show(cards,name);
    }
    public static void show(String name, String message){
        cardLayout.show(cards,"message");
        textPane.setText(message);
    }
}
