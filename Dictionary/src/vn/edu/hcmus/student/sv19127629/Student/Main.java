package vn.edu.hcmus.student.sv19127629.Student;
import vn.edu.hcmus.student.sv19127629.Student.UI.UI;
public class Main {

    public static void main(String[] args) {
        // write your code here
        UI.createAndShowGUI();
        SlangList list = new SlangList();
        list = SlangList.readFromFile("Dictionary/slang.txt");
        list.output();
    }
}
