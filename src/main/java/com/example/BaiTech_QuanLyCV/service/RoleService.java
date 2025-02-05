package com.example.BaiTech_QuanLyCV.service;

import com.example.BaiTech_QuanLyCV.dto.RolesDTO;

import java.util.List;

public interface RoleService {

    List<RolesDTO> getAll();

    RolesDTO getOne(Integer id);

    RolesDTO save(RolesDTO rolesDTO);

    RolesDTO update(RolesDTO rolesDTO, Integer id);

    void delete(Integer id);
}
