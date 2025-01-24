package tools;

// class phục vụ cho việc nhập và kiểm tra dữ liệu

import java.util.Scanner;

public class Inputter {
    // properties
    private Scanner ndl;
    
    // constructor

    public Inputter() {
        this.ndl = new Scanner(System.in);
    }
    
    // Mời người dùng nhập một chuỗi từ bàn phím
    public String getString(String mess){
        System.out.println(mess);
        return ndl.nextLine();
    }
    
    // Mời người dùng nhập một số nguyên từ bàn phím
    //nếu k valid thì trả số 0
    public int getInt(String mess){
        int result = 0;
        String temp = getString(mess);
        if(Acceptable.isValid(temp, Acceptable.INTEGER_VALID)){
            result = Integer.parseInt(temp);
        }
        return result;
    }
    
    // Mời người dùng nhập một số thực từ bàn phím
    //nếu k valid thì trả số 0
    public double getDouble(String mess){
        double result = 0;
        String temp = getString(mess);
        if(Acceptable.isValid(temp, Acceptable.DOUBLE_VALID)){
            result = Double.parseDouble(temp);
        }
        return result;
    }
    
    /* Phương thức cho phép nhập các loại dữ liệu dưới dạng chuỗi và yêu cầu nhập lại nếu dữ liệu không đúng */
    // đồng thời cũng không được bỏ trống
    public String inputAndLoop(String mess, String pattern){
        String result = "";
        // Bien check
        boolean isCheck = false;
        do {  
            isCheck = false;
            result = getString(mess);
            // Phải vừa không được bỏ trống và vừa thỏa regex thì mới dừng
            if(!result.isEmpty() && Acceptable.isValid(result, pattern)){
                isCheck = true;
            }else{
                System.out.println("Data is invalid !. Re-enter ...");
            }
        } while (!isCheck);
        return result.trim();
    }
    
}
