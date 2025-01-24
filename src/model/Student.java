package model;


public class Student {
    // properties
    private String id;
    private String name;
    private String phone;
    private String email;
    private String mountainCode;
    private double tutionFee;
    
    // Constructor
    // Constuctor1: none-field

    public Student() {
    }
    
    // Constructor full-field

    public Student(String id, String name, String phone, String email, String mountainCode, double tutionFee) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tutionFee = tutionFee;
    }
    
    // Getter and Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public double getTutionFee() {
        return tutionFee;
    }

    public void setTutionFee(double tutionFee) {
        this.tutionFee = tutionFee;
    }
    
    // Method: toString(): String
    public String toString(){
        String str = String.format("%-15s| %-15s | %-15s | %-8s | %-8.0f",
         id, name, phone, mountainCode, tutionFee);
        return str;
    }
   
    
}
