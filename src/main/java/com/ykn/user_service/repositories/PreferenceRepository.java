package com.ykn.user_service.repositories;

import com.ykn.user_service.entities.preference.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
