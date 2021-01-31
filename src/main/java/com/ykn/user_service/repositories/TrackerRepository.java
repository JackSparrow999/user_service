package com.ykn.user_service.repositories;

import com.ykn.user_service.entities.tracker.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerRepository extends JpaRepository<Tracker, Long> {



}
