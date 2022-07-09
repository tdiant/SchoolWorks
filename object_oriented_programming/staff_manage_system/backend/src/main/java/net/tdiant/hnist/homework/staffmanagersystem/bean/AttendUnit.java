package net.tdiant.hnist.homework.staffmanagersystem.bean;

import lombok.Data;

import java.util.Date;

@Data
public class AttendUnit {

    private int staffId;
    private Date time;

    public AttendUnit(int staffId, Date time) {
        this.staffId = staffId;
        this.time = time;
    }
}
