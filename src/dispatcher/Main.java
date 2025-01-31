package dispatcher;

import business.Mountains;
import business.Students;
import java.util.ArrayList;
import model.Mountain;
import model.Student;
import tools.Inputter;
import tools.Menu;


public class Main {
    public static void main(String[] args) {
        // Tạo instance Students chuyên quản lí các chức năng liên quan đến danh sách
        Students sm = new Students();
        // Tạo instance Menu chuyên quản lí danh sách menu
        Menu menu = new Menu("Mountain Hiking Application");
        // Tạo instance Input chuyên quản lí nhập dữ liệu
        Inputter input = new Inputter();
        // Tạo instance Mountains chuyên quản lí các mountain
        Mountains mountains = new Mountains();
        
        // Thêm yêu các yêu cầu cho menu
        menu.addNewOption("Add a new student registration.");
        menu.addNewOption("Modify existing registration details.");
        menu.addNewOption("Show the list of all registered students.");
        menu.addNewOption("Remove a student's registration record.");
        menu.addNewOption("Find registered students based on their names.");
        menu.addNewOption("Display registrations specific to a campus");
        menu.addNewOption("Generate statistics on the number of registrations for each location.");
        menu.addNewOption("Store registration data in a file");
        menu.addNewOption("End the program execution.");
    }
}
