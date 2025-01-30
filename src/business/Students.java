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
    
    //searchByName(String name): void
    public void searchByName(String name){
        // Tạo cái mảng để lưu những thằng Student có một phần tên hoặc toàn phần
        ArrayList<Student> tempList = new ArrayList<>();
        
        // Kiểm tra trong mảng 
        for (Student item : tempList) {
            if(item.getName().contains(name)){
                tempList.add(item);
            }
        }
        
        // Thông báo
        if(tempList.isEmpty()){
            System.out.println("No one matches the search criteria!");
        }else{
            System.out.println("Matching Students:");
            String str = String.format(
                    "-----------------------------------------------------------------------------\n"
                    + "Student ID     | Name            | Phone           | Peak Code| Fee\n"
                    + "-----------------------------------------------------------------------------"
            );
            System.out.println(str);
            for (Student student : tempList) {
                System.out.println(student.toString());
            }
            System.out.println("-----------------------------------------------------------------------------");
        }
    }
    
    // showAll(): void
    public void showAll(){
        // Check xem trong danh sách có Student nào không
        if(studentList.isEmpty()){
            System.out.println("No students have registered yet.");
        }else{
            System.out.println("Registered Students:");
            String str = String.format(
                    "-----------------------------------------------------------------------------\n"
                    + "Student ID     | Name            | Phone           | Peak Code| Fee\n"
                    + "-----------------------------------------------------------------------------"
            );
            System.out.println(str);
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
            System.out.println("-----------------------------------------------------------------------------");
        }
        
    }
    
}
