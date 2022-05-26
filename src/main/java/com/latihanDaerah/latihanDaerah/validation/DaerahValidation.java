package com.latihanDaerah.latihanDaerah.validation;

import java.util.List;

import com.latihanDaerah.latihanDaerah.Exception.BadRequestException;
import com.latihanDaerah.latihanDaerah.Exception.NullException;
import com.latihanDaerah.latihanDaerah.dto.request.KecamatanRequest;
import com.latihanDaerah.latihanDaerah.dto.request.KelurahanRequest;
import com.latihanDaerah.latihanDaerah.dto.request.KotaRequest;
import com.latihanDaerah.latihanDaerah.dto.request.ProvinsiRequest;
import com.latihanDaerah.latihanDaerah.model.Kecamatan;
import com.latihanDaerah.latihanDaerah.model.Kelurahan;
import com.latihanDaerah.latihanDaerah.model.Kota;
import com.latihanDaerah.latihanDaerah.model.Provinsi;
import org.springframework.stereotype.Service;

@Service
public class DaerahValidation {
        
    public void createProvinsiValidation(ProvinsiRequest provinsiRequest) throws Exception{
        if(provinsiRequest.getCodeProvinsi() == null || provinsiRequest.getNamaProvinsi() == null){
          throw new BadRequestException("Attribut tidak boleh null");
        }
    }

    public void getProvinsiWithIdValidation(Provinsi provinsi) throws NullException{
        if(provinsi == null){
            throw new NullException("Data Tidak ada");
        }
    }

    public void updateProvinsiValidation(ProvinsiRequest provinsiRequest, Provinsi provinsi) throws Exception{
        if(provinsi == null){
            throw new NullException("Data tidak tersedia");
        }
        if(provinsiRequest.getCodeProvinsi() == null){  
            provinsiRequest.setCodeProvinsi(provinsi.getCodeProvinsi());
        }else{
            throw new BadRequestException("Tidak bisa mengganti code provinsi");
        }
    }

    public void deleteProvinsiValidation(Provinsi provinsi) throws Exception{
        if(provinsi == null){
            throw new NullException("Data tidak ada");
        }
    }

    // KOTA VALIDASI

    public void createKotaValidation(KotaRequest kotaRequest) throws Exception{
        if(kotaRequest.getCodeKota() == null || kotaRequest.getNamaKota() == null){
            throw new BadRequestException("Data tidak boleh kosong");
        }
    } 

    public void getKotaWithIdValidation(Kota kota) throws NullException{
        if(kota == null){
            throw new NullException("Data Tidak ada");
        }
    }

    public void updateKotaValidation(KotaRequest kotaRequest, Kota kota) throws Exception{
        if(kota == null){
            throw new NullException("Data tidak tersedia");
        }
        if(kotaRequest.getCodeKota() == null){  
            kotaRequest.setCodeKota(kota.getCodeKota());
        }else{
            throw new BadRequestException("Tidak bisa mengganti code kota");
        }
    }

    public void deleteKotaValidation(Kota kota) throws Exception{
        if(kota == null){
            throw new NullException("Data tidak ada");
        }
    }

    // validasi Kecamatan
    public void createKecamatanValidation(KecamatanRequest kecamatanRequest) throws Exception{
        if(kecamatanRequest.getCodeKecamatan() == null || kecamatanRequest.getNamaKecamatan() == null){
            throw new BadRequestException("Data tidak boleh kosong");
        }
    } 

    public void getKecamatanWithIdValidation(Kecamatan kecamatan) throws NullException{
        if(kecamatan == null){
            throw new NullException("Data Tidak ada");
        }
    }

    public void updateKecamatanValidation(KecamatanRequest kecamatanRequest, Kecamatan kecamatan) throws Exception{
        if(kecamatan == null){
            throw new NullException("Data tidak tersedia");
        }
        if(kecamatanRequest.getCodeKecamatan() == null){  
            kecamatanRequest.setCodeKecamatan(kecamatan.getCodeKecamatan());
        }else{
            throw new BadRequestException("Tidak bisa mengganti code kecamatan");
        }
    }

    public void deleteKecamatanValidation(Kecamatan kecamatan) throws Exception{
        if(kecamatan == null){
            throw new NullException("Data tidak ada");
        }
    }

    // Validasi kelurahan
    public void createKelurahanValidation(List<KelurahanRequest> kelurahanRequest) throws Exception{
        for(int i = 0 ; i < kelurahanRequest.size(); i++){
            if(kelurahanRequest.get(i).getCodeKelurahan() == null || kelurahanRequest.get(i).getNamaKelurahan() == null){
                throw new BadRequestException("Attribut tidak boleh null");
              }
        }
        
    }

    public void getKelurahanWithIdValidation(Kelurahan kelurahan) throws NullException{
        if(kelurahan == null){
            throw new NullException("Data Tidak ada");
        }
    }
    public void updateKelurahanValidation(KelurahanRequest kelurahanRequest, Kelurahan kelurahan) throws Exception{
        if(kelurahan == null){
            throw new NullException("Data tidak tersedia");
        }
        if(kelurahanRequest.getCodeKelurahan() == null){  
            kelurahanRequest.setCodeKelurahan(kelurahan.getCodeKelurahan());
        }else{
            throw new BadRequestException("Tidak bisa mengganti code kecamatan");
        }
    }
    public void deleteKelurahanValidation(Kelurahan kelurahan) throws Exception{
        if(kelurahan == null){
            throw new NullException("Data tidak ada");
        }
    }
}
