package com.latihanDaerah.latihanDaerah.dto.response.BooksResponse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.latihanDaerah.latihanDaerah.model.BooksModel.Book;
import com.latihanDaerah.latihanDaerah.model.BooksModel.User;

import lombok.Data;

@Data
public class PinjamBukuResponse {
    private Integer idPinjam;
    private String namaPeminjam;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tanggalPinjam;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tanggalBalik;
    private User user;
    private Book book;
}
