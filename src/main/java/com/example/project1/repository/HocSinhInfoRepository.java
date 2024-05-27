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
    @Query(value = "SELECT * FROM luanvan.hocsinh hs WHERE hs.ho_ten LIKE CONCAT('%', :ten, '%')", nativeQuery = true)
    List<HocSinhInfo> search(@Param("ten") String ten);

}
