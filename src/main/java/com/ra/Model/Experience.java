package com.ra.Model;

import java.util.List;

public class Experience extends Employee {
    /*
    Đối với nhân viên Experience có thêm thuộc tính: Số năm kinh nghiệm (ExpInYear), Kỹ năng chuyên môn (ProSkill)
     *Đây là quan hệ Is-a vì Experience là một loại Employee
     */
    private int expInYear;
    private String proSkill;
    public Experience() {
    }
    public Experience(String id, String fullName, String birthDay, String phone, String email, int employee_type, List<Certificate> certificates, int expInYear, String proSkill) {
        //Dùng super gọi constructor của lớp cha Employee để khởi tạo các thuộc tính chung
        //Còn các thuộc tính riêng của Experience thì khởi tạo trong constructor này
        //dùng this để phân biệt với tham số truyền vào
        super(id, fullName, birthDay, phone, email, employee_type, certificates);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }


    @Override
    public void showInfo() {
        //Gọi phương thức showInfo() của lớp cha Employee và supper để hiển thị thông tin chung của nhân viên
        super.showInfo();
        System.out.println("Số năm kinh nghiệm: " + expInYear);
        System.out.println("Kỹ năng chuyên môn: " + proSkill);
    }




}
