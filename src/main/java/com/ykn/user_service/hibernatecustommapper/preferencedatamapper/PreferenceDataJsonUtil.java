package com.ykn.user_service.hibernatecustommapper.preferencedatamapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ykn.user_service.entities.preference.PreferenceData;
import com.ykn.user_service.utils.ObjectUtils;

import java.io.IOException;

public class PreferenceDataJsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public static boolean isEquals(PreferenceData a, PreferenceData b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        return ObjectUtils.isEqualList(a.getFieldsOfInterest(), b.getFieldsOfInterest())
                && ObjectUtils.isEqualList(a.getSearchStrings(), b.getSearchStrings());
    }

    public static String toJson(PreferenceData pd) {
        try {
            return MAPPER.writeValueAsString(pd);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static PreferenceData fromJson(String jsonString) {
        try {
            return MAPPER.readValue(jsonString, PreferenceData.class);
        } catch (IOException e) {
            return null;
        }
    }

}
