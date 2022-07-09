package net.tdiant.hnist.homework.staffmanagersystem.service;

import net.tdiant.hnist.homework.staffmanagersystem.bean.BoardUnit;

import java.util.Date;
import java.util.List;

public interface BoardService {

    public List<BoardUnit> findAll();

    public void create(String title, String description, int authorId, Date createdTime);

}
