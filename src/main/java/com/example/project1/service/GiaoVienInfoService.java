package com.example.project1.service;

import com.example.project1.enity.GiaoVienInfo;
import com.example.project1.repository.GiaoVienInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiaoVienInfoService {

    @Autowired
    private GiaoVienInfoRepository giaoVienInfoRepository;

    public List<GiaoVienInfo> getAllGiaoVien() {
        return giaoVienInfoRepository.findAll();
    }

    public Optional<GiaoVienInfo> getGiaoVienById(Long id) {
        return giaoVienInfoRepository.findById(id);
    }

    public GiaoVienInfo saveGiaoVien(GiaoVienInfo giaoVienInfo) {
        return giaoVienInfoRepository.save(giaoVienInfo);
    }

    public GiaoVienInfo updateGiaoVien(Long id, GiaoVienInfo giaoVienInfoDetails) {
        Optional<GiaoVienInfo> optionalGiaoVienInfo = giaoVienInfoRepository.findById(id);
        if (optionalGiaoVienInfo.isPresent()) {
            GiaoVienInfo existingGiaoVienInfo = optionalGiaoVienInfo.get();
            existingGiaoVienInfo.setHoten(giaoVienInfoDetails.getHoten());
            existingGiaoVienInfo.setNgaysinh(giaoVienInfoDetails.getNgaysinh());
            existingGiaoVienInfo.setGioitinh(giaoVienInfoDetails.isGioitinh());
            existingGiaoVienInfo.setCccd(giaoVienInfoDetails.getCccd());
            existingGiaoVienInfo.setEmail(giaoVienInfoDetails.getEmail());
            existingGiaoVienInfo.setHinhanh(giaoVienInfoDetails.getHinhanh());
            existingGiaoVienInfo.setTinh(giaoVienInfoDetails.getTinh());
            existingGiaoVienInfo.setHuyen(giaoVienInfoDetails.getHuyen());
            existingGiaoVienInfo.setXa(giaoVienInfoDetails.getXa());
            existingGiaoVienInfo.setNoisinh(giaoVienInfoDetails.getNoisinh());
            existingGiaoVienInfo.setThuongtru(giaoVienInfoDetails.getThuongtru());
            existingGiaoVienInfo.setTamtru(giaoVienInfoDetails.getTamtru());
            existingGiaoVienInfo.setDantoc(giaoVienInfoDetails.getDantoc());
            existingGiaoVienInfo.setTongiao(giaoVienInfoDetails.getTongiao());
            existingGiaoVienInfo.setMagv(giaoVienInfoDetails.getMagv());
            return giaoVienInfoRepository.save(existingGiaoVienInfo);
        } else {
            throw new RuntimeException("GiaoVienInfo not found with id " + id);
        }
    }

    public void deleteGiaoVien(Long id) {
        giaoVienInfoRepository.deleteById(id);
    }
}
