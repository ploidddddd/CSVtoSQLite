/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtosqlite;

public class Person {
    //private int id;
    private String fName;
    private String lName;
    private String gender;
    private String email;
    private String picpath;
    private String acct;
    private String salary;
    private Boolean q1;
    private Boolean q2;
    private String city;

    public Person(String fName, String lName, String gender, String email, String picpath, String acct, String salary, Boolean q1, Boolean q2, String city) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.email = email;
        this.picpath = picpath;
        this.acct = acct;
        this.salary = salary;
        this.q1 = q1;
        this.q2 = q2;
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
  

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Boolean getQ1() {
        return q1;
    }

    public void setQ1(Boolean q1) {
        this.q1 = q1;
    }

    public Boolean getQ2() {
        return q2;
    }

    public void setQ2(Boolean q2) {
        this.q2 = q2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    
}
