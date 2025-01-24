package model;

public class Mountain {
    // properties
    private String mountainCode;
    private String mountain;
    private String province;
    private String description;
    
    // Constructor
    // Constructor1: none-field

    public Mountain() {
    }
    
    // Constructor2: full-field

    public Mountain(String mountainCode, String mountain, String province, String description) {
        this.mountainCode = mountainCode;
        this.mountain = mountain;
        this.province = province;
        this.description = description;
    }
    
    // Getter and Setter

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public String getMountain() {
        return mountain;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    // Method: toString(): String
    
    public String toString(){
        String str = String.format("%-10s| %-25s | %-15s | %-25s",
                        mountainCode, mountain, province, description);
        return str;
    }
    
    
}
