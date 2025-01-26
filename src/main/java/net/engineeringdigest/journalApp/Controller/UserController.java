package net.engineeringdigest.journalApp.Controller;


import net.engineeringdigest.journalApp.Reposetry.UserRep;
import net.engineeringdigest.journalApp.Service.UserService;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


        @Autowired
    private UserService userService;
        @GetMapping
    public List<User>getAllUser(){
            return userService.getAll();
        }
        @PostMapping
    public  void createUser(@RequestBody User user){
            userService.saveNewUser(user);
        }

@Autowired
private UserRep userRepository;
    @PutMapping
    public ResponseEntity<?> updateuser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDb = userService.findByUsername(username);
        if (userInDb != null) {
            // Update user details
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);

            return ResponseEntity.ok("User updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User not found.");
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUsername(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

