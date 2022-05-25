package com.latihanDaerah.latihanDaerah.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer status;
    private String message;
    private Object Data;
}
