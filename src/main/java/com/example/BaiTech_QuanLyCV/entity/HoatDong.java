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
@Table(name="Activity")
public class HoatDong {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="activity_id")
    private Integer activityId;

    @Column(name = "activity_ma")
    private String activityMa;

    @Column(name = "activity_type", nullable = false, length = 20)
    private String activityType;

    @Column(name = "activity_note")
    private String activityNote;

    @Column(name = "share")
    private Boolean share = false;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
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
