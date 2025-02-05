package com.example.BaiTech_QuanLyCV.rest;

import com.example.BaiTech_QuanLyCV.dto.DotTuyenDungDTO;
import com.example.BaiTech_QuanLyCV.dto.PhongBanDTO;
import com.example.BaiTech_QuanLyCV.dto.ViTriCongViecDTO;
import com.example.BaiTech_QuanLyCV.service.DotTuyenDungService;
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
@RequestMapping("dot-tuyen-dung")
public class DotTuyenDungRest {

    private DotTuyenDungService dotTuyenDungService;

    @Autowired
    public DotTuyenDungRest(DotTuyenDungService dotTuyenDungService) {
        this.dotTuyenDungService = dotTuyenDungService;
    }

    @GetMapping("hien-thi2")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(dotTuyenDungService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DotTuyenDungDTO> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(dotTuyenDungService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<DotTuyenDungDTO> save(@RequestBody DotTuyenDungDTO dotTuyenDungDTO){
        return ResponseEntity.ok(dotTuyenDungService.save(dotTuyenDungDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DotTuyenDungDTO> update(@RequestBody DotTuyenDungDTO dotTuyenDungDTO,@PathVariable("id") Integer id){
        return ResponseEntity.ok(dotTuyenDungService.update(dotTuyenDungDTO,id));
    }

    @GetMapping("hien-thi")
    public Page<DotTuyenDungDTO> searchNhanVien(
            @RequestParam(required = false, defaultValue = "") String maDotTuyenDung,
            @RequestParam(required = false, defaultValue = "") String tenDotTuyenDung,
            @RequestParam(required = false, defaultValue = "") String noiDung,
            @RequestParam(required = false, defaultValue = "") String tenNhanVien,
            Pageable pageable) {
        return dotTuyenDungService.searchDotTuyenDung(maDotTuyenDung, tenDotTuyenDung, noiDung, tenNhanVien, pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        dotTuyenDungService.delete(id);
        return ResponseEntity.ok().build();
    }
}
