package net.tdiant.hnist.homework.staffmanagersystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.tdiant.hnist.homework.staffmanagersystem.bean.mapper")
public class StaffManagerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffManagerSystemApplication.class, args);
    }

}
