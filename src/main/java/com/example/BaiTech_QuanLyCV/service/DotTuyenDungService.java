package com.example.BaiTech_QuanLyCV.service;

import com.example.BaiTech_QuanLyCV.dto.DotTuyenDungDTO;
import com.example.BaiTech_QuanLyCV.entity.DotTuyenDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DotTuyenDungService {

    List<DotTuyenDungDTO> getAll();

    DotTuyenDungDTO getOne(Integer id);

    DotTuyenDungDTO save(DotTuyenDungDTO dotTuyenDungDTO);

    DotTuyenDungDTO update(DotTuyenDungDTO dotTuyenDungDTO, Integer id);

    void delete(Integer id);

    Page<DotTuyenDungDTO> searchDotTuyenDung(String maDotTuyenDung, String tenDotTuyenDung, String noiDung, String tenNhanVien,
                                             Pageable pageable);
}
