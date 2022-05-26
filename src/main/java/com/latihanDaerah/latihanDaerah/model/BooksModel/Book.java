package com.latihanDaerah.latihanDaerah.model.BooksModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(name = "judul")
    private String judul;
    @Column(name = "penulis")
    private String penulis;
    @Column(name = "isDeleted")
    private Boolean isDeleted;
}
