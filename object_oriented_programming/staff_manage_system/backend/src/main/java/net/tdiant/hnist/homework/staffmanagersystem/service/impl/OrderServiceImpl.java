package net.tdiant.hnist.homework.staffmanagersystem.service.impl;

import net.tdiant.hnist.homework.staffmanagersystem.bean.OrderUnit;
import net.tdiant.hnist.homework.staffmanagersystem.bean.User;
import net.tdiant.hnist.homework.staffmanagersystem.bean.mapper.OrderMapper;
import net.tdiant.hnist.homework.staffmanagersystem.service.OrderService;
import net.tdiant.hnist.homework.staffmanagersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private UserService userService;
    private OrderMapper orderMapper;

    @Override
    public List<OrderWrapper> findAll() {
        return orderMapper.findAll().stream().map(x -> new OrderWrapper(
                x,
                userService.getUser(x.getAuthorStaffId()),
                (x.getResponseStaffId() > 0) ? userService.getUser(x.getResponseStaffId()) : null
        )).collect(Collectors.toList());
    }

    @Override
    public List<OrderWrapper> findMyselfPull(int staffId) {
        return orderMapper.findMyselfPull(staffId).stream().map(x -> new OrderWrapper(
                x,
                userService.getUser(x.getAuthorStaffId()),
                (x.getResponseStaffId() > 0) ? userService.getUser(x.getResponseStaffId()) : null
        )).collect(Collectors.toList());
    }

    @Override
    public List<OrderWrapper> findByDepartment(String department) {
        return orderMapper.findByDepartment(department).stream().map(x -> new OrderWrapper(
                x,
                userService.getUser(x.getAuthorStaffId()),
                (x.getResponseStaffId() > 0) ? userService.getUser(x.getResponseStaffId()) : null
        )).collect(Collectors.toList());
    }

    @Override
    public OrderWrapper getOrder(int id) {
        OrderUnit x = orderMapper.getOrder(id);
        return new OrderWrapper(
                x,
                userService.getUser(x.getAuthorStaffId()),
                (x.getResponseStaffId() > 0) ? userService.getUser(x.getResponseStaffId()) : null
        );
    }

    @Override
    public OrderUnit createOrder(String title, String details, String targetDepartment, User author) {
        OrderUnit order = new OrderUnit(new Date(new java.util.Date().getTime()), author.getId(), targetDepartment, title, details);
        orderMapper.addOrder(order);
        return order;
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
