package com.ykn.user_service.services;

import com.ykn.user_service.dtos.tracker.TrackerRequest;
import com.ykn.user_service.dtos.tracker.TrackerResponse;
import com.ykn.user_service.dtos.user.UserRequest;
import com.ykn.user_service.dtos.user.UserResponse;
import com.ykn.user_service.entities.tracker.Tracker;
import com.ykn.user_service.entities.user.User;

import java.util.List;

public interface TrackerService {

    TrackerResponse saveTracker(TrackerRequest trackerRequest);

    List<Tracker> getAllTrackers();

    Tracker getTrackerById(Long id);

}
