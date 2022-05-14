/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageofficer;

/**
 *
 * @author Van Cao Phu Loc
 */
public class Engineer extends Officer{
    private String major;

    public Engineer(String name, int age, String gender, String address, String major) {
        super(name, age, gender, address);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
}
