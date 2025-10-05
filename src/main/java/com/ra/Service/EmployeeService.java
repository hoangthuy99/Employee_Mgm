package com.ra.Service;

import com.ra.Model.Experience;
import com.ra.Model.Fresher;
import com.ra.Model.Intern;

import java.util.List;

public interface EmployeeService {
    void add();
    void search();
    void showAll();
    void update();
    void delete();
    boolean isIdExist(String id);
    boolean isValidName(String name);
    boolean isValidEmail(String email);
    boolean isValidPhone(String phone);
    boolean isValidBirthDay(String birthDay);



}
