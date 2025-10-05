package com.ra.Controller;


import com.ra.Service.EmployeeIMPL;
/** * EmployeeController là lớp điều khiển để quản lý các thao tác liên quan đến nhân viên.
 * Lớp này sử dụng EmployeeIMPL để thực hiện các chức năng như thêm, hiển thị, tìm kiếm, cập nhật và xóa nhân viên.
 * Mỗi phương thức trong lớp này tương ứng với một chức năng cụ thể và gọi phương thức tương ứng trong EmployeeIMPL.
 * Có mối quan hệ Has-a vì controller có một đối tượng của EmployeeIMPL để thực hiện các thao tác.
 */
public class EmployeeController {
    private EmployeeIMPL employeeIMPL = new EmployeeIMPL();

    public void insertEmployee() {
        employeeIMPL.add();
    }

    public void displayEmployee() {
        employeeIMPL.showAll();
    }

    public void searchEmployee() {
        employeeIMPL.search();
    }


    public void updateEmployee() {
        employeeIMPL.update();
    }

    public void deleteEmployee() {
        employeeIMPL.delete();
    }

}