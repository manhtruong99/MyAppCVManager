package com.example.BaiTech_QuanLyCV.rest;

import com.example.BaiTech_QuanLyCV.dto.HoSoDTO;
import com.example.BaiTech_QuanLyCV.dto.HoatDongDTO;
import com.example.BaiTech_QuanLyCV.dto.PhongBanDTO;
import com.example.BaiTech_QuanLyCV.service.HoatDongService;
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
@RequestMapping("hoat-dong")
public class HoatDongRest {

    private HoatDongService hoatDongService;

    @Autowired
    public HoatDongRest(HoatDongService hoatDongService) {
        this.hoatDongService = hoatDongService;
    }

    @GetMapping("hien-thi2")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(hoatDongService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoatDongDTO> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(hoatDongService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<HoatDongDTO> save(@RequestBody HoatDongDTO hoatDongDTO){
        return ResponseEntity.ok(hoatDongService.save(hoatDongDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoatDongDTO> update(@RequestBody HoatDongDTO hoatDongDTO,@PathVariable("id") Integer id){
        return ResponseEntity.ok(hoatDongService.update(hoatDongDTO,id));
    }


    @GetMapping("hien-thi")
    public Page<HoatDongDTO> searchNhanVien(
            @RequestParam(required = false, defaultValue = "") String activityMa,
            @RequestParam(required = false, defaultValue = "") String activityType,
            @RequestParam(required = false, defaultValue = "") String tenNhanVien,
            Pageable pageable) {
        return hoatDongService.searchHoatDong(activityMa, activityType, tenNhanVien, pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        hoatDongService.delete(id);
        return ResponseEntity.ok().build();
    }
}
