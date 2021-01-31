package com.ykn.user_service.hibernatecustommapper.trackerdatamapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ykn.user_service.entities.tracker.TrackerData;
import com.ykn.user_service.entities.user.UserData;

import java.io.IOException;

public class TrackerDataJsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public static boolean isEquals(TrackerData a, TrackerData b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;

        //update when tracker data is stored
        return true;
    }

    public static String toJson(TrackerData pd) {
        try {
            return MAPPER.writeValueAsString(pd);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static TrackerData fromJson(String jsonString) {
        try {
            return MAPPER.readValue(jsonString, TrackerData.class);
        } catch (IOException e) {
            return null;
        }
    }

}
