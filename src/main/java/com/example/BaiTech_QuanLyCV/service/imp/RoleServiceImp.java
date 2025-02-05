package com.example.BaiTech_QuanLyCV.service.imp;

import com.example.BaiTech_QuanLyCV.dto.RolesDTO;
import com.example.BaiTech_QuanLyCV.repository.RoleRepository;
import com.example.BaiTech_QuanLyCV.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp implements RoleService {

    private RoleRepository roleRepository;

    private ModelMapper modelMapper;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RolesDTO> getAll() {
        return roleRepository.findAll().stream().map((roles)-> modelMapper.map(roles,RolesDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RolesDTO getOne(Integer id) {
        return null;
    }

    @Override
    public RolesDTO save(RolesDTO rolesDTO) {
        return null;
    }

    @Override
    public RolesDTO update(RolesDTO rolesDTO, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
