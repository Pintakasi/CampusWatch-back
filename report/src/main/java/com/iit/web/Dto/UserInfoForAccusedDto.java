package com.iit.web.Dto;

public class UserInfoForAccusedDto
{
    int id;
    String fullName;
    String role;
    String department;

    public UserInfoForAccusedDto(int id, String fullName, String role, String department)
    {
        this.id = id;
        this.fullName = fullName;
        this.role = role;
        this.department = department;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }
}
