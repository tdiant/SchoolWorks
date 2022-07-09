package net.tdiant.hnist.homework.staffmanagersystem.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BoardUnit implements Serializable {

    private int id;
    private Date createdTime;
    private String title;
    private int authorId;
    private String description;

    public BoardUnit() {
    }

}
