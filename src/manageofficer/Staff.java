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
public class Staff extends Officer{
    private String job;

    public Staff(String name, int age, String gender, String address, String job) {
        super(name, age, gender, address);
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
}
