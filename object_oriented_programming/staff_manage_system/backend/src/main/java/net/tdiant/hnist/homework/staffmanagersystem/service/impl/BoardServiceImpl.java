package net.tdiant.hnist.homework.staffmanagersystem.service.impl;

import net.tdiant.hnist.homework.staffmanagersystem.bean.BoardUnit;
import net.tdiant.hnist.homework.staffmanagersystem.bean.mapper.BoardUnitMapper;
import net.tdiant.hnist.homework.staffmanagersystem.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardUnitMapper boardUnitMapper;

    @Override
    public List<BoardUnit> findAll() {
        return boardUnitMapper.findAll().stream().sorted(Comparator.comparingInt(BoardUnit::getId)).collect(Collectors.toList());
    }

    @Override
    public void create(String title, String description, int authorId, Date createdTime) {
        boardUnitMapper.create(title, description, authorId, createdTime);
    }

    @Autowired
    public void setBoardUnitMapper(BoardUnitMapper boardUnitMapper) {
        this.boardUnitMapper = boardUnitMapper;
    }
}
