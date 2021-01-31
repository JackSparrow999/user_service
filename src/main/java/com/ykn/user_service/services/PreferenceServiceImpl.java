package com.ykn.user_service.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ykn.user_service.dtos.preference.PreferenceRequest;
import com.ykn.user_service.dtos.preference.PreferenceResponse;
import com.ykn.user_service.entities.preference.Preference;
import com.ykn.user_service.entities.preference.PreferenceData;
import com.ykn.user_service.entities.tracker.Tracker;
import com.ykn.user_service.entities.user.User;
import com.ykn.user_service.exceptions.AppException;
import com.ykn.user_service.repositories.PreferenceRepository;
import com.ykn.user_service.repositories.TrackerRepository;
import com.ykn.user_service.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService{

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private TrackerRepository trackerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public PreferenceResponse savePreference(PreferenceRequest preferenceRequest) {

        Preference preference = new Preference(preferenceRequest);

        if(preferenceRequest.getId() != null){
            preference = preferenceRepository.findById(preferenceRequest.getId()).orElseGet(() -> null);
            BeanUtils.copyProperties(preferenceRequest, preference);
        }

        preferenceRepository.save(preference);

        return new PreferenceResponse(true, "Preference saved successfully");
    }

    @Override
    public List<Preference> getAllPreferences() {
        return preferenceRepository.findAll();
    }

    @Override
    public PreferenceResponse savePreferenceUsingTracker(PreferenceRequest preferenceRequest) {
        Tracker tracker = trackerRepository.findById(preferenceRequest.getTrackerId()).orElseGet(() -> null);

        if(tracker == null)
            throw new AppException(String.format("Tracker with id: {} doesn't exist", preferenceRequest.getTrackerId()));

        Preference preference = preferenceRepository.save(new Preference(preferenceRequest));

        tracker.setPreferId(preference.getId());

        trackerRepository.save(tracker);

        return new PreferenceResponse(preference);
    }

    @Override
    public PreferenceResponse savePreferenceUsingUser(PreferenceRequest preferenceRequest) {
        User user = userRepository.findById(preferenceRequest.getUserId()).orElseGet(() -> null);

        if(user == null)
            throw new AppException(String.format("User with id: {} doesn't exist", preferenceRequest.getUserId()));

        Preference preference = preferenceRepository.save(new Preference(preferenceRequest));

        user.setPreferId(preference.getId());

        userRepository.save(user);

        return new PreferenceResponse(preference);
    }

    @Override
    public Preference getPreferenceById(Long id) {
        return preferenceRepository.findById(id).orElseGet(() -> null);
    }
}
