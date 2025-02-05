package com.example.BaiTech_QuanLyCV.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="CV")
public class HoSo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_id")
    private Integer cvId;

    @Column(name="maHoSo")
    private String maHoSo;

    @Column(name = "apply_datetime", nullable = false)
    private Date applyDatetime;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, length = 10)
    private String gender;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String tel;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(name = "job_name", nullable = false, length = 100)
    private String jobName;

    @Column(name = "tong_nam_kinh_nghiem", nullable = false)
    private Double tongNamKinhNghiem;

    @Column
    private String note;

    @Column(name = "link_cv", nullable = false, length = 255)
    private String linkCv;

    @Column(name = "nguon_tuyen_dung", nullable = false, length = 255)
    private String nguonTuyenDung;

    @Column(name = "trang_thai", nullable = false, length = 50)
    private String trangThai;

    @Column
    private Boolean share = false;

    @ManyToOne
    @JoinColumn(name = "hr_user_id")
    private NhanVien nhanVien;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean deletedAt = true;
}
