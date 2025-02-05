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

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="NhanVien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nhan_vien_id")
    private Integer nhanVienId;

    @Column(name = "ma_nhan_vien", nullable = false, length = 10, unique = true)
    private String maNhanVien;

    @Column(name = "ten_nhan_vien", nullable = false, length = 100)
    private String tenNhanVien;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "vi_tri_id")
    private ViTriCongViec viTriCongViec;

    @ManyToOne
    @JoinColumn(name = "nhan_vien_quan_ly_id")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "ma_account")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Roles roles;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", columnDefinition = "BIT(0) DEFAULT 0")
    private Boolean deletedAt = true;

}
