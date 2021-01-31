package com.ykn.user_service.services;

import com.ykn.user_service.dtos.user.UserRequest;
import com.ykn.user_service.dtos.user.UserResponse;
import com.ykn.user_service.entities.user.User;
import com.ykn.user_service.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {

        User user = new User(userRequest);

        if(userRequest.getId() != null){
            user = userRepository.findById(userRequest.getId()).orElseGet(() -> null);
            BeanUtils.copyProperties(userRequest, user);
        }

        return new UserResponse(userRepository.save(user));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseGet(() -> null);
    }
}
