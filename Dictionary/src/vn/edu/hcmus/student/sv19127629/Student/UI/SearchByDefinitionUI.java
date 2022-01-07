package vn.edu.hcmus.student.sv19127629.Student.UI;

import vn.edu.hcmus.student.sv19127629.Student.SlangWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Search slang word by definition UI
 */
public class SearchByDefinitionUI extends UI  implements ActionListener {
    private JPanel panel = new JPanel();
    private JTextField textField;
    private JTextPane textPane = new JTextPane();

    public JPanel getUI()
    {
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("ENTER DEFINITION OF SLANG WORD");
        textField = new JTextField(40);
        panel.add(label);
        panel.add(textField);

        addAButton("FIND",null,panel,this,null);

        JPanel boxPane = new JPanel();
        boxPane.setLayout(new BoxLayout(boxPane,BoxLayout.PAGE_AXIS));
        boxPane.add(textPane);
        panel.add(boxPane,null);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        list.output();
        try{
            String text = textField.getText();
            ArrayList<SlangWord> words = list.findByDefinition(text);
            if (!words.isEmpty()){
                StringBuilder stringBuilder = new StringBuilder();

                for (SlangWord word : words){
                    stringBuilder.append(word + "\n");
                }

                textPane.setText(stringBuilder.toString());
            }
            else{
                textPane.setText("Slang word does not exist!");
                JOptionPane.showMessageDialog(frame,"Your entered slang words does not exist!","FAILED",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (NullPointerException ex){

        }

    }


}
