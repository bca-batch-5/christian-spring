package com.latihanDaerah.latihanDaerah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "provinsi")
public class Provinsi {
    @Id
    @Column(name = "code_provinsi")
    private Integer codeProvinsi;
    @Column(name = "nama_provinsi")
    private String namaProvinsi;
}
