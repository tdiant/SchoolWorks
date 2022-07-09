package net.tdiant.hnist.homework.staffmanagersystem;

import net.tdiant.hnist.homework.staffmanagersystem.bean.OrderUnit;
import net.tdiant.hnist.homework.staffmanagersystem.bean.User;
import net.tdiant.hnist.homework.staffmanagersystem.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {

//    @Autowired
//    public OrderMapper order;
//
//    @Test
//    public void testOrderFindAll() {
//        System.out.println(order.findByAuthor(new User(1, null, null, nBigIntegerull, null, null, null, null)));
//    }

    @Autowired
    public OrderService orderService;

    @Test
    public void testInsert() {
        OrderUnit o = orderService.createOrder("test233", "66666", "fuck", new User(233, null, null, null, null, null, null, null, 0));
        System.out.println(o.getId());
    }
}
