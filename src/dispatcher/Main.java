package dispatcher;

import business.Mountains;
import business.Students;
import java.util.ArrayList;
import java.util.List;
import model.Mountain;
import model.Student;
import tools.Acceptable;
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

        // Đọc file để có dữ liệu trước khi chạy chương trình 
        sm.readFromFile();
        mountains.readFromFile();

        // Tạo biến để thu thập lựa chọn của người dùng
        int choice;
        while (true) {
            // show menu
            menu.print();
            // moi nhap lua chon
            choice = menu.getChoice();
            switch (choice) {
                case 1: {
                    // Check stuId truoc xem co trung khong
                    boolean isFind = false;
                    Student tempStudent = null;
                    String keyId;
                    do {
                        isFind = false;
                        keyId = input.getString("Input student id:");
                        tempStudent = sm.searchById(keyId);
                        // Nếu không tìm thấy và valid id thì isFind = true
                        //và dừng vòng lặp
                        if (tempStudent != null && keyId.matches(Acceptable.STU_ID_VALID)) {
                            isFind = true;
                        } else {
                            System.out.println("Data is invalid! Re-enter...");
                        }
                    } while (!isFind);
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    sm.showAll();
                    break;
                }
                case 4: {
                    // Moi nhap id
                    String keyId = input.inputAndLoop("Input student id:",
                            Acceptable.STU_ID_VALID);
                    sm.delete(keyId);
                    break;
                }
                case 5: {
                    // Yêu cầu người dùng nhập tên đầy đủ hoặc một phần tên
                    String keyName = input.inputAndLoop("Input full name or a part of name:",
                            Acceptable.NAME_VALID);
                    sm.searchByName(keyName);
                    break;
                }
                case 6: {
                    // Yêu cầu người dùng nhập vào campus
                    String keyCampus = input.inputAndLoop("Input your campusCode wannna to find(e.g., CE,DE,HE,SE,QE):",
                            "^\\D{2}$");
                    // Tạo mảng tạm để chứa
                    List<Student> filter = new ArrayList<>();
                    filter = sm.filterByCampusCode(keyCampus);
                    // Check và thông báo
                    if (filter.size() > 0) {
                        System.out.println("Registered Students Under Campus " + keyCampus + ":");
                        String str = String.format(
                                "-----------------------------------------------------------------------------\n"
                                + "Student ID     | Name            | Phone           | Peak Code| Fee\n"
                                + "-----------------------------------------------------------------------------"
                        );
                        System.out.println(str);
                        for (Student student : filter) {
                            System.out.println(student.toString());
                        }
                        System.out.println("-----------------------------------------------------------------------------");
                    } else {
                        System.out.println("No students have registered under this campus.");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Statistics of Registration by Mountain Peak:");
                    sm.statisticalizeByMountainPeak();
                    break;
                }
                case 8: {
                    sm.saveToFile();
                    System.out.println("Registration data has been successfully saved to `StudentList.csv`");
                    break;
                }
                case 9: {
                    return;
                }
                default: {
                    System.out.println("This function is not available.");
                    break;
                }
            }
        }

    }
}
