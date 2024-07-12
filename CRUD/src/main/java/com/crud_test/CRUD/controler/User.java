package com.crud_test.CRUD.controler;

import com.crud_test.CRUD.dto.UserDTO;
import com.crud_test.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class User {

    @Autowired
    private UserService userService;

//SHOW
    @GetMapping("/getUser")
    public List<UserDTO> getUser() {
        return  userService.getAllUsers();
    }
//ADD USER
    @PostMapping("/addUser")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
//UPDATE
    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {return userService.updateUser(userDTO);}

    //DELETE
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody UserDTO userDTO){return userService.deleteUser(userDTO);}

}
