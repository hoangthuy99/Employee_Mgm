package com.ra.View;


import com.ra.Controller.EmployeeController;

import java.util.Scanner;

/* Lơp có quan hệ Has-a với EmployeeController vì nó sử dụng EmployeeController để thực hiện các thao tác liên quan đến nhân viên.
 * Lớp này chịu trách nhiệm hiển thị menu và nhận lựa chọn từ người dùng, sau đó gọi các phương thức tương ứng trong EmployeeController để thực hiện các chức năng như thêm, hiển thị, tìm kiếm, cập nhật và xóa nhân viên.
* */

public class EmployeeView {
    // hiển thị menu nhân viên
    public void menuEmployee() {
        EmployeeController employeeController = new EmployeeController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Menu Employee Management-----");
        do {
            menu();
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Add new employee");
                    employeeController.insertEmployee();
                    break;
                case 2:
                    System.out.println("Display employee list");
                    employeeController.displayEmployee();
                    break;
                case 3:
                    System.out.println("Search employee by type");
                    employeeController.searchEmployee();
                    break;
                case 4:
                    System.out.println("Update employee information");
                    employeeController.updateEmployee();
                    break;
                case 5:
                    System.out.println("Delete employee");
                    employeeController.deleteEmployee();
                    break;
                case 6:
                    System.out.println("Exist program");
                    return;
                default:
                    System.out.println("Please choose again (1-6)");
            }
        } while (true);

    }
    public void menu() {
        System.out.println("1. Add new employee");
        System.out.println("2. Display employee list");
        System.out.println("3. Search employee by type");
        System.out.println("4. Update employee information");
        System.out.println("5. Delete employee");
        System.out.println("7. Exist program");
    }
}
