package com.example.project1.service;

import com.example.project1.enity.HocSinhInfo;
import com.example.project1.repository.HocSinhInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocSinhInfoService {

 @Autowired
 HocSinhInfoRepository hocSinhInfoRepository;

 public List<HocSinhInfo> getAllHocSinh() {
     return hocSinhInfoRepository.findAll();
 }

    public Optional<HocSinhInfo> getHocSinhById(Long id) {
        return hocSinhInfoRepository.findById(id);
    }

 public HocSinhInfo saveHocSinhInfo(HocSinhInfo hocSinhInfo) {
        return hocSinhInfoRepository.save(hocSinhInfo);
 }

 public HocSinhInfo updateHocSinhInfo(Long id, HocSinhInfo hocSinhInfoDetails) {
        Optional<HocSinhInfo> optionalHocSinhInfo = hocSinhInfoRepository.findById(id);
        if (optionalHocSinhInfo.isPresent()) {
            HocSinhInfo existingHocSinhInfo = optionalHocSinhInfo.get();
            existingHocSinhInfo.setHoTen(hocSinhInfoDetails.getHoTen());
            existingHocSinhInfo.setNgaySinh(hocSinhInfoDetails.getNgaySinh());
            existingHocSinhInfo.setGioiTinh(hocSinhInfoDetails.isGioiTinh());
            existingHocSinhInfo.setCccd(hocSinhInfoDetails.getCccd());
            existingHocSinhInfo.setHinhAnh(hocSinhInfoDetails.getHinhAnh());
            existingHocSinhInfo.setTinh(hocSinhInfoDetails.getTinh());
            existingHocSinhInfo.setHuyen(hocSinhInfoDetails.getHuyen());
            existingHocSinhInfo.setXa(hocSinhInfoDetails.getXa());
            existingHocSinhInfo.setNoiSinh(hocSinhInfoDetails.getNoiSinh());
            existingHocSinhInfo.setThuongTru(hocSinhInfoDetails.getThuongTru());
            existingHocSinhInfo.setTamTru(hocSinhInfoDetails.getTamTru());
            existingHocSinhInfo.setDanToc(hocSinhInfoDetails.getDanToc());
            existingHocSinhInfo.setTonGiao(hocSinhInfoDetails.getTonGiao());
            existingHocSinhInfo.setMaHs(hocSinhInfoDetails.getMaHs());
            existingHocSinhInfo.setTrangThai(hocSinhInfoDetails.isTrangThai());
            existingHocSinhInfo.setNhapHoc(hocSinhInfoDetails.getNhapHoc());
            return hocSinhInfoRepository.save(existingHocSinhInfo);
        } else {
            throw new RuntimeException("HocSinhInfo not found with id " + id);
        }
    }

    public void deleteHocSinhInfo(Long id) {
        hocSinhInfoRepository.deleteById(id);
    }
}
