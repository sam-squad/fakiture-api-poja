package com.samsquad.fakitureapi.endpoint.rest.controller.model;

import com.samsquad.fakitureapi.repository.model.User;
import com.samsquad.fakitureapi.service.event.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        User addedUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedUser).getBody();
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userNumber}")
    public User getUserById(@PathVariable Integer userNumber) throws ChangeSetPersister.NotFoundException {
        return userService.getUserByUserNumber(userNumber);
    }
    @PutMapping("/user/{userNumber}")
    public User updateUser(@PathVariable Integer userNumber,@RequestParam String userName) throws ChangeSetPersister.NotFoundException {
        return userService.updateUser(userNumber,userName);
    }
    @DeleteMapping("/user/{userNumber}")
    public void deleteUser(@PathVariable Integer userNumber){
        userService.deleteUserByUserNumber(userNumber);
    }

}

