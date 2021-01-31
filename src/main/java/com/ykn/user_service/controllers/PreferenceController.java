package com.ykn.user_service.controllers;

import com.ykn.user_service.dtos.preference.PreferenceRequest;
import com.ykn.user_service.dtos.preference.PreferenceResponse;
import com.ykn.user_service.entities.preference.Preference;
import com.ykn.user_service.services.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preference")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @PostMapping("/save")
    public PreferenceResponse savePreference(@RequestBody PreferenceRequest preferenceRequest){
        return preferenceService.savePreference(preferenceRequest);
    }

    @GetMapping("/all")
    public List<Preference> getAllPreferences(){
        return preferenceService.getAllPreferences();
    }

    @GetMapping("/get")
    public Preference getPreferenceById(@RequestParam Long id){
        return preferenceService.getPreferenceById(id);
    }

    @PostMapping("/tracker/save")
    public PreferenceResponse savePreferenceUsingTracker(@RequestBody PreferenceRequest preferenceRequest){
        return preferenceService.savePreferenceUsingTracker(preferenceRequest);
    }

    @PostMapping("/user/save")
    public PreferenceResponse savePreferenceUsingUser(@RequestBody PreferenceRequest preferenceRequest){
        return preferenceService.savePreferenceUsingUser(preferenceRequest);
    }

}
