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
            existingHocSinhInfo.setHoten(hocSinhInfoDetails.getHoten());
            existingHocSinhInfo.setNgaysinh(hocSinhInfoDetails.getNgaysinh());
            existingHocSinhInfo.setGioitinh(hocSinhInfoDetails.isGioitinh());
            existingHocSinhInfo.setCccd(hocSinhInfoDetails.getCccd());
            existingHocSinhInfo.setEmail(hocSinhInfoDetails.getEmail());
            existingHocSinhInfo.setHinhanh(hocSinhInfoDetails.getHinhanh());
            existingHocSinhInfo.setTinh(hocSinhInfoDetails.getTinh());
            existingHocSinhInfo.setHuyen(hocSinhInfoDetails.getHuyen());
            existingHocSinhInfo.setXa(hocSinhInfoDetails.getXa());
            existingHocSinhInfo.setNoisinh(hocSinhInfoDetails.getNoisinh());
            existingHocSinhInfo.setThuongtru(hocSinhInfoDetails.getThuongtru());
            existingHocSinhInfo.setTamtru(hocSinhInfoDetails.getTamtru());
            existingHocSinhInfo.setDantoc(hocSinhInfoDetails.getDantoc());
            existingHocSinhInfo.setTongiao(hocSinhInfoDetails.getTongiao());
            existingHocSinhInfo.setMahs(hocSinhInfoDetails.getMahs());
            existingHocSinhInfo.setTenlop(hocSinhInfoDetails.getTenlop());
            existingHocSinhInfo.setKhoi(hocSinhInfoDetails.getKhoi());
            existingHocSinhInfo.setTrangthai(hocSinhInfoDetails.isTrangthai());
            existingHocSinhInfo.setNhaphoc(hocSinhInfoDetails.getNhaphoc());
            return hocSinhInfoRepository.save(existingHocSinhInfo);
        } else {
            throw new RuntimeException("HocSinhInfo not found with id " + id);
        }
    }

    public void deleteHocSinhInfo(Long id) {
        hocSinhInfoRepository.deleteById(id);
    }
}
