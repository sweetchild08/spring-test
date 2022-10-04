package com.example2.motor2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example2.motor2.Model.User;
import com.example2.motor2.Repo.UserRepository;

@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/user")
    public String addUser(User user){
        userRepo.save(user);
        return "Saved..";
    }
    
    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable long id,User user){
        User updatedUser=userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        userRepo.save(updatedUser);
        return "updated..";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable long id){
        User user=userRepo.findById(id).get();
        userRepo.delete(user);
        return "deleted..";
    }
}
