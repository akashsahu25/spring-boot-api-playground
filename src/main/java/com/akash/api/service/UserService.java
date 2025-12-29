package com.akash.api.service;

import com.akash.api.dto.UserDto;
import com.akash.api.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);
    public List<UserDto> getAllUsers();
    public UserDto findById(int id);
    public void deleteUser(int id);
    User putUser(int id, User user);

    UserDto patchUser(int id, UserDto userDto);
}
