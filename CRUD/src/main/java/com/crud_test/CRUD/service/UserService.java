package com.crud_test.CRUD.service;

import com.crud_test.CRUD.dto.UserDTO;
import com.crud_test.CRUD.model.User;
import com.crud_test.CRUD.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO saveUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }
    public UserDTO updateUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }
    public String deleteUser(UserDTO userDTO) {
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return "user Deleted";
    }
}
