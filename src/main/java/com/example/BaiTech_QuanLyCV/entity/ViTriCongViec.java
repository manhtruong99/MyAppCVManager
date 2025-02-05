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
@Table(name="ViTriCongViec")
public class ViTriCongViec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vi_tri_id")
    private Integer viTriId;

    @Column(name = "ma_vi_tri", nullable = false, length = 10, unique = true)
    private String maViTri;

    @Column(name = "ten_vi_tri", nullable = false, length = 100)
    private String tenViTri;

    @Column(nullable = false, length = 20)
    private String level;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean deletedAt = true;
}
