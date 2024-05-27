package com.example.project1.controller;

import com.example.project1.enity.HocSinhInfo;
import com.example.project1.enity.HocSinhInfoDTO;
import com.example.project1.service.HocSinhInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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





}
