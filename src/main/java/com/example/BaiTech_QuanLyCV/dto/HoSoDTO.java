package com.example.BaiTech_QuanLyCV.dto;

import com.example.BaiTech_QuanLyCV.entity.NhanVien;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HoSoDTO {

    private Integer cvId;

    private String maHoSo;

    private Date applyDatetime;

    private String fullName;

    private String gender;

    private String email;

    private String tel;

    private String city;

    private String jobName;

    private Double   tongNamKinhNghiem;

    private String note;

    private String linkCv;

    private String nguonTuyenDung;

    private String trangThai;

    private Boolean share = false;

    private Integer nhanVienIdNhanVien;

    private String tenNhanVien;
}
