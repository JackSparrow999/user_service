package com.ykn.user_service.dtos.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class NotificationRequest {

    Long trackerId;

    Long userId;

    Long preferenceId;

    String name;

    String email;

    String query;

    Boolean trigger;

    Long offset;

}
