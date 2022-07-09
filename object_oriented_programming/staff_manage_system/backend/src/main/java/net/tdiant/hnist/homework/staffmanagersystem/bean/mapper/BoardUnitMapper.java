package net.tdiant.hnist.homework.staffmanagersystem.bean.mapper;

import net.tdiant.hnist.homework.staffmanagersystem.bean.BoardUnit;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BoardUnitMapper {

    List<BoardUnit> findAll();

    void create(@Param("title") String title, @Param("description") String description, @Param("authorId") int authorId, @Param("createdTime") Date createdTime);
}
