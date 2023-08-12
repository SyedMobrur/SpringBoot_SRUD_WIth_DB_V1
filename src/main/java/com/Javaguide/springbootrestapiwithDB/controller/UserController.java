package com.Javaguide.springbootrestapiwithDB.controller;

import com.Javaguide.springbootrestapiwithDB.entity.User;
import com.Javaguide.springbootrestapiwithDB.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser= userService.createUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll()
    {
        List<User> users= userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping("/getBy/{id}")

    public ResponseEntity<Optional<User>> getById(@PathVariable("id") String user_Id)
    {
        return new ResponseEntity<>(userService.getById(user_Id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<User>> updateById(@PathVariable("id") String ID,  @RequestBody User user)
    {

        return new ResponseEntity<>(userService.updateById(user , ID), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String ID)
    {
        boolean result= userService.deleteById(ID);
        if(result)
            return "Deleted Successfully";
        else
            return "Opps Failed";
    }
}
