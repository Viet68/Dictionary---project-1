package vn.edu.hcmus.student.sv19127629.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * vn.edu.hcmus.student.sv19127629.Student
 * Created by ASUS
 * Date 12/19/2021 - 1:17 PM
 * Description: a list of slang word
 */

/**
 *  Class used for compare two slang words by their name
 */
class compareNameSlangWord implements Comparator<SlangWord>{

    @Override
    public int compare(SlangWord o1, SlangWord o2) {
        char[] w1 = o1.getName().toCharArray();
        char[] w2 = o2.getName().toCharArray();

        for (int i = 0; i < w1.length; i++){
            if (i >= w2.length)
                return 1;
            int temp = w1[i] - w2[i];
            if (temp != 0)
                return temp;

        }
        if (w1.length == w2.length)
            return 0;
        return -1;
    }
}

/**
 * presentation for the Slang list in program
 */
public class SlangList {
    public ArrayList<SlangWord> getList() {
        return list;
    }

    public void setList(ArrayList<SlangWord> list) {
        this.list = list;
    }

    private ArrayList<SlangWord> list = new ArrayList<>();
    public  SlangList(){}

    public void add(SlangWord word){
        list.add(word);
    }
    public void sort(){
        Collections.sort(list, new compareNameSlangWord());
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
            list.sort();
            return list;
        }catch(FileNotFoundException ex){
            System.out.println("Error occurred!");
            return null;
        }

    }
    public SlangWord findByName(String name){
        int result = Collections.binarySearch(list,new SlangWord(name, ""));
        System.out.println("RE: " + result);
        if (result < 0)
            return null;
        return list.get(result);
    }
    public ArrayList<SlangWord> findByDefinition (String definition){
        ArrayList<SlangWord> words = new ArrayList<>();
        for (SlangWord word : list){
            ArrayList<String> defs = word.getDefinition();
            for (String def : defs){
                if (def.equals(definition) )
                    words.add(word);
            }
        }
        return words;
    }
    public void output(){
        for (SlangWord slangWord : list) {
            System.out.println(slangWord.toString());
        }
    }
}
