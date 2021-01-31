package com.ykn.user_service.controllers;

import com.ykn.user_service.dtos.tracker.TrackerRequest;
import com.ykn.user_service.dtos.tracker.TrackerResponse;
import com.ykn.user_service.entities.tracker.Tracker;
import com.ykn.user_service.services.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracker")
public class TrackerController {

    @Autowired
    private TrackerService trackerService;

    @PostMapping("/save")
    public TrackerResponse saveTracker(@RequestBody TrackerRequest trackerRequest){
        return trackerService.saveTracker(trackerRequest);
    }

    @GetMapping("/all")
    public List<Tracker> getAllTrackers(){
        return trackerService.getAllTrackers();
    }

    @GetMapping("/get")
    public Tracker getTrackerById(@RequestParam Long id){
        return trackerService.getTrackerById(id);
    }

}
