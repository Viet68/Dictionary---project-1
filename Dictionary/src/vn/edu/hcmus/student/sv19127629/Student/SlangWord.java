package vn.edu.hcmus.student.sv19127629.Student;

import java.util.ArrayList;

/**
 * vn.edu.hcmus.student.sv19127629.Student
 * Created by ASUS
 * Date 12/19/2021 - 1:06 PM
 * Description: Slang word presentation
 */

/**
 * Class present the slang word in this program
 */
public class SlangWord implements  Comparable<SlangWord>{
    private String name;
    private ArrayList<String> definition = new ArrayList<>();
    public SlangWord(){

    }
    public SlangWord(String name, ArrayList<String> definition){
        this.name = name;
        this.definition = definition;
    }

    public SlangWord(String name, String definition){
        this.name = name;
        this.definition.add(definition) ;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDefinition() {
        return definition;
    }

    public void setDefinition(ArrayList<String> definition) {
        this.definition = definition;
    }
    public void addDefinition(String definition){
        this.definition.add(definition);
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(name + " : ");
        for (String def : definition){
            builder.append(def + " . ");
        }
        return builder.toString();
    }

    public String toFileString(){
        StringBuilder builder = new StringBuilder();
        builder.append(name + "`");
        for (String def : definition){
            builder.append(def + "\n");
        }
        return builder.toString();
    }

    @Override
    public int compareTo(SlangWord o) {
        char[] w1 = name.toCharArray();
        char[] w2 =o.getName().toCharArray();

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
