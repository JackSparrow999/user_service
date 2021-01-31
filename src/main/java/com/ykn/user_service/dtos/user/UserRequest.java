package com.ykn.user_service.dtos.user;

import com.ykn.user_service.entities.user.UserData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserRequest {

    Long id;

    String name;

    String email;

    UserData data;

}
