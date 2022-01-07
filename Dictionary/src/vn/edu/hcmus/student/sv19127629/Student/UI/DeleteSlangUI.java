package vn.edu.hcmus.student.sv19127629.Student.UI;


import vn.edu.hcmus.student.sv19127629.Student.SlangWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteSlangUI extends UI implements ActionListener {
    private JPanel panel = new JPanel();
    private  JTextPane textPane = new JTextPane();
    private JTextField nameField = null;
    public JPanel getUI() {
        panel.setLayout(new GridLayout(2,1));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        nameField = addInputField("ENTER NAME OF SLANG WORD YOU WANT TO DELETE",10,panel2,null);
        addAButton("DELETE",null,panel2,this,null);
        panel.add(panel2);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = nameField.getText();
        SlangWord f1 = list.findByName(text);
        if (f1 != null){
            textPane.setText("Your entered slang words is exist! (" + f1.toString() + ")");
            int index = list.findIndexByName(f1.getName());
            list.delete(index);
            Cards.show(null,"DELETE  SLANG SUCCESSFUL!");
            JOptionPane.showMessageDialog(frame,"Delete slang successful!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            textPane.setText("Your entered slang words does not exist!");
            JOptionPane.showMessageDialog(frame,"Your entered slang words does not exist!","FAILED",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

