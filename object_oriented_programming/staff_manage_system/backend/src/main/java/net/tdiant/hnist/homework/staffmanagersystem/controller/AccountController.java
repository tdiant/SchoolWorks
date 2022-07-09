package net.tdiant.hnist.homework.staffmanagersystem.controller;

import net.tdiant.hnist.homework.staffmanagersystem.bean.User;
import net.tdiant.hnist.homework.staffmanagersystem.service.UserService;
import net.tdiant.hnist.homework.staffmanagersystem.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    private UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> args, HttpServletRequest request) {
        try {
            if (!args.containsKey("username") || !args.containsKey("passwd")) return null;
            String username = args.get("username");
            String passwd = args.get("passwd");
            if (username.trim().equalsIgnoreCase("") || passwd.equalsIgnoreCase("")) return null;

            String password = StringUtils.sha1(passwd);

            User user = userService.findLoginUser(username, password);

            if (user != null) {
                request.getSession().removeAttribute("login");
                request.getSession().setAttribute("login", user);
            }

            return user;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @CrossOrigin
    @GetMapping("/logout")
    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        request.getSession().removeAttribute("login");
    }

    Map<Integer, Long> checkCooldownMap = new HashMap<>();

    @CrossOrigin
    @GetMapping("/checkLogin")
    @PostMapping("/checkLogin")
    public User checkLogin(HttpServletRequest request) {
        try {
            User user = (User) request.getSession().getAttribute("login");
            if (System.currentTimeMillis() - checkCooldownMap.getOrDefault(user.getId(), 0L) > 3000) {
                user = userService.getUser(user.getId());
                request.getSession().setAttribute("login", user);
                checkCooldownMap.put(user.getId(), System.currentTimeMillis());
            }
            if (user.getId() >= 0)
                return user;
        } catch (Exception ignored) {
        }
        return null;
    }

    @CrossOrigin
    @PostMapping("/changePassword")
    public boolean changePassword(@RequestBody Map<String, String> args, HttpServletRequest request) {

        if (request.getSession().getAttribute("login") == null) return false; //un-login

        User user = (User) request.getSession().getAttribute("login");

        try {
            String oldPassword = args.get("old");
            String newPassword = args.get("new");
            String checkPassword = args.get("check");
            if (!newPassword.equals(checkPassword)) return false;

            if (userService.findLoginUser(user.getUsername(), StringUtils.sha1(oldPassword)).getUsername().equalsIgnoreCase(user.getUsername())) {
                userService.changePassword(user.getId(), StringUtils.sha1(newPassword));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @CrossOrigin
    @GetMapping("/getUserGlobalData")
    public UserService.UserWrapper findUserGlobalData(@RequestParam("id") String id, HttpServletRequest request) {
        if (request.getSession().getAttribute("login") == null) return null;
        try {
            return userService.findUserGlobalData(Integer.parseInt(id));
        } catch (Exception ignore) {
        }
        return null;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
