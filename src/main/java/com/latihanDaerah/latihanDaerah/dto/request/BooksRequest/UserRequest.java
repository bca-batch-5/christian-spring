package com.latihanDaerah.latihanDaerah.dto.request.BooksRequest;

import lombok.Data;

@Data
public class UserRequest {
    private Integer userId;
    private String username;
    private String password;
    private String fullName;
    private Boolean isDeleted;
}
