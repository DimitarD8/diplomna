package com.example.erasmus_programs.utils;

import com.example.erasmus_programs.entity.*;
import com.example.erasmus_programs.repository.AppConfigurationRepository;
import com.example.erasmus_programs.service.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final DoctoralMobilityService doctoralMobilityService;
    private final AppConfigurationRepository appConfigurationRepository;

    @Override
    public void run(String... args) throws Exception {
        AppConfiguration appConfiguration = appConfigurationRepository.findById(1L).orElse(new AppConfiguration());
        if (!appConfiguration.isDatabaseInitialized()) {
            populateDatabase();
            appConfiguration.setDatabaseInitialized(true);
            appConfigurationRepository.save(appConfiguration);
        }
    }

    private void populateDatabase() {

        DoctoralMobility doctoralMobility = new DoctoralMobility();
        doctoralMobility.setDescription("some description");

        doctoralMobilityService.createDoctoralMobility(doctoralMobility);

    }
}
