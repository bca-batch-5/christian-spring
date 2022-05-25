package com.latihanDaerah.latihanDaerah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "kecamatan")
public class Kecamatan {

    @Id
    @Column(name = "code_kecamatan")
    private Integer codeKecamatan;
    @Column(name = "nama_kecamatan")
    private String namaKecamatan;
}
