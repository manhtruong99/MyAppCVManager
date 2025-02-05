package com.example.BaiTech_QuanLyCV.service;

import com.example.BaiTech_QuanLyCV.dto.HoatDongDTO;
import com.example.BaiTech_QuanLyCV.entity.HoatDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HoatDongService {

    List<HoatDongDTO> getAll();

    HoatDongDTO getOne(Integer id);

    HoatDongDTO save(HoatDongDTO hoatDongDTO);

    HoatDongDTO update(HoatDongDTO hoatDongDTO, Integer id);

    void delete(Integer id);

    Page<HoatDongDTO> searchHoatDong(String activityMa, String activityType, String tenNhanVien, Pageable pageable);
}
