package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import model.Mountain;

public class Mountains {

    // Tạo mảng để quản lí các đỉnh núi
    public ArrayList<Mountain> mountainList = new ArrayList<>();

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
    
    //dataToObject(String text): Mountain
    // nhận vào string sau đó băm ra đúc và trả ra obj
    public Mountain dataToObject(String text){
        StringTokenizer st = new StringTokenizer(text, ",");
        // Đổ các field băm ra được vào biến
        // Tuy nhiên đối với id thì độ chế tí
        String mountainCode = st.nextToken().trim();
        // Nghĩa là từ 1 đến 9 thì thêm số 0
        if(mountainCode.matches("\\d")){
            mountainCode = "MT0" + mountainCode;
        }else{
            mountainCode = "MT" + mountainCode;
        }
        // các prop khác
        String mountain = st.nextToken().trim();
        String province = st.nextToken().trim();
        String description = st.nextToken().trim();
        
        // Đúc ra obj
        Mountain m = new Mountain(mountainCode, mountain, province, description);
        return m;
    }
    
    //readFromFile():void
    public void readFromFile(){
        // Tạo đối tượng file
        File f = new File(pathFile);
        // Trong quá trình đọc file có thể lỗi
        //nên mình cần try-catch
        try {
            // handle sự tồn tại của file
            if(!f.exists()) return;
            // Tạo đối tượng đọc dữ liệu
            FileReader fr = new FileReader(f);
            // Tạo Buffer đọc dữ liệu từ file
            BufferedReader br = new BufferedReader(fr);
            // Đọc dòng đầu tiên
            String line = br.readLine();
            // Bỏ dòng đầu do dính title
            line = br.readLine();
            // Kiểm tra nếu còn đọc được thì còn làm
            while(line != null && !line.isEmpty()){
                Mountain m = dataToObject(line);
                // handle 
                if(m != null){
                    mountainList.add(m);
                }
                // đọc dòng tiếp theo
                line = br.readLine();
            }
            // Đóng sau khi hoàn thành
            br.close();
        } catch (Exception e) {
            System.out.println("File loi roi: " + e);
        }
        
    }
    
}
