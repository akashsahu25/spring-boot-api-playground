package com.akash.api.controller;


import com.akash.api.dto.UserDto;
import com.akash.api.entity.User;
import com.akash.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    // READ ALL
    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
    // READ BY ID
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable int id){
        return userService.findById(id);
    }
    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    // FULL UPDATE (PUT)
    @PutMapping("/{id}")
    public User putUser(
            @PathVariable int id,
            @RequestBody User user) {
        return userService.putUser(id, user);
    }

    // UPDATE (PATCH)
    @PatchMapping("/{id}")
    public UserDto patchUser(
            @PathVariable int id,
            @RequestBody UserDto userDto) {
        return userService.patchUser(id, userDto);
    }
}
