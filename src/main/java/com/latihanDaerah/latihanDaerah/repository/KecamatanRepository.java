package com.latihanDaerah.latihanDaerah.repository;

import com.latihanDaerah.latihanDaerah.model.Kecamatan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KecamatanRepository extends JpaRepository<Kecamatan, Integer> {
    Kecamatan findByCodeKecamatan(Integer Id);
}
