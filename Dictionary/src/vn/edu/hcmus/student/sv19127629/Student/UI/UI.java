package vn.edu.hcmus.student.sv19127629.Student.UI;

import vn.edu.hcmus.student.sv19127629.Student.SlangList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * vn.edu.hcmus.student.sv19127629.Student
 * Created by ASUS
 * Date 12/19/2021 - 12:41 PM
 * Description: user interface
 */
public class UI {
    protected SlangList list= SlangList.readFromFile("Dictionary/slang.txt");


    /**
     * initial frame for swing UI
     * @param title : title of UI
     * @return a new frame
     */
    private static JFrame init(String title){

        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return frame;
    }



    /**
     * create a new button into given container
     * @param text : name of button
     * @param size : size of button in dimention form
     * @param container : frame or pane includes new button
     * @param listener : action listener for the button
     */
    protected static void addAButton(String text, Dimension size, Container container, ActionListener listener,String positon) {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        pane.setPreferredSize(size);
        JButton button = new JButton(text);
        if (size != null){
            button.setPreferredSize(size);
            button.setMaximumSize(size);
        }
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand(text);
        button.addActionListener(listener);
        pane.add(button);
        container.add(pane,positon);
    }

    /**
     * create a new text field for input into given container
     * @param labelText : label of the field
     * @param length : length of text
     * @param container : frame or pane
     * @return new text field
     */
    protected static JTextField addInputField(String labelText,int length, Container container,String position){
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(length);
        panel.add(label);
        panel.add(textField);
        container.add(panel,position);
        return textField;
    }

    /**
     * create and show the new Swing UI to window
     */
    public static JFrame createAndShowGUI() {
        JFrame frame = init("Slang words");

        //Create and set up the content pane.
        Container mainPane = frame.getContentPane();
        mainPane.setLayout(new BorderLayout());
        mainPane.setPreferredSize(new Dimension(600,800));

        JPanel topPane = new JPanel();
        topPane.setLayout(new GridLayout(3,3));
        topPane.setPreferredSize(new Dimension(600,300));
        addAButton("Search by name",new Dimension(160,80), topPane,e ->{
            Cards.show("searchByName");
            System.out.println("SEARCH BY NAME");
        },null );

        addAButton("Search by definition",new Dimension(160,80), topPane,e ->{
            Cards.show("searchByDefinition");
            System.out.println("SEARCH BY definition");
        } ,null);

        addAButton("History",new Dimension(160,80), topPane,e ->{
            System.out.println("HISTORY");
        },null );

        addAButton("Add new slangword",new Dimension(160,80), topPane,e ->{
            System.out.println("ADD");
        },null );

        addAButton("Edit slangword",new Dimension(160,80), topPane,e ->{
            System.out.println("EDIT");
        },null );

        addAButton("Delete slangword",new Dimension(160,80), topPane,e ->{
            System.out.println("DELETE");
        } ,null);

        addAButton("Reset slangword list",new Dimension(160,80), topPane,e ->{
            System.out.println("RESET");
        },null );

        addAButton("Funny game 1",new Dimension(160,80), topPane,e ->{
            System.out.println("GAME 1");
        },null );

        addAButton("Funny game 2",new Dimension(160,80), topPane,e ->{
            System.out.println("GAME 2");
        } ,null);

        mainPane.add(topPane,BorderLayout.PAGE_START);
        mainPane.add(Cards.cards,BorderLayout.CENTER);



        //Display the window.
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

}
