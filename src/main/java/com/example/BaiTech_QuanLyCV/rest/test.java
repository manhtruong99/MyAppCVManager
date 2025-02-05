package com.example.BaiTech_QuanLyCV.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {

    @GetMapping("test")
    public String testAhahaa(){
        return "haha";
    }

    @GetMapping("test2")
    public String testAhahaa2(){
        return "TrangChu";
    }
}
