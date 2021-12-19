package vn.edu.hcmus.student.sv19127629.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * vn.edu.hcmus.student.sv19127629.Student
 * Created by ASUS
 * Date 12/19/2021 - 1:17 PM
 * Description: a list of slang word
 */
public class SlangList {
    private ArrayList<SlangWord> list = new ArrayList<>();
    public  SlangList(){}

    public void add(SlangWord word){
        list.add(word);
    }
    public static SlangList readFromFile(String fileName){
        try{
            File f = new File(fileName);
            Scanner scan = new Scanner(f);
            String line;
            SlangWord lastWord = new SlangWord("t","test");
            SlangList list = new SlangList();
            while (scan.hasNext()){
                line = scan.nextLine();
                String[] part = line.split("`");
                if (part.length == 1){
                    lastWord.addDefinition(part[0]);
                }else{
                    lastWord = new SlangWord(part[0], part[1]);
                    list.add(lastWord);
                }
            }
            return list;
        }catch(FileNotFoundException ex){
            System.out.println("Error occurred!");
            return null;
        }

    }
    public void output(){
        for (SlangWord slangWord : list) {
            System.out.println(slangWord.toString());
        }
    }
}
