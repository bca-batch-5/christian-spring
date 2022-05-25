package com.latihanDaerah.latihanDaerah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "kota")
public class Kota {
    @Id
    @Column(name = "code_kota")
    private Integer codeKota;
    @Column(name = "nama_kota")
    private String namaKota;

    @ManyToOne
    @JoinColumn(name = "code_provinsi", referencedColumnName = "code_provinsi")
    private Provinsi provinsi;
}
