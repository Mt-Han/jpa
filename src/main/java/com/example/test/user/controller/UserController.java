package com.example.test.user.controller;

import com.example.test.user.model.UserService;
import com.example.test.user.model.req.UserRequest;
import com.example.test.user.model.res.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> get(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<UserResponse> findByUserId(
            @PathVariable("userId") String userId
    ){
        return ResponseEntity.ok(userService.findByUserId(userId));
    }

    @GetMapping("/findage")
    public ResponseEntity<List<UserResponse>> findByAge(
            UserRequest request
    ){
        return ResponseEntity.ok(userService.findByAge(request));
    }

    @PostMapping("/")
    public ResponseEntity<UserResponse> post(
            @RequestBody UserRequest request
            ){
        return ResponseEntity.ok(userService.insertUser(request));
    }

    @PutMapping("/")
    public ResponseEntity<UserResponse> put(
            @RequestBody UserRequest request
    ){
        return ResponseEntity.ok(userService.updateUser(request));
    }

    @DeleteMapping("/")
    public ResponseEntity<String> delete(
            @RequestBody UserRequest request
    ){
        return ResponseEntity.ok(userService.deleteUser(request));
    }
}
