package com.ykn.user_service.services;

import com.ykn.user_service.dtos.notification.NotificationRequest;
import com.ykn.user_service.dtos.notification.NotificationResponse;

public interface NotificationService {

    NotificationResponse executeNotificationRequest(NotificationRequest notificationRequest, Object trackerId, Object userId);

}
