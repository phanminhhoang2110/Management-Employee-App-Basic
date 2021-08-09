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
public class Worker extends Employee {

    private int level;

    public Worker(String name, int age, String sex, String address) {
        super(name, age, sex, address);
    }

    public Worker() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Công nhân : " + " " + getName() + " " + getAge() + " " + getSex() + " Cấp Bậc: " + getLevel();
    }
}
