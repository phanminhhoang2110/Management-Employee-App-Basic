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
public class Engineer extends Employee {

    private String specialized;

    public Engineer(String name, int age, String sex, String address) {
        super(name, age, sex, address);
    }

    public Engineer() {
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    @Override
    public String toString() {
        return "Kĩ sư : " + " " + getName() + " " + getAge() + " " + getSex() + " Chuyên Ngành: " + getSpecialized();
    }

}
