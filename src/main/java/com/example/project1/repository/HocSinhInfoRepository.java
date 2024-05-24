package com.example.project1.repository;

import com.example.project1.enity.HocSinhInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocSinhInfoRepository extends JpaRepository<HocSinhInfo, Long> {

}
