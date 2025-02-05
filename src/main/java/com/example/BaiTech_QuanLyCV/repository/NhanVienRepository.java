package com.example.BaiTech_QuanLyCV.repository;

import com.example.BaiTech_QuanLyCV.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    @Query("SELECT nv FROM NhanVien nv JOIN FETCH nv.viTriCongViec JOIN FETCH nv.roles " +
            "JOIN FETCH nv.account where nv.deletedAt=false ")
    List<NhanVien> getAllJoinFetch();

    @Query("SELECT nv FROM NhanVien nv WHERE " +
            "(:maNhanVien IS NULL OR nv.maNhanVien LIKE %:maNhanVien%) AND " +
            "(:tenNhanVien IS NULL OR nv.tenNhanVien LIKE %:tenNhanVien%) AND " +
            "(:email IS NULL OR nv.email LIKE %:email%) AND nv.deletedAt=false ")
    Page<NhanVien> searchNhanVien(@Param("maNhanVien") String maNhanVien,
                                  @Param("tenNhanVien") String tenNhanVien,
                                  @Param("email") String email,
                                  Pageable pageable);


    @Transactional
    @Modifying
    @Query("UPDATE NhanVien nv SET nv.deletedAt = true WHERE nv.nhanVienId = :id")
    void softDeleteNhanVien(@Param("id") Integer id);



}
