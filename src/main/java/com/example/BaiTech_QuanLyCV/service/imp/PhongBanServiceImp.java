package com.example.BaiTech_QuanLyCV.service.imp;

import com.example.BaiTech_QuanLyCV.dto.NhanVienDTO;
import com.example.BaiTech_QuanLyCV.dto.PhongBanDTO;
import com.example.BaiTech_QuanLyCV.dto.ViTriCongViecDTO;
import com.example.BaiTech_QuanLyCV.entity.NhanVien;
import com.example.BaiTech_QuanLyCV.entity.PhongBan;
import com.example.BaiTech_QuanLyCV.exception.ResourceNotfound;
import com.example.BaiTech_QuanLyCV.repository.PhongBanRepository;
import com.example.BaiTech_QuanLyCV.service.PhongBanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhongBanServiceImp implements PhongBanService {

    private PhongBanRepository phongBanRepository;

    private ModelMapper modelMapper;

    @Autowired
    public PhongBanServiceImp(PhongBanRepository phongBanRepository, ModelMapper modelMapper) {
        this.phongBanRepository = phongBanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PhongBanDTO> getAll() {
        return phongBanRepository.findAll().stream()
                .map((phongBan) -> modelMapper.map(phongBan, PhongBanDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PhongBanDTO getOne(Integer id) {
        return modelMapper.map(phongBanRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại phong ban có id: " + id)), PhongBanDTO.class);
    }

    @Override
    public PhongBanDTO save(PhongBanDTO phongBanDTO) {
        PhongBan phongBan = modelMapper.map(phongBanDTO, PhongBan.class);
        phongBan.setDeletedAt(false);
        PhongBan phongBanSave = phongBanRepository.save(phongBan);
        return modelMapper.map(phongBanSave, PhongBanDTO.class);
    }

    @Override
    public PhongBanDTO update(PhongBanDTO phongBanDTO, Integer id) {
        PhongBan phongBan = phongBanRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại phong ban có id: " + id));
        phongBan.setMaPhongBan(phongBanDTO.getMaPhongBan());
        phongBan.setTenPhongBan(phongBanDTO.getTenPhongBan());
        PhongBan phongBanUpdate = phongBanRepository.save(phongBan);
        return modelMapper.map(phongBanUpdate, PhongBanDTO.class);
    }

    @Override
    public void delete(Integer id) {
        PhongBan phongBan = phongBanRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại phong ban có id: " + id));
        phongBanRepository.softDeletePhongBan(id);
    }

    @Override
    public Page<PhongBanDTO> searchPhongBan(String maPhongBan, String tenPhongBan, Pageable pageable) {
        Page<PhongBan> phongBanPage = phongBanRepository.searchPhongBan(maPhongBan, tenPhongBan,pageable);

        List<PhongBanDTO> phongBanDTOS = phongBanPage.getContent().stream()
                .map((phongBan) ->modelMapper.map(phongBan,PhongBanDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<>(phongBanDTOS, pageable, phongBanPage.getTotalElements());
    }
}
