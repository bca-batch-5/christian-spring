package com.latihanDaerah.latihanDaerah.dto.request.BooksRequest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PinjamBukuRequest {
    private Integer idPinjam;
    private String namaPeminjam;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tanggalPinjam;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tanggalBalik;
    private Integer userId;
    private Integer bookId;
}
