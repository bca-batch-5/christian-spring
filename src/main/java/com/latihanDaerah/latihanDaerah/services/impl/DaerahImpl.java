package com.latihanDaerah.latihanDaerah.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.latihanDaerah.latihanDaerah.Exception.NullException;
import com.latihanDaerah.latihanDaerah.constant.DaerahConstant;
import com.latihanDaerah.latihanDaerah.dto.request.KecamatanRequest;
import com.latihanDaerah.latihanDaerah.dto.request.KelurahanRequest;
import com.latihanDaerah.latihanDaerah.dto.request.KotaRequest;
import com.latihanDaerah.latihanDaerah.dto.request.ProvinsiRequest;
import com.latihanDaerah.latihanDaerah.dto.response.KecamatanResponse;
import com.latihanDaerah.latihanDaerah.dto.response.KelurahanaResponse;
import com.latihanDaerah.latihanDaerah.dto.response.KotaResponse;
import com.latihanDaerah.latihanDaerah.dto.response.ProvinsiResponse;
import com.latihanDaerah.latihanDaerah.dto.response.Response;
import com.latihanDaerah.latihanDaerah.model.Kecamatan;
import com.latihanDaerah.latihanDaerah.model.Kelurahan;
import com.latihanDaerah.latihanDaerah.model.Kota;
import com.latihanDaerah.latihanDaerah.model.Provinsi;
import com.latihanDaerah.latihanDaerah.repository.KecamatanRepository;
import com.latihanDaerah.latihanDaerah.repository.KelurahanRepository;
import com.latihanDaerah.latihanDaerah.repository.KotaRepository;
import com.latihanDaerah.latihanDaerah.repository.ProvinsiRepository;
import com.latihanDaerah.latihanDaerah.services.DaerahService;
import com.latihanDaerah.latihanDaerah.validation.DaerahValidation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DaerahImpl implements DaerahService {
    private Response response;

    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DaerahValidation daerahValidation;

    @Autowired
    private KotaRepository kotaRepository;

    @Autowired
    private DaerahConstant daerahConstant;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KelurahanRepository kelurahanRepository;

    @Override
    public Response createProvinsi(ProvinsiRequest provinsiRequest) throws Exception {
        Provinsi provinsi = new Provinsi();
        daerahValidation.createProvinsiValidation(provinsiRequest);
        provinsi = mapper.map(provinsiRequest, Provinsi.class);
        provinsiRepository.save(provinsi);
        
        ProvinsiResponse provinsiResponse = mapper.map(provinsi, ProvinsiResponse.class);
        String msg = provinsiResponse.getNamaProvinsi() + " created";
        response = new Response(daerahConstant.getSTATUS_CREATED(), msg, provinsiResponse);
        return response;
    }

    @Override
    public Response getProvinsi() {
        List<Provinsi> provinsi = provinsiRepository.findAll();
        List<ProvinsiResponse> res = new ArrayList<>();
        for (int i = 0; i < provinsi.size(); i++) {
            res.add(mapper.map(provinsi.get(i), ProvinsiResponse.class));
        }

        response = new Response(HttpStatus.OK.value(), "Data Berhasil di Get", res);
        return response;
    }

    @Override
    public Response getProvinsiWithId(Integer Id) throws NullException {
        Provinsi provinsi = provinsiRepository.findByCodeProvinsi(Id);
        daerahValidation.getProvinsiWithIdValidation(provinsi);
        ProvinsiResponse result = mapper.map(provinsi, ProvinsiResponse.class);
        response = new Response(HttpStatus.OK.value(), "Data berhasil di dapatkan", result);
        return response;
    }

    @Override
    public Response updateProvinsi(Integer Id, ProvinsiRequest provinsiRequest) throws Exception {
        Provinsi provinsi = provinsiRepository.findByCodeProvinsi(Id);
        daerahValidation.updateProvinsiValidation(provinsiRequest, provinsi);
        Provinsi provinsiUpdate = mapper.map(provinsiRequest, Provinsi.class);
        provinsiRepository.save(provinsiUpdate);
        ProvinsiResponse result = mapper.map(provinsiUpdate, ProvinsiResponse.class);
        response = new Response(HttpStatus.OK.value(), "Data Terupdate", result);
        return response;
    }

    @Override
    public Response deleteProvinsi(Integer id) throws Exception {
        Provinsi provinsi = provinsiRepository.findByCodeProvinsi(id);
        daerahValidation.deleteProvinsiValidation(provinsi);
        provinsiRepository.delete(provinsi);
        String msg = "Data Provinsi di hapus code: " + provinsi.getCodeProvinsi() + " - Dengan nama provinsi: "
                + provinsi.getNamaProvinsi();
        response = new Response(HttpStatus.OK.value(), msg, null);
        return response;
    }

    // ----------------------------------------------------------------- method Kota
    // -------------------------------------------------------------

    @Override
    public Response createKota(KotaRequest kotaRequest) throws Exception {
        Kota kota = new Kota();
        Provinsi provinsi = provinsiRepository.findByCodeProvinsi(kotaRequest.getCodeProvinsi());
        daerahValidation.createKotaValidation(kotaRequest);
        kota = mapper.map(kotaRequest, Kota.class);
        kota.setProvinsi(provinsi);
        kotaRepository.save(kota);
        KotaResponse res = mapper.map(kota, KotaResponse.class);
        response = new Response(daerahConstant.getSTATUS_CREATED(), "Data Terbuat", res);
        return response;
    }

    @Override
    public Response getKota() {
        List<Kota> kota = kotaRepository.findAll();
        List<KotaResponse> res = new ArrayList<>();
        for (int i = 0; i < kota.size(); i++) {
            res.add(mapper.map(kota.get(i), KotaResponse.class));
        }
        response = new Response(daerahConstant.getSTATUS_OK(), "Data berhasil di get", res);
        return response;
    }

    @Override
    public Response getKotaById(Integer Id) throws Exception {
        Kota kota = kotaRepository.findByCodeKota(Id);
        daerahValidation.getKotaWithIdValidation(kota);
        KotaResponse res = mapper.map(kota, KotaResponse.class);
        response = new Response(daerahConstant.getSTATUS_OK(), "data di dapatkan", res);
        return response;
    }

    @Override
    public Response updateKota(Integer Id, KotaRequest kotaRequest) throws Exception {
        Kota kota = kotaRepository.findByCodeKota(Id);
        daerahValidation.updateKotaValidation(kotaRequest, kota);
        Kota kotaUpdate = mapper.map(kotaRequest, Kota.class);
        kotaRepository.save(kotaUpdate);
        KotaResponse res = mapper.map(kotaUpdate, KotaResponse.class);
        response = new Response(daerahConstant.getSTATUS_OK(), "Data Terupdate", res);
        return response;
    }

    @Override
    public Response deleteKota(Integer id) throws Exception {
        Kota kota = kotaRepository.findByCodeKota(id);
        daerahValidation.deleteKotaValidation(kota);
        kotaRepository.delete(kota);
        String msg = "Data Kota Code : " + kota.getCodeKota() + " - dengan nama: " + kota.getNamaKota()
                + " Telah di hapus";
        response = new Response(daerahConstant.getSTATUS_OK(), msg, null);
        return response;
    }
    // ----------------------------------------------------------------- method
    // Kecamatan -------------------------------------------------------------

    @Override
    public Response createKecamatan(KecamatanRequest kecamatanRequest) throws Exception {
        daerahValidation.createKecamatanValidation(kecamatanRequest);
        Kecamatan kecamatan = mapper.map(kecamatanRequest, Kecamatan.class);
        kecamatanRepository.save(kecamatan);
        KecamatanResponse kecamatanResponse = mapper.map(kecamatan, KecamatanResponse.class);
        String msg = kecamatanResponse.getNamaKecamatan() + " Created";
        response = new Response(daerahConstant.getSTATUS_CREATED(), msg, kecamatanResponse);
        return response;
    }

    @Override
    public Response getKecamatan() {
        List<Kecamatan> kecamatan = kecamatanRepository.findAll();
        List<KecamatanResponse> res = new ArrayList<>();

        for (int i = 0; i < kecamatan.size(); i++) {
            res.add(mapper.map(kecamatan.get(i), KecamatanResponse.class));
        }
        response = new Response(daerahConstant.getSTATUS_OK(), "Data berhasil di dapatkan", res);
        return response;
    }

    @Override
    public Response getKecamatanById(Integer Id) throws Exception {
        Kecamatan kecamatan = kecamatanRepository.findByCodeKecamatan(Id);
        daerahValidation.getKecamatanWithIdValidation(kecamatan);
        KecamatanResponse res = mapper.map(kecamatan, KecamatanResponse.class);
        response = new Response(daerahConstant.getSTATUS_OK(), "Data di dapaatkan", res);
        return response;
    }

    @Override
    public Response updateKecamatan(Integer Id, KecamatanRequest kecamatanRequest) throws Exception {
        Kecamatan kecamatan = kecamatanRepository.findByCodeKecamatan(Id);
        daerahValidation.updateKecamatanValidation(kecamatanRequest, kecamatan);
        Kecamatan kecamatanUpdate = mapper.map(kecamatanRequest, Kecamatan.class);
        kecamatanRepository.save(kecamatanUpdate);
        KecamatanResponse res = mapper.map(kecamatanUpdate, KecamatanResponse.class);
        response = new Response(daerahConstant.getSTATUS_OK(), "Data Terupdate", res);
        return response;
    }

    @Override
    public Response deleteKecamatan(Integer id) throws Exception {
        Kecamatan kecamatan = kecamatanRepository.findByCodeKecamatan(id);
        daerahValidation.deleteKecamatanValidation(kecamatan);
        kecamatanRepository.delete(kecamatan);
        String msg = "Data Kecamatan Code: " + kecamatan.getCodeKecamatan() + " - dengan nama kecamatan: "
                + kecamatan.getNamaKecamatan() + " Telah di hapus";
        response = new Response(daerahConstant.getSTATUS_OK(), msg, null);
        return response;
    }
    // ----------------------------------------------------------------- method
    // Kelurahan -------------------------------------------------------------

    @Override
    public Response createKelurahan(List<KelurahanRequest> kelurahanRequest) throws Exception {
        List<Kelurahan> kelurahan = new ArrayList<>();
        List<KelurahanaResponse> res = new ArrayList<>();
        daerahValidation.createKelurahanValidation(kelurahanRequest);
        for(int i = 0 ; i < kelurahanRequest.size(); i++){
            kelurahan.add(mapper.map(kelurahanRequest.get(i), Kelurahan.class));
        }
        kelurahanRepository.saveAll(kelurahan);
        for(int j = 0 ; j < kelurahan.size(); j++){
            res.add(mapper.map(kelurahan.get(j), KelurahanaResponse.class));
        }
          
        response = new Response(daerahConstant.getSTATUS_CREATED(), "Data Created", res);
        return response;
    }

    @Override
    public Response getKelurahan() {
        List<Kelurahan> kelurahan = kelurahanRepository.findAll();
        List<KelurahanaResponse> res = new ArrayList<>();
        for (int i = 0; i < kelurahan.size(); i++) {
            res.add(mapper.map(kelurahan.get(i), KelurahanaResponse.class));
        }
        response = new Response(daerahConstant.getSTATUS_OK(), "Data di dapatkan", res);
        return response;
    }

    @Override
    public Response getKelurahanById(Integer Id) throws Exception {
        Kelurahan kelurahan = kelurahanRepository.findByCodeKelurahan(Id);
        daerahValidation.getKelurahanWithIdValidation(kelurahan);
        KelurahanaResponse res = mapper.map(kelurahan, KelurahanaResponse.class);
        response = new Response(daerahConstant.getSTATUS_OK(), "Data Berhasil di dapatkan", res);
        return response;
    }

    @Override
    public Response updateKelurahan(Integer Id, KelurahanRequest kelurahanRequest) throws Exception {
        Kelurahan kelurahan = kelurahanRepository.findByCodeKelurahan(Id);
        daerahValidation.updateKelurahanValidation(kelurahanRequest, kelurahan);
        Kelurahan kelurahanUpdate = mapper.map(kelurahanRequest, Kelurahan.class);
        kelurahanRepository.save(kelurahanUpdate);
        KelurahanaResponse res = mapper.map(kelurahanUpdate, KelurahanaResponse.class);
        response = new Response(daerahConstant.getSTATUS_OK(), "data terupdate", res);
        return response;
    }

    @Override
    public Response deleteKelurahan(Integer id) throws Exception {
        Kelurahan kelurahan = kelurahanRepository.findByCodeKelurahan(id);
        daerahValidation.deleteKelurahanValidation(kelurahan);
        kelurahanRepository.delete(kelurahan);
        String msg = "Data Kelurahan Code: " + kelurahan.getCodeKelurahan() + " - dengan nama kelurahan: "
                + kelurahan.getNamaKelurahan() + " Berhasil di hapus";
        response = new Response(daerahConstant.getSTATUS_OK(), msg, null);
        return response;
    }

}
