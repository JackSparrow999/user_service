package com.ykn.user_service.services;

import com.ykn.user_service.client.ArticlesServiceClient;
import com.ykn.user_service.dtos.article.SearchRequest;
import com.ykn.user_service.dtos.article.SearchResponse;
import com.ykn.user_service.dtos.notification.NotificationRequest;
import com.ykn.user_service.dtos.notification.NotificationResponse;
import com.ykn.user_service.dtos.preference.PreferenceRequest;
import com.ykn.user_service.entities.preference.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    PreferenceService preferenceService;

    @Autowired
    TrackerService trackerService;

    @Autowired
    UserService userService;

    @Autowired
    ArticlesServiceClient articlesServiceClient;

    @Override
    public NotificationResponse executeNotificationRequest(NotificationRequest notificationRequest, Object trackerId, Object userId) {
        Preference preference = null;
        if(notificationRequest.getPreferenceId() != null)
            preference = preferenceService.getPreferenceById(notificationRequest.getPreferenceId());
        else{
            PreferenceRequest preferenceRequest = new PreferenceRequest();
            preferenceService.savePreference(new PreferenceRequest());
        }

        SearchResponse searchResponse = articlesServiceClient.search(new SearchRequest(notificationRequest));

        return new NotificationResponse(searchResponse);
    }
}
