package com.mapping.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.practice.Entities.UserSettings;
//Repository interface for UserSettings
@Repository
public interface UserSettingsRepository extends JpaRepository<UserSettings, Long>{
    
}
