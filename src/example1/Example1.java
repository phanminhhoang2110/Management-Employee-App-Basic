/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example1;

import Constant.Constant;
import Controller.ManagementService;
import Model.Employee;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hoang
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public static void menu() {
        System.out.println("_____________________________________________");
        System.out.println("HỆ THỐNG QUẢN LÍ CÁN BỘ");
        System.out.println("1. Thêm mới cán bộ");
        System.out.println("2. Tìm kiếm");
        System.out.println("3. Hiển thị danh sách cán bộ");
        System.out.println("4. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void addEmployee() {
        System.out.println("1. Thêm Kĩ Sư");
        System.out.println("2. Thêm Nhân Viên");
        System.out.println("3. Thêm Công Nhân");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static int checkTypeIntInput(Scanner s) {
        int choice = 0;
        do {
            try {
                String choiceFromInput = s.nextLine();
                choice = Integer.parseInt(choiceFromInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
            }
        } while (true);
        return choice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Constant constant = new Constant();
        ManagementService managementService = new ManagementService();
        int choice = 0;
        int isRepeat = 1;
        menu();
        do {
            choice = checkTypeIntInput(scanner);
            switch (choice) {
                case 1:
                    addEmployee();
                    int e = checkTypeIntInput(scanner);
                    String result;
                    switch (e) {
                        case 1:
                            result = managementService.addNewEmployee(constant.ENGINEER);
                            System.out.println(result);
                            break;
                        case 2:
                            result = managementService.addNewEmployee(constant.STAFF);
                            System.out.println(result);
                            break;
                        case 3:
                            result = managementService.addNewEmployee(constant.WORKER);
                            System.out.println(result);
                            break;
                        default:
                            System.out.println("Vui lòng nhập lại lựa chọn");
                    }
                    break;
                case 2:
                    String keyword = "";
                    if (managementService.getEmployees().size() == 0) {
                        System.out.println("Chưa có dữ liệu !");
                    } else {
                        do {
                            System.out.print("Vui lòng nhập tên người bạn muốn tìm: ");
                            keyword = scanner.nextLine();
                        } while (keyword.isEmpty());
                        managementService.searchEmployeeByName(keyword, (ArrayList<Employee>) managementService.getEmployees());
                    }
                    break;
                case 3:
                    managementService.viewListEmployee((ArrayList<Employee>) managementService.getEmployees());
                    break;
                case 4:
                    isRepeat = 0;
                    break;
                default:
                    System.out.println("Vui lòng nhập lại lựa chọn");
            }
            if (choice != 4) {
                menu();
            } else {
                System.out.println("CHÚC BẠN MỘT BUỔI LÀM VIỆC HIỆU QUẢ !");
            }
        } while (isRepeat == 1);
    }

}
