package com.example.BaiTech_QuanLyCV.repository;

import com.example.BaiTech_QuanLyCV.entity.PhongBan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PhongBanRepository  extends JpaRepository<PhongBan,Integer> {

    @Query("SELECT pb FROM PhongBan pb WHERE " +
            "(:maPhongBan IS NULL OR pb.maPhongBan LIKE %:maPhongBan%) AND " +
            "(:tenPhongBan IS NULL OR pb.tenPhongBan LIKE %:tenPhongBan%) AND pb.deletedAt=false ")
    Page<PhongBan> searchPhongBan(@Param("maPhongBan") String maPhongBan,
                                  @Param("tenPhongBan") String tenPhongBan,
                                  Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE PhongBan pb SET pb.deletedAt = true WHERE pb.phongBanId = :id")
    void softDeletePhongBan(@Param("id") Integer id);
}
