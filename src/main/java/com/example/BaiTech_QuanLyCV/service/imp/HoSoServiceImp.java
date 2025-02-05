package com.example.BaiTech_QuanLyCV.service.imp;

import com.example.BaiTech_QuanLyCV.dto.HoSoDTO;
import com.example.BaiTech_QuanLyCV.dto.NhanVienDTO;
import com.example.BaiTech_QuanLyCV.dto.PhongBanDTO;
import com.example.BaiTech_QuanLyCV.entity.HoSo;
import com.example.BaiTech_QuanLyCV.entity.NhanVien;
import com.example.BaiTech_QuanLyCV.entity.PhongBan;
import com.example.BaiTech_QuanLyCV.exception.ResourceNotfound;
import com.example.BaiTech_QuanLyCV.repository.HoSoRepository;
import com.example.BaiTech_QuanLyCV.repository.NhanVienRepository;
import com.example.BaiTech_QuanLyCV.service.HoSoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoSoServiceImp implements HoSoService {

    private HoSoRepository hoSoRepository;

    private NhanVienRepository nhanVienRepository;

    private ModelMapper modelMapper;

    @Autowired
    public HoSoServiceImp(HoSoRepository hoSoRepository, NhanVienRepository nhanVienRepository, ModelMapper modelMapper) {
        this.hoSoRepository = hoSoRepository;
        this.nhanVienRepository = nhanVienRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HoSoDTO> getAll() {
        return hoSoRepository.findAll().stream()
                .map((hoSo) -> modelMapper.map(hoSo, HoSoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public HoSoDTO getOne(Integer id) {
        return modelMapper.map(hoSoRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại HoSo có id: "+id)),HoSoDTO.class);
    }

    @Override
    public HoSoDTO save(HoSoDTO hoSoDTO) {
        NhanVien nhanVien=nhanVienRepository.findById(hoSoDTO.getNhanVienIdNhanVien()).orElseThrow(() -> new ResourceNotfound("Không tồn tại nhan vien có id: "+hoSoDTO.getNhanVienIdNhanVien()));
        HoSo hoSo=modelMapper.map(hoSoDTO,HoSo.class);
        hoSo.setNhanVien(nhanVien);
        HoSo hoSoSave=hoSoRepository.save(hoSo);
        return modelMapper.map(hoSoSave,HoSoDTO.class);
    }

    @Override
    public HoSoDTO update(HoSoDTO hoSoDTO, Integer id) {
        NhanVien nhanVien=nhanVienRepository.findById(hoSoDTO.getNhanVienIdNhanVien()).orElseThrow(() -> new ResourceNotfound("Không tồn tại nhan vien có id: "+hoSoDTO.getNhanVienIdNhanVien()));
        HoSo hoSo=hoSoRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại HoSo có id: "+id));
        hoSo.setMaHoSo(hoSoDTO.getMaHoSo());
        hoSo.setApplyDatetime(hoSoDTO.getApplyDatetime());
        hoSo.setFullName(hoSoDTO.getFullName());
        hoSo.setGender(hoSoDTO.getGender());
        hoSo.setEmail(hoSoDTO.getEmail());
        hoSo.setTel(hoSoDTO.getTel());
        hoSo.setCity(hoSoDTO.getCity());
        hoSo.setJobName(hoSoDTO.getJobName());
        hoSo.setTongNamKinhNghiem(hoSoDTO.getTongNamKinhNghiem());
        hoSo.setNote(hoSoDTO.getNote());
        hoSo.setNguonTuyenDung(hoSoDTO.getNguonTuyenDung());
        hoSo.setTrangThai(hoSoDTO.getTrangThai());
        hoSo.setShare(hoSoDTO.getShare());
        hoSo.setNhanVien(nhanVien);
        HoSo hoSoUpdate=hoSoRepository.save(hoSo);
        return modelMapper.map(hoSoUpdate,HoSoDTO.class);
    }

    @Override
    public void delete(Integer id) {
HoSo hoSo=hoSoRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại HoSo có id: "+id));
hoSoRepository.softDeleteHoSo(id);
    }

    @Override
    public Page<HoSoDTO> searchHoSo(String fullName, String email, String tel, String city, String tenNhanVien, String jobName, Pageable pageable) {
        Page<HoSo> hoSoPage = hoSoRepository.searchHoSo(fullName, email, tel, city, tenNhanVien, jobName,pageable);

        List<HoSoDTO> hoSoDTOS = hoSoPage.getContent().stream()
                .map((hoSo) ->modelMapper.map(hoSo,HoSoDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<>(hoSoDTOS, pageable, hoSoPage.getTotalElements());
    }
}
