package com.yfunes.bookordersapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


    @Bean("customerModelMapper")
    public ModelMapper customerModelMapper(){
        return new ModelMapper();
    }

    @Bean("bookModelMapper")
    public ModelMapper bookModelMapper(){
        return new ModelMapper();
    }

}
