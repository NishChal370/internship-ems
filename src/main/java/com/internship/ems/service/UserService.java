package com.internship.ems.service;

import com.internship.ems.dao.UserRepository;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User save(User user){
        return userRepo.save(user);
    }

    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User updateUser(Long id, User newUser) {
        User user = userRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        userRepo.save(user);
        return user;
    }

    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        userRepo.findAll().forEach(result::add);
        return result;
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
