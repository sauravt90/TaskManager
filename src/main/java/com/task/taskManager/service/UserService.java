package com.task.taskManager.service;


import com.task.taskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("we are in the userDetails service");

//        if (!username.equals("Ethan")){
//                   throw new UsernameNotFoundException("Not Ethan");
//        }
//
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1,"USER"));
//
//        return new ApplicationUser(1,"Ethan", passwordEncoder.encode("password"),roles );

        return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));

    }
}
