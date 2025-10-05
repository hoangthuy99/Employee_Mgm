package com.ra.Service;

import com.ra.Model.*;

import java.util.*;

public class EmployeeIMPL implements EmployeeService {
    // Dùng static để danh sách nhân viên được chia sẻ giữa tất cả các instance của EmployeeIMPL
    // Điều này giúp duy trì trạng thái nhất quán của danh sách nhân viên trong toàn
    // bộ ứng dụng, bất kể có bao nhiêu đối tượng EmployeeIMPL được tạo ra
    // Nếu không dùng static, mỗi instance của EmployeeIMPL sẽ có danh sách nhân viên riêng biệt,
    // dẫn đến việc mất đồng bộ và khó quản lý dữ liệu nhân viên
    // Sử dụng ArrayList để lưu trữ danh sách nhân viên vì nó cung cấp khả năng truy cập ngẫu nhiên nhanh chóng và hiệu quả
    // Điều này rất hữu ích khi cần hiển thị hoặc tìm kiếm nhân viên theo chỉ số
    // ArrayList cũng linh hoạt trong việc thay đổi kích thước, cho phép thêm hoặc xóa nhân viên một cách dễ dàng
    // Điều này làm cho ArrayList trở thành lựa chọn phù hợp cho việc quản lý danh sách nhân viên trong ứng dụng
    // Sử dụng List thay vì ArrayList để khai báo biến giúp tăng tính linh hoạt và khả năng mở rộng của mã nguồn
    // Bằng cách khai báo biến là List, chúng ta có thể dễ dàng thay đổi kiểu cụ thể của danh sách (ví dụ: LinkedList, Vector) mà không cần thay đổi
    // các phần còn lại của mã nguồn. Điều này giúp mã nguồn trở nên dễ bảo trì và mở rộng trong tương lai
    // Dùng final để đảm bảo rằng biến employees không thể được gán lại một đối tượng danh sách khác sau khi đã khởi tạo

