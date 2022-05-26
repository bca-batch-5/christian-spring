package com.latihanDaerah.latihanDaerah.repository.BookRepo;

import com.latihanDaerah.latihanDaerah.model.BooksModel.PinjamBuku;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinjamBukuRepo extends JpaRepository<PinjamBuku, Integer> {
    PinjamBuku findByIdPinjam(Integer id);
}
