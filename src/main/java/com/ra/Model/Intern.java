package com.ra.Model;

import java.util.List;

public class Intern extends Employee {
    /*
    Đối với nhân viên Intern có thêm thuộc tính: Chuyên ngành đang học (Majors), Học kì đang học (Semester), Tên trường đang học (University_name)
    *Đây là quan hệ Is-a vì Intern là một loại Employee
     */

    private String majors;
    private String semester;
    private String university_name;


    public Intern() {
    }

    public Intern(String id, String fullName, String birthDay, String phone, String email, int employee_type, List<Certificate> certificates, String majors, String semester, String university_name) {
        super(id, fullName, birthDay, phone, email, employee_type, certificates);
        this.majors = majors;
        this.semester = semester;
        this.university_name = university_name;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }
    @Override
    public void showInfo() {
        //Gọi phương thức showInfo() của lớp cha Employee và supper để hiển thị thông tin chung của nhân viên
        super.showInfo();
        System.out.println("Chuyên ngành đang học: " + majors);
        System.out.println("Học kì đang học: " + semester);
        System.out.println("Tên trường đang học: " + university_name);
    }
}
