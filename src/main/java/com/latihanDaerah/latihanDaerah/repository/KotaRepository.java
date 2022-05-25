package com.latihanDaerah.latihanDaerah.repository;

import com.latihanDaerah.latihanDaerah.model.Kota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KotaRepository extends JpaRepository<Kota, Integer> {
    Kota findByCodeKota(Integer Id);
}
