package com.example.project1.controller;

import com.example.project1.enity.GiaoVienInfo;
import com.example.project1.service.GiaoVienInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/giaovien")
public class GiaoVienInfoController {

    @Autowired
    private GiaoVienInfoService giaoVienInfoService;

    @GetMapping
    public List<GiaoVienInfo> getAllGiaoVien() {
        return giaoVienInfoService.getAllGiaoVien();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiaoVienInfo> getGiaoVienById(@PathVariable Long id) {
        Optional<GiaoVienInfo> giaoVienInfo = giaoVienInfoService.getGiaoVienById(id);
        return giaoVienInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<GiaoVienInfo> createGiaoVien(@RequestBody GiaoVienInfo giaoVienInfo) {
        GiaoVienInfo savedGiaoVienInfo = giaoVienInfoService.saveGiaoVien(giaoVienInfo);
        return new ResponseEntity<>(savedGiaoVienInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiaoVienInfo> updateGiaoVien(@PathVariable Long id, @RequestBody GiaoVienInfo giaoVienInfo) {
        GiaoVienInfo updatedGiaoVien = giaoVienInfoService.updateGiaoVien(id, giaoVienInfo);
        return ResponseEntity.ok(updatedGiaoVien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiaoVien(@PathVariable Long id) {
        if (giaoVienInfoService.getGiaoVienById(id).isPresent()) {
            giaoVienInfoService.deleteGiaoVien(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
