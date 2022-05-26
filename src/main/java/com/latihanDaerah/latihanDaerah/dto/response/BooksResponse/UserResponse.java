package com.latihanDaerah.latihanDaerah.dto.response.BooksResponse;

import lombok.Data;

@Data
public class UserResponse {
    private Integer userId;
    private String username;
    private String fullName;
    private Boolean isDeleted;
}
