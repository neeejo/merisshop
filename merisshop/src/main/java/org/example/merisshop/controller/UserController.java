package org.example.merisshop.controller;

import org.example.merisshop.model.User;
import org.example.merisshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/read")
    public User read(@RequestParam Long id) {return userService.read(id);}
    @PostMapping(value = "/insert")
    public User insert(@RequestBody User user) {return userService.insert(user);}
    @PutMapping(value = "/update")
    public User update(@RequestBody User user) {return userService.update(user);}
    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam Long id) {userService.delete(id);}
    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()), HttpStatus.OK);
    }
}
