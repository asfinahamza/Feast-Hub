package com.feasthub.feasthub.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.feasthub.feasthub.repository.UserRepository;
import com.feasthub.feasthub.entity.User;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email){
       List<User> userlist = getAllUsers();
       List<User> userWanted = userlist.stream()
       .filter(usr -> usr.getemail().equalsIgnoreCase(email))
       .collect(Collectors.toList());
       return (userWanted.size()>0)?userWanted.get(0): null;
    }
}