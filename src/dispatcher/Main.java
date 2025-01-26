package dispatcher;

import business.Mountains;
import model.Mountain;
import model.Student;


public class Main {
    public static void main(String[] args) {
        Mountains m = new Mountains();
        m.readFromFile();
        for (Mountain item : m.mountainList) {
            System.out.println(item.toString());
        }
    }
}
