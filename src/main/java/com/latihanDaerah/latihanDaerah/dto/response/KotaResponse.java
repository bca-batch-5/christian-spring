package com.latihanDaerah.latihanDaerah.dto.response;

import com.latihanDaerah.latihanDaerah.model.Provinsi;

import lombok.Data;

@Data
public class KotaResponse {
    private Integer codeKota;
    private String namaKota;
    private Provinsi provinsi;
}
