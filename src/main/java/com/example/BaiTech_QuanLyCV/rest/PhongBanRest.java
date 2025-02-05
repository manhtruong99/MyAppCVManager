package com.example.BaiTech_QuanLyCV.rest;

import com.example.BaiTech_QuanLyCV.dto.NhanVienDTO;
import com.example.BaiTech_QuanLyCV.dto.PhongBanDTO;
import com.example.BaiTech_QuanLyCV.dto.ViTriCongViecDTO;
import com.example.BaiTech_QuanLyCV.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("phong-ban")
public class PhongBanRest {

    private PhongBanService phongBanService;

    @Autowired
    public PhongBanRest(PhongBanService phongBanService) {
        this.phongBanService = phongBanService;
    }

    @GetMapping("hien-thi2")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(phongBanService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhongBanDTO> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(phongBanService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<PhongBanDTO> save(@RequestBody PhongBanDTO phongBanDTO){
        return ResponseEntity.ok(phongBanService.save(phongBanDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhongBanDTO> update(@RequestBody PhongBanDTO phongBanDTO,@PathVariable("id") Integer id){
        return ResponseEntity.ok(phongBanService.update(phongBanDTO,id));
    }

    @GetMapping("hien-thi")
    public Page<PhongBanDTO> searchNhanVien(
            @RequestParam(required = false, defaultValue = "") String maPhongBan,
            @RequestParam(required = false, defaultValue = "") String tenPhongBan,
            Pageable pageable) {
        return phongBanService.searchPhongBan(maPhongBan, tenPhongBan, pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        phongBanService.delete(id);
        return ResponseEntity.ok().build();
    }
}
