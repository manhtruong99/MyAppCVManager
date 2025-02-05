package com.example.BaiTech_QuanLyCV.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class DotTuyenDungDTO {

    private Integer dotTuyenDungId;

    private String maDotTuyenDung;

    private String tenDotTuyenDung;

    private String noiDung;

    private Date deadline;

    private Integer nhanVienId;

    private String tenNhanVien;
}
