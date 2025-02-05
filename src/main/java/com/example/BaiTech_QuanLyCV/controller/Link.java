package com.example.BaiTech_QuanLyCV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Link {

    @GetMapping("quan-li-nhan-vien")
    public String viewQuanLyNhanVien(){
        return "QuanLyNhanVien";
    }

    @GetMapping("quan-li-phong-ban")
    public String viewQuanLyPhongBan(){
        return "QuanLyPhongBan";
    }

    @GetMapping("quan-li-vi-tri-cong-viec")
    public String viewQuanLyViTriCongViec(){
        return "QuanLyCongViec";
    }

    @GetMapping("quan-li-dot-tuyen-dung")
    public String viewQuanLyDotTuyenDung(){
        return "QuanLyDotTuyenDung";
    }

    @GetMapping("quan-li-ho-so")
    public String viewQuanLyHoSo(){
        return "QuanLyHoSo";
    }

    @GetMapping("quan-li-hoat-dong")
    public String viewQuanLyHoatDong(){
        return "QuanLyHoatDong";
    }
}
