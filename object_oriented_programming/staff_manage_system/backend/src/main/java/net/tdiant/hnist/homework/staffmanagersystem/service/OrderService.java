package net.tdiant.hnist.homework.staffmanagersystem.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.tdiant.hnist.homework.staffmanagersystem.bean.OrderUnit;
import net.tdiant.hnist.homework.staffmanagersystem.bean.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public interface OrderService {

    List<OrderWrapper> findAll();

    List<OrderWrapper> findMyselfPull(int staffId);

    List<OrderWrapper> findByDepartment(String department);

    OrderWrapper getOrder(int id);

    OrderUnit createOrder(String title, String details, String targetDepartment, User author);

    @Data
    class OrderWrapper {
        private int id = -1;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
        private Date createdDate;
        private int authorStaffId;
        private String authorStaff;
        private String targetDepartment;
        private String title;
        private String details;
        private boolean closed = false;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
        private Date responseDate;
        private String responseDetails;
        private int responseStaffId;
        private String responseStaff;

        public OrderWrapper(OrderUnit orderUnit, User authorStaff, User responseStaff) {
            this.id = orderUnit.getId();
            this.createdDate = orderUnit.getCreatedDate();
            this.authorStaffId = orderUnit.getAuthorStaffId();
            this.authorStaff = (authorStaff != null) ? authorStaff.getUsername() : null;
            this.targetDepartment = orderUnit.getTargetDepartment();
            this.title = orderUnit.getTitle();
            this.details = orderUnit.getDetails();
            this.closed = orderUnit.isClosed();
            this.responseDate = orderUnit.getResponseDate();
            this.responseDetails = orderUnit.getResponseDetails();
            this.responseStaffId = orderUnit.getResponseStaffId();
            this.responseStaff = (responseStaff != null) ? responseStaff.getUsername() : null;
        }

    }

}
