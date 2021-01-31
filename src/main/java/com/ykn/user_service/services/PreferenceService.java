package com.ykn.user_service.services;

import com.ykn.user_service.dtos.preference.PreferenceRequest;
import com.ykn.user_service.dtos.preference.PreferenceResponse;
import com.ykn.user_service.entities.preference.Preference;

import java.util.List;

public interface PreferenceService{

    PreferenceResponse savePreference(PreferenceRequest preferenceRequest);

    List<Preference> getAllPreferences();

    PreferenceResponse savePreferenceUsingTracker(PreferenceRequest preferenceRequest);

    PreferenceResponse savePreferenceUsingUser(PreferenceRequest preferenceRequest);

    Preference getPreferenceById(Long id);

}
