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
    public Mountain get(String mountainCode) {
        for (Mountain item : mountainList) {
            if (item.getMountainCode().equals(mountainCode)) {
                return item;
            }
        }
        return null;
    }

}
