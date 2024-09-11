package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getUserById(@RequestParam long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }
    @GetMapping
    public ResponseEntity<?> listUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Пользователь создан");
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body("Пользователь изменен");
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Пользователь удален");
    }

}
