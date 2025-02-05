package com.example.BaiTech_QuanLyCV.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NhanVienDTO {

    private Integer nhanVienId;

    private String maNhanVien;

    private String tenNhanVien;

    private String email;

    private String sdt;

    private Integer idViTriCongViec;

    private String tenViTriCongViec;

    private Integer nhanVienIdNhanVien;

    private String tenNhanVienNhanVien;

    private String maAccount;

    private Integer idRoles;

    private String authorityRoles;
}
