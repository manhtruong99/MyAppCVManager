package com.example.BaiTech_QuanLyCV.repository;

import com.example.BaiTech_QuanLyCV.entity.HoSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HoSoRepository  extends JpaRepository<HoSo,Integer> {

    @Query("SELECT hs FROM HoSo hs WHERE " +
            "(:fullName IS NULL OR hs.fullName LIKE %:fullName%) AND " +
            "(:email IS NULL OR hs.email LIKE %:email%) AND " +
            "(:tel IS NULL OR hs.tel LIKE %:tel%) AND " +
            "(:city IS NULL OR hs.city LIKE %:city%) AND " +
            "(:tenNhanVien IS NULL OR hs.nhanVien.tenNhanVien LIKE %:tenNhanVien%) AND " +
            "(:jobName IS NULL OR hs.jobName LIKE %:jobName%) AND hs.deletedAt=false ")
    Page<HoSo> searchHoSo(@Param("fullName") String fullName,
                                  @Param("email") String email,
                                  @Param("tel") String tel,
                                  @Param("city") String city,
                                  @Param("tenNhanVien") String tenNhanVien,
                                  @Param("jobName") String jobName,
                                  Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE HoSo hs SET hs.deletedAt = true WHERE hs.cvId = :id")
    void softDeleteHoSo(@Param("id") Integer id);
}
