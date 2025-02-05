package com.example.BaiTech_QuanLyCV.rest;

import com.example.BaiTech_QuanLyCV.dto.HoSoDTO;
import com.example.BaiTech_QuanLyCV.service.HoSoService;
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
@RequestMapping("ho-so")
public class HoSoRest {

    private HoSoService hoSoService;

    @Autowired
    public HoSoRest(HoSoService hoSoService) {
        this.hoSoService = hoSoService;
    }

    @GetMapping("hien-thi2")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(hoSoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoSoDTO> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(hoSoService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<HoSoDTO> save(@RequestBody HoSoDTO hoSoDTO){
        return ResponseEntity.ok(hoSoService.save(hoSoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoSoDTO> update(@RequestBody HoSoDTO hoSoDTO,@PathVariable("id") Integer id){
        return ResponseEntity.ok(hoSoService.update(hoSoDTO,id));
    }

    @GetMapping("hien-thi")
    public Page<HoSoDTO> searchNhanVien(
            @RequestParam(required = false, defaultValue = "") String fullName,
            @RequestParam(required = false, defaultValue = "") String email,
            @RequestParam(required = false, defaultValue = "") String tel,
            @RequestParam(required = false, defaultValue = "") String city,
            @RequestParam(required = false, defaultValue = "") String tenNhanVien,
            @RequestParam(required = false, defaultValue = "") String jobName,
            Pageable pageable) {
        return hoSoService.searchHoSo(fullName, email, tel, city, tenNhanVien, jobName,pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        hoSoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
