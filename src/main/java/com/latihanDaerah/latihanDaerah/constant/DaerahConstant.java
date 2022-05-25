package com.latihanDaerah.latihanDaerah.constant;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
@Configuration
public class DaerahConstant {
    private Integer STATUS_CREATED = HttpStatus.CREATED.value();
    private Integer STATUS_OK = HttpStatus.OK.value();
}
