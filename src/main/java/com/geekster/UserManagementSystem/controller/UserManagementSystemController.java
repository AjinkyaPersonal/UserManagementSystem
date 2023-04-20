package com.geekster.UserManagementSystem.controller;

import com.geekster.UserManagementSystem.model.User;
import com.geekster.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserManagementSystemController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "getUser/{userid}")
    public User getUser(@PathVariable String userid) {
        return userService.getUserById(userid);
    }

    @PutMapping(value = "/updateUserInfo/{userid}")
    public String updateUserInfo(@PathVariable String userid, @RequestBody User user) {
        return userService.updateUser(userid, user);
    }

    @DeleteMapping(value = "/deleteUser/{userid}")
    public String deleteUser(@PathVariable String userid) {
        return userService.deleteUserById(userid);
    }

}
