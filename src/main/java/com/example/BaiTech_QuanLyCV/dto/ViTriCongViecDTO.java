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

public class ViTriCongViecDTO {

    private Integer viTriId;

    private String maViTri;

    private String tenViTri;

    private String level;
}
