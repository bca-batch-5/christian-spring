package com.latihanDaerah.latihanDaerah.dto.request.BooksRequest;

import lombok.Data;

@Data
public class BookRequest {
    private Integer bookId;
    private String judul;
    private String penulis;
    private Boolean isDeleted;
}
