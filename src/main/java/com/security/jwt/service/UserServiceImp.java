/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.jwt.service;

import com.security.jwt.model.Role;
import com.security.jwt.model.User;
import com.security.jwt.repository.RoleRepository;
import com.security.jwt.repository.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tim
 */
@Service
@Transactional
@Slf4j
public class UserServiceImp implements UserService, UserDetailsService {
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder=passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null){
            log.info("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        log.info("User found in the database: {}",username);
        
        Collection<SimpleGrantedAuthority> autorities = new ArrayList<>();
        user.getRoles().forEach(role->autorities.add(new SimpleGrantedAuthority(role.getName() )));
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),autorities);
    }
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to database",user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {}",role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}",roleName, username);
        Role role=roleRepository.findByName(roleName);
        User user=userRepository.findByUsername(username);
        user.getRoles().add(role);
        
        //userRepository.save(user);
        
    }

    @Override
    public List<User> getUsers() {
        log.info("Getting all users");
        return userRepository.findAll();
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    
    
}
