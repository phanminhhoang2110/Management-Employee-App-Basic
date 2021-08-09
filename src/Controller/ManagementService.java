/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constant.Constant;
import Model.Employee;
import Model.Engineer;
import Model.Staff;
import Model.Worker;
import example1.Example1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hoang
 */
public class ManagementService {

    private List<Employee> employees;

    public ManagementService() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public static Employee addCommon(Employee employee, Scanner scanner) {
        Constant constant = new Constant();
        System.out.print("Nhập tên: ");
        employee.setName(checkEmpty(scanner.nextLine(), scanner));
        System.out.print("Nhập tuổi: ");
        int age = Example1.checkTypeIntInput(scanner,constant.DOWN_BOUND_AGE,constant.UP_BOUND_AGE,constant.REENTER_AGE);
        employee.setAge(age);
        String sex = "";
        do {
            System.out.print("Nhập giới tính (tiếng việt không dấu Nam/Nu/Khac): ");
            sex = scanner.nextLine();
        } while (!sex.equalsIgnoreCase(constant.MALE) && !sex.equalsIgnoreCase(constant.FEMALE) && !sex.equalsIgnoreCase(constant.OTHER));
        employee.setSex(sex);
        System.out.print("Nhập địa chỉ: ");
        employee.setAddress(checkEmpty(scanner.nextLine(), scanner));
        return employee;
    }

    public static String checkEmpty(String string, Scanner scanner) {
        if (!string.isEmpty()) {
            return string;
        }
        do {
            System.out.println("Không được để chống trường này !");
            string = scanner.nextLine();
        } while (string.isEmpty());
        return string;
    }

    public String addNewEmployee(String typeEmployee) {
        String result = "";
        boolean add = false;
        Constant constant = new Constant();
        Scanner scanner = new Scanner(System.in);
        if (constant.ENGINEER.equals(typeEmployee)) {
            Engineer engineer = new Engineer();
            engineer = (Engineer) addCommon(engineer, scanner);
            System.out.print("Nhập chuyên ngành: ");
            engineer.setSpecialized(checkEmpty(scanner.nextLine(), scanner));
            add = employees.add(engineer);
        } else if (constant.STAFF.equals(typeEmployee)) {
            Staff staff = new Staff();
            staff = (Staff) addCommon(staff, scanner);
            System.out.print("Nhập công việc: ");
            staff.setMission(checkEmpty(scanner.nextLine(), scanner));
            add = employees.add(staff);
        } else if (constant.WORKER.equals(typeEmployee)) {
            Worker worker = new Worker();
            worker = (Worker) addCommon(worker, scanner);
            System.out.print("Nhập cấp bậc: ");
            int level = 0;
            level = Example1.checkTypeIntInput(scanner,constant.DOWN_BOUND_LEVEL,constant.UP_BOUND_LEVEL,constant.REENTER_LEVEL);
            worker.setLevel(level);
            add = employees.add(worker);
        }
        if (add) {
            result = "Nhập liệu thành công";
        } else {
            result = "Nhập liệu chưa thành công vui lòng thử lại";
        }
        return result;
    }

    public void viewListEmployee(ArrayList<Employee> employees) {
        System.out.println("_____________________________________________");
        System.out.println("DANH SÁCH NHÂN VIÊN CỦA CÔNG TY ");
        System.out.println("---");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public void searchEmployeeByName(String keyword, ArrayList<Employee> employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getName().toLowerCase().contains(keyword.toLowerCase())) {
                count++;
                System.out.println(employee.toString());
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy ai tên giống bạn cần tìm !");
        }
    }

}
