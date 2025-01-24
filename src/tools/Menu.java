package tools;

import java.util.ArrayList;

/*
    Menu là cái khuôn dùng đúc ra anh quản lí menu. Ảnh có danh sách list lưu các
option và đồng thời có title là properties để hiển thị tên của menu
    có danh sách các lựa chọn 'option list'
    có: tên của menu 'title'
    có: những hàm thao tác với optionList
    //thêm một option vào optionList
    //hiển thị danh sách optionList
    //hàm thu nhập lựa chọn của người dùng
*/
public class Menu {
    // mảng lưu các sự lựa chọn
    ArrayList<String> optionList = new ArrayList<>();
    // property
    private String title;
    
    // constructor

    public Menu(String title) {
        this.title = title;
    }
    
    // hàm thêm một option cho danh sách optionList
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    
    // hiển thị danh sách option kèm theo số đếm
    public void print(){
        int count = 1;
        System.out.println("__________.~" +title+"~.__________");
        for (String op : optionList) {
            System.out.println(count + ". " + op);
            count++;
        }
    }
    
    // hàm getChoice thu thập lựa chọn của người dùng
    public int getChoice(){
        return 1;
    }
}
