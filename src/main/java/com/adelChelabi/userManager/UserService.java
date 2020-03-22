package com.adelChelabi.userManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUserById(int id){
       return userRepository.findById(id);
    }

    public void deleteUserById(int id){
         userRepository.deleteById(id);
    }
}
