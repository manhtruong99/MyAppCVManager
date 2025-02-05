package com.example.BaiTech_QuanLyCV.service;

import com.example.BaiTech_QuanLyCV.dto.JwtAuthResponse;
import com.example.BaiTech_QuanLyCV.dto.LoginDTO;
import com.example.BaiTech_QuanLyCV.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDTO loginDto);
}
