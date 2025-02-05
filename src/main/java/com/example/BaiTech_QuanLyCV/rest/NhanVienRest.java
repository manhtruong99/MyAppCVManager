package com.example.BaiTech_QuanLyCV.rest;

import com.example.BaiTech_QuanLyCV.dto.NhanVienDTO;
import com.example.BaiTech_QuanLyCV.service.NhanVienService;
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
@RequestMapping("nhan-vien")
public class NhanVienRest {

    private NhanVienService nhanVienService;

    @Autowired
    public NhanVienRest(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("hien-thi2")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(nhanVienService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVienDTO> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(nhanVienService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<NhanVienDTO> save(@RequestBody NhanVienDTO nhanVienDTO){
        return ResponseEntity.ok(nhanVienService.save(nhanVienDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVienDTO> update(@RequestBody NhanVienDTO nhanVienDTO,@PathVariable("id") Integer id){
        return ResponseEntity.ok(nhanVienService.update(nhanVienDTO,id));
    }

    @GetMapping("hien-thi")
    public Page<NhanVienDTO> searchNhanVien(
            @RequestParam(required = false, defaultValue = "") String maNhanVien,
            @RequestParam(required = false, defaultValue = "") String tenNhanVien,
            @RequestParam(required = false, defaultValue = "") String email,
            Pageable pageable) {
        return nhanVienService.searchNhanVien(maNhanVien, tenNhanVien, email, pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        nhanVienService.delete(id);
        return ResponseEntity.ok().build();
    }
}
