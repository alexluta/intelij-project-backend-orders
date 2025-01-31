package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Order;
import com.example.Hospital.entity.User;
import com.example.Hospital.repository.OrderRepository;
import com.example.Hospital.repository.UserRepository;
import com.example.Hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return userOptional.orElseThrow(()-> new RuntimeException("No such User"));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new RuntimeException("No such Medic");
        }else {
            User user1 = userOptional.get();
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            userRepository.save(user1);
        }
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new RuntimeException("No such User");
        }
        userRepository.deleteById(id);
    }
}
