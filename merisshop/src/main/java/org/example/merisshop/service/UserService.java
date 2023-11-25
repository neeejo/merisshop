package org.example.merisshop.service;

import org.example.merisshop.model.User;
import org.example.merisshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User read(Long id) {return userRepository.findById(id).orElseThrow(()->new RuntimeException("erorre read user"));}

    public User insert(User user) {return userRepository.save(user);}

    public User update(User user) {return userRepository.save(user);}

    public void delete(Long id) {userRepository.deleteById(id);}
}
