package com.hutech.ngay3c5.Services;

import com.hutech.ngay3c5.Entities.Student;
import com.hutech.ngay3c5.Entities.User;
import com.hutech.ngay3c5.Repositories.UserRepository;
import com.hutech.ngay3c5.RequestEntities.RequestCreateStudent;
import com.hutech.ngay3c5.RequestEntities.RequestCreateUser;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateStudent;
import com.hutech.ngay3c5.RequestEntities.RequestUpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    public User CreateUser(RequestCreateUser requestCreateUser){
        try {
            User user = new User();
            user.setFirstname(requestCreateUser.getFirstname());
            user.setLastname(requestCreateUser.getLastname());
            user.setEmail(requestCreateUser.getEmail());
            user.setPassword(requestCreateUser.getPassword());
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        );
    }
    public User updateUser(String id, RequestUpdateUser requestUpdateUser){
        try {
            User user = getUserById(id);
            user.setFirstname(requestUpdateUser.getFirstname());
            user.setLastname(requestUpdateUser.getLastname());
            user.setEmail(requestUpdateUser.getEmail());
            user.setPassword(requestUpdateUser.getPassword());
            return userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
