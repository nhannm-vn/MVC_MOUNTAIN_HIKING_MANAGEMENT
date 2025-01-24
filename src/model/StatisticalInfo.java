package model;

// class hỗ trợ cho việc thống kê số lượng sinh viên
//và tính toán tổng số tiền
//*Nó dựa trên tính escapsulation để hỗ trợ việc code
public class StatisticalInfo {

    // Properties
    private String mountainCode;
    private int numOfStudent;
    private double totalCost;

    // Constructor
    // Constructor1: none-field
    public StatisticalInfo() {
    }

    // Constructor2: full-field
    public StatisticalInfo(String mountainCode, int numOfStudent, double totalCost) {
        this.mountainCode = mountainCode;
        this.numOfStudent = numOfStudent;
        this.totalCost = totalCost;
    }

    // Getter and Setter
    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // Method: toString(): String
    public String toString() {
        String str = String.format("%-5s| %-4d | %-8.0f",
                mountainCode, numOfStudent, totalCost);
        return str;
    }

}
