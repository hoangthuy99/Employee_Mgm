package com.ra.Model;
// Certificate chỉ là chứng chỉ, không phải nhân viên
// Vì vậy, Certificate không nên kế thừa từ Employee
// Mà nên là một lớp riêng biệt
// Và Employee sẽ có một danh sách các Certificate (quan hệ has-a)
// Điều này giúp mô hình hóa đúng hơn thực tế, vì một nhân viên có thể có nhiều chứng chỉ khác nhau
// Và chứng chỉ không phải là một loại nhân viên
public class Certificate {
    private String certificatedID;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;

    public Certificate() {
    }

    public Certificate(String certificatedID, String certificateName, String certificateRank, String certificatedDate) {
        this.certificatedID = certificatedID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }

    public String getCertificatedID() {
        return certificatedID;
    }

    public void setCertificatedID(String certificatedID) {
        this.certificatedID = certificatedID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }
    public void showMe( ){
        System.out.println("Certificate ID: " + certificatedID);
        System.out.println("Certificate Name: " + certificateName);
        System.out.println("Certificate Rank: " + certificateRank);
        System.out.println("Certificate Date: " + certificatedDate);
    }
}
