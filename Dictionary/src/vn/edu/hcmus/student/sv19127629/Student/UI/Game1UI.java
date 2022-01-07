package vn.edu.hcmus.student.sv19127629.Student.UI;

import vn.edu.hcmus.student.sv19127629.Student.SlangWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;


public class Game1UI extends UI  implements ActionListener {
    private JPanel panel = null;
    private JTextField textField;
    private JTextPane textPane = new JTextPane();

    public JPanel getUI()
    {
        if (panel !=null){
            panel.removeAll();
            panel = null;
        }
        panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.add(textPane,null);
        Random random = new Random();
        int index = random.nextInt(list.size()) ;
        SlangWord des = list.get(index);
        String desDef = des.getDefinition().toString();
        textPane.setText("THE SLANG NAME IS: " + des.getName() + ". THE DEFINITION OF THE SLANG IS:");
        String[] indexs = new String[4];
        int answer = random.nextInt(4);
        for (int i =0; i<4;i++){
            JCheckBox checkBox;
            if (i == answer){
                indexs[i] = desDef;
                checkBox = new JCheckBox(indexs[i]);
                checkBox.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        JOptionPane.showMessageDialog(frame,"Exactly!","NICE",JOptionPane.INFORMATION_MESSAGE);
                        getUI();
                    }
                });

            }else{
                int newInt = random.nextInt(list.size());
                indexs[i] = list.get(newInt).getDefinition().toString();
                checkBox = new JCheckBox(indexs[i]);
                checkBox.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        JOptionPane.showMessageDialog(frame,"Wrong!","POOR",JOptionPane.WARNING_MESSAGE);
                    }
                });

            }
            panel.add(checkBox);

        }

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
