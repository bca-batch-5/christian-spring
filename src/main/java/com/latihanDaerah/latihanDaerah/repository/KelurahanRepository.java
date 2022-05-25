package com.latihanDaerah.latihanDaerah.repository;

import com.latihanDaerah.latihanDaerah.model.Kelurahan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelurahanRepository extends JpaRepository<Kelurahan, Integer>{
    Kelurahan findByCodeKelurahan(Integer Id);
}
