package com.example.BaiTech_QuanLyCV.service;

import com.example.BaiTech_QuanLyCV.dto.ViTriCongViecDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ViTriCongViecService {

    List<ViTriCongViecDTO> getAll();

    ViTriCongViecDTO getOne(Integer id);

    ViTriCongViecDTO save(ViTriCongViecDTO viTriCongViecDTO);

    ViTriCongViecDTO update(ViTriCongViecDTO viTriCongViecDTO, Integer id);

    void delete(Integer id);

    Page<ViTriCongViecDTO> searchViTriCongViec(String maViTri, String tenViTri, String level, Pageable pageable);
}
