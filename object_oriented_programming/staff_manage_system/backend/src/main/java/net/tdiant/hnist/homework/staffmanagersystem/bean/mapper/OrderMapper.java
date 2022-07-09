package net.tdiant.hnist.homework.staffmanagersystem.bean.mapper;

import net.tdiant.hnist.homework.staffmanagersystem.bean.OrderUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    List<OrderUnit> findAll();

    List<OrderUnit> findMyselfPull(@Param("id") int staffId);

    List<OrderUnit> findByDepartment(@Param("department") String department);

    OrderUnit getOrder(@Param("id") int id);

    void addOrder(OrderUnit order);


}
