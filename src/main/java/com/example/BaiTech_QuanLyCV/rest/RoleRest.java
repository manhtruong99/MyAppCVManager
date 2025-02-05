package com.example.BaiTech_QuanLyCV.rest;

import com.example.BaiTech_QuanLyCV.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleRest {

    private RoleService roleService;

    @Autowired
    public RoleRest(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("hien-thi")
    public ResponseEntity<List> getAll(){
        return ResponseEntity.ok(roleService.getAll());
    }
}
