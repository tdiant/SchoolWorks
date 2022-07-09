package net.tdiant.hnist.homework.staffmanagersystem.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable {

    private int id;
    private String username;
    private String realName;
    private String job;
    private String phoneNumber;
    private String department;
    private List<String> tags;
    private Date joinDate;
    private int expectSalary;
    private int role = 0;

    public User() {
    }

    public User(int id, String username, String realName, String job, String phoneNumber, String department, List<String> tags, Date joinDate, int expectSalary) {
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.job = job;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.tags = tags;
        this.joinDate = joinDate;
        this.expectSalary = expectSalary;
    }

}
