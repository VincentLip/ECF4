package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("")
    public ResponseEntity<User> post(@RequestParam String name, @RequestParam String email) {
        User user = userService.createUser(name, email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> get(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}
