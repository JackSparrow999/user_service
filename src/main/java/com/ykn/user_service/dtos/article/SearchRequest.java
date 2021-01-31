package com.ykn.user_service.dtos.article;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ykn.user_service.dtos.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SearchRequest {

    String query;

    Long offset;

    String trackerId;

    String userId;

    String name;

    String email;

    //like knowledge
    String fieldType;

    //like learning
    String fieldAction;

    Long sendAfterDate = Instant.now().toEpochMilli();

    public SearchRequest(NotificationRequest notificationRequest){
        this.query = notificationRequest.getQuery();
        this.offset = notificationRequest.getOffset();
        this.name = notificationRequest.getName();
        this.email = notificationRequest.getEmail();
        this.fieldType = "knowledge";
        this.fieldAction = "learning";
        this.sendAfterDate = Instant.now().toEpochMilli();
    }

}