package dispatcher;

import business.Mountains;
import business.Students;
import java.util.ArrayList;
import model.Mountain;
import model.Student;
import tools.Menu;


public class Main {
    public static void main(String[] args) {
        // Tạo instance Students chuyên quản lí các chức năng liên quan đến danh sách
        Students sm = new Students();
        // Tạo instance Menu chuyên quản lí danh sách menu
        Menu menu = new Menu("Mountain Hiking Application");
        
    }
}
