package com.ykn.user_service.dtos.notification;

import com.ykn.user_service.dtos.article.SearchResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class NotificationResponse {

    Boolean success = true;

    public NotificationResponse(SearchResponse searchResponse){
        this.success = searchResponse.getSuccess();
    }

}
