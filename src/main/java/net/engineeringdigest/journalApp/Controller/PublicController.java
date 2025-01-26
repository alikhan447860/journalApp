package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Service.UserService;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;
    @GetMapping("/health-check")
public String healthcheck(){
    return  "ok";
}
@PostMapping("/createuser")
    public  void createUser(@RequestBody User user){
    userService.saveNewUser(user);
}
}
