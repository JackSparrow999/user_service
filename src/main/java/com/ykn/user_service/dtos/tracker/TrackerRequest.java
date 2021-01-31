package com.ykn.user_service.dtos.tracker;

import com.ykn.user_service.entities.tracker.TrackerData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TrackerRequest {

    Long id;

    String name = "Guy";

    String email = "behuraronaq1999@gmail.com";

    TrackerData data = new TrackerData();

}
