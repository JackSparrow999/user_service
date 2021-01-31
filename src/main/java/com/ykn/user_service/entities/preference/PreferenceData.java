package com.ykn.user_service.entities.preference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class PreferenceData{

    List<String> fieldsOfInterest;

    List<String> searchStrings;

    public PreferenceData(PreferenceData pd){
        List<String> fi = new ArrayList<>();
        List<String> ss = new ArrayList<>();

        if(pd.fieldsOfInterest != null)
            for(String s: pd.fieldsOfInterest)
                fi.add(new String(s));

        if(pd.searchStrings != null)
            for(String s: pd.searchStrings)
                ss.add(new String(s));

        this.fieldsOfInterest = fi;
        this.searchStrings = ss;
    }

}
