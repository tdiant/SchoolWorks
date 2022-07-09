package net.tdiant.hnist.homework.staffmanagersystem.service;

import lombok.Data;
import net.tdiant.hnist.homework.staffmanagersystem.bean.User;

import java.io.Serializable;

public interface UserService {

    User findLoginUser(String username, String password);

    User getUser(int id);

    void changePassword(int id, String newPassword);

    UserWrapper findUserGlobalData(int id);

    @Data
    class UserWrapper implements Serializable {
        private int id;
        private String realName;
        private String username;
        private String job;
        private String department;

        public UserWrapper() {
        }

        public UserWrapper(int id, String realName, String username, String job, String department) {
            this.id = id;
            this.realName = realName;
            this.username = username;
            this.job = job;
            this.department = department;
        }
    }

}
