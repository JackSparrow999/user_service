package com.ykn.user_service.entities.user;

import com.ykn.user_service.dtos.user.UserRequest;
import com.ykn.user_service.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity(name = "users")
public class User extends AbstractEntity {

    public static final String JSON_USER_DATA = "com.ykn.user_service.hibernatecustommapper.userdatamapper.UserDataJsonUserType";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "prefer_id")
    Long preferId;

    @Column
    String name;

    @Column
    String email;

    @Column
    @Type(type = JSON_USER_DATA)
    UserData data;

    public User(UserRequest userRequest){
        this.name = userRequest.getName();
        this.email = userRequest.getEmail();
        this.data = userRequest.getData();
    }

}
