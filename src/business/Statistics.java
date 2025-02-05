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
//    public final void statisticalize(List<Student> list){
//        // Duyệt danh sách list vừa mới truyền vào
//        for (Student item : list) {
//            // Trường hợp item có mountainCode nằm trong key của danh sách hashMap
//            if(this.containsKey(item.getMountainCode())){
//                // Thì móc thằng object dựa vào key đó ra và tiến hành cập nhật
//                StatisticalInfo x = this.get(item.getMountainCode());
//                // Tiến hành cập nhật cho nó
//                // Cập nhật thêm một sinh viên mới
//                x.setNumOfStudent(x.getNumOfStudent() + 1);
//                // Cập nhật số tiền của nó
//                x.setTotalCost(x.getTotalCost() + item.getTutionFee());
//            }else{
//                // Nghĩa là chưa có thì sẽ tiến hành thêm mới vào hashMap luôn
//                StatisticalInfo z = new StatisticalInfo(item.getMountainCode(),
//                        1, item.getTutionFee());
//                // Thêm vào danh sách 
//                this.put(item.getMountainCode(), z);
//            }
//        }
//    }
    
    public final void statisticalize(List<Student> list){
        // Duyet danh sach moi truyen vao
        for (Student item : list) {
            // TH item co mountainCode nam trong hashMap
            if(this.containsKey(item.getMountainCode())){
                // Moc no ra 
                StatisticalInfo x = this.get(item.getMountainCode());
                // Cap nhat lai cac thong tin
                x.setNumOfStudent(x.getNumOfStudent() + 1);
                // Cap nhat lai so tien
                x.setTotalCost(x.getTotalCost() + item.getTutionFee());
            }else{
                StatisticalInfo z = new StatisticalInfo(item.getMountainCode(), 1, item.getTutionFee());
                // Them vao
                this.put(item.getMountainCode(), z);
            }
        }
    }
    
//    public final void statisticalize(List<Student> list){
//        // Duyet danh sach
//        for (Student item : list) {
//            // TH: có key trong hashmap
//            if(this.containsKey(item.getMountainCode())){
//                // moc object đo ra
//                StatisticalInfo x = this.get(item.getMountainCode());
//                // cap nhat
//                x.setNumOfStudent(x.getNumOfStudent() + 1);
//                x.setTotalCost(x.getTotalCost() + item.getTutionFee());
//            }else{
//                // create obj
//                StatisticalInfo z = new StatisticalInfo(item.getMountainCode(), 1, 
//                                                            item.getTutionFee());
//                // them vao hashmap
//                this.put(item.getMountainCode(), z);
//            }
//        }
//    }
    public void show(){
        // Hiển thị thông tin
        System.out.println(HEADER_TABLE);
        for (StatisticalInfo item : this.values()) {
            System.out.println(item);
        }
        System.out.println(FOOTER_TABLE);
    }
    
    
    
    
    // Phương thức hiển thị thông tin thống kê
//    public void show(){
//        System.out.println(HEADER_TABLE);
//        for (StatisticalInfo item : this.values()) {
//            System.out.println(item);
//        }
//        System.out.println(FOOTER_TABLE);
//    }
    
}
