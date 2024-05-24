package com.example.project1.repository;

import com.example.project1.enity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopHocRepository extends JpaRepository<LopHoc, Long> {
}
