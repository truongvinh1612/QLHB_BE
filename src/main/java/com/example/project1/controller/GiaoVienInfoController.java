package com.example.project1.controller;

import com.example.project1.enity.GiaoVienInfo;
import com.example.project1.enity.GiaoVienInfoDTO;
import com.example.project1.enity.HocSinhInfo;
import com.example.project1.enity.HocSinhInfoDTO;
import com.example.project1.service.GiaoVienInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<GiaoVienInfo> createHocSinh(@RequestBody GiaoVienInfoDTO giaoVienInfoDTO) {
        GiaoVienInfo giaoVienInfo1 =  giaoVienInfoService.createGiaoVien(giaoVienInfoDTO);
        return new ResponseEntity<GiaoVienInfo>(giaoVienInfo1, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/upload-image")
    public ResponseEntity<String> uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile imageFile) {
        try {
            Optional<GiaoVienInfo> giaoVienInfoOptional = giaoVienInfoService.getGiaoVienById(id);
            if (giaoVienInfoOptional.isPresent()) {
                byte[] imageBytes = imageFile.getBytes();
                GiaoVienInfo updatedTeacher = giaoVienInfoService.saveTeacherWithImage(giaoVienInfoOptional.get(), imageBytes);
                return ResponseEntity.ok("Image uploaded successfully for teacher ID: " + updatedTeacher.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading image: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] image = giaoVienInfoService.getTeacherImage(id);
        if (image != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GiaoVienInfo> updateGiaoVien(@PathVariable Long id, @RequestBody GiaoVienInfo giaoVienInfo) {
        GiaoVienInfo updatedGiaoVien = giaoVienInfoService.updateGiaoVien(id, giaoVienInfo);
        return ResponseEntity.ok(updatedGiaoVien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiaoVien(@PathVariable Long id) {
        giaoVienInfoService.deleteGiaoVien(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteGiaoVien(@RequestParam(value = "maGv") String maGv) {
        Optional<GiaoVienInfo> giaoVienInfo = giaoVienInfoService.findByMaGv(maGv);
        if (giaoVienInfo.isPresent()) {
            giaoVienInfoService.deleteGiaoVienByMaGv(maGv);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher with maGV: " + maGv + " not found.");
        }
    }

    @GetMapping("/search")
    public List<GiaoVienInfo> searchGiaoVien(@RequestParam String hoTen,@RequestParam String maGv,@RequestParam(required = false) Boolean gioiTinh, @RequestParam String trinhDo) {
        return giaoVienInfoService.search(hoTen,maGv,gioiTinh, trinhDo);
    }
}
