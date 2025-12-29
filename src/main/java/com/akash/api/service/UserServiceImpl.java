package com.akash.api.service;

import com.akash.api.dto.UserDto;
import com.akash.api.entity.User;
import com.akash.api.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        User users = new User(user.getId(), user.getName(), user.getEmail(), user.getPassword());
        return userRepository.save(users);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            return userDto;
        }).toList();
    }

    @Override
    public UserDto findById(int id) {
//        return userRepository.findById(id).map(user ->{
//            UserDto userDto = new UserDto();
//            userDto.setId(user.getId());
//            userDto.setName(user.getName());
//            userDto.setEmail(user.getEmail());
//            return userDto;
//        }).orElse(null);
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserDto.class))
                .orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User putUser(int id, User user) {
        User Finduser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if(Finduser != null){
//            Finduser.setId(user.getId()); // primary key should not be changed
            Finduser.setName(user.getName());
            Finduser.setEmail(user.getEmail());
            return userRepository.save(Finduser);
        }
        return null;
    }

    @Override
    public UserDto patchUser(int id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if(userDto.getEmail() != null){
            user.setEmail(userDto.getEmail());
        }
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDto.class);

    }
}
