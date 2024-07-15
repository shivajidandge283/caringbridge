package com.db.hackathon.dementia.dabbler.caringbridge.service;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.User;
import com.db.hackathon.dementia.dabbler.caringbridge.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public boolean checkIfEmailAlreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        }catch (Exception exception) {
            log.error("Exception occurred while saving User ", exception.getCause());
        }
        return null;
    }

    public boolean findByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return null != user ? true : false;
    }

    public User updateUser(User user) {
        if(null != user.getId()) {
            return userRepository.save(user);
        }
        return null;
    }
}
