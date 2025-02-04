package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
    public boolean isSaved() {
        return this.isSaved;
    }

    //add(Student x):void
    public void add(Student x) {
        studentList.add(x);
    }

    //update(Student x): void
    public void update(Student x) {
        // Tìm pos
        int pos = studentList.indexOf(x);
        // Ghì đè 
        studentList.set(pos, x);
    }

    //delete(String id): void
    public void delete(String id) {
        // Kiểm tra xem student muốn delete đã tồn tại trong danh sách chưa
        Student studentCheck = searchById(id);
        // Bằng null nghĩa là không tìm thấy thì thông báo
        if (studentCheck == null) {
            System.out.println("This student has not registered yet.");
        } else {
            // In ra thong tin va hoi muon xoa khong
            System.out.println("Student Details:");
            System.out.println("-----------------------------------------------------");
            // Tạo format để in đẹp
            String str = String.format(
                    "Student ID: " + studentCheck.getId() + "\n"
                    + "Name      : " + studentCheck.getName() + "\n"
                    + "Phone     : " + studentCheck.getPhone() + "\n"
                    + "Mountain  : " + studentCheck.getMountainCode() + "\n"
                    + "Fee       : " + studentCheck.getTutionFee() + "\n"
            );
            System.out.println(str);
            System.out.println("-----------------------------------------------------");
            String result = input.getString("Are you sure you want to delete this registration? (Y/N):");
            // Nếu như nhập y hoặc Y thì xóa
            if (result.matches("^[Yy]$")) {
                studentList.remove(studentCheck);
                System.out.println("The registration has been successfully deleted");
            } else {
                // Nếu như người dùng không bấm Yes thì dừng method
                return;
            }
        }
    }

    //searchById(String id): Student
    public Student searchById(String id) {
        for (Student item : studentList) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    //searchByName(String name): void
    public void searchByName(String name) {
        // Tạo cái mảng để lưu những thằng Student có một phần tên hoặc toàn phần
        ArrayList<Student> tempList = new ArrayList<>();

        // Kiểm tra trong mảng 
        for (Student item : tempList) {
            if (item.getName().contains(name)) {
                tempList.add(item);
            }
        }

        // Thông báo
        if (tempList.isEmpty()) {
            System.out.println("No one matches the search criteria!");
        } else {
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
    public void showAll() {
        // Check xem trong danh sách có Student nào không
        if (studentList.isEmpty()) {
            System.out.println("No students have registered yet.");
        } else {
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

    // statisticalizeByMountainPeak():void
    public void statisticalizeByMountainPeak() {
        // Tạo instance Statistics
        Statistics management = new Statistics(studentList);
        // Sau khi đã thống kê thì tiến hành in ra 
        management.show();
    }

    // filterByCampusCode(String: campusCode): List<Student>
    public List<Student> filterByCampusCode(String campusCode) {
        // Tạo cái mảng tạm: khai cha- new con
        List<Student> tempList = new ArrayList<>();
        // Check trong danh sach và thêm vào mảng tạm
        for (Student item : tempList) {
            // Ở đây mình sẽ upperCase lên để dễ cho việc filter
            //đối với tìm kiếm nhập bậy thì không có chứ không quá nghiêm khắc
            if (item.getId().contains(campusCode.toUpperCase())) {
                tempList.add(item);
            }
        }
        return tempList;
    }

    // readFromFile():void
    public void readFromFile(){
        // Tạo obj file
        File f = new File(pathFile);
        // Quá trình đọc file có thể xảy ra lỗi nên cần try-catch
        try {
            // Kiểm tra nếu như obj f không tồn tại thì return luôn
            if(!f.exists()){
                System.out.println("StudentList.csv not found!");
                return;
            }
            // Tạo ra anh đọc file
            FileReader fr = new FileReader(f);
            // Tạo ra anh buffer đọc file
            BufferedReader br = new BufferedReader(fr);
            // Đọc dòng đầu tiên
            String line = br.readLine();
            while(line != null && !line.isEmpty()){
                StringTokenizer st = new StringTokenizer(line, ",");
                // Băm các field ra 
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String phone = st.nextToken().trim();
                String email = st.nextToken().trim();
                String mountainCode = st.nextToken().trim();
                // ép kiểu riêng thằng này
                double tutionFee = Double.parseDouble(st.nextToken().trim());
                // Đúc ra object
                Student s = new Student(id, name, phone, email, mountainCode, tutionFee);
                // Nếu có object thì thêm vào list
                if(s != null){
                    studentList.add(s);
                }
                // Đọc dòng tiếp theo
                line = br.readLine();
            }
            // Dừng 
            br.close();
        } catch (Exception e) {
            System.out.println("File lỗi rồi: " +e);
        }
    }
//    public void readFromFile() {
//        // Tạo ra instance obj file
//        File f = new File(pathFile);
//        // Quá trình đọc file có thể có lỗi nên cần try-catch
//        try {
//            // Nếu instance tạo mà bị lỗi thì thông báo và dừng luôn
//            if (!f.exists()) {
//                System.out.println("StudentList.csv file not found !.");
//                return;
//            }
//            // Tạo đối tượng đọc dữ liệu
//            FileReader fr = new FileReader(f);
//            // Tạo buffer đọc và lấy dữ liệu
//            BufferedReader br = new BufferedReader(fr);
//            // Đọc dòng đầu tiên
//            String line = br.readLine();
//            while(line != null && !line.isEmpty()){
//                // Băm các field ra bằng StringTokenizer
//                StringTokenizer st = new StringTokenizer(line, ",");
//                String id = st.nextToken();
//                String name = st.nextToken();
//                String phone = st.nextToken();
//                String email = st.nextToken();
//                String mountainCode = st.nextToken();
//                double tutionFee = Double.parseDouble(st.nextToken());
//                // tạo obj
//                // Viết tới đây sẽ hiểu tại sao cần để cho model Student cái phểu mặc định
//                Student s = new Student(id, name, phone, email, mountainCode, tutionFee);
//                // thêm vào danh sách
//                studentList.add(s);
//                // Đọc dòng tiếp theo
//                line = br.readLine();
//            }
//            // Đóng 
//            br.close();
//        } catch (Exception e) {
//            System.out.println("File loi roi: " +e);
//        }
//    }
    
    // saveToFile()
    public void saveToFile(){
        // Nếu đã chạy hàm này rồi thì dừng luôn
        if(isSaved) return;
        // Tạo obj file
        File f = new File(pathFile);
        try {
            // Nếu không tồn tại thì dừng luôn
            if(!f.exists()) return;
            // Tạo ra anh ghi file
            FileWriter fw = new FileWriter(f);
            // Tạo buffer ghi file
            BufferedWriter writter = new BufferedWriter(fw);
            // Duyet danh sach va tien hanh ghi
            for (Student student : studentList) {
                writter.write(student.getId() + "," + student.getName() + "," +
                        student.getPhone() + "," + student.getEmail() + "," + 
                        student.getMountainCode() + "," + student.getTutionFee());
                 // Xuong dong
                 writter.newLine();
            }
            // Tat
            writter.close();
            // Doi trang thai cho bien check luu
            this.isSaved = true;
        } catch (Exception e) {
            System.out.println("File lỗi gòi: " +e);
        }
        
    }
    
//    public void saveToFile(){
//        // Nếu đã lưu rồi thì không chạy method này
//        if(isSaved) return;
//        // Tạo obj file
//        File f = new File(pathFile);
//        if(!f.exists()) return;
//        try {
//            FileWriter fw = new FileWriter(f);
//            BufferedWriter writter = new BufferedWriter(fw);
//            for (Student student : studentList) {
//                writter.write(student.getId() + "," + student.getName() + "," 
//                              + student.getPhone() + "," + student.getEmail() + ","
//                              + student.getMountainCode() + "," + student.getTutionFee());
//                // xuong dong
//                writter.newLine();
//            }
//            writter.close();
//            // Khi chay xong method nay thi xac nhan da luu roi
//            this.isSaved = true;
//        } catch (Exception e) {
//            System.out.println("File loi roi: " +e);
//        }
//    }

}
