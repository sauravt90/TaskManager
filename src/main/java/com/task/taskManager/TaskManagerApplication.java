package com.task.taskManager;

import com.task.taskManager.models.user.ApplicationUser;
import com.task.taskManager.models.user.Role;
import com.task.taskManager.repository.RoleRepository;
import com.task.taskManager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(RoleRepository roleRepository,
								 UserRepository userRepository,
								 PasswordEncoder passwordEncoder){


		return args -> {

			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;

            Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser applicationUser = new ApplicationUser(1,"admin",passwordEncoder.encode("password"),roles);
			userRepository.save(applicationUser);

		};
	}


}
