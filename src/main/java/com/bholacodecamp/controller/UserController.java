package com.bholacodecamp.controller;

import com.bholacodecamp.entity.User;
import com.bholacodecamp.qrcode.QRCodeGenerator;
import com.bholacodecamp.service.UserService;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() throws IOException, WriterException {
        List<User> users = userService.getUsers();
         if (users.size() != 0) {
             for (User user: users) {
                 QRCodeGenerator.generateQRCode(user);
             }
         }
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User findByUserId(@PathVariable Long id) {
        return userService.findById(id);
    }
}
