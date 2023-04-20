package com.geekster.UserManagementSystem.service;

import com.geekster.UserManagementSystem.model.User;
import com.geekster.UserManagementSystem.repo.UserDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDataBase userDataBase;


    public String addNewUser(User user) {
        return userDataBase.save(user);
    }

    public List<User> getAllUsers() {
        return userDataBase.getUsers();
    }

    public User getUserById(String userid) {
        List<User> helperList = getAllUsers();
        for ( User user : helperList ) {
            if ( user.getUserId().equals(userid) ) {
                return user;
            }
        }
        return null;
    }

    public String deleteUserById(String userid) {
        List<User> helperList = getAllUsers();
        Boolean status = false;

        for ( User user : helperList ) {
            if ( user.getUserId().equals(userid) ) {
                status = userDataBase.removeUserById(user);
                if ( status ) {
                    return "User " + userid + " removed from database successfully!!!";
                }
                else {
                    return "User " + userid + " cannot be removed from database (Database error)!!!";
                }
            }
        }
        return "User " + userid + " Not Found!!!";
    }

    public String updateUser(String userid, User user ) {
        boolean updateStatus =  userDataBase.updateUserById(userid,user);

        if(updateStatus)
        {
            return "User: " + userid + " was updated!!!";
        }
        else
        {
            return "User: " + userid + " does not exist!!!";
        }
    }


}
