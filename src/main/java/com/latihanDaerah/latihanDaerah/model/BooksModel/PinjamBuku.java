package com.latihanDaerah.latihanDaerah.model.BooksModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pinjam_buku")
public class PinjamBuku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPinjam;
    @Column(name = "nama_peminjam")
    private String namaPeminjam;
    @Column(name = "tanggal_pinjam")
    private Date tanggalPinjam;
    @Column(name = "tanggal_balik")
    private Date tanggalBalik;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
