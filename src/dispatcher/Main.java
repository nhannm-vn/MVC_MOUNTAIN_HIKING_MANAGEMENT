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
                        if (tempStudent == null && keyId.matches(Acceptable.STU_ID_VALID)) {
                            isFind = true;
                        } else {
                            System.out.println("Data is invalid! Re-enter...");
                        }
                    } while (!isFind);
                    // Nhập các field khác 
                    String name = input.inputAndLoop("Input student name:",
                            Acceptable.NAME_VALID);
                    String phone = input.inputAndLoop("Input student phone number:",
                            Acceptable.PHONE_VALID);
                    String email = input.inputAndLoop("Input student email:",
                            Acceptable.EMAIL_VALID);
                    // Check mountain code nhập vào có trong list chưa
                    String mountainCode;
                    do {
                        // reset
                        isFind = false;
                        mountainCode = input.getString("Input mountain code of student:");
                        // Check xem mã núi có trong list không. Nếu không có thì phải 
                        //nhập lại
                        if (mountains.isValidMountainCode(mountainCode)) {
                            isFind = true;
                        } else {
                            System.out.println("Data is invalid! Re-enter...");
                        }
                    } while (!isFind);
                    // Tạo ra instance bằng cái phểu tính tiền
                    Student newStudent = new Student(keyId, name, phone, email, mountainCode);
                    // Thêm vào danh sách
                    sm.add(newStudent);
                    // Thông báo thành công
                    System.out.println("Adding new student to list successfully!");
                    break;
                }
                case 2: {
                    // Nhập vào id nếu mà không có thằng để update thì báo luôn
                    String id = input.inputAndLoop("Input student id:",
                            Acceptable.STU_ID_VALID);
                    // Check
                    Student updateStudent = sm.searchById(id);
                    // Nếu không có thì làm sao update được
                    if (updateStudent == null) {
                        System.out.println("This student has not registered yet.");
                    } else {
                        String name = input.inputAndLoop("Input student name:",
                                Acceptable.NAME_VALID);
                        String phone = input.inputAndLoop("Input student phone number:",
                                Acceptable.PHONE_VALID);
                        String email = input.inputAndLoop("Input student email:",
                                Acceptable.EMAIL_VALID);
                        // Check valid cho mountainCode
                        String mountainCode;
                        boolean isFind = false;
                        do {
                            // reset
                            isFind = false;
                            mountainCode = input.getString("Input mountain code of student:");
                            // Check xem mã núi có trong list không. Nếu không có thì phải 
                            //nhập lại
                            if (mountains.isValidMountainCode(mountainCode)) {
                                isFind = true;
                            } else {
                                System.out.println("Data is invalid! Re-enter...");
                            }
                        } while (!isFind);
                        // set lại các thuộc tính
                        updateStudent.setName(name);
                        updateStudent.setPhone(phone);
                        updateStudent.setEmail(email);
                        updateStudent.setMountainCode(mountainCode);
                        // sau khi update sdt thì cũng phải update lại số tiền luôn
                        if (updateStudent.getPhone().matches(Acceptable.VIETTEL_VALID)
                                || updateStudent.getPhone().matches(Acceptable.VNPT_VALID)) {
                            double free = (6000000 * 35) / 100;
                            updateStudent.setTutionFee(6000000 - free);
                        }else{
                            updateStudent.setTutionFee(6000000);
                        }
                        // Nhờ sm update vào list
                        sm.update(updateStudent);
                        // Thông báo
                        System.out.println("Update student information successfully");
                    }
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
                    // Nếu đã chạy method saveToFile rồi thì dừng luôn
                    if(sm.isSaved()) return;
                    // Nếu chưa thì hỏi có muốn save không trước khi tắt
                    String option = input.inputAndLoop("You have unsaved changes."
                    + " Are you sure you want to exit without saving? (Y/N)", "^[YyNn]$");
                    if(option.matches("^[Yy]$")){
                        sm.saveToFile();
                    }else{
                        return;
                    }
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
