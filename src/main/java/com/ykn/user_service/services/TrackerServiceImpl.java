package com.ykn.user_service.services;

import com.ykn.user_service.dtos.tracker.TrackerRequest;
import com.ykn.user_service.dtos.tracker.TrackerResponse;
import com.ykn.user_service.entities.tracker.Tracker;
import com.ykn.user_service.repositories.TrackerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackerServiceImpl implements TrackerService {

    @Autowired
    private TrackerRepository trackerRepository;

    @Override
    public TrackerResponse saveTracker(TrackerRequest trackerRequest) {

        Tracker tracker = new Tracker(trackerRequest);

        if(trackerRequest.getId() != null){
            BeanUtils.copyProperties(trackerRequest, tracker);
        }

        return new TrackerResponse(trackerRepository.save(tracker));
    }

    @Override
    public List<Tracker> getAllTrackers() {
        return trackerRepository.findAll();
    }

    @Override
    public Tracker getTrackerById(Long id) {
        return getTrackerById(id);
    }
}
