package business;

import java.util.ArrayList;
import model.Student;
import tools.Inputter;


public class Students {
    // Mang luu cac student
    ArrayList<Student> studentList = new ArrayList<>();
    
    // Tao instance input de de dang nhap lieu
    Inputter input = new Inputter();
          
    // Properties
    private String pathFile;
    private boolean isSaved;
    
    // Constructor

    public Students() {
        this.pathFile = "D:\\PIEDTEAM_MERN\\F2\\Mvc-MountainHiking\\StudentList.csv";
    }
    
    
    
}
