package com.example.project1.controller;

import com.example.project1.enity.HocSinhInfo;
import com.example.project1.enity.HocSinhInfoDTO;
import com.example.project1.enity.LopHoc;
import com.example.project1.enity.LopHocDTO;
import com.example.project1.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lophoc")
public class LopHocController {

    @Autowired
    private LopHocService lopHocService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<LopHoc> getAllLopHoc() {
        return lopHocService.getAllLopHoc();
    }

    @PostMapping("/add")
    public ResponseEntity<LopHoc> createLopHoc(@RequestBody LopHocDTO lopHocDTO) {
        LopHoc lopHoc1 =  lopHocService.createLopHoc(lopHocDTO);
        return new ResponseEntity<LopHoc>(lopHoc1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LopHoc> getLopHocById(@PathVariable Long id) {
        LopHoc lopHoc = lopHocService.getLopHocById(id);
        if (lopHoc != null) {
            return ResponseEntity.ok(lopHoc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LopHoc> updateLopHoc(@PathVariable Long id, @RequestBody LopHoc lopHocDetails) {
        LopHoc updatedLopHoc = lopHocService.updateLopHoc(id, lopHocDetails);
        if (updatedLopHoc != null) {
            return ResponseEntity.ok(updatedLopHoc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLopHoc(@PathVariable Long id) {
        lopHocService.deleteLopHoc(id);
        return ResponseEntity.noContent().build();
    }
}