  private static final List<Employee> employees = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        Employee newEmployee = null;
        try{
            System.out.println("Enter employee ID: ");
            String id = scanner.nextLine();
            if(isIdExist(id)){
                System.out.println("ID already exists. Please enter a unique ID.");
                return;
            }
            System.out.println("Enter employee name: ");
            String fullName = scanner.nextLine();

            if(!isValidName(fullName)){
                System.out.println("Invalid name format. Please enter a valid name.");
                return;
            }
            System.out.println("Enter employee birth date: ");
            String birthDay = scanner.nextLine();
            if(!isValidBirthDay(birthDay)){
                System.out.println("Invalid birth date format. Please enter a valid date (dd/MM/yyyy).");
                return;
            }
            System.out.println("Enter employee phone number: ");
            String phone = scanner.nextLine();
            if(!isValidPhone(phone)){
                System.out.println("Invalid phone number format. Please enter a valid phone number. beginning with 0 or +84 and followed by 9-10 digits.");
                return;
            }
            System.out.println("Enter employee email: ");
            String email = scanner.nextLine();
            if(!isValidEmail(email)){
                System.out.println("Invalid email format. Please enter a valid email.@gmail.com");
                return;
            }
            //Add Certificate
            List<Certificate> certificates = new ArrayList<>();
            System.out.println("Do you want to add certificates? Y/N(yes/no)");
            String choice = scanner.nextLine();
            while (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter certificate ID: ");
                String certId = scanner.nextLine();
                System.out.println("Enter certificate name: ");
                String certName = scanner.nextLine();
                System.out.println("Enter certificate rank: ");
                String certRank = scanner.nextLine();
                System.out.println("Enter certificate date: ");
                String certDate = scanner.nextLine();
                certificates.add(new Certificate(certId, certName, certRank, certDate));
                System.out.println("Do you want to add another certificate? (yes/no)");
                choice = scanner.nextLine();
            }


            System.out.println("Enter employee type (0: Experience, 1: Fresher, 2: Intern): ");
            int employee_type = Integer.parseInt(scanner.nextLine());
            switch (employee_type) {
                case 0:
                    System.out.println("Enter years of experience: ");
                    int expInYear = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter professional skills: ");
                    String proSkill = scanner.nextLine();
                    newEmployee = new Experience(id, fullName, birthDay, phone, email, employee_type, certificates, expInYear, proSkill);
                    break;
                case 1:
                    System.out.println("Enter graduation date: ");
                    String graduation_date = scanner.nextLine();
                    System.out.println("Enter graduation rank: ");
                    String graduation_rank = scanner.nextLine();
                    System.out.println("Enter education: ");
                    String education = scanner.nextLine();
                    newEmployee = new Fresher(id, fullName, birthDay, phone, email, employee_type, graduation_date, graduation_rank, education, certificates);
                    break;
                case 2:
                    System.out.println("Enter major: ");
                    String major = scanner.nextLine();
                    System.out.println("Enter semester: ");
                    String semester = scanner.nextLine();
                    System.out.println("Enter university name: ");
                    String university_name = scanner.nextLine();
                    newEmployee = new Intern(id, fullName, birthDay, phone, email, employee_type, certificates, major, semester, university_name);
                    break;
                default:
                    System.out.println("Invalid employee type.");
            }
          // Add the new employee to the list
            if (newEmployee != null) {
                employees.add(newEmployee);
                System.out.println("Employee added successfully.");
            }else{
                System.out.println("Failed to add employee.");
            }


        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }


    }

    @Override
    public void search() {
        //Search employee by Type
        System.out.println("Enter employee type to search (0: Experience, 1: Fresher, 2: Intern): ");
        try{
            //Khai báo biến type để lưu loại nhân viên cần tìm kiếm
            int type = Integer.parseInt(scanner.nextLine().trim());
            //Kiểm tra tính hợp lệ của biến type nếu không hợp lệ thì thông báo lỗi và kết thúc phương thức
            if (type < 0 || type > 2) {
                System.out.println("Invalid employee type.");
                return;
            }
            //Kiểm tra nếu danh sách nhân viên rỗng thì thông báo và kết thúc phương thức
            if (employees.isEmpty()) {
                System.out.println("No employees available.");
                return;
            }
            //Duyệt qua danh sách nhân viên và hiển thị thông tin của những nhân viên có loại trùng với biến type
            boolean found = false;
            for (Employee emp : employees) {
                //So sánh loại nhân viên của từng nhân viên với biến type
                //Nếu trùng khớp thì gọi phương thức showInfo() để hiển thị thông tin nhân viên
                if (emp.getEmployee_type() == type) {
                    emp.showInfo();
                    System.out.println("--------------------");
                    found = true;
                }

            }
            //Nếu không tìm thấy nhân viên nào có loại trùng với biến type thì thông báo không tìm thấy
            if (!found) {
                System.out.println("No employees found of the specified type.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter 0, 1 or 2.");
        }catch (Exception e){
            System.out.println("Error searching employees: " + e.getMessage());
        }
    }

    @Override
    public void showAll() {
       // Show all employees
        //Dùng instanceof để kiểm tra kiểu đối tượng và ép kiểu tương ứng để gọi phương thức showInfo()
       try{
           if(employees.isEmpty()) {
               System.out.println("No employees to display.");
               return;
           }
           for (Employee emp : employees) {
               if (emp instanceof Experience) {
                   System.out.println("Experience Employee:");
                   emp.showInfo();
                   System.out.println("-------------------");
               } else if (emp instanceof Fresher) {
                   System.out.println("Fresher Employee:");
                   emp.showInfo();
                   System.out.println("-------------------");
               } else if (emp instanceof Intern) {
                   System.out.println("Intern Employee:");
                   emp.showInfo();
                   System.out.println("-------------------");
               }
           }
       } catch (Exception e) {
           System.out.println("Error displaying employees: " + e.getMessage());
       }

    }

    @Override
    public void update() {
    // Update employee information by ID
        System.out.println("Enter employee ID to update: ");
        String id = scanner.nextLine();
        //Duyệt qua danh sách nhân viên để tìm nhân viên theo ID
        try{
            for (Employee emp : employees) {
                if (emp.getId().equals(id)) {
                    System.out.println("Enter new name: ");
                    String name = scanner.nextLine();
                    if(isValidName(name)) {
                        emp.setFullName(name);
                    } else {
                        System.out.println("Invalid name format.");
                    }
                    System.out.println("Enter new birth date: ");
                    String birthDay = scanner.nextLine();
                    if(isValidBirthDay(birthDay)) {
                        emp.setBirthDay(birthDay);
                    } else {
                        System.out.println("Invalid birth date format.");
                    }
                    System.out.println("Enter new phone number: ");
                    String phone = scanner.nextLine();
                    if(isValidPhone(phone)) {
                        emp.setPhone(phone);
                    } else {
                        System.out.println("Invalid phone number format.");
                    }
                    System.out.println("Enter new email: ");
                    String email = scanner.nextLine();
                    if(isValidEmail(email)) {
                        emp.setEmail(email);
                    } else {
                        System.out.println("Invalid email format.");
                    }
                    System.out.println("Employee updated successfully.");
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    @Override
    public void delete() {
   // Delete employee by ID
        System.out.println("Enter employee ID to delete: ");
        try{
            String id = scanner.nextLine();
            // Sử dụng iterator để tránh ConcurrentModificationException khi xóa phần tử trong danh sách
            Iterator<Employee> iterator = employees.iterator();
            // Duyệt qua danh sách nhân viên để tìm nhân viên theo ID
            while (iterator.hasNext()) {
                Employee emp = iterator.next();
                // Nếu tìm thấy nhân viên với ID tương ứng, xóa nhân viên khỏi danh sách
                if (emp.getId().equals(id)) {
                    iterator.remove();
                    Employee.setEmployee_count(Employee.getEmployee_count() - 1);
                    System.out.println("Employee deleted successfully.");
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    @Override
    public boolean isIdExist(String id) {
        // Check if ID already exists
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                return true;
            }
        } return false;
    }

    @Override
    public boolean isValidName(String name) {
        //regex for name validation
        String nameRegex = "^[a-zA-ZÀ-ỹ\\s]+$";
        return name != null && name.matches(nameRegex);
    }

    @Override
    public boolean isValidEmail(String email) {

       //regex for email validation
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    @Override
    public boolean isValidPhone(String phone) {
        //regex for phone number validation
        String phoneRegex = "^(\\+84|0)(3[2-9]|5[2689]|7[0-9]|8[1-9]|9[0-9])[0-9]{7}$";
        return phone != null && phone.matches(phoneRegex);
    }

    @Override
    public boolean isValidBirthDay(String birthDay) {
        //regex for birthdate validation (format: dd/MM/yyyy)
        String dateRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (birthDay != null && birthDay.matches(dateRegex)) {
            String[] parts = birthDay.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            if (month == 2) {
                return day <= 29; // Simplified check for February
            } else if (Arrays.asList(4, 6, 9, 11).contains(month)) {
                return day <= 30;
            } else {
                return day <= 31;
            }
        }
        return false;
    }

}
