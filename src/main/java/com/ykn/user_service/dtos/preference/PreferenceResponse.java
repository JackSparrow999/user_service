package com.ykn.user_service.dtos.preference;

import com.ykn.user_service.entities.preference.Preference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PreferenceResponse {

    boolean success = false;

    String message;

    public PreferenceResponse(Preference preference){
        this.success = true;
        this.message = "Preference saved successfully";
    }

}
