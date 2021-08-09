/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hoang
 */
public class Staff extends Employee{

    private String mission;
    
    public Staff() {
    }

    public Staff(String name, int age, String sex, String address) {
        super(name, age, sex, address);
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
    
    @Override
    public String toString() {
        return "Nhân viên: " + getName() + " - " + getAge() + " - " + getSex() + " - Công việc: " + getMission();
    }
}
