package vn.edu.hcmus.student.sv19127629.Student.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * vn.edu.hcmus.student.sv19127629.Student
 * Created by ASUS
 * Date 12/19/2021 - 12:41 PM
 * Description: user interface
 */
public class UI {
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
    protected static void addAButton(String text, Dimension size, Container container, ActionListener listener) {
        JButton button = new JButton(text);
        if (size != null){
            button.setPreferredSize(size);
        }else{
            button.setPreferredSize(new Dimension(100,100));
        }
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand(text);
        button.addActionListener(listener);
        container.add(button);
    }

    /**
     * create a new text field for input into given container
     * @param labelText : label of the field
     * @param length : length of text
     * @param container : frame or pane
     * @return new text field
     */
    protected static JTextField addInputField(String labelText,int length, Container container){
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(length);
        container.add(label);
        container.add(textField);
        return textField;
    }

    /**
     * create and show the new Swing UI to window
     */
    public static JFrame createAndShowGUI() {
        JFrame frame = init("Student management");

        //Create and set up the content pane.
        Container mainPane = frame.getContentPane();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(10,2));
        pane.setPreferredSize(new Dimension(200,400));
        addAButton("Search slang",null, pane,e ->{
            frame.dispose();
            System.out.println("SEARCH");
        } );

        addAButton("History",null, pane,e ->{
            frame.dispose();
            System.out.println("HISTORY");
        } );

        addAButton("Add new slangword",null, pane,e ->{
            frame.dispose();
            System.out.println("ADD");
        } );

        addAButton("Edit slangword",null, pane,e ->{
            frame.dispose();
            System.out.println("EDIT");
        } );

        addAButton("Delete slangword",null, pane,e ->{
            frame.dispose();
            System.out.println("DELETE");
        } );

        addAButton("Reset slangword list",null, pane,e ->{
            frame.dispose();
            System.out.println("RESET");
        } );

        addAButton("Funny game 1",null, pane,e ->{
            frame.dispose();
            System.out.println("GAME 1");
        } );

        addAButton("Funny game 2",null, pane,e ->{
            frame.dispose();
            System.out.println("GAME 2");
        } );
        mainPane.add(pane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
