package com.latihanDaerah.latihanDaerah.dto.request;

import com.latihanDaerah.latihanDaerah.model.Provinsi;

import lombok.Data;

@Data
public class KotaRequest {
    private Integer codeKota;
    private String namaKota;
    private Integer codeProvinsi;
}
