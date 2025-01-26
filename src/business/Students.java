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
    
    // Method
    //isSaved(): boolean
    //Hỗ trợ cho việc check đã save trước khi tắt chưa
    public boolean isSaved(){
        return this.isSaved;
    }
    
    //add(Student x):void
    public void add(Student x){
        studentList.add(x);
    }
    
    //update(Student x): void
    public void update(Student x){
        // Tìm pos
        int pos = studentList.indexOf(x);
        // Ghì đè 
        studentList.set(pos, x);
    }
    
    
    
    //searchById(String id): Student
    public Student searchById(String id){
        for (Student item : studentList) {
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }
    
}
