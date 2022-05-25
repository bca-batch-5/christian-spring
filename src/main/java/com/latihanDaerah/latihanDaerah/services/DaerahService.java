package com.latihanDaerah.latihanDaerah.services;

import java.util.List;

import com.latihanDaerah.latihanDaerah.dto.request.KecamatanRequest;
import com.latihanDaerah.latihanDaerah.dto.request.KelurahanRequest;
import com.latihanDaerah.latihanDaerah.dto.request.KotaRequest;
import com.latihanDaerah.latihanDaerah.dto.request.ProvinsiRequest;
import com.latihanDaerah.latihanDaerah.dto.response.Response;

public interface DaerahService {
    public Response createProvinsi(ProvinsiRequest provinsiRequest) throws Exception;
    public Response getProvinsi();
    public Response getProvinsiWithId(Integer Id) throws Exception;
    public Response updateProvinsi(Integer Id, ProvinsiRequest provinsiRequest) throws Exception;
    public Response deleteProvinsi(Integer id) throws Exception;

    // Interface Kota
    public Response createKota(KotaRequest kotaRequest) throws Exception;
    public Response getKota();
    public Response getKotaById(Integer Id) throws Exception;
    public Response updateKota(Integer Id, KotaRequest kotaRequest) throws Exception;
    public Response deleteKota(Integer id) throws Exception;

    // Inteface Kecamatan
    public Response createKecamatan(KecamatanRequest kecamatanRequest) throws Exception;
    public Response getKecamatan();
    public Response getKecamatanById(Integer Id) throws Exception;
    public Response updateKecamatan(Integer Id, KecamatanRequest kecamatanRequest) throws Exception;
    public Response deleteKecamatan(Integer id) throws Exception;

    // Inteface Kelurahan
    public Response createKelurahan(List<KelurahanRequest> kelurahanRequest) throws Exception;
    public Response getKelurahan();
    public Response getKelurahanById(Integer Id) throws Exception;
    public Response updateKelurahan(Integer Id, KelurahanRequest kelurahanRequest) throws Exception;
    public Response deleteKelurahan(Integer id) throws Exception;
}
