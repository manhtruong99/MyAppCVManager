package com.example.BaiTech_QuanLyCV.repository;

import com.example.BaiTech_QuanLyCV.entity.ViTriCongViec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ViTriCongViecRepository extends JpaRepository<ViTriCongViec, Integer> {

    @Query("SELECT vtcv FROM ViTriCongViec vtcv WHERE " +
            "(:maViTri IS NULL OR vtcv.maViTri LIKE %:maViTri%) AND " +
            "(:tenViTri IS NULL OR vtcv.tenViTri LIKE %:tenViTri%) AND " +
            "(:level IS NULL OR vtcv.level LIKE %:level%) AND vtcv.deletedAt=false ")
    Page<ViTriCongViec> searchViTriCongViec(@Param("maViTri") String maViTri,
                                       @Param("tenViTri") String tenViTri,
                                       @Param("level") String level,
                                       Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE ViTriCongViec vtcv SET vtcv.deletedAt = true WHERE vtcv.viTriId = :id")
    void softDeleteViTriCongViec(@Param("id") Integer id);
}
