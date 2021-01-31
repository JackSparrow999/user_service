package com.ykn.user_service.dtos.preference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PreferenceRequest {

    Long id;

    Long trackerId;

    Long userId;

    List<String> fieldsOfInterest = new ArrayList<>();

    List<String> searchStrings = new ArrayList<>();

}
