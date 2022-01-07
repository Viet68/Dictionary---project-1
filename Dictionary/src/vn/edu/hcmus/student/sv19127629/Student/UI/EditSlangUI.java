package vn.edu.hcmus.student.sv19127629.Student.UI;


import vn.edu.hcmus.student.sv19127629.Student.SlangWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditSlangUI extends UI implements ActionListener {
    private JPanel panel = new JPanel();
    private  JTextPane textPane = new JTextPane();
    private JTextField nameField = null;
    private JPanel panel3 = null;
    public JPanel getUI() {
        panel.setLayout(new GridLayout(4,1));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        nameField = addInputField("ENTER NAME OF SLANG WORD YOU WANT TO EDIT",10,panel2,null);
        addAButton("FIND",null,panel2,this,null);
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
            if (panel3 != null){
                panel3.removeAll();
                panel.remove(panel3);
                panel3 = null;
            }
            panel3 = new JPanel();
            panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));
            int index = list.findIndexByName(f1.getName());
            JTextField definition = addInputField("ENTER NEW DEFINITION ",15,panel3,null);
            JTextField name = addInputField("ENTER NEW NAME",15,panel3,null);
            addAButton("EDIT", null, panel3, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!definition.getText().equals("") && definition.getText() != null){
                        f1.setDefinition(definition.getText());
                    }
                    if (!name.getText().equals("") && name.getText() != null){
                        f1.setName(name.getText());
                    }
                    list.set(index,f1);
                    Cards.show(null,"EDIT SLANG SUCCESSFUL!");
                    JOptionPane.showMessageDialog(frame,"Edit slang successful!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                }
            }, null);
            panel.add(panel3);
        }
        else{
            textPane.setText("Your entered slang words does not exist!");
            JOptionPane.showMessageDialog(frame,"Your entered slang words does not exist!","FAILED",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

