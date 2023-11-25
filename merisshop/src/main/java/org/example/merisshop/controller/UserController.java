package org.example.merisshop.controller;

import org.example.merisshop.model.User;
import org.example.merisshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
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
}
