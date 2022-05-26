package com.latihanDaerah.latihanDaerah.dto.response.BooksResponse;

import lombok.Data;

@Data
public class BookResponse {
    private Integer bookId;
    private String judul;
    private String penulis;
    private Boolean isDeleted;
}
