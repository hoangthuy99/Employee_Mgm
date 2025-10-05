package com.ra.Model;

import java.util.ArrayList;
import java.util.List;
//Đây là phương thức trừu tượng
public abstract class Employee {
/*
* Đây là lớp Employee đại diện cho một nhân viên trong hệ thống quản lý nhân sự.
* Lớp này chứa các thuộc tính cơ bản của một nhân viên như ID, họ tên, ngày sinh, số điện thoại, email và loại nhân viên.
* Ngoài ra, lớp còn có một danh sách các chứng chỉ (certificates) mà nhân viên sở hữu.
* Lớp cũng có các phương thức để hiển thị thông tin nhân viên, thêm và xóa chứng chỉ.
* Lớp này có một biến tĩnh employee_count để đếm số lượng nhân viên được tạo ra.
* Lớp này có thể được kế thừa bởi các lớp con như Experience, Fresher và Intern để mở rộng thêm các thuộc tính và phương thức đặc thù cho từng loại nhân viên.
* */

    private String id;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private int employee_type; // 0: Experience, 1: Fresher , 2: Intern
    private static int employee_count = 0;
    List<Certificate> certificates = new ArrayList<>();// danh sách chứng chỉ và thể hiện quan hệ has-a

    public Employee() {
        employee_count++;
    }

    public Employee(String id, String fullName, String birthDay, String phone, String email, int employee_type, List<Certificate> certificates) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employee_type = employee_type;
        employee_count++;
        this.certificates = certificates;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(int employee_type) {
        this.employee_type = employee_type;
    }

    public static int getEmployee_count() {
        return employee_count;
    }

    public static void setEmployee_count(int employee_count) {
        Employee.employee_count = employee_count;
    }
    //Phương thức abstract mà các lớp con phải implement
    public void showInfo() {
        System.out.println("Employee Count: " + employee_count);
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Birth Day: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Type: " + employee_type);
        System.out.println("Certificates: ");
        //`Hiển thị thông tin các chứng chỉ của nhân viên
        for (Certificate certificate : certificates) {
            System.out.println("# " + certificate.getCertificateName() + " (ID: " + certificate.getCertificatedID() + ", Rank: " + certificate.getCertificateRank() + ", Date: " + certificate.getCertificatedDate() + ")");
        }
    }


}
