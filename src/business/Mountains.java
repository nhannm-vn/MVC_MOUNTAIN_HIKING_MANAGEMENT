package business;

import java.util.ArrayList;
import model.Mountain;

public class Mountains {

    // Tạo mảng để quản lí các đỉnh núi
    ArrayList<Mountain> mountainList = new ArrayList<>();

    // Properties
    private String pathFile;

    // Constructor
    //mình sẽ để gán luôn đường dẫn file trong này cho tiện sử dụng
    public Mountains() {
        this.pathFile = "D:\\PIEDTEAM_MERN\\F2\\Mvc-MountainHiking\\MountainList.csv";
    }

    // Method
    //get(String mountainCode): Mountain
    // Dựa vào mã núi để tìm ra đỉnh núi
    public Mountain get(String mountainCode) {
        for (Mountain item : mountainList) {
            if (item.getMountainCode().equals(mountainCode)) {
                return item;
            }
        }
        return null;
    }

    //isValidMountainCode(String mountainCode): boolean
    // dựa vào mã núi kiểm tra xem có núi trong danh sách không
    public boolean isValidMountainCode(String mountainCode){
        Mountain m = get(mountainCode);
        return m != null ? true : false;
    }
    
    
}
