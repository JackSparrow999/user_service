package com.ykn.user_service.dtos.user;

import com.ykn.user_service.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserResponse {

    boolean success = false;

    String message;

    public UserResponse(User user){
        if(user.getId() != null){
            this.success = true;
            this.message = "User saved successfully";
        }
        else{
            this.success = false;
            this.message = "User service failed!";
        }
    }

}
