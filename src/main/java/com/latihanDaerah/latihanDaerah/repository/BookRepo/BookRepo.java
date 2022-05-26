package com.latihanDaerah.latihanDaerah.repository.BookRepo;

import java.util.List;

import com.latihanDaerah.latihanDaerah.model.BooksModel.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
    public Book findByJudul(String judul);
    public Book findByBookId(Integer id);
}
