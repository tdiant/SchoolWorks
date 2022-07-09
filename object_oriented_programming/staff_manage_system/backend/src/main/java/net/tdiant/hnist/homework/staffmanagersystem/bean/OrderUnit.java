package net.tdiant.hnist.homework.staffmanagersystem.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Data
public class OrderUnit implements Serializable {

    private int id = -1;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;
    private int authorStaffId;
    private String targetDepartment;
    private String title;
    private String details;
    private boolean closed = false;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    private Date responseDate;
    private String responseDetails;
    private int responseStaffId;

    public OrderUnit() {
    }

    public OrderUnit(Date createdDate, int authorStaffId, String targetDepartment, String title, String details) {
        this.createdDate = createdDate;
        this.authorStaffId = authorStaffId;
        this.targetDepartment = targetDepartment;
        this.title = title;
        this.details = details;
    }

}
