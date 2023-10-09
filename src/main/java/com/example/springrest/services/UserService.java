package com.example.springrest.services;

import com.example.springrest.models.User;
import com.example.springrest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional()
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void updateUserById(long id, User updateUser) {
        User user = this.getUser(id);
        user.setLogin(updateUser.getLogin());
        user.setAge(updateUser.getAge());
        user.setFirstname(updateUser.getFirstname());
        user.setLastname(updateUser.getLastname());
        user.setPassword(updateUser.getPassword());
        user.setRoles(updateUser.getRoles());
        userRepository.save(user);
    }

    public User getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
        return  user;
    }

    public List<User> listAllUser() {
        List<User> users = userRepository.findAll();
        System.out.println(users);
        return users;
    }
}