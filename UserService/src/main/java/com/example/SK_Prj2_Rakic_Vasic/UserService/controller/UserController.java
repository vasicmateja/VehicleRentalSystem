package com.example.SK_Prj2_Rakic_Vasic.UserService.controller;

import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.security.CheckSecurity;
import com.example.SK_Prj2_Rakic_Vasic.UserService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findById/{id}")
   // @CheckSecurity(roles = {"ROLE_USER","USER_ADMIN"})
    public ResponseEntity<UserDto> findById(@RequestHeader("authorization") String authorization,@PathVariable ("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
  //  @CheckSecurity(roles = {"ROLE_USER","USER_ADMIN"})
    public ResponseEntity<List<UserDto>> findAll(@RequestHeader("authorization") String authorization) {
        System.out.println(userService.findAll());
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @CheckSecurity(roles = {"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<UserDto> add(@RequestHeader("authorization") String authorization, @RequestBody UserCreateDto userCreateDto){
        return new ResponseEntity<>(userService.add(userCreateDto), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    @CheckSecurity(roles = {"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<Boolean> delete(@RequestHeader("authorization") String authorization, @PathVariable Long id){
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    @CheckSecurity(roles = {"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<UserDto> update(@RequestHeader("authorization") String authorization, @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.update(userDto), HttpStatus.OK);
    }






}
