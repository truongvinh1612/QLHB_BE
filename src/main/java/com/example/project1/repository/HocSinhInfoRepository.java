package com.example.project1.repository;

import com.example.project1.enity.HocSinhInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocSinhInfoRepository extends JpaRepository<HocSinhInfo, Long> {
    @Query(value = "SELECT * FROM luanvan.hocsinh hs " +
            "WHERE (:hoTen IS NULL OR hs.ho_ten LIKE CONCAT('%', :hoTen, '%')) " +
            "AND (:maHs IS NULL OR hs.ma_hs LIKE CONCAT('%', :maHs, '%')) " +
            "AND (:gioiTinh IS NULL OR hs.gioi_tinh = :gioiTinh OR hs.gioi_tinh = '') " +
            "AND (:danToc IS NULL OR hs.dan_toc LIKE CONCAT('%', :danToc, '%')) " +
            "AND (:tenLop IS NULL OR hs.ten_lop LIKE CONCAT('%', :tenLop, '%')) " +
            "AND (:trangThai IS NULL OR hs.trang_thai = :trangThai OR hs.trang_thai = '') " +
            "OR (hs.ho_ten IS NULL OR hs.ho_ten = '' " +
            "OR hs.ma_hs IS NULL OR hs.ma_hs = '' " +
            "OR hs.dan_toc IS NULL OR hs.dan_toc = '' " +
            "OR hs.ten_lop IS NULL OR hs.ten_lop = '')" , nativeQuery = true)
    List<HocSinhInfo> search(@Param("hoTen") String hoTen, @Param("maHs") String maHs, @Param("gioiTinh") Boolean gioiTinh, @Param("danToc") String danToc, @Param("tenLop") String tenLop, @Param("trangThai") Boolean trangThai);

}


