package com.example.project1.controller;

import com.example.project1.enity.HocSinhInfo;
import com.example.project1.enity.HocSinhInfoDTO;
import com.example.project1.service.HocSinhInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/hocsinh")
public class HocSinhInfoController {

    @Autowired
    HocSinhInfoService hocSinhInfoService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<HocSinhInfo> getHocSinh() {
        return hocSinhInfoService.getAllHocSinh();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocSinhInfo> getHocSinhById(@PathVariable Long id) {
        Optional<HocSinhInfo> hocSinhInfo = hocSinhInfoService.getHocSinhById(id);
        return hocSinhInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<HocSinhInfo> createHocSinh(@RequestBody HocSinhInfoDTO hocSinhInfoDTO) {
        HocSinhInfo hocSinhInfo1 =  hocSinhInfoService.createHocSinhInfo(hocSinhInfoDTO);
        return new ResponseEntity<HocSinhInfo>(hocSinhInfo1, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/upload-image")
    public ResponseEntity<String> uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile imageFile) {
        try {
            Optional<HocSinhInfo> studentOptional = hocSinhInfoService.getHocSinhById(id);
            if (studentOptional.isPresent()) {
                byte[] imageBytes = imageFile.getBytes();
                HocSinhInfo updatedStudent = hocSinhInfoService.saveStudentWithImage(studentOptional.get(), imageBytes);
                return ResponseEntity.ok("Image uploaded successfully for student ID: " + updatedStudent.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading image: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/edit-image")
    public ResponseEntity<String> editImage(@PathVariable Long id, @RequestParam("image") MultipartFile imageFile) {
        try {
            Optional<HocSinhInfo> studentOptional = hocSinhInfoService.getHocSinhById(id);
            if (studentOptional.isPresent()) {
                byte[] imageBytes = imageFile.getBytes();
                HocSinhInfo updatedStudent = hocSinhInfoService.saveStudentWithImage(studentOptional.get(), imageBytes);
                return ResponseEntity.ok("Image edited successfully for student ID: " + updatedStudent.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error reading image file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error editing image: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] image = hocSinhInfoService.getStudentImage(id);
        if (image != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<HocSinhInfo> updateHocSinh(@PathVariable Long id, @RequestBody HocSinhInfo hocSinhInfoDetails) {
        HocSinhInfo updatedHocSinhInfo = hocSinhInfoService.updateHocSinhInfo(id, hocSinhInfoDetails);
        return ResponseEntity.ok(updatedHocSinhInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHocSinh(@PathVariable Long id) {
        hocSinhInfoService.deleteHocSinhInfo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<HocSinhInfo> searchHocSinh(@RequestParam String hoTen,@RequestParam String maHs,@RequestParam(required = false) Boolean gioiTinh, @RequestParam String danToc, @RequestParam String tenLop, @RequestParam(required = false) Boolean trangThai) {
        return hocSinhInfoService.search(hoTen,maHs,gioiTinh, danToc, tenLop, trangThai);
    }
    @DeleteMapping("/delete-multiple")
    public ResponseEntity<Void> deleteMultipleHocSinh(@RequestBody List<Long> ids) {
        try {
            hocSinhInfoService.deleteMultipleHocSinhInfos(ids);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
