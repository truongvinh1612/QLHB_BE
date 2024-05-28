package com.example.project1.repository;

import com.example.project1.enity.GiaoVienInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GiaoVienInfoRepository extends JpaRepository<GiaoVienInfo, Long> {
    Optional<GiaoVienInfo> findByMaGv(String maGV);
    void deleteByMaGv(String maGV);

    @Query(value = "SELECT * FROM luanvan.giaovien gv " +
            "WHERE (:hoTen IS NULL OR gv.ho_ten LIKE CONCAT('%', :hoTen, '%')) " +
            "AND (:maGv IS NULL OR gv.ma_gv LIKE CONCAT('%', :maGv, '%')) " +
            "AND (:gioiTinh IS NULL OR gv.gioi_tinh = :gioiTinh OR gv.gioi_tinh = '') " +
            "AND (:trinhDo IS NULL OR gv.trinh_do LIKE CONCAT('%', :trinhDo, '%')) " +
            "OR (gv.ho_ten IS NOT NULL AND gv.ho_ten = '' " +
            "OR gv.ma_gv IS NOT NULL AND gv.ma_gv = '' " +
            "OR gv.trinh_do IS NOT NULL AND gv.trinh_do = '')", nativeQuery = true)
    List<GiaoVienInfo> search(@Param("hoTen") String hoTen, @Param("maGv") String maGv, @Param("gioiTinh") Boolean gioiTinh, @Param("trinhDo") String trinhDo);

}
