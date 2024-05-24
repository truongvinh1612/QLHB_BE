package com.example.project1.repository;

import com.example.project1.enity.GiaoVienInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GiaoVienInfoRepository extends JpaRepository<GiaoVienInfo, Long> {
    Optional<GiaoVienInfo> findByMaGv(String maGv);

}
