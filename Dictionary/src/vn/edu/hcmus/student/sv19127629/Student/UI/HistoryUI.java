package vn.edu.hcmus.student.sv19127629.Student.UI;

import vn.edu.hcmus.student.sv19127629.Student.SlangWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HistoryUI extends UI implements ActionListener {
    private JPanel panel = new JPanel();
    private JTextPane textPane = new JTextPane();


    public JPanel getUI() {
        panel.setLayout(new FlowLayout());
        addAButton("Show History",null,panel,this,null);
        panel.add(textPane);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder stringBuilder = new StringBuilder();
        if (history == null){
            textPane.setText("Empty history!");
            return ;
        }
        ArrayList<SlangWord> historyList = history.getList();
        if (historyList.isEmpty()){
            textPane.setText("Empty history!");
            return ;
        }
        for (SlangWord word: historyList){
            stringBuilder.append(word.toString() + "\n");
        }
        textPane.setText(stringBuilder.toString());
    }
}

