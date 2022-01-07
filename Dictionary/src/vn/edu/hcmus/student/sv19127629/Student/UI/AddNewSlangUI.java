package vn.edu.hcmus.student.sv19127629.Student.UI;

import vn.edu.hcmus.student.sv19127629.Student.SlangList;
import vn.edu.hcmus.student.sv19127629.Student.SlangWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddNewSlangUI extends UI implements ActionListener {
    private JPanel panel = new JPanel();
    private  JTextPane textPane = new JTextPane();
    private JTextField nameField;
    private JTextField definitionField;

    public JPanel getUI() {
        panel.setLayout(new GridLayout(3,1));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        nameField = addInputField("ENTER NAME OF SLANG WORD",10,panel2,null);
        definitionField = addInputField("ENTER DEFINITION OF SLANG WORD",10,panel2,null);
        addAButton("ADD",null,panel2,this,null);

        panel.add(panel2);
        panel.add(textPane);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = nameField.getText();
        SlangWord f1 = list.findByName(text);
        if (f1 != null){
            textPane.setText("Your entered slang words is already exist! (" + f1.toString() + ")");
            JPanel panel3 = new JPanel();
            panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));

            addAButton("Overwrite", null, panel3, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SlangWord newSlang = new SlangWord(nameField.getText(),definitionField.getText());
                    int index = list.findIndexByName(f1.getName());
                    list.set(index,newSlang);
                    Cards.show("success");
                    JOptionPane.showMessageDialog(frame,"Add new slang successful!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                }
            }, null);

            addAButton("Duplicate", null, panel3, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f1.addDefinition(definitionField.getText());
                    Cards.show(null,"ADD NEW SLANG SUCCESSFUL!");
                    JOptionPane.showMessageDialog(frame,"Add new slang successful!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                }
            }, null);
            panel.add(panel3);
        }
        else{
            list.add(new SlangWord(nameField.getText(),definitionField.getText()));
            list.sort();
            Cards.show(null,"ADD NEW SLANG SUCCESSFUL!");
            JOptionPane.showMessageDialog(frame,"Add new slang successful!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

