package com.ykn.user_service.controllers;

import com.ykn.user_service.dtos.notification.NotificationRequest;
import com.ykn.user_service.dtos.notification.NotificationResponse;
import com.ykn.user_service.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public NotificationResponse notify(
            @RequestBody NotificationRequest notificationRequest){
        return notificationService.executeNotificationRequest(notificationRequest, null, null);
    }

}
