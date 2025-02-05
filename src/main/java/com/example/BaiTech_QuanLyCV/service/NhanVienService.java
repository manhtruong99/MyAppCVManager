package com.example.BaiTech_QuanLyCV.service;

import com.example.BaiTech_QuanLyCV.dto.NhanVienDTO;
import com.example.BaiTech_QuanLyCV.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NhanVienService {

    List<NhanVienDTO> getAll();

    NhanVienDTO getOne(Integer id);

    NhanVienDTO save(NhanVienDTO nhanVienDTO);

    NhanVienDTO update(NhanVienDTO nhanVienDTO, Integer id);

    void delete(Integer id);

    Page<NhanVienDTO> searchNhanVien(String maNhanVien, String tenNhanVien, String email, Pageable pageable);
}
