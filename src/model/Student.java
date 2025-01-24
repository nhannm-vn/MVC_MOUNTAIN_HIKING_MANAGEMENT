package model;

import tools.Acceptable;


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
        this.id = id.toUpperCase();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tutionFee = tutionFee;
    }
    
    // Constructor3: tính số tiền sẵn cho sinh viên dựa vào nhà mạng

    public Student(String id, String name, String phone, String email, String mountainCode) {
        this.id = id.toUpperCase();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        if(Acceptable.isValid(this.phone, Acceptable.VNPT_VALID) 
           || Acceptable.isValid(this.phone, Acceptable.VIETTEL_VALID)){
            double free = (6000000 / 100) * 35;
            this.tutionFee = 6000000 - free;
        }else{
            this.tutionFee = 6000000;
        }
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
