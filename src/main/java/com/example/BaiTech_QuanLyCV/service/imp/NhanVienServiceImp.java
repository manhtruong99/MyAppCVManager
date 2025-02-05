package com.example.BaiTech_QuanLyCV.service.imp;

import com.example.BaiTech_QuanLyCV.dto.NhanVienDTO;
import com.example.BaiTech_QuanLyCV.entity.Account;
import com.example.BaiTech_QuanLyCV.entity.NhanVien;
import com.example.BaiTech_QuanLyCV.entity.Roles;
import com.example.BaiTech_QuanLyCV.entity.ViTriCongViec;
import com.example.BaiTech_QuanLyCV.exception.ResourceNotfound;
import com.example.BaiTech_QuanLyCV.repository.AccountRepository;
import com.example.BaiTech_QuanLyCV.repository.NhanVienRepository;
import com.example.BaiTech_QuanLyCV.repository.RoleRepository;
import com.example.BaiTech_QuanLyCV.repository.ViTriCongViecRepository;
import com.example.BaiTech_QuanLyCV.service.NhanVienService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhanVienServiceImp implements NhanVienService {

    private NhanVienRepository nhanVienRepository;

    private AccountRepository accountRepository;

    private RoleRepository roleRepository;

    private ViTriCongViecRepository viTriCongViecRepository;

    private ModelMapper modelMapper;

    @Autowired
    public NhanVienServiceImp(NhanVienRepository nhanVienRepository, AccountRepository accountRepository,
                              RoleRepository roleRepository, ViTriCongViecRepository viTriCongViecRepository, ModelMapper modelMapper) {
        this.nhanVienRepository = nhanVienRepository;
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.viTriCongViecRepository = viTriCongViecRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<NhanVienDTO> getAll() {
        return nhanVienRepository.getAllJoinFetch().stream()
                .map((nhanVien) -> modelMapper.map(nhanVien, NhanVienDTO.class)).collect(Collectors.toList());
    }

    @Override
    public NhanVienDTO getOne(Integer id) {
        return modelMapper.map(nhanVienRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại nhân viên có id: " + id)), NhanVienDTO.class);
    }

    @Override
    public NhanVienDTO save(NhanVienDTO nhanVienDTO) {

        NhanVien nhanVien = modelMapper.map(nhanVienDTO, NhanVien.class);

        Account account = accountRepository.findByMaAccount(nhanVienDTO.getMaAccount());

        if (account == null) {
            throw new ResourceNotfound("Không tồn tại Account có mã: " + nhanVienDTO.getMaAccount());
        }


        Roles roles = roleRepository.findById(nhanVienDTO.getIdRoles())
                .orElseThrow(() -> new ResourceNotfound("Không tồn tại Roles có id: " + nhanVienDTO.getIdRoles()));

        ViTriCongViec viTriCongViec = viTriCongViecRepository.findById(nhanVienDTO.getIdViTriCongViec())
                .orElseThrow(() -> new ResourceNotfound("Không tồn tại ViTriCongViec có id: " + nhanVienDTO.getIdViTriCongViec()));

        nhanVien.setAccount(account);
        nhanVien.setRoles(roles);
        nhanVien.setViTriCongViec(viTriCongViec);
        NhanVien nhanVienSave = nhanVienRepository.save(nhanVien);
        return modelMapper.map(nhanVienSave, NhanVienDTO.class);
    }

    @Override
    public NhanVienDTO update(NhanVienDTO nhanVienDTO, Integer id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại nhân viên có id: " + id));
        Account account = accountRepository.findById(nhanVienDTO.getMaAccount())
                .orElseThrow(() -> new ResourceNotfound("Không tồn tại Account có id: " + nhanVienDTO.getMaAccount()));

        Roles roles = roleRepository.findById(nhanVienDTO.getIdRoles())
                .orElseThrow(() -> new ResourceNotfound("Không tồn tại Roles có id: " + nhanVienDTO.getIdRoles()));

        ViTriCongViec viTriCongViec = viTriCongViecRepository.findById(nhanVienDTO.getIdViTriCongViec())
                .orElseThrow(() -> new ResourceNotfound("Không tồn tại ViTriCongViec có id: " + nhanVienDTO.getIdViTriCongViec()));

        nhanVien.setMaNhanVien(nhanVienDTO.getMaNhanVien());
        nhanVien.setTenNhanVien(nhanVienDTO.getTenNhanVien());
        nhanVien.setEmail(nhanVienDTO.getEmail());
        nhanVien.setSdt(nhanVienDTO.getSdt());
        nhanVien.setViTriCongViec(viTriCongViec);
        nhanVien.setRoles(roles);
        nhanVien.setAccount(account);
        NhanVien nhanVienUpdate=nhanVienRepository.save(nhanVien);
        return modelMapper.map(nhanVienUpdate,NhanVienDTO.class);
    }

    @Override
    public void delete(Integer id) {
        NhanVien nhanVien=nhanVienRepository.findById(id).orElseThrow(() -> new ResourceNotfound("Không tồn tại nhân viên có id: " + id));
        nhanVienRepository.softDeleteNhanVien(id);
    }

    @Override
    public Page<NhanVienDTO> searchNhanVien(String maNhanVien, String tenNhanVien, String email, Pageable pageable) {
        Page<NhanVien> nhanVienPage = nhanVienRepository.searchNhanVien(maNhanVien, tenNhanVien, email, pageable);

        List<NhanVienDTO> nhanVienDTOs = nhanVienPage.getContent().stream()
                .map((nhanVien) ->modelMapper.map(nhanVien,NhanVienDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<>(nhanVienDTOs, pageable, nhanVienPage.getTotalElements());
    }
}

