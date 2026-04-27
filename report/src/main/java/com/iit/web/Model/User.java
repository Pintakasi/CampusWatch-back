package com.iit.web.Model;

public class User {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private Byte yearLevel;
    private String college;
    private String department;
    private String role;

    // No-args constructor
    public User() {
    }

    // All-args constructor
    public User(int id, String email, String password, String firstName, String lastName,
                String middleName, Byte yearLevel, String college, String department, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.yearLevel = yearLevel;
        this.college = college;
        this.department = department;
        this.role = role;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Byte getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(Byte yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}