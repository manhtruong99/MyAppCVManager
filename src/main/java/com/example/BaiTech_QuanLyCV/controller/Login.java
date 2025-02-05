package com.example.BaiTech_QuanLyCV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "DangNhap";
    }
}
