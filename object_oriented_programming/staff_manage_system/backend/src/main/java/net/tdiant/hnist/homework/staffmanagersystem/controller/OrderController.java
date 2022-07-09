package net.tdiant.hnist.homework.staffmanagersystem.controller;

import net.tdiant.hnist.homework.staffmanagersystem.bean.OrderUnit;
import net.tdiant.hnist.homework.staffmanagersystem.bean.User;
import net.tdiant.hnist.homework.staffmanagersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @GetMapping("/findAll")
    public List<OrderService.OrderWrapper> findAll(HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) return new ArrayList<>();
        return orderService.findAll();
    }

    @GetMapping("/findMyselfPull")
    public List<OrderService.OrderWrapper> findMyselfPull(HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) return new ArrayList<>();
        try {
            User user = (User) request.getSession().getAttribute("login");
            return orderService.findMyselfPull(user.getId());
        } catch (Exception ignore) {
        }
        return new ArrayList<>();
    }

    @GetMapping("/findByDepartment")
    public List<OrderService.OrderWrapper> findByDepartment(HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) return new ArrayList<>();
        try {
            User user = (User) request.getSession().getAttribute("login");
            return orderService.findByDepartment(user.getDepartment());
        } catch (Exception ignore) {
        }
        return new ArrayList<>();
    }

    @GetMapping("/getOrder")
    public OrderService.OrderWrapper getOrder(@RequestParam("id") String id, HttpServletRequest request) {
        try {
            return orderService.getOrder(Integer.parseInt(id));
        } catch (Exception ignore) {
        }
        return null;
    }


    @PostMapping
    public OrderUnit createOrder(@RequestParam("title") String title, @RequestParam("details") String details, @RequestParam("targetDepartment") String targetDepartment) {
        return null;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
