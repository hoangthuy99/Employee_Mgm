package com.ra.Model;

import java.util.List;

public class Fresher extends Employee {
    /*
    Đối với nhân viên Fresher có thêm thuộc tính: Thời gian tốt nghiệp(Graduation_date), Xếp loại tốt nghiệp (Graduation_rank) , Trường tốt nghiệp (Education)
    *Đây là quan hệ Is-a vì Fresher là một loại Employee
     */

    private String graduation_date;
    private String graduation_rank;
    private String education;
    public Fresher() {
    }

   public Fresher(String id, String fullName, String birthDay, String phone, String email, int employee_type, String graduation_date, String graduation_rank, String education, List<Certificate> certificates) {
        super(id, fullName, birthDay, phone, email, employee_type, certificates);
        this.graduation_date = graduation_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduation_rank() {
        return graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public String getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;
    }
    @Override
    public void showInfo() {
        //Gọi phương thức showInfo() của lớp cha Employee và supper để hiển thị thông tin chung của nhân viên
        super.showInfo();
        System.out.println("Thời gian tốt nghiệp: " + graduation_date);
        System.out.println("Xếp loại tốt nghiệp: " + graduation_rank);
        System.out.println("Trường tốt nghiệp: " + education);
    }
}
