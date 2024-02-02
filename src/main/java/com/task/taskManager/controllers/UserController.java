package com.task.taskManager.controllers;


import com.task.taskManager.models.user.ApplicationUser;
import com.task.taskManager.models.user.LoginResponseDTO;
import com.task.taskManager.models.user.RegistrationDTO;
import com.task.taskManager.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {

    public final AuthenticationService authenticationService;

    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/test")
    public String getTest(){
        return "<h1>hello</h1>";
    }

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO ){
        return authenticationService.registerUser(registrationDTO.getUserName(),registrationDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody RegistrationDTO registrationDTO){
        return authenticationService.loginUser(registrationDTO.getUserName(),registrationDTO.getPassword());
    }




}
