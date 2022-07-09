package net.tdiant.hnist.homework.staffmanagersystem.controller;

import net.tdiant.hnist.homework.staffmanagersystem.bean.BoardUnit;
import net.tdiant.hnist.homework.staffmanagersystem.bean.User;
import net.tdiant.hnist.homework.staffmanagersystem.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @GetMapping("/getAll")
    public List<BoardUnit> getAll(HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null)
            return new ArrayList<>();
        return boardService.findAll();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody Map<String, String> args, HttpServletRequest request) {
        try {
            User user = (User) request.getSession().getAttribute("login");
            if (user.getRole() < 2) return false;
            if (!args.containsKey("title")) return false;
            boardService.create(args.get("title"), args.getOrDefault("description", ""), user.getId(), new Date());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Autowired
    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

}
