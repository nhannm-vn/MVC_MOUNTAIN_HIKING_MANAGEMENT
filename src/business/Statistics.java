package business;

// Lớp chuyên dùng để chuyên thống kê dữ liệu theo yêu cầu chức năng

import java.util.HashMap;
import java.util.List;
import model.StatisticalInfo;
import model.Student;

//lớp này sẽ kết hợp cùng với class StatisticalInfo để thực hiện chức năng 7
//nói thẳng ra là nó là mảng chứa các chức năng
public class Statistics extends HashMap<String, StatisticalInfo>{
    // properties
    private final String HEADER_TABLE =
            "|----------------------------------------------------------|\n" +
            "|   Peak Name       | Number of Participants | Total Cost  |\n" +
            "------------------------------------------------------------";
    private final String FOOTER_TABLE = 
            "------------------------------------------------------------";
    
    // constructor

    public Statistics() {
        super();
    }
    
    /** Constructor with Student list to update Statistical Information*/
    // Nhận vào cái list student khi đúc ra đối tượng luôn để có thể chạy method 
    //thống kê ở dưới
    public Statistics(List<Student> list) {
        super();
        statisticalize(list);
    }
    
    // Method
    // Phương thức thực hiện thống kê dữ liệu dựa trên danh sách
    //nghĩa là nó sẽ nhận vào danh sách và tiến hành thống kê
    public final void statisticalize(List<Student> list){
        // Duyet danh sach
        for (Student item : list) {
            // TH: có key trong hashmap
            if(this.containsKey(item.getMountainCode())){
                // moc object đo ra
                StatisticalInfo x = this.get(item.getMountainCode());
                // cap nhat
                x.setNumOfStudent(x.getNumOfStudent() + 1);
                x.setTotalCost(x.getTotalCost() + item.getTutionFee());
            }else{
                // create obj
                StatisticalInfo z = new StatisticalInfo(item.getMountainCode(), 1, 
                                                            item.getTutionFee());
                // them vao hashmap
                this.put(item.getMountainCode(), z);
            }
        }
    }
    
    // Phương thức hiển thị thông tin thống kê
    public void show(){
        System.out.println(HEADER_TABLE);
        for (StatisticalInfo item : this.values()) {
            System.out.println(item);
        }
        System.out.println(FOOTER_TABLE);
    }
    
}
