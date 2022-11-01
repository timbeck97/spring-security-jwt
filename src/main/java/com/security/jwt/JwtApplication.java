package com.security.jwt;

import com.security.jwt.model.Role;
import com.security.jwt.model.User;
import com.security.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ServletComponentScan // para usar webservlet precisa dessa annotation
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}
        
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
        
        @Bean
        CommandLineRunner run(UserService service){
            return args ->{
            
//            service.saveRole(new Role("ROLE_USER"));
//            service.saveRole(new Role("ROLE_MANAGER"));
//            service.saveRole(new Role("ROLE_ADMIN"));
//            service.saveRole(new Role("ROLE_SUPER_ADMIN"));
//            
//            service.saveUser(new User("John Travolta", "john", "1234"));
//            service.saveUser(new User("Will Smith", "will", "1234"));
//            service.saveUser(new User("Jim Carry", "jim", "1234"));
//            service.saveUser(new User("Arnold Schwarzenegger", "arnold", "1234"));
//            
//            service.addRoleToUser("john", "ROLE_USER");
//             service.addRoleToUser("john", "ROLE_MANAGER");
//            service.addRoleToUser("will", "ROLE_MANAGER");
//            service.addRoleToUser("jim", "ROLE_ADMIN");
//            service.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
//            service.addRoleToUser("arnold", "ROLE_ADMIN");
//            service.addRoleToUser("arnold", "ROLE_USER");
            
            
        };
        }
}
