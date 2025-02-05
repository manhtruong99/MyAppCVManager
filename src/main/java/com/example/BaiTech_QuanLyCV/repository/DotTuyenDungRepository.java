package com.example.BaiTech_QuanLyCV.repository;

import com.example.BaiTech_QuanLyCV.entity.DotTuyenDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DotTuyenDungRepository extends JpaRepository<DotTuyenDung,Integer> {


    @Query("SELECT dtd FROM DotTuyenDung dtd WHERE " +
            "(:maDotTuyenDung IS NULL OR dtd.maDotTuyenDung LIKE %:maDotTuyenDung%) AND " +
            "(:noiDung IS NULL OR dtd.noiDung LIKE %:noiDung%) AND " +
            "(:tenDotTuyenDung IS NULL OR dtd.tenDotTuyenDung LIKE %:tenDotTuyenDung%) AND " +
            "(:tenNhanVien IS NULL OR dtd.nhanVien.tenNhanVien LIKE %:tenNhanVien%) AND dtd.deletedAt=false")
    Page<DotTuyenDung> searchDotTuyenDung(@Param("maDotTuyenDung") String maDotTuyenDung,
                                          @Param("tenDotTuyenDung") String tenDotTuyenDung,
                                          @Param("noiDung") String noiDung,
                                          @Param("tenNhanVien") String tenNhanVien,
                                          Pageable pageable);


    @Transactional
    @Modifying
    @Query("UPDATE DotTuyenDung dtd SET dtd.deletedAt = true WHERE dtd.dotTuyenDungId = :id")
    void softDeleteDotTuyenDung(@Param("id") Integer id);
}
