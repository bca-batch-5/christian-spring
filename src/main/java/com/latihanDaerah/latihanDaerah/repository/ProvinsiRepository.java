package com.latihanDaerah.latihanDaerah.repository;

import com.latihanDaerah.latihanDaerah.model.Provinsi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer> {
    Provinsi findByCodeProvinsi(Integer id);
}
