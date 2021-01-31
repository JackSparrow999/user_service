package com.ykn.user_service.entities.tracker;

import com.ykn.user_service.dtos.tracker.TrackerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity(name = "trackers")
public class Tracker {

    public static final String JSON_USER_DATA = "com.ykn.user_service.hibernatecustommapper.trackerdatamapper.TrackerDataJsonUserType";

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
    TrackerData data;

    public Tracker(TrackerRequest trackerRequest){
        this.name = trackerRequest.getName();
        this.email = trackerRequest.getEmail();
        this.data = trackerRequest.getData();
    }

}
