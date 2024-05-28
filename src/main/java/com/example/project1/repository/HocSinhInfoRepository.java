package com.example.project1.repository;

import com.example.project1.enity.HocSinhInfo;
import com.example.project1.enity.HocSinhInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocSinhInfoRepository extends JpaRepository<HocSinhInfo, Long> {
    @Query(value = "SELECT * FROM luanvan.hocsinh hs " +
            "WHERE (hs.ho_ten LIKE CONCAT('%', :ten, '%') OR hs.ma_hs LIKE CONCAT('%', :mahs, '%') OR (hs.gioi_tinh = :gioitinh)) " +
            "OR (hs.ho_ten IS NULL OR hs.ho_ten LIKE '' OR hs.ma_hs IS NULL OR hs.ma_hs LIKE '')", nativeQuery = true)
    List<HocSinhInfo> search(@Param("ten") String ten, @Param("mahs") String mahs, @Param("gioitinh") Boolean gioitinh);
}


