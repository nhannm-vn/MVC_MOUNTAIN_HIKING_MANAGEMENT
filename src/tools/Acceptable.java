package tools;

public interface Acceptable {
    // Properties constanst
    public final String STU_ID_VALID = "^[CcDdHhSsQq][Ee]\\d{6}$";
    public final String NAME_VALID = "^\\D{2,20}$";
    public final String DOUBLE_VALID = "^-?\\d+([.,]\\d+)?$";
    public final String INTEGER_VALID = "\\d+";
    public final String PHONE_VALID = "^(03[2-9]|05[6|8|9]|07[0-9]|08[1-9]|09[0-9])\\d{7}$";
    public final String VIETTEL_VALID = "^(086|096|097|098|032|033|034|035|036|037|038|039)[0-9]{7}$";
    public final String VNPT_VALID = "^(081|082|083|084|085|088|091|094)\\d{7}$";
    public final String EMAIL_VALID = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    
    // method static này nghĩa là nó sẽ không phân mảnh và mình muốn sử dụng nó
    //thì phải lấy tên interface doc tới vì bản chất interface cũng không dùng để 
    //đúc ra object
    public static boolean isValid (String data, String pattern){
        return data.matches(pattern);
    }
}
