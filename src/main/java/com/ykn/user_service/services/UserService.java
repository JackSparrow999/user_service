package com.ykn.user_service.services;

import com.ykn.user_service.dtos.user.UserRequest;
import com.ykn.user_service.dtos.user.UserResponse;
import com.ykn.user_service.entities.user.User;

import java.util.List;

public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    List<User> getAllUsers();

    User getUserById(Long id);

}
