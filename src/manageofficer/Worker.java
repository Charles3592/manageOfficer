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
public class Worker extends Officer {
    private String level;
            
    public Worker(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
