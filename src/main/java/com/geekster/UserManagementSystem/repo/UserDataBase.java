package com.geekster.UserManagementSystem.repo;

import com.geekster.UserManagementSystem.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDataBase {
//    To store data we are using ArrayList

    List<User> userList = new ArrayList<>();
    public String save(User user) {
        userList.add(user);
        return "Added Successfully!!";
    }

    public List<User> getUsers() {
        return userList;
    }

    public Boolean removeUserById(User user) {
        userList.remove(user);
        return true;
    }

    public Boolean updateUserById(String userid, User user) {
        for ( User userObj : userList ) {
            if ( userObj.getUserId().equals(userid) ) {
                userObj.setUserName(user.getUserName());
                userObj.setAddress(user.getAddress());
                userObj.setPhoneNumber(user.getPhoneNumber());
                return true;
            }
        }
        return false;
    }




}
