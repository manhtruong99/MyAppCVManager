package com.example.BaiTech_QuanLyCV.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="PhongBan")
public class PhongBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="phong_ban_id")
    private Integer phongBanId;

    @Column(name = "ma_phong_ban", nullable = false, length = 10, unique = true)
    private String maPhongBan;

    @Column(name = "ten_phong_ban", nullable = false, length = 100)
    private String tenPhongBan;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", columnDefinition = "BIT(0) DEFAULT 0")
    private Boolean deletedAt = true;


}
