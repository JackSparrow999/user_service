package com.ykn.user_service.dtos.tracker;

import com.ykn.user_service.entities.tracker.Tracker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TrackerResponse {

    Long id;

    boolean success = false;

    String message;

    public TrackerResponse(Tracker tracker){
        if(tracker.getId() != null){
            this.success = true;
            this.message = "Tracker saved successfully";
        }
        else{
            this.success = false;
            this.message = "Tracker service failed!";
        }
        this.id = tracker.getId();
    }

}
