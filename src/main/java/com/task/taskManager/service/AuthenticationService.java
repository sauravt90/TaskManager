package com.task.taskManager.service;

import com.task.taskManager.models.user.ApplicationUser;
import com.task.taskManager.models.user.LoginResponseDTO;
import com.task.taskManager.models.user.Role;
import com.task.taskManager.repository.RoleRepository;
import com.task.taskManager.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    private final UserRepository userRepository;

    public final RoleRepository roleRepository;


    public final PasswordEncoder passwordEncoder;

    public final AuthenticationManager authenticationManager;

    public final TokenService tokenService;


    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public ApplicationUser registerUser(String userName,String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(0,userName,encodedPassword ,authorities));
    }

    public LoginResponseDTO loginUser(String userName,
                                      String password){


        try{

            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userName,password)
            );


            String token = tokenService.generateJWT(auth);

            return new LoginResponseDTO(userRepository.findByUserName(userName).get(),token);


        }catch (AuthenticationException e){
            return new LoginResponseDTO(null,"");
        }

    }










}
