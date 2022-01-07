package vn.edu.hcmus.student.sv19127629.Student.UI;

import vn.edu.hcmus.student.sv19127629.Student.SlangWord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * vn.edu.hcmus.student.sv19127629.Student.UI
 * Created by ASUS
 * Date 12/19/2021 - 1:03 PM
 * Description: Search slang word by name UI
 */
public class SearchByNameUI extends UI  implements ActionListener {
    private JPanel panel = new JPanel();
    private JTextField textField;
    private JTextPane textPane = new JTextPane();

    public JPanel getUI()
    {
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        textField = addInputField("ENTER NAME OF SLANG WORD",10,panel,null);
        addAButton("FIND",null,panel,this,null);
        panel.add(textPane,null);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        list.output();
        String text = textField.getText();
        SlangWord f1 = list.findByName(text);
        if (f1 != null){
            textPane.setText(f1.toString());
            history.add(f1,0);
        }
        else{
            textPane.setText("Slang word does not exist!");
        }
    }


}
