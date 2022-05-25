package com.latihanDaerah.latihanDaerah.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaerahConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
