package com.example.BaiTech_QuanLyCV.service;

import com.example.BaiTech_QuanLyCV.dto.PhongBanDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhongBanService {

    List<PhongBanDTO> getAll();

    PhongBanDTO getOne(Integer id);

    PhongBanDTO save(PhongBanDTO phongBanDTO);

    PhongBanDTO update(PhongBanDTO phongBanDTO, Integer id);

    void delete(Integer id);

    Page<PhongBanDTO> searchPhongBan(String maPhongBan, String tenPhongBan, Pageable pageable);
}
