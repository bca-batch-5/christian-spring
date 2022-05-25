package com.latihanDaerah.latihanDaerah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "keluharan")
public class Kelurahan {
    @Id
    @Column(name = "code_kelurahan")
    private Integer codeKelurahan;
    @Column(name = "nama_kelurahan")
    private String namaKelurahan;
}
