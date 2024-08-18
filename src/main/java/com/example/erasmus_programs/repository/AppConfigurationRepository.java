package com.example.erasmus_programs.repository;

import com.example.erasmus_programs.entity.AppConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppConfigurationRepository extends JpaRepository<AppConfiguration,Long> {
}
