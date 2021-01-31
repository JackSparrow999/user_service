package com.ykn.user_service.entities.preference;
import com.ykn.user_service.dtos.preference.PreferenceRequest;
import com.ykn.user_service.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity(name = "preferences")
@ToString
public class Preference extends AbstractEntity {

    public static final String JSON_PREFERENCE_DATA = "com.ykn.user_service.hibernatecustommapper.preferencedatamapper.PreferenceDataJsonUserType";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column
    @Type(type = JSON_PREFERENCE_DATA)
    PreferenceData data;

    public Preference(PreferenceRequest preferenceRequest){
        this.id = preferenceRequest.getId();
        this.data = new PreferenceData(preferenceRequest.getFieldsOfInterest(),
                preferenceRequest.getSearchStrings());
    }

    public Preference(PreferenceData preferenceData){
        this.data = preferenceData;
    }

}
