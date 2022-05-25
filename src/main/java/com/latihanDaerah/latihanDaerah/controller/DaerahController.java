package com.latihanDaerah.latihanDaerah.controller;

import java.util.List;

import com.latihanDaerah.latihanDaerah.dto.request.KecamatanRequest;
import com.latihanDaerah.latihanDaerah.dto.request.KelurahanRequest;
import com.latihanDaerah.latihanDaerah.dto.request.KotaRequest;
import com.latihanDaerah.latihanDaerah.dto.request.ProvinsiRequest;
import com.latihanDaerah.latihanDaerah.dto.response.Response;
import com.latihanDaerah.latihanDaerah.services.DaerahService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daerah")
public class DaerahController {
    @Autowired
    private DaerahService daerahService;

    @PostMapping("/provinsi")
    public ResponseEntity<?> createProvinsi(@RequestBody ProvinsiRequest provinsiRequest) throws Exception {
        Response responseData = daerahService.createProvinsi(provinsiRequest);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/provinsi")
    public ResponseEntity<?> getProvinsi() {
        Response responseData = daerahService.getProvinsi();
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/provinsi/{Id}")
    public ResponseEntity<?> getProvinsiWithId(@PathVariable Integer Id) throws Exception {
        Response responseData = daerahService.getProvinsiWithId(Id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/provinsi/{Id}")
    public ResponseEntity<?> updateProvinsi(@PathVariable Integer Id, @RequestBody ProvinsiRequest provinsiRequest)
            throws Exception {
        Response responseData = daerahService.updateProvinsi(Id, provinsiRequest);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/provinsi/{id}")
    public ResponseEntity<?> deleteProvinsi(@PathVariable Integer id) throws Exception {
        Response responseData = daerahService.deleteProvinsi(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    // KOTA CONTROLLER 

    @PostMapping("/kota")
    public ResponseEntity<?> createKota(@RequestBody KotaRequest kotaRequest) throws Exception {
        Response responseData = daerahService.createKota(kotaRequest);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/kota")
    public ResponseEntity<?> getKota() {
        Response responseData = daerahService.getKota();
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/kota/{Id}")
    public ResponseEntity<?> getKotaById(@PathVariable Integer Id) throws Exception {
        Response responseData = daerahService.getKotaById(Id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/kota/{Id}")
    public ResponseEntity<?> updateKota(@PathVariable Integer Id, @RequestBody KotaRequest kotaRequest) throws Exception{
        Response responseData = daerahService.updateKota(Id, kotaRequest);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/kota/{id}")
    public ResponseEntity<?> deletekota(@PathVariable Integer id) throws Exception {
        Response responseData = daerahService.deleteKota(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    // Kecamatan Controller
    @PostMapping("/kecamatan")
    public ResponseEntity<?> createKecamatan(@RequestBody KecamatanRequest kecamatanRequest) throws Exception {
        Response responseData = daerahService.createKecamatan(kecamatanRequest);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/kecamatan")
    public ResponseEntity<?> getKecamatan() {
        Response responseData = daerahService.getKecamatan();
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/kecamatan/{Id}")
    public ResponseEntity<?> getKecamatanById(@PathVariable Integer Id) throws Exception {
        Response responseData = daerahService.getKecamatanById(Id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/kecamatan/{Id}")
    public ResponseEntity<?> updateKecamatan(@PathVariable Integer Id, @RequestBody KecamatanRequest kecamatanRequest) throws Exception{
        Response responseData = daerahService.updateKecamatan(Id, kecamatanRequest);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/kecamatan/{id}")
    public ResponseEntity<?> deleteKecamatan(@PathVariable Integer id) throws Exception {
        Response responseData = daerahService.deleteKecamatan(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    //Kelurahan Controller
    @PostMapping("/kelurahan")
    public ResponseEntity<?> createKelurahan(@RequestBody List<KelurahanRequest> kelurahanRequest) throws Exception {
        Response responseData = daerahService.createKelurahan(kelurahanRequest);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/kelurahan")
    public ResponseEntity<?> getKelurahan() {
        Response responseData = daerahService.getKelurahan();
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/kelurahan/{Id}")
    public ResponseEntity<?> getKelurahanById(@PathVariable Integer Id) throws Exception {
        Response responseData = daerahService.getKelurahanById(Id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @PutMapping("/kelurahan/{Id}")
    public ResponseEntity<?> updateKelurahan(@PathVariable Integer Id, @RequestBody KelurahanRequest kelurahanRequest) throws Exception{
        Response responseData = daerahService.updateKelurahan(Id, kelurahanRequest);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @DeleteMapping("/kelurahan/{id}")
    public ResponseEntity<?> deleteKelurahan(@PathVariable Integer id) throws Exception {
        Response responseData = daerahService.deleteKelurahan(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }


}
